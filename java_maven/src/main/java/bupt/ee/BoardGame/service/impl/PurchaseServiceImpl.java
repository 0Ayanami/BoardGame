package bupt.ee.BoardGame.service.impl;

import bupt.ee.BoardGame.dao.PurchaseDao;
import bupt.ee.BoardGame.dao.impl.PurchaseDaoImpl;
import bupt.ee.BoardGame.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService {
    PurchaseDao purchaseDao = new PurchaseDaoImpl();
    /**
     * 购买物品
     * @param bid
     */
    public void buy(String bid){
        purchaseDao.buy(Integer.parseInt(bid));
    }
}
