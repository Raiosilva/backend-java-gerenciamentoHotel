package com.oliveira.raimundo;

import com.oliveira.raimundo.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Customer c1 = new Customer(null, "Raimundo", "71 98888888", null, null);

		// customerRepository.saveAll(Arrays.asList(c1));

	}

}
