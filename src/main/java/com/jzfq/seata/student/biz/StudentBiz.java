package com.jzfq.seata.student.biz;

import com.jzfq.seata.student.annotation.Biz;
import com.jzfq.seata.student.feign.GradeFeign;
import com.jzfq.seata.student.model.Student;
import com.jzfq.seata.student.service.StudentService;
import com.jzfq.seata.student.util.LogUtils;
import com.jzfq.seata.student.vo.GradeVO;
import com.jzfq.seata.student.vo.StudentVO;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;

import java.util.List;

/**
 * @Author: jianmin.li
 * @Description: 学生信息 业务层
 * @Date: 2021/3/21 17:49
 * @Version: 1.0
 */
@Biz
@Slf4j
public class StudentBiz {
    /**
     * 学生信息 服务类
     */
    @Autowired
    private StudentService studentService;
    /**
     * 成绩 feign
     */
    @Autowired
    private GradeFeign gradeFeign;

    /**
     * 添加学生信息和成绩
     *
     * @param studentVO 学生信息和成绩
     * @return 添加结果
     * @author jianmin.li
     * @date 2021/3/21 21:53
     */
    @GlobalTransactional(rollbackFor = Exception.class)
    public boolean addStudentAndGrade(StudentVO studentVO) {
        LogUtils.info(log,"接收到的学生信息和成绩:{}",studentVO);
        BeanCopier beanCopier = BeanCopier.create(StudentVO.class,Student.class,false);
        Student student = Student.builder().build();
        beanCopier.copy(studentVO,studentVO,null);
        studentService.save(student);
        List<GradeVO> grades = studentVO.getGrades();
        for (GradeVO grade : grades) {
            grade.setStudentId(studentVO.getStudentId());
        }
        return gradeFeign.addGrades(grades);
    }
}
