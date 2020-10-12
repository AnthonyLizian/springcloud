package cn.how2j.springcloud.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.how2j.springcloud.pojo.Product;

@Component
public class ProductClientRibbon {

    @Autowired
    RestTemplate restTemplate;

    //通过restTemplate访问http://PRODUCT-DATA-SERVICE/products 找到数据服务在eureka上的名称
    public List<Product> listProdcuts() {
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products",List.class);
    }

}