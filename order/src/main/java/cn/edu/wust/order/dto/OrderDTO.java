package cn.edu.wust.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: huhan
 * @Date: 2020/1/16 9:46
 * @Description
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class OrderDTO {
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户地址")
    private String address;

    @ApiModelProperty("商品id")
    private String productId;

    @ApiModelProperty("扣库存数量")
    private Integer count;
}
