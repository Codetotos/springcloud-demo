package com.example.controller;

import com.example.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerDeptController {

    // 消费者不应该有Service层
    // RestTemplate直接调用即可,注册到Spring中

    @Autowired
    private RestTemplate restTemplate;

    // Ribbon 这里的地址应该是一个变量通过服务名调用
    // private static final String URL = "http://localhost:8001/provider/";
    // SPRINGCLOUD-DEMO-PROVIDER 提供者的服务名
    private static final String URL = "http://SPRINGCLOUD-DEMO-PROVIDER/provider/";

    @RequestMapping("add")
    public Boolean insertDept(String deptname) {
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("deptname", deptname);
        //  使用postForEntity请求接口
        return restTemplate.postForObject(URL + "insertDept", paramMap, Boolean.class);
    }

    @RequestMapping("list")
    public List findAllDepts() {
        return restTemplate.getForObject(URL + "findAllDepts", List.class);
    }

    @RequestMapping("get")
    public Dept findDeptById(@RequestParam("deptno") Integer deptno) {
        // 封装参数，这里是HashMap
        HashMap<String, Integer> paramMap = new HashMap<>();
        paramMap.put("deptno", deptno);
        // 使用getForObject请求接口
        // Map需要使用HashMap，且url需要使用占位符
        return restTemplate.getForObject(URL + "findDeptById?deptno={deptno}", Dept.class, paramMap);
    }
}
