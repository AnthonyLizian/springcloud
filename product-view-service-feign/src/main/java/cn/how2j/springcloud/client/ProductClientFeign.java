package cn.how2j.springcloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cn.how2j.springcloud.pojo.Product;

//通过注解方式访问http://PRODUCT-DATA-SERVICE/products 找到数据服务在eureka上的名称
@FeignClient(value = "PRODUCT-DATA-SERVICE")
public interface ProductClientFeign {

    @GetMapping("/products")
    public List<Product> listProdcuts();
}