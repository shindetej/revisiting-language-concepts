package com.tejas.model;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
@ConfigurationPropertiesBinding
public class PersonConverterClass implements Converter<String, Person>, ApplicationContextAware {

	//Using @Autowired instead of implementing ApplicationContextAware also work but here we are taking usecase of it 
	
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;

	}

	@Override
	public Person convert(String source) {
		return (Person) this.context.getBean(source);
	}

}
