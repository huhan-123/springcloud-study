package cn.edu.wust.product.controller;

import cn.edu.wust.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huhan
 * @Date: 2020/1/16 9:06
 * @Description
 * @Version 1.0
 */
@RestController
@Api(tags = "商品")
public class ProductController {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商品id",required = true),
            @ApiImplicitParam(name = "count",value = "扣库存数量",required = true)
    })
    @ApiOperation("扣库存接口")
    @PutMapping("/decrease_stock")
    public Result<Object> decreaseStock(@RequestParam("id") String id,@RequestParam("count")Integer count){
        return Result.ok("扣库存成功");
    }
}
