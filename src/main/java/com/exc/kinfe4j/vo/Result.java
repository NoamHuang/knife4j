package com.exc.kinfe4j.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 定义一个统一的返回接口数据类
 *
 * @author huangmin
 * @date 2019/06/22
 */
@ApiModel

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Result {
    private static final long serialVersionUID = 1065681926787951541L;
    /**响应错误码*/
    @ApiModelProperty(value = "返回码", example="200",notes = "返回200,400")
    private Integer code;
     /**返回错误信息*/
     @ApiModelProperty(value = "返回信息", example="操作成功")
    private String message;

}
