package com.jzfq.seata.student.vo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: jianmin.li
 * @Description: 成绩 实体
 * @Date: 2021/3/21 21:11
 * @Version: 1.0
 */
@Data
@ApiModel
public class GradeVO {
    /**
     * 学号
     */
    @ApiModelProperty(hidden = true)
    private Integer studentId;
    /**
     * 学科
     */
    @ApiModelProperty(value = "学科", example = "1")
    private Integer subject;
    /**
     * 分数
     */
    @ApiModelProperty(value = "分数", example = "100")
    private Integer score;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
