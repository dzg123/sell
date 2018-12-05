package com.dzg.sell.constant;
/**  
 * redis常量
 * @author dzg  
 * @date 2018/12/3 12:17
 * @param    
 * @return   
 */ 
public interface RedisConstant {
    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200; //2小时
}
