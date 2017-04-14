package ktv.pojo.response;

/**
 * Created by evam on 16-12-18.
 */
public class VoiceMessage extends BaseMessage{
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
