package com.exc.kinfe4j.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Huang Min
 * @date 2020/11/14 22:28
 * @description
 */
@ApiModel

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VideoVO {
    private static final long serialVersionUID = 1165681926787951541L;
    /**返回的视频ID*/
    @ApiModelProperty(value = "主键id", example="2")
    private Integer id;
}
