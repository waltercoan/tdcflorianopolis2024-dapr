package br.com.waltercoan.ms_inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MsInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInventoryApplication.class, args);
	}

}
