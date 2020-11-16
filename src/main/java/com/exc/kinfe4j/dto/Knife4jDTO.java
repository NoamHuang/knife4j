package com.exc.kinfe4j.dto;

import lombok.*;

/**
 * Knife4j 配置参数
 * @author Huang Min
 * @date 2020/11/16 10:50
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Knife4jDTO {
    /**分组名称*/
    private String groupName;
    /**作者*/
    private String author;
    /**主页*/
    private String homePage;
    /**邮箱*/
    private String email;
    /**标题*/
    private String title;
    /**描述*/
    private String description;
    /**服务条款网址*/
    private String termsOfServiceUrl;
    /**版本*/
    private String version;
    /**指定扫描包路径*/
    private String basePackage;
}
