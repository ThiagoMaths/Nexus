package br.com.control;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
    @EntityScan(basePackages = "br.com.control.model")
    @EnableJpaRepositories(basePackages = "br.com.control.repository")
    @EnableTransactionManagement
    @EnableWebMvc
    public class Application implements WebMvcConfigurer {
        public static void main(String[] args) {

            org.springframework.boot.SpringApplication.run(br.com.control.Application.class, args);

        }
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("views/login");
            registry.setOrder(Ordered.LOWEST_PRECEDENCE);
        }
    }


