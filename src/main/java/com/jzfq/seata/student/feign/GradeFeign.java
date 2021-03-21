package com.jzfq.seata.student.feign;

import com.jzfq.seata.student.feign.fallback.GradeFeignFallback;
import com.jzfq.seata.student.vo.GradeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: jianmin.li
 * @Description: 成绩 feign
 * @Date: 2021/3/21 21:19
 * @Version: 1.0
 */
@FeignClient(value = "seata-grade", fallbackFactory = GradeFeignFallback.class)
public interface GradeFeign {
    /**
     * 添加学生成绩
     *
     * @param grades 成绩
     * @author jianmin.li
     * @date 2021/3/21 21:22
     */
    @PostMapping("/grade/addGrades")
    boolean addGrades(@RequestBody List<GradeVO> grades);
}
