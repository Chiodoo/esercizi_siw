package it.uniroma3.siw.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

        //Metodo che trova tutti i clienti con un determinato nome
        public Iterable<Customer> findByName(String firstName);

        //Metodo che trova tutti i clienti con un determinato cognome
        public Iterable<Customer> findBySurname(String surname);

        //Metodo che trova un cliente con un determinato nome e cognome
        public Customer findByNameAndSurname(String name, String surname);

        //Metodo che trova tutti i clienti nati in una determinata data
        public Iterable<Customer> findByDateOfBirth(LocalDate dateOfBirth);

        //Metodo che trova tutti i clienti nati prima di una certa data
        @Query("SELECT c FROM Customer C WHERE c.dateOfBirth < :dateOfBirth")
        public List<Customer> findByDateOfBirthBefore(LocalDate dateOfBirth);

        //Metodo che trova tutti i clienti nati dopo una certa data
        @Query("SELECT c FROM Customer C WHERE c.dateOfBirth > :dateOfBirth")
        public List<Customer> findByDateOfBirthAfter(LocalDate dateOfBirth);

        //Metodo che trova tutti i clienti il cui nome inizia con una certa stringa
        //MI fermo qui per ora, non so come scegliere il tipo di ritorno per i metodi sopra
}
