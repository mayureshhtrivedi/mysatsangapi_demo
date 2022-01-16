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

/**
 * https://micrometer.io : As an instrumentation facade, Micrometer allows you to instrument your code with dimensional 
 *  metrics with a vendor-neutral interface and decide on the monitoring system as a last step.
 *  Instrumenting your core library code with Micrometer allows the libraries to be included in applications
 *  that ship metrics to different backends.
 *  Contains built-in support for AppOptics, Azure Monitor, Netflix Atlas, CloudWatch, Datadog, 
 *  Dynatrace, Elastic,Ganglia, Graphite, Humio, Influx/Telegraf, JMX, KairosDB, New Relic, Prometheus, 
 *  SignalFx, Google Stackdriver, StatsD, and Wavefront.
 * 
 * @author mayuresh
 *
 */
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
