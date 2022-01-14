
package com.baps.mysatsangapi;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.baps.mysatsangapi.filters.MetricsFilter;

@Configuration
public class ApiConfig {

	@Bean
	public FilterRegistrationBean<MetricsFilter> metricsFilter(){
		FilterRegistrationBean<MetricsFilter> regBean = new FilterRegistrationBean<>();
		regBean.setFilter(new MetricsFilter());
		regBean.addUrlPatterns("/v1/demo/*");
		regBean.setOrder(1);
		
		return regBean;
	}
}

