package com.jzfq.seata.student.model;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author jianmin.li
 * @since 2021-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，雪花算法生成
     */
    @TableId("id")
    private Long id;

    /**
     * 学生姓名
     */
    @TableField("name")
    private String name;

    /**
     * 学生年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 学号
     */
    @TableField("student_id")
    private Integer studentId;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private LocalDateTime createAt;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String AGE = "age";

    public static final String STUDENT_ID = "student_id";

    public static final String CREATE_AT = "create_at";

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
