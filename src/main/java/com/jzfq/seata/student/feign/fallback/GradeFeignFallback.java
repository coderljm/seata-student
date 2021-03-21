package com.jzfq.seata.student.feign.fallback;

import com.jzfq.seata.student.feign.GradeFeign;
import com.jzfq.seata.student.util.LogUtils;
import com.jzfq.seata.student.vo.GradeVO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: jianmin.li
 * @Description: 成绩 feign 熔断器
 * @Date: 2021/3/21 21:20
 * @Version: 1.0
 */
@Component
@Slf4j
public class GradeFeignFallback implements FallbackFactory<GradeFeign> {
    /**
     * Returns an instance of the fallback appropriate for the given cause
     *
     * @return com.jzfq.seata.student.feign.GradeFeign
     * @author jianmin.li
     * @date 2021/3/21 21:29
     */
    @Override
    public GradeFeign create(Throwable throwable) {
        return new GradeFeign() {
            @Override
            public boolean addGrades(List<GradeVO> grades) {
                LogUtils.error(log,"请求添加学生成绩出现异常",throwable);
                return false;
            }
        };
    }
}
