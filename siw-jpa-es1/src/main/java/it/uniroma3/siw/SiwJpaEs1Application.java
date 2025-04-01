package it.uniroma3.siw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.repository.CustomerRepository;
import jakarta.transaction.Transactional;


@SpringBootApplication
public class SiwJpaEs1Application implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SiwJpaEs1Application.class, args);
	}

	@Transactional
	public void run(String... args) throws Exception {

		//Creo un nuovo customer
		Customer customer = new Customer();
		customer.setFirstName("Harold");
		customer.setLastName("Barroga");

		//Creo un nuovo address
		Address address = new Address();
		address.setStreet("Via della vasca navale");
		address.setCity("Roma");
		address.setCountry("Italia");
		address.setZipcode("00146");

		//Associo l'indirizzo al customer
		customer.setAddress(address);


		System.out.println("========================================================================================================================");
		//Stampo le informazioni sul customer
		System.out.println("Customer prima di save:\n"+customer);
		System.out.println("Address prima di save:\n"+address);

		//Salvo il customer nel database
		customerRepository.save(customer);

		//Stampo le informazioni sul customer
		System.out.println("Customer dopo save:\n"+customer);
		System.out.println("Address dopo di save:\n"+address);
	}

}
