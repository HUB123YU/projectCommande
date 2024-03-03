package com.example.tpjee.dao;

import com.example.tpjee.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);
    int deleteByRef(String ref);
    List<Commande> findByRefLikeAndTotalGreaterThan(String ref, double total);
    List<Commande> findByTotalLessThan(double total);
    @Query("select item from Commande item where item.total < item.montantPayeEspece + item.montantPayeCheque") //jpaql et l'entity il est sensible a la case
    //@Query(value = "select * Commande where item.total < montantPayeEspece + montantPayeCheque",nativeQuery = true) //sql
    List<Commande> findNonPaye();

}
