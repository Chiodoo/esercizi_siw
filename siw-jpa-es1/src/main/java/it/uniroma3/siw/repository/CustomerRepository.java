package it.uniroma3.siw.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

        //Metodo che trova tutti i clienti con un determinato nome
        public List<Customer> findByName(String firstName);

        //Metodo che trova tutti i clienti con un determinato cognome
        public List<Customer> findBySurname(String surname);

        //Metodo che trova un cliente con un determinato nome e cognome
        public Customer findByNameAndSurname(String name, String surname);

        //Metodo che trova tutti i clienti nati in una determinata data
        public List<Customer> findByDateOfBirth(LocalDate dateOfBirth);

        //Metodo che trova tutti i clienti nati prima di una certa data
        public List<Customer> findByDateOfBirthBefore(LocalDate dateOfBirth);

        //Metodo che trova tutti i clienti nati dopo una certa data
        public List<Customer> findByDateOfBirthAfter(LocalDate dateOfBirth);

        //Metodo che trova tutti i clienti il cui nome inizia con una certa stringa
        public List<Customer> findByNameStartingWith(String name);

        //Metodo che trova tutti i clienti il cui cognome termina con una certa stringa
        public List<Customer> findBySurnameEndingWith(String surname);

        //Metodo che trova tutti i clienti il cui nome contiene una certa stringa
        public List<Customer> findByNameContaining(String name);

        //Metodo che trova tutti i clienti con un nome diverso da un certo nome
        public List<Customer> findByNameNot(String name);

        //Metodo che trova tutti i clienti con nome o cognome uguale a un certo nome o cognome
        public List<Customer> findByNameOrSurname(String name, String surname);

        //Metodo che trova tutti i clienti ordinati per cognome
        public List<Customer> findByOrderBySurnameAsc();

        //Metodo che conta quanti clienti hanno un certo nome
        public Long countByName(String name);

        //Metodo che conta quanti clienti hanno un certo cognome
        public Long countBySurname(String surname);

        //Metodo che conta quanti clienti hanno un certo nome e cognome
        public Long countByNameAndSurname(String name, String surname);
        
        //Metodo che conta quanti clienti sono nati prima di una certa data
        public Long countByDateOfBirthBefore(LocalDate dateOfBirth);

        //Metodo che conta quanti clienti hanno un nome che inizia con una certa stringa
        public Long countByNameStartingWith(String name);

        //Metodo che conta quanti clienti hanno un cognome che termina con una certa stringa
        public Long countBySurnameEndingWith(String surname);

        //Metodo che conta quanti clienti hanno un nome diverso da un certo nome
        public Long countByNameNot(String name);
}
