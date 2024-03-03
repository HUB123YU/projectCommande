package com.example.tpjee.service.facade;

import com.example.tpjee.bean.Commande;

import java.util.List;
public interface CommandeService {
    void update(Commande commande);
    int encaisser(String code);
    Commande findByRef(String ref);
    int deleteByRef(String ref);
    List<Commande> findByTotaleLesseThan(double total);
    List<Commande> findAll();
    @Deprecated
    Commande getOne(Long aLong);
    int save(Commande commande);
     int payer(String ref, double mt);
}
