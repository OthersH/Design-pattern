package org.design.pattern.factory.demo.marketing.store.impl;

import com.alibaba.fastjson.JSON;
import org.design.pattern.factory.demo.marketing.coupon.CouponResult;
import org.design.pattern.factory.demo.marketing.coupon.CouponService;
import org.design.pattern.factory.demo.marketing.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CouponCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    private CouponService couponService = new CouponService();
    public void sendCommodit(String uId, String commodityId, String bizId, Map<String, String> ectMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uid:{} commodityId:{} bizId:{} extMap:{}",uId,commodityId,bizId, JSON.toJSON(ectMap));
        logger.info("测试结果[优惠券]: {}",JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}
