package com.cmahrmobile.hr.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @Title:FastJsonConfig
 * @Description: fastJson配置类
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date:2018年11月15
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Configuration
public class HttpConverterConfig {

	/**
	 * 配置fastJson
	 * @return HttpMessageConverters
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverter() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter converter = fastJsonHttpMessageConverter;
		return new HttpMessageConverters(converter);
	}
}
