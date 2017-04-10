package ktv.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ktv.pojo.MyX509TrustManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

/**
 * Created by admin on 2017/4/10.
 */
public class NetWorkUtil {
    public static final String token_url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public static final String APPID = "wxf9a6b3518abcf0b1";
    public static final String APPSecret = "bf4394771bc2203cdcd0a4fb9c872c5b";
    public static String httpsRequest(String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer =null;
        try{
            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManager[] tm = {new MyX509TrustManager()};

            sslContext.init(null, tm, new java.security.SecureRandom());

            SSLSocketFactory ssf = sslContext.getSocketFactory();



            URL url = new URL(requestUrl);
            HttpsURLConnection conn  = (HttpsURLConnection)url.openConnection();
            conn.setRequestMethod(requestMethod);

            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //往服务器端写内容

            if(null!=outputStr)
            {
                OutputStream os = conn.getOutputStream();

                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;

            while((line = br.readLine())!=null)
            {
                buffer.append(line);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return buffer.toString();
    }
    public static String getOpenId(String code){

        String requestUrl = token_url.replace("APPID", APPID).replace("SECRET", APPSecret).replace("CODE",code);
        String  jsonString =  httpsRequest(requestUrl, "GET", null);
        Type listType=new TypeToken<Map<String,String>>(){}.getType();
        Gson gson = new Gson();
        Map<String,String>map=gson.fromJson(jsonString, listType);
        return map.get("openid");
    }
}
