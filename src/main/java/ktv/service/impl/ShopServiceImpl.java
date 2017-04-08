package ktv.service.impl;

import ktv.dao.IShopDao;
import ktv.model.Shop;
import ktv.service.AbstractService;
import ktv.service.IShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
}
