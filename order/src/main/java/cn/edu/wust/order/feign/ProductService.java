package cn.edu.wust.order.feign;

import cn.edu.wust.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huhan
 * @Date: 2020/1/16 9:32
 * @Description
 * @Version 1.0
 */
@FeignClient(name = "product-service")
@Component
public interface ProductService {
    @PutMapping("/product/decrease_stock")
    Result<Object> decreaseStock(@RequestParam("id") String id,@RequestParam("count") Integer count);
}
