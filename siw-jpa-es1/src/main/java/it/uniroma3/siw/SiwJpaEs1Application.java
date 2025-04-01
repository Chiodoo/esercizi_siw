package it.uniroma3.siw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

CustomerRepository customerRepository;

@SpringBootApplication
public class SiwJpaEs1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SiwJpaEs1Application.class, args);
	}

	@Transactional
	public void run(String... args) throws Exception {
	}

}
