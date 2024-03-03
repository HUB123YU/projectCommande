package com.example.tpjee.ws.dto;

import com.example.tpjee.bean.Commande;
import com.example.tpjee.bean.TypePaiement;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class PaiementDto {
    private Long id;
    private String ref;
    private double montant;
    private Date datePaiement;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private TypePaiement typePaiement;
    private boolean encaissement;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String reference) {
        this.ref = reference;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public TypePaiement getTyptPaiement() {
        return typePaiement;
    }

    public void setTyptPaiement(TypePaiement typtPaiement) {
        this.typePaiement = typtPaiement;
    }

    public boolean isEncaissement() {
        return encaissement;
    }

    public void setEncaissement(boolean encaissement) {
        this.encaissement = encaissement;
    }

}
