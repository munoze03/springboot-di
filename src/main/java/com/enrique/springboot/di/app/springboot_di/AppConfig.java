package com.enrique.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.enrique.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.enrique.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({

    @PropertySource("classpath:config.properties")

})

public class AppConfig {

    @Bean
    @Primary
    public ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }

}