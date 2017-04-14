package ktv.service;

import ktv.model.Shop;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2016/12/25.
 */
public interface IShopService extends AbstractService<Integer,Shop>{
    int saveShop(Shop shop);
    String responseMsg(HttpServletRequest request);
}
