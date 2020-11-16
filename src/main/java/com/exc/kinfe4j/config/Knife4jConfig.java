/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.exc.kinfe4j.config;

import com.exc.kinfe4j.dto.Knife4jDTO;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口文档系统 Knife4j 配置类
 * @author Huang Min
 * @date 2020/11/16 12:40
 * @description
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfig {

//    /*********************开发单个版本的接口默认处理方式,该配置与'开发多个版本的接口处理方式'互斥*********************/
    /**
     * https://gitee.com/xiaoym/swagger-bootstrap-ui-demo/blob/master/swagger-bootstrap-ui-demo/src/main/java/com/swagger/bootstrap/ui/demo/config/SwaggerConfiguration.java
     * 默认访问工程下所有api
     * 注意:web包下子包的类的类名,注解@RequestMapping("/v1")的映射地址,均不能相同
     * @return
     */
    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        //分组/版本,名称
        String groupName="1.0.0版本";
        String author = "Huang Min";
        String homePage = "https://www.yuque.com/huangmins/java/hcds4q";
        String email = "huangmin@exc-led.com";
        String title = "多媒体文件处理服务的接口";
        String description = "多媒体文件处理服务 RESTful APIs";
        String termsOfServiceUrl = "https://www.yuque.com/huangmins/java/hcds4q";
        String version = "1.0.0";

        Contact contact = new Contact(author, homePage, email);

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(contact)
                .version(version)
                .build();

        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo)
                .groupName(groupName)
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /*********************开发多个版本的接口处理方式，例如向第三方平台提供接口测试时，开放测试指定的包下的api*********************/

    /**
     * 上海50所的接口测试1
     *
     * @return
     */
    @Bean(value = "packageApiV2")
    public Docket packageApiV2() {
        //分组/版本,名称
        String groupName = "V2版本";
        String author = "Huang Min";
        String homePage = "https://doc.xiaominfo.com/guide/";
        String email = "huangmin@exc-led.com";
        String title = "多媒体文件处理服务的接口";
        String description = "多媒体文件处理服务 RESTful APIs";
        String termsOfServiceUrl = "https://www.yuque.com/huangmins/java/hcds4q";
        String version = "1.2.0";
        String basePackage = "com.exc.kinfe4j.web.v2";

        Knife4jDTO knife4jDTO = new Knife4jDTO(groupName, author, homePage, email, title, description, termsOfServiceUrl, version, basePackage);

        Docket docket = createDocket(knife4jDTO);
        return docket;
    }

    /**
     * 上海50所的接口测试2
     *
     * @return
     */
    @Bean(value = "packageApiV3")
    public Docket packageApiV3() {
        //分组/版本,名称
        String groupName = "50所V3";
        String author = "Huang Min";
        String homePage = "https://doc.xiaominfo.com/guide/";
        String email = "huangmin@exc-led.com";
        String title = "多媒体文件处理服务的接口";
        String description = "多媒体文件处理服务 RESTful APIs";
        String termsOfServiceUrl = "https://www.yuque.com/huangmins/java/hcds4q";
        String version = "1.3.0";
        String basePackage = "com.exc.kinfe4j.web.v3";

        Knife4jDTO knife4jDTO = new Knife4jDTO(groupName, author, homePage, email, title, description, termsOfServiceUrl, version, basePackage);

        Docket docket = createDocket(knife4jDTO);
        return docket;
    }


    /**
     * 创建 Docket
     *
     * @param knife4jDTO
     * @return Docket
     */
    private Docket createDocket(Knife4jDTO knife4jDTO) {
        String groupName = knife4jDTO.getGroupName();
        String author = knife4jDTO.getAuthor();
        String homePage = knife4jDTO.getHomePage();
        String email = knife4jDTO.getEmail();
        String title = knife4jDTO.getTitle();
        String description = knife4jDTO.getDescription();
        String termsOfServiceUrl = knife4jDTO.getTermsOfServiceUrl();
        String version = knife4jDTO.getVersion();
        String basePackage = knife4jDTO.getBasePackage();

        Contact contact = new Contact(author, homePage, email);

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(contact)
                .license("exc-led")
                .licenseUrl("https://www.exc-led.com/")
                .version(version)
                .build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo)
                .groupName(groupName)
                // 设置哪些接口暴露给Swagger展示
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
