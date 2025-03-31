package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime creationTime;

    @OneToMany(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines;
    //CascadeType.PERSIST: se l'ordine viene salvato, anche le righe d'ordine vengono salvate
    //CascadeType.REMOVE: se l'ordine viene rimosso, anche le righe d'ordine vengono rimosse
    //CascadeType.MERGE: se l'ordine viene aggiornato, anche le righe d'ordine vengono aggiornate
    //FetchType.EAGER: le righe d'ordine vengono caricate insieme all'ordine

    @ManyToOne
    private Customer customer;

    //-----------------METODI-----------------//

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer payer) {
        this.customer = payer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
        result = prime * result + ((orderLines == null) ? 0 : orderLines.hashCode());
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
        Order other = (Order) obj;
        if (creationTime == null) {
            if (other.creationTime != null)
                return false;
        } else if (!creationTime.equals(other.creationTime))
            return false;
        if (orderLines == null) {
            if (other.orderLines != null)
                return false;
        } else if (!orderLines.equals(other.orderLines))
            return false;
        return true;
    }
}
