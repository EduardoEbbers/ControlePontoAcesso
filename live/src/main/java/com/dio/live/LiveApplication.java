package com.dio.live;

import com.dio.live.repository.JornadaTrabalhoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.dio.live"})
//@EntityScan("com.dio.live.model")
//@EnableJpaRepositories(basePackages="com.dio.live.repository", entityManagerFactoryRef = "emf")
@SpringBootApplication//(exclude = {HibernateJpaAutoConfiguration.class})
public class LiveApplication {

	public static void main(String[] args) {

		SpringApplication.run(LiveApplication.class, args);
	}

}
