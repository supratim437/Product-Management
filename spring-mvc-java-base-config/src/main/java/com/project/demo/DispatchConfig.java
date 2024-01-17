package com.project.demo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatchConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configs= {MyBeansConfig.class};
		System.out.println("getServletConfigClasses() method called...");
		return configs;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mapping= {"/"};
		System.out.println("getServletMappings() method called...");
		return mapping;
	}

}
