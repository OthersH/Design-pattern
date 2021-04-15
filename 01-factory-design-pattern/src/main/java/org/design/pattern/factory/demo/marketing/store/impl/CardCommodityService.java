package org.design.pattern.factory.demo.marketing.store.impl;

import org.design.pattern.factory.demo.marketing.card.IQIYiCardService;
import org.design.pattern.factory.demo.marketing.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CardCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    //模拟注入
    private IQIYiCardService iqiYiCardService = new IQIYiCardService();
    public void sendCommodit(String uId, String commodityId, String bizId, Map<String, String> ectMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iqiYiCardService.grantToken(mobile,bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uid:{} commodityId: {} biz: {} ectMap: {}",uId,commodityId,bizId,ectMap);
        logger.info("测试结果[爱奇艺兑换卡] => :success");
    }

    private String queryUserMobile(String uId){
        return  "156111111111";
    }
}
