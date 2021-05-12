package store.bigdata.analysis.wry;

import java.io.IOException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//(exclude = {DataSourceAutoConfiguration.class}) 
@SpringBootApplication
@ComponentScan(basePackages = { "store.bigdata.analysis.wry" })
public class ApplicationController {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationController.class, args);
	}
}
