package com.codegym.laptopmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.codegym.laptopmanager")
@PropertySource("classpath:global_config_app.properties")
public class AppConfigUploadFile extends WebMvcConfigurerAdapter  {
    @Autowired
    Environment environment;

    // Cấu hình để sử dụng các file nguồn tĩnh (css, image, js..)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String fileUpload = environment.getProperty("file_upload").toString();

        // Image resource.
        registry.addResourceHandler("/a/**") //
                .addResourceLocations("file:" + fileUpload);
    }
}
