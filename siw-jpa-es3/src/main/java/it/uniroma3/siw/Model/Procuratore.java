package it.uniroma3.siw.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Procuratore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    private String codiceFederale;

    @OneToMany(mappedBy = "procuratore")    //Corrispone ad associazione in Giocatore, un procuratore può avere più giocatori, ma un giocatore ha solo un procuratore
    private List<Giocatore> giocatori;

    @ManyToOne
    private Societa societa;

    //Metodi =================================================================00

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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFederale() {
        return codiceFederale;
    }

    public void setCodiceFederale(String codiceFederale) {
        this.codiceFederale = codiceFederale;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codiceFederale == null) ? 0 : codiceFederale.hashCode());
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
        Procuratore other = (Procuratore) obj;
        if (codiceFederale == null) {
            if (other.codiceFederale != null)
                return false;
        } else if (!codiceFederale.equals(other.codiceFederale))
            return false;
        return true;
    }
}
