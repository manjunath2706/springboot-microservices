package com.microservices_example2.departmentservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.microservices_example2.departmentservice.client.EmployeeClient;

@Configuration
public class WebCLientConfig {
	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;
	@Bean
	public WebClient employeeWebClient() {
		return WebClient.builder()
				.baseUrl("http://employee-service")
				.filter(filterFunction)
				.build();
	}
	
	@Bean
	public EmployeeClient employeeClient() {
		HttpServiceProxyFactory httpServiceProxyFactory= HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(employeeWebClient())).build();
		return httpServiceProxyFactory.createClient(EmployeeClient.class);
	}

}
