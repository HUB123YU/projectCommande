package com.example.tpjee.service.impl;
import com.example.tpjee.bean.Commande;
import com.example.tpjee.bean.Paiement;
import com.example.tpjee.bean.TypePaiement;
import com.example.tpjee.dao.PaiementDao;
import com.example.tpjee.dao.TypePaiementDao;
import com.example.tpjee.service.facade.CommandeService;
import com.example.tpjee.service.facade.PaiementService;
import com.example.tpjee.service.facade.TypePaiementService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaiementServiceImpl implements PaiementService {
    @Autowired
    private PaiementDao paiementDao;
    private @Autowired CommandeService commandeService;
    private @Autowired TypePaiementService typePaiementService;
    public static final String ESPECE = "espece"; //ctr + alt + c + entrer
    public static final String CHEQUE = "cheque";
    @Override
    public int save(Paiement paiement) {
        String code = paiement.getTypePaiement().getCode();
        TypePaiement tp =typePaiementService.findByCode(code);
        typePaiementService.setTypePaiement(tp);
        String ref = paiement.getCommande().getRef();
        Commande commande = commandeService.findByRef(ref);
        paiement.setCommande(commande);
        if (commande == null) {
            return -1;
        } else if (commande.getMontantPayeCheque() + commande.getMontantPayeEspece() + paiement.getMontant() > commande.getTotal()) {
            return -2;
        }else if (paiement.getTypePaiement()==null || (!code.equals(ESPECE) && !code.equals(CHEQUE))){
            return -3;
        }else {
            paiementDao.save(paiement);
            String codeTypePaiement = code;
            if (ESPECE.equals(codeTypePaiement)){
                commande.setMontantPayeEspece(commande.getMontantPayeEspece()+paiement.getMontant());
            }else {
                commande.setMontantPayeCheque(commande.getMontantPayeCheque()+paiement.getMontant());
            }
            commandeService.update(commande);
            return 1;
        }
    }
    @Override
    public int encaisser(String code){
        Paiement paiement = findByRef(code);
        if (paiement == null) {
            return -1;
        }else if (paiement.getTypePaiement()!=null && !ESPECE.equals(paiement.getTypePaiement().getCode())){
            return -2;
        } else if (paiement.isEncaissement()==true) {
            return -3;
        }else{
            paiement.setEncaissement(true);
            paiementDao.save(paiement);
            Commande commande = paiement.getCommande();
            commande.setMontantPayeCheque(commande.getMontantPayeCheque()-paiement.getMontant());
            commande.setMontantPayeEspece(commande.getMontantPayeEspece()+paiement.getMontant());
            commandeService.update(commande);
            return 1;
        }
    }
    @Override
    @Deprecated
    public Paiement getOne(Long aLong) {  //pour retourner l'id
        return paiementDao.getOne(aLong);
    }
    @Override
    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }
    @Override
    public Paiement findByRef(String ref) {
        return paiementDao.findByRef(ref);
    }
    @Override
    public int deleteByRef(String ref){
        return paiementDao.deleteByRef(ref);
    }
    @Override
    public void update(Commande commande) {
    }
    @Override
    public List<Commande> findNonPaye() {
        return null;
    }
    @Override
    public List<Paiement> findByCommandeRef(String ref) {
        return paiementDao.findByCommandeRef(ref);
    }
    @Override
    @Transactional
    public int deleteByCommandeRef(String ref) {
        return paiementDao.deleteByCommandeRef(ref);
    }
}

