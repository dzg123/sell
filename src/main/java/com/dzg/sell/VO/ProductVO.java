package com.dzg.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 *       
 * @author dzg  商品（包含类目）
 * @date 2018/11/23 10:22
 * @param    
 * @return   
 */ 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO implements Serializable{
    private static final long serialVersionUID = -602795552833669518L;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
