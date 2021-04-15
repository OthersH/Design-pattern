package org.design.pattern.factory.demo.marketing.store.impl;

import org.design.pattern.factory.demo.marketing.goods.DeliverReq;
import org.design.pattern.factory.demo.marketing.goods.GoodsService;
import org.design.pattern.factory.demo.marketing.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);
    private GoodsService goodsService = new GoodsService();
    public void sendCommodit(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(qurtyUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAdress(extMap.get("consigneeUserAddress"));
        Boolean isSuccess = goodsService.deliverGoods(deliverReq);
        logger.info("请求参数[优惠券] => uId: {}  commodityId: {} bizId:{} extMap: {}",uId,commodityId,bizId,extMap);
        logger.info("测试结果[优惠券]: {} ",isSuccess);
        if (!isSuccess) throw new RuntimeException("实物商品发放失败");
    }

    private String queryUserName(String uId){
        return  "发发";
    }
    private String qurtyUserPhoneNumber(String uId){
        return "15611141666";
    }
}
