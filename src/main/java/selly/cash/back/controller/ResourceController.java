package selly.cash.back.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins= "http://208.109.37.247")
@RestController

public class ResourceController {

    @Bean
    public WebMvcConfigurer corsConfigurerCodigoLogin() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://208.109.37.247").allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS");
            }
        };
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
