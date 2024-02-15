package br.edu.ufape.reu.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBeanConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mp = new ModelMapper();
		mp.getConfiguration().setSkipNullEnabled(true);
	    return mp;
	}

}