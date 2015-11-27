/*
 * Copyright (c)  2015 hanks ( https://github.com/hanks-zyh ).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hanks.otherkiller;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.hanks.otherkiller.weibo.AccessTokenKeeper;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
/**
 * add share function to app, one key share
 * <p>
 * Created by hanks on 15-11-26.
 */
public class ShareSDK {

    private Context                context;
    private IWeiboShareAPI         mWeiboShareAPI;
    private IWXAPI                 wxApi;
    private PlatformActionListener shareListener;

    public void init(Context context) {
        this.context = context;
        // 微博
        mWeiboShareAPI = WeiboShareSDK.createWeiboAPI(context, ConfigKey.WEIBO_APP_KEY);
        mWeiboShareAPI.registerApp();

        // 微信
        wxApi = WXAPIFactory.createWXAPI(context, ConfigKey.WX_APP_ID);
        wxApi.registerApp(ConfigKey.WX_APP_ID);
    }

    public void share(ShareParams params) {

    }

    private void shareWeibo(ShareParams params) {
        // 1. 初始化微博的分享消息
        WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
        weiboMessage.textObject = getTextObj(params);

        // 2. 初始化从第三方到微博的消息请求
        SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
        // 用transaction唯一标识一个请求
        request.transaction = String.valueOf(System.currentTimeMillis());
        request.multiMessage = weiboMessage;

        // 3. 发送请求消息到微博，唤起微博分享界面

        AuthInfo authInfo = new AuthInfo(context, ConfigKey.WEIBO_APP_KEY, ConfigKey.WEIBO_REDIRECT_URL, ConfigKey.WEIBO_SCOPE);
        Oauth2AccessToken accessToken = AccessTokenKeeper.readAccessToken(context);
        String token = "";
        if (accessToken != null) {
            token = accessToken.getToken();
        }
        mWeiboShareAPI.sendRequest((Activity) context, request, authInfo, token, new WeiboAuthListener() {
            @Override public void onWeiboException(WeiboException arg0) {
                if(shareListener != null){
                    shareListener.onError(new WeiboPlatform("微博"), arg0.hashCode(),arg0.getCause());
                }
            }

            @Override public void onComplete(Bundle bundle) {
                Oauth2AccessToken newToken = Oauth2AccessToken.parseAccessToken(bundle);
                AccessTokenKeeper.writeAccessToken(context, newToken);
                if (shareListener != null) {
                    shareListener.onComplete(new WeiboPlatform(""),200,null);
                }
            }

            @Override public void onCancel() {
                if (shareListener != null) {
                    shareListener.onCancel(null,0);
                }
            }
        });
    }

    /**
     * 创建文本消息对象。
     *
     * @param params
     * @return 文本消息对象。
     */
    private TextObject getTextObj(ShareParams params) {
        TextObject textObject = new TextObject();
        textObject.text = params.getText();
        return textObject;
    }


    /**
     * 微信分享 （这里仅提供一个分享网页的示例，其它请参看官网示例代码）
     *
     * @param flag (0:分享到微信好友，1：分享到微信朋友圈)
     */
    private void shareWechat(final int flag, ShareParams params) {
        WXWebpageObject webpage = new WXWebpageObject();
        // 这里填写链接url
        webpage.webpageUrl = params.getUrl();
        final WXMediaMessage msg = new WXMediaMessage(webpage);
        // 这里填写标题
        msg.title = params.getTitle();
        // 这里填写内容
        msg.description = params.getText();

        msg.setThumbImage(params.getThumbImage());

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = msg;
        req.scene = flag == 0 ? SendMessageToWX.Req.WXSceneSession : SendMessageToWX.Req.WXSceneTimeline;
        wxApi.sendReq(req);

    }


    public void setShareListener(PlatformActionListener shareListener) {
        this.shareListener = shareListener;
    }
}
