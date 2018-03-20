package com.ce.krf;

import java.io.Serializable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
 
@SpringBootApplication
@MapperScan("com.ce.krf.biz.mapper")
public class KrfBizApplication extends SpringBootServletInitializer implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4259370242342246524L;

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//    	application.bannerMode(Banner.Mode.OFF);
        return application.sources(KrfBizApplication.class);
    }
//    @Bean
//    public InternalResourceViewResolver jspViewResolver() {
//        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
////        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }  
    
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserialization() {
//        return new Jackson2ObjectMapperBuilderCustomizer() {
//
//            @Override
//            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
//                jacksonObjectMapperBuilder.deserializerByType(BigDecimal.class, bigDecimalDeserializer);
//            }
//
//        };
//    }
	public static void main(String[] args) {
		SpringApplication.run(KrfBizApplication.class);
	}
}
