package hu.futureofmedia.task.contactsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;

@SpringBootApplication
public class ContactsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContactsApiApplication.class, args);
    }

    /**
     * Prevent CORS errors to make life easier.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("POST", "GET", "PUT", "DELETE")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);
            }
        };
    }
}
