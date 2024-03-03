package com.example.tpjee.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commande {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String ref;
    private double total;//100
    private double totalPaye; //28,58,55,75
    private double montantPayeEspece;
    private double montantPayeCheque;
    @OneToMany
    private List<Paiement> paiments;
    public double getMontantPayeCheque() {
        return montantPayeCheque;
    }
    public void setMontantPayeCheque(double montantPayeCheque) {
        this.montantPayeCheque = montantPayeCheque;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public  String getRef() {
        return ref;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public double getMontantPayeEspece() {
        return montantPayeEspece;
    }
    public void setMontantPayeEspece(double montantPayeEspece) {
        this.montantPayeEspece = montantPayeEspece;
    }

    public List<Paiement> getPaiments() {
        return paiments;
    }

    public void setPaiments(List<Paiement> paiments) {
        this.paiments = paiments;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }



}
