package com.dzg.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @param
 * @author dzg  商品详情
 * @date 2018/11/23 10:35
 * @return
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -5464828208218822518L;
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}
