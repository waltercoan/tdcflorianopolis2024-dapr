package br.com.waltercoan.ms_shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MsShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsShoppingcartApplication.class, args);
	}

}
