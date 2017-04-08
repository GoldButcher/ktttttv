package ktv.service;

import ktv.model.Shop;

/**
 * Created by admin on 2016/12/25.
 */
public interface IShopService extends AbstractService<Integer,Shop>{
    int saveShop(Shop shop);
}
