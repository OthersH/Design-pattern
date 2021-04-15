package org.design.pattern.factory.demo.marketing.store;

import java.util.Map;

/**
 * 定义发奖接口
 */
public interface ICommodity {
    /**
     * 所有奖品无论是实物还是虚拟还是第三方都通过此接口进行处理，保证出入参的统一性
     * @param uId 用户id
     * @param commodityId 奖品id
     * @param bizId 业务id
     * @param ectMap 扩展字段用于处理实物商品的收货地址
     * @throws Exception
     */
    void sendCommodit(String uId, String commodityId, String bizId, Map<String,String> ectMap) throws Exception;
}
