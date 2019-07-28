package com.mydeveloperplanet.brandservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BrandController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value= "/getBrands/{brand}", method = RequestMethod.GET)
    public String getBrands(@PathVariable String brand) {

        String response = restTemplate.exchange("http://car-service/getCars/{brand}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, brand).getBody();

        return "Brand -  " + brand + " \n Cars " + response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
