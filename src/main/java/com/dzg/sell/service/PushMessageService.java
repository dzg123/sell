package com.dzg.sell.service;

import com.dzg.sell.dto.OrderDTO;
/**  
 * 推送消息
 * @author dzg
 * @date 2018/12/3 15:50 
 * @param    
 * @return   
 */ 
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
