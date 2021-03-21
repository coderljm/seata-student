package com.jzfq.seata.student.controller;


import com.jzfq.seata.student.biz.StudentBiz;
import com.jzfq.seata.student.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jianmin.li
 * @since 2021-03-21
 */
@RestController
@RequestMapping("/student")
@CrossOrigin
@Api("StudentController")
public class StudentController {
    /**
     * 学生信息 业务层
     */
    @Autowired
    private StudentBiz studentBiz;

    /**
     * 添加学生信息和成绩
     *
     * @param studentVO 学生信息和成绩
     * @return 添加结果
     * @author jianmin.li
     * @date 2021/3/21 21:53
     */
    @ApiOperation(value = "添加学生信息和成绩", notes = "添加学生信息和成绩")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ContentType", value = "ContentType", paramType = "header", dataTypeClass =
                    String.class, required = true, example = MediaType.APPLICATION_JSON_VALUE)
    })
    @PostMapping("/addStudentAndGrade")
    public boolean addStudentAndGrade(@RequestBody StudentVO studentVO) {
        return studentBiz.addStudentAndGrade(studentVO);
    }
}

