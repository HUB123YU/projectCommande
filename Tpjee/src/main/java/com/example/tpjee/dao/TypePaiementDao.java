package com.example.tpjee.dao;

import com.example.tpjee.bean.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaiementDao extends JpaRepository<TypePaiement,Long> {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);
}
//input:ref commande ------ output: retourner la liste de paiement de cet commande
