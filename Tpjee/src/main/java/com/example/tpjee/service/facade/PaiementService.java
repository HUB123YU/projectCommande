package com.example.tpjee.service.facade;

import com.example.tpjee.bean.Commande;
import com.example.tpjee.bean.Paiement;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PaiementService{

    int save(Paiement paiement);

    int encaisser(String code);

    @Deprecated
    Paiement getOne(Long aLong);

    List<Paiement> findAll();

    Paiement findByRef(String ref);

    int deleteByRef(String ref);

    void update(Commande commande);

    List<Commande> findNonPaye();

    List<Paiement> findByCommandeRef(String ref);

    @Transactional
    int deleteByCommandeRef(String ref);
}
