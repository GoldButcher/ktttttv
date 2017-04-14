package ktv.pojo.request;

/**
 * Created by admin on 2016/12/18.
 */
public class VideoMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
