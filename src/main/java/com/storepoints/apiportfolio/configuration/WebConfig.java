package com.storepoints.apiportfolio.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.storepoints.apiportfolio.converter.ModelReqToModelConverter;
import com.storepoints.apiportfolio.converter.ModelToModelResConverter;
import com.storepoints.apiportfolio.converter.ModelsToModelsResConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{
 
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ModelReqToModelConverter());
        registry.addConverter(new ModelToModelResConverter());
        registry.addConverter(new ModelsToModelsResConverter());
    }
}