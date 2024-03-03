package com.example.tpjee.ws.dto;

import com.example.tpjee.bean.Paiement;
import jakarta.persistence.OneToMany;

import java.util.List;

public class CommandeDto {
    private Long id;
    private String ref;
    private double total;
    private double totalPaye;
    private double montantPayeEspece;
    private double montantPayeCheque;

    private List<Paiement> paiments;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getMontantPayeEspece() {
        return montantPayeEspece;
    }

    public void setMontantPayeEspece(double montantPayeEspece) {
        this.montantPayeEspece = montantPayeEspece;
    }

    public double getMontantPayeCheque() {
        return montantPayeCheque;
    }

    public void setMontantPayeCheque(double montantPayeCheque) {
        this.montantPayeCheque = montantPayeCheque;
    }

    public List<Paiement> getPaiments() {
        return paiments;
    }

    public void setPaiments(List<Paiement> paiments) {
        this.paiments = paiments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return ref;
    }

    public void setCode(String code) {
        this.ref = code;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }
}
