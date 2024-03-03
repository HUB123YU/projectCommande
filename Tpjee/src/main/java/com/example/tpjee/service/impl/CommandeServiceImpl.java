package com.example.tpjee.service.impl;
import com.example.tpjee.bean.Commande;
import com.example.tpjee.bean.Paiement;
import com.example.tpjee.dao.CommandeDao;
import com.example.tpjee.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CommandeServiceImpl implements CommandeService{
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private PaiementServiceImpl paiementService;
    @Override
    public int save(Commande c) {
        if (findByRef(c.getRef()) != null) { //findByRef(ref) s'il exeiste dèja ou non = c-à-d chercher si existe cet ref deja si oui existe deje le retour deferent de null
            return -1;
        } else if (c.getTotal() < c.getTotalPaye()) {
            return -2;
        } else {
            c.setTotal(c.getTotal());
            commandeDao.save(c);
            return 1;
        }
    }
public int payer(String ref, double mt){
      Commande commande = findByRef(ref); //reference qui a dans le service
      if(commande==null){
          return -1;
      }else if (commande.getTotalPaye()+ mt > commande.getTotal()){
          return -2;//JE depasse le montant a payer
      }
      else {
          double nvTotalPaye = commande.getTotalPaye() + mt;
          commande.setTotalPaye(nvTotalPaye);
          commandeDao.save(commande);
          return 1;
      }
}
    @Override
    public void update(Commande commande){
        if (findByRef(commande.getRef()) == null) {
            commandeDao.save(commande);
        }
    }
    @Override
    public int encaisser(String code) {
        return 0;
    }
    @Transactional   //transactional de spring pas de jpa
    @Override
    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }
    @Transactional   //transactional de spring pas de jpa
    @Override
    public int deleteByRef(String ref) {
        int res1 = paiementService.deleteByCommandeRef(ref);
        int res2 = commandeDao.deleteByRef(ref);
        return res1+res2;
    }
    @Override
    public List<Commande> findByTotaleLesseThan(double total) {
        return commandeDao.findByTotalLessThan(total);
    }
    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
    @Override
    @Deprecated
    public Commande getOne(Long aLong) {
        return commandeDao.getOne(aLong);
    }
}
