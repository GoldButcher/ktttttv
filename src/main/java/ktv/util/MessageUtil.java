package ktv.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import ktv.pojo.response.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 2016/12/19.
 */
public class MessageUtil {
    public static final  String REQ_MESSAGE_TYPE_TEXT="text";
    public static final  String REQ_MESSAGE_TYPE_IMAGE="image";
    public static final  String REQ_MESSAGE_TYPE_VOICE="voice";
    public static final  String REQ_MESSAGE_TYPE_VIDEO="video";
    public static final  String REQ_MESSAGE_TYPE_LOCATION="location";
    public static final  String REQ_MESSAGE_TYPE_LINK="link";

    public static final  String REQ_MESSAGE_TYPE_EVENT="event";

    public static final  String RESP_MESSAGE_TYPE_TEXT="text";
    public static final  String RESP_MESSAGE_TYPE_IMAGE="image";
    public static final  String RESP_MESSAGE_TYPE_VOICE="voice";
    public static final  String RESP_MESSAGE_TYPE_VIDEO="video";
    public static final  String RESP_MESSAGE_TYPE_MUSIC="music";
    public static final  String RESP_MESSAGE_TYPE_NEWS="news";
    //subscribe
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final String EVENT_TYPE_CLICK = "CLICK";

    public static HashMap<String,String> parseXML(HttpServletRequest request) throws Exception{
        HashMap<String,String> map = new HashMap<String,String>();
        SAXReader readr=new SAXReader();
        Document doc=readr.read(request.getInputStream());
        Element root = doc.getRootElement();
        recursiveParseXML(root,map);
        return map;
    }
    private static  void recursiveParseXML(Element root,HashMap<String,String>map) throws Exception
    {
        List<Element> l= root.elements();
        if(l.size()==0)
        {
            map.put(root.getName(),root.getTextTrim());
        }else{
            for (Element e : l) {
                recursiveParseXML(e,map);

            }
        }
    }

    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    public static String messageToXML(TextMessage textMessage){
        xstream.alias("xml", TextMessage.class);
        return xstream.toXML(textMessage);
    }

    public static String messageToXML(ImageMessage imageMessage){
        xstream.alias("xml", ImageMessage.class);
        return xstream.toXML(imageMessage);
    }

    public static String messageToXML(MusicMessage musicMessage){
        xstream.alias("xml", MusicMessage.class);
        return xstream.toXML(musicMessage);
    }
    public static String messageToXML(VoiceMessage voiceMessage){
        xstream.alias("xml", VoiceMessage.class);
        return xstream.toXML(voiceMessage);
    }
    public static String messageToXML(NewsMessage newsMessage){
        xstream.alias("xml", NewsMessage.class);
        xstream.alias("item", Article.class);
        return xstream.toXML(newsMessage);
    }
    public static String messageToXML(VideoMessage videoMessage){
        xstream.alias("xml", VideoMessage.class);
        return xstream.toXML(videoMessage);
    }
}
