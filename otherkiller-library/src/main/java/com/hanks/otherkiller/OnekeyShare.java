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
/**
 * 一键分享<br/>
 * ShareSDK.initSDK(this);<br/>
 * OnekeyShare oks = new OnekeyShare();<br/>
 * //关闭sso授权<br/>
 * oks.disableSSOWhenAuthorize();<br/>
 * // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法<br/>
 * //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));<br/>
 * // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用<br/>
 * oks.setTitle(getString(R.string.share));<br/>
 * // titleUrl是标题的网络链接，仅在人人网和QQ空间使用<br/>
 * oks.setTitleUrl("http://sharesdk.cn");<br/>
 * // text是分享文本，所有平台都需要这个字段<br/>
 * oks.setText("我是分享文本");<br/>
 * // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数<br/>
 * oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片<br/>
 * // url仅在微信（包括好友和朋友圈）中使用<br/>
 * oks.setUrl("http://sharesdk.cn");<br/>
 * // comment是我对这条分享的评论，仅在人人网和QQ空间使用<br/>
 * oks.setComment("我是测试评论文本");<br/>
 * // site是分享此内容的网站名称，仅在QQ空间使用<br/>
 * oks.setSite(getString(R.string.app_name));<br/>
 * // siteUrl是分享此内容的网站地址，仅在QQ空间使用<br/>
 * oks.setSiteUrl("http://sharesdk.cn");<br/>
 * // 启动分享GUI<br/>
 * oks.show(this);<br/>
 * </code>
 * <p>
 * Created by hanks on 15-11-26.
 */
public class OnekeyShare {

    private String title;
    private String titleUrl;
    private String text;
    private String imagePath;
    private String url;
    private String comment;
    private String site;
    private String siteUrl;


    /**
     * @param title 标题 印象笔记、邮箱、信息、微信、人人网和QQ空间使用
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param titleUrl 是标题的网络链接，仅在人人网和QQ空间使用
     */
    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    /**
     * @param text 分享文本，所有平台都需要这个字段
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param imagePath 是图片的本地路径，Linked-In以外的平台都支持此参数, 确保SDcard下面存在此张图片
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * setUrl("https://github.com/hanks-zyh");
     *
     * @param url url仅在微信（包括好友和朋友圈）中使用
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * setComment("我是测试评论文本");
     *
     * @param comment comment是我对这条分享的评论，仅在人人网和QQ空间使用
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @param site site是分享此内容的网站名称，仅在QQ空间使用
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @param siteUrl siteUrl是分享此内容的网站地址，仅在QQ空间使用
     */
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

}
