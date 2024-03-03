package com.example.tpjee.dao;

import com.example.tpjee.bean.Paiement;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaiementDao extends JpaRepository <Paiement,Long> {
    Paiement findByRef(String ref);
    List<Paiement> findByCommandeRef(String ref);
    int deleteByCommandeRef(String ref);
    int deleteByRef(String ref);
}
