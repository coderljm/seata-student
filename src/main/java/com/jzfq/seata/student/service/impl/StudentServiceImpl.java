package com.jzfq.seata.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzfq.seata.student.mapper.StudentMapper;
import com.jzfq.seata.student.model.Student;
import com.jzfq.seata.student.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianmin.li
 * @since 2021-03-21
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
