package ktv.pojo.request;

/**
 * Created by admin on 2016/12/18.
 */
public class ImageMessage extends BaseMessage{
    // 图片链接
    private String PicUrl;
    private String MediaId;
    public String getPicUrl() {
        return PicUrl;
    }
    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
