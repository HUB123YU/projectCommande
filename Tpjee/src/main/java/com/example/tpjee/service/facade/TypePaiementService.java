package com.example.tpjee.service.facade;

import com.example.tpjee.bean.Commande;
import com.example.tpjee.bean.Paiement;
import com.example.tpjee.bean.TypePaiement;

public interface TypePaiementService {
    TypePaiement findByCode(String code);

    void setTypePaiement(TypePaiement tp);
    int save(TypePaiement paiement);
}
