package it.uniroma3.siw.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String dataInizio;
    private String dataFine;
    private int oreTotali;

    @ManyToOne
    private Sede sede;

    @OneToOne
    private Docente docente;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Docente> docenteAula;

    @ManyToMany
    private List<Allievo> allievi;

    //METODI =================================================================

    public List<Allievo> getAllievi() {
        return allievi;
    }

    public void setAllievi(List<Allievo> allievi) {
        this.allievi = allievi;
    }

    public List<Docente> getDocenteAula() {
        return docenteAula;
    }

    public void setDocenteAula(List<Docente> docenteAula) {
        this.docenteAula = docenteAula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public int getOreTotali() {
        return oreTotali;
    }

    public void setOreTotali(int oreTotali) {
        this.oreTotali = oreTotali;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
        result = prime * result + ((dataFine == null) ? 0 : dataFine.hashCode());
        result = prime * result + oreTotali;
        result = prime * result + ((sede == null) ? 0 : sede.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Corso other = (Corso) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (dataInizio == null) {
            if (other.dataInizio != null)
                return false;
        } else if (!dataInizio.equals(other.dataInizio))
            return false;
        if (dataFine == null) {
            if (other.dataFine != null)
                return false;
        } else if (!dataFine.equals(other.dataFine))
            return false;
        if (oreTotali != other.oreTotali)
            return false;
        if (sede == null) {
            if (other.sede != null)
                return false;
        } else if (!sede.equals(other.sede))
            return false;
        return true;
    }
}
