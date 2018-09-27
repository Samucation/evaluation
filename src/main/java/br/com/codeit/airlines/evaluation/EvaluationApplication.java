package br.com.codeit.airlines.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class EvaluationApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EvaluationApplication.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println("Bean mapeado: " + name);
		}
	}
}
