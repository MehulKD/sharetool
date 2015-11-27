package com.hanks.otherkiller;
import android.graphics.Bitmap;
/**
 * put the share params
 * <p>
 * Created by hanks on 15-11-26.
 */
public class ShareParams {
    private String title;
    private String titleUrl;
    private String text;
    private String imagePath;
    private String url;
    private String comment;
    private String site;
    private String siteUrl;
    private Bitmap thumbImage;
    private int platform;

    /**
     * 所以平台都需要 text 字段
     * @param text
     */
    public ShareParams(String text) {
        this.text = text;
    }

    public int getPlatform() {
        return platform;
    }

    /**
     * 设置要分享的平台
     * @param platform
     */
    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public Bitmap getThumbImage() {
        return thumbImage;
    }

    /**
     *
     * @param thumbImage 分享card 的图片缩略图， 微信使用
     */
    public void setThumbImage(Bitmap thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getTitle() {
        return title;
    }

    /**
     * @param title 标题 印象笔记、邮箱、信息、微信、人人网和QQ空间使用
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    /**
     * @param titleUrl 是标题的网络链接，仅在人人网和QQ空间使用
     */
    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    public String getText() {
        return text;
    }

    /**
     * @param text 分享文本，所有平台都需要这个字段
     */
    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath 是图片的本地路径，Linked-In以外的平台都支持此参数, 确保SDcard下面存在此张图片
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUrl() {
        return url;
    }

    /**
     * setUrl("https://github.com/hanks-zyh");
     *
     * @param url url仅在微信（包括好友和朋友圈）中使用
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    /**
     * setComment("我是测试评论文本");
     *
     * @param comment comment是我对这条分享的评论，仅在人人网和QQ空间使用
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSite() {
        return site;
    }

    /**
     * @param site site是分享此内容的网站名称，仅在QQ空间使用
     */
    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    /**
     * @param siteUrl siteUrl是分享此内容的网站地址，仅在QQ空间使用
     */
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
