package it.uniroma3.siw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.repository.AddressRepository;
import it.uniroma3.siw.repository.CustomerRepository;
import jakarta.transaction.Transactional;


@SpringBootApplication
public class SiwJpaEs1Application implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(SiwJpaEs1Application.class, args);
	}

	@Transactional
	public void run(String... args) throws Exception {

		//Creo un nuovo customer
		Customer customer = new Customer();
		customer.setFirstName("Harold");
		customer.setLastName("Barroga");

		//Stampo le informazioni sul customer
		System.out.println("Customer prima di save:\n"+customer);

		//Salvo il customer nel database
		customerRepository.save(customer);

		//Stampo le informazioni sul customer
		System.out.println("Customer dopo save:\n"+customer);
	}

}
