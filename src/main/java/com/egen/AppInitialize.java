package com.egen;

//import org.jetbrains.annotations.Nullable;
//import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitialize extends AbstractAnnotationConfigDispatcherServletInitializer{
/**
 * implement the following methods
 */

//@Nullable
@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class[]{AppConfig.class, JPAConfig.class};
}
	//@Nullable
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[0];
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/api/*"};
	}}
