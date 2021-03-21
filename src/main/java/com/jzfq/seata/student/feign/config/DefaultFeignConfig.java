package com.jzfq.seata.student.feign.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;

import java.nio.charset.StandardCharsets;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * <p>
 * 默认全局feign配置
 * </p>
 *
 * @author lijianmin
 * @since 2020/11/24 15:52
 */
@Configuration
public class DefaultFeignConfig {

    @Bean
    public Retryer feignRetry() {
        return new Retryer.Default(SECONDS.toMillis(1L),SECONDS.toMillis(2L),3);
    }

    @Bean
    public Encoder encoder(FastJsonHttpMessageConverter fastJsonHttpMessageConverter) {
        return new SpringEncoder(feginHttpMessageConverters(fastJsonHttpMessageConverter));
    }

    @Bean
    public Decoder decoder(FastJsonHttpMessageConverter fastJsonHttpMessageConverter) {
        return new SpringDecoder(feginHttpMessageConverters(fastJsonHttpMessageConverter));
    }

    private ObjectFactory<HttpMessageConverters> feginHttpMessageConverters(
            FastJsonHttpMessageConverter fastJsonHttpMessageConverter) {
        final HttpMessageConverters httpMessageConverters =
                new HttpMessageConverters(new ByteArrayHttpMessageConverter(),
                        new StringHttpMessageConverter(StandardCharsets.UTF_8),
                        new ResourceHttpMessageConverter(),
                        new SourceHttpMessageConverter(),
                        new AllEncompassingFormHttpMessageConverter(),
                        new Jaxb2RootElementHttpMessageConverter(),
                        fastJsonHttpMessageConverter);
        return () -> httpMessageConverters;
    }
}
