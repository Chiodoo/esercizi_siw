package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Docente;
import java.util.List;


public interface docenteRepository extends CrudRepository<Docente, Long>{

    //Lista dei docenti con quel cognome
    public List<Docente> findByCognome(String cognome);

    //Docente che insegna in quel corso, ricerca per corso
    public Docente findByCorso(Corso corso);

    //Docente che insegna in quel corso, ricerca per id corso
    public Docente findByCorsoId(Long id);

    //Docenti il cui cognome inizia con la lettere b (Con una query nativa SQL)
    @Query(value = "SELECT * FROM Docente WHERE cognome like 'b%'", nativeQuery = true)
    public List<Docente> findByCognomeConBNative();

    //Docenti il cui cognome inizia con la lettera b (Con una query JPQL)
    @Query("SELECT d FROM Docente d WHERE d.cognome like 'b%'")
    public List<Docente> findByCognomeConB();

}
