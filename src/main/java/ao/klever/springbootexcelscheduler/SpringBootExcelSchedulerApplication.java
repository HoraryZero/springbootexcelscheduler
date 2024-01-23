package ao.klever.springbootexcelscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootExcelSchedulerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExcelSchedulerApplication.class, args);
	}
}
