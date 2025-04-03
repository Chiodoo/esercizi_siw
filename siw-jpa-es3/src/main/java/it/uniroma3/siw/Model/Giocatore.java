package it.uniroma3.siw.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Giocatore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private LocalDate dataNascita;

    private String ruolo;

    private int altezza;

    @ManyToOne
    public Procuratore procuratore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public Procuratore getProcuratore() {
        return procuratore;
    }

    public void setProcuratore(Procuratore procuratore) {
        this.procuratore = procuratore;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
        result = prime * result + ((dataNascita == null) ? 0 : dataNascita.hashCode());
        result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
        result = prime * result + altezza;
        result = prime * result + ((procuratore == null) ? 0 : procuratore.hashCode());
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
        Giocatore other = (Giocatore) obj;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (dataNascita == null) {
            if (other.dataNascita != null)
                return false;
        } else if (!dataNascita.equals(other.dataNascita))
            return false;
        if (ruolo == null) {
            if (other.ruolo != null)
                return false;
        } else if (!ruolo.equals(other.ruolo))
            return false;
        if (altezza != other.altezza)
            return false;
        if (procuratore == null) {
            if (other.procuratore != null)
                return false;
        } else if (!procuratore.equals(other.procuratore))
            return false;
        return true;
    }

    // Metodi =================================================================

    
}
