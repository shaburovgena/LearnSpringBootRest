package messenger.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class WebMvcConfig {
    @Bean
    public WebServerFactoryCustomizer <ConfigurableServletWebServerFactory> webServerCustomizer (){
        return container -> {
            //Если страница не найдена будет возвращать адрес "/" главную страницу, но URL останется
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
        };
    }
}
