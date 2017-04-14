package ktv.service.impl;

import ktv.dao.IShopDao;
import ktv.model.Shop;
import ktv.pojo.response.TextMessage;
import ktv.service.AbstractService;
import ktv.service.IShopService;
import ktv.util.MessageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
@Service
public class ShopServiceImpl extends AbstractServiceimpl<Integer,Shop> implements IShopService{
    @Resource
    private IShopDao shopDao;

    @Resource
    public void setShopDao(IShopDao shopDao) {
        super.setAbstractDao(shopDao);
    }

    @Override
    public int saveShop(Shop shop) {
        long count = shopDao.getTotalCount();
        if(1 == count)
        {
            return 0;
        }else{
            shopDao.sava(shop);
        }

        return 1;
    }

    @Override
    public String responseMsg(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "已经接收到您的消息，谢谢！";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXML(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "您发送的是文本消息！";
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！,暂时无法测试收藏的表情，请不要乱发哟";
                }
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                } else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){
                    //点击事件
                    String eventKey = requestMap.get("EventKey");
                    if(eventKey.equals("KEY_INTRODUCTION")){
                        respContent = shopDao.getAll().get(0).getDescription();
                    }else if (eventKey.equals("KEY_CONNECT")){
                        respContent = shopDao.getAll().get(0).getAboutUs();
                    }

                }

            }

            textMessage.setContent(respContent);
            respMessage = MessageUtil.messageToXML(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
    }
}
