package com.baps.mysatsangapi.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baps.mysatsangapi.ApiConfig;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsFilter implements Filter {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetricsFilter.class);
	
	public void init(final ApiConfig config) throws ServletException {
		LOG.info("Initializing the BAPS Config Filter: {}", this);
		Metrics.addRegistry(new SimpleMeterRegistry());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		chain.doFilter(request, response);
		Metrics.counter("service.new_http_requests",
				"request_method",req.getMethod(),
				"user_agent",req.getHeader("User-Agent"), 
				"status-code",
				String.valueOf(resp.getStatus()));
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		LOG.warn("Destructing the filter :{}", this);
	}
}
