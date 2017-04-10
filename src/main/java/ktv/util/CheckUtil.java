package ktv.util;
//
//import com.sun.deploy.util.SessionState;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
//import com.sun.jersey.core.util.MultivaluedMapImpl;
//import ktv.dto.CommonResponseDto;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.util.DigestUtils;
//
//import javax.servlet.http.HttpSession;
//import javax.ws.rs.core.MediaType;
//import java.util.Random;

/**
 * Created by admin on 2017/4/9.
 */
public class CheckUtil {
//    private static final String api = "key-fd60f85f1aa200880f65ac9a166f1da2";
//    public static void send(String mobile, HttpSession session) throws Exception {
//        String check = getCheck();
//
//        // just replace key here
//        Client client = Client.create();
//        client.addFilter(new HTTPBasicAuthFilter(
//                "api",api));
//        WebResource webResource = client.resource(
//                "http://sms-api.luosimao.com/v1/send.json");
//        MultivaluedMapImpl formData = new MultivaluedMapImpl();
//        formData.add("mobile", mobile);
//        formData.add("message", "您的验证码为："+check+"打死都不要告诉别人哦【校园交易网】");
////        formData.add("message", "你的验证码为："+check+"打死都不要告诉别人哦！【校园交易网】");
//        ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).
//                post(ClientResponse.class, formData);
//        String textEntity = response.getEntity(String.class);
//        try {
//            JSONObject jsonObj = new JSONObject( textEntity );
//            int error_code = jsonObj.getInt("error");
//            String error_msg = jsonObj.getString("msg");
//            if(error_code==0){
//                System.out.println("Send message success.");
//            }else{
//                throw new Exception();
//               // System.out.println("Send message failed,code is "+error_code+",msg is "+error_msg);
//            }
//        } catch (JSONException ex) {
//            System.out.println("JSON解析出错请检查");
//        }
//        session.setAttribute("check",DigestUtils.md5Digest(check.getBytes()));
//        session.setMaxInactiveInterval(60);
//        //int status = response.getStatus();
//        //System.out.print(textEntity);
//        //System.out.print(status);
//    }
//
//    public static CommonResponseDto check(String str, HttpSession session){
//        String checkStr = (String) session.getAttribute("check");
//        if(checkStr==null){
//            return CommonResponseUtil.errorWithObj("验证码过时请重新输入");
//        }else {
//            if(!DigestUtils.md5Digest(str.getBytes()).equals(checkStr)){
//                return CommonResponseUtil.errorWithObj("验证码错误");
//            }else {
//                return CommonResponseUtil.successWithNull();
//            }
//        }
//
//    }
//
//    private static String getCheck(){
//        String str ="";
//        Random rn = new Random();
//        for(int i=0;i<5;i++){
//
//            str = str + (rn.nextInt(10) + 1);
//        }
//        return str;
//    }
}
