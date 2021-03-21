package com.jzfq.seata.student.vo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: jianmin.li
 * @Description: 学生信息 实体
 * @Date: 2021/3/21 21:07
 * @Version: 1.0
 */
@Data
@ApiModel
public class StudentVO {
    /**
     * 学生姓名
     */
    @ApiModelProperty(value = "学生姓名", example = "张三")
    private String name;
    /**
     * 学生年龄
     */
    @ApiModelProperty(value = "学生年龄", example = "18")
    private Integer age;
    /**
     * 学号
     */
    @ApiModelProperty(value = "学号", example = "10021211")
    private Integer studentId;
    /**
     * 学生成绩
     */
    @ApiModelProperty(value = "学生成绩")
    private List<GradeVO> grades;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
