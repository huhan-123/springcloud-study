package cn.edu.wust.order.feign.fallback;

import cn.edu.wust.common.vo.Result;
import cn.edu.wust.order.feign.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: huhan
 * @Date: 2020/1/16 9:36
 * @Description
 * @Version 1.0
 */
@Service
@Slf4j
public class ProductServiceFallbackImpl implements ProductService {
    @Override
    public Result<Object> decreaseStock(String id, Integer count){
        log.error("服务：{}，调用服务：{}，方法：{}，参数：{}","系统自动","product-service","decreaseStock","id="+id+",count="+count);
        return Result.error500("商品服务调用失败");
    }
}
