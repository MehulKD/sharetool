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
import android.content.Context;

import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/**
 * add share function to app, one key share
 * <p/>
 * Created by hanks on 15-11-26.
 */
public class Killer {

    public void init(Context context) {

        // 微博
        IWeiboShareAPI mWeiboShareAPI = WeiboShareSDK.createWeiboAPI(context, ConfigKey.WEIBO_APP_KEY);
        mWeiboShareAPI.registerApp();

        // 微信
        IWXAPI wxApi = WXAPIFactory.createWXAPI(context, ConfigKey.WX_APP_ID);
        wxApi.registerApp(ConfigKey.WX_APP_ID);
    }

    public void share(ShareParams params) {

    }

    public void setShareListener(PlatformActionListener shareListener) {

    }
}
