package cn.edu.wust.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

/**
 * @Author: huhan
 * @Date: 2020/1/16 19:54
 * @Description 处理网关前缀
 * @Version 1.0
 */
@Configuration
public class ApiPrefixFilterConfig {
    @Value("${spring.cloud.gateway.api-prefix}")
    private String prefix;

    @Bean
    @Order(-1)
    public WebFilter apiPrefixFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getRawPath();
            //如果不带前缀将返回网关错误
            if(!path.startsWith(prefix)){
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.BAD_GATEWAY);
                DataBuffer buffer = response.bufferFactory().wrap(HttpStatus.BAD_GATEWAY.getReasonPhrase().getBytes());
                return response.writeWith(Mono.just(buffer));
            }
            //去掉统一网关
            String newPath = path.replaceFirst(prefix, "");
            ServerHttpRequest newRequest = request.mutate().path(newPath).build();
            return chain.filter(exchange.mutate().request(newRequest).build());
        };
    }
}
