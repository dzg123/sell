package com.dzg.sell.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *       
 * @author dzg http请求返回的最外层对象
 * @date 2018/11/22 21:29
 * @param
 * @return   
 */ 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> implements Serializable{
    private static final long serialVersionUID = -7351377310248717185L;
    //    错误码
    private Integer code;
//    提示信息
    private String msg;
//    具体内容
    private T data;

}
