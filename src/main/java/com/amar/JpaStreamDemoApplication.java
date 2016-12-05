package com.amar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaStreamDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaStreamDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				for (int i = 0; i <1000; i++){
					employeeRepository.save(new Employee("firstName" + i, "LastName" + i
                            , "Description" + i))	;
				}
				employeeRepository.save(new Employee("Amar", "Kumar", "Student"));
			}
		};
	}
}
