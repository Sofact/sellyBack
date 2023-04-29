package selly.cash.back.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins= "${myapp.datasource.url}")
@RestController

public class ResourceController {
/*
    @Bean
    public WebMvcConfigurer corsConfigurerCodigoLogin() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("${myapp.datasource.url}").allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS");
            }
        };
    }*/
    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE");
        }
    }

    @GetMapping("/login")
    public String loginEndpoint() {
        return "Loginer!";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Admin!";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "User!";
    }

    @GetMapping("/all")
    public String allRolesEndpoint() {
        return "All Roles!";
    }

    @DeleteMapping("/delete")
    public String deleteEndpoint(@RequestBody String s) {
        return "I am deleting " + s;
    }
}
