package org.design.pattern.factory.demo.marketing;

import org.design.pattern.factory.demo.marketing.store.ICommodity;
import org.design.pattern.factory.demo.marketing.store.impl.CardCommodityService;
import org.design.pattern.factory.demo.marketing.store.impl.CouponCommodityService;
import org.design.pattern.factory.demo.marketing.store.impl.GoodsCommodityService;

/**
 * 定义一个商店工厂类，按照类型实现各种商品服务，后续新增的商品在这里扩展即可。
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType){
        if ( null == commodityType){
            return null;
        }
        if ( 1 == commodityType){
            return new CouponCommodityService();
        }
        if ( 2 == commodityType){
            return new GoodsCommodityService();
        }
        if ( 3 == commodityType){
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品服务类型");
    }
}
