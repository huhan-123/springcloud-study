package cn.edu.wust.order.controller;

import cn.edu.wust.common.annotation.Loggable;
import cn.edu.wust.common.constant.OpText;
import cn.edu.wust.common.constant.OpType;
import cn.edu.wust.common.vo.Result;
import cn.edu.wust.order.dto.OrderDTO;
import cn.edu.wust.order.feign.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author: huhan
 * @Date: 2020/1/16 9:41
 * @Description
 * @Version 1.0
 */
@RestController
@Api(tags = "订单")
public class OrderController {
    @Autowired
    private ProductService productService;

    @ApiOperation("添加订单")
    @PostMapping("/add")
    @Loggable(opType = OpType.INSERT,opText = OpText.INSERTORDER)
    public Result<Object> add(OrderDTO orderDTO){
        Result<Object> result = productService.decreaseStock(orderDTO.getProductId(), orderDTO.getCount());
        return result;
    }
}
