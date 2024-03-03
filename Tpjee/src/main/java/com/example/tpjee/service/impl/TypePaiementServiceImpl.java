package com.example.tpjee.service.impl;

import com.example.tpjee.bean.TypePaiement;
import com.example.tpjee.dao.TypePaiementDao;
import com.example.tpjee.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePaiementServiceImpl implements TypePaiementService {
    private @Autowired TypePaiementDao dao ;
    @Override
    public TypePaiement findByCode(String code) {
        return null;
    }
    @Override
    public void setTypePaiement(TypePaiement tp) {
    }
    @Override
    public int save(TypePaiement typePaiement) {
        if (findByCode(typePaiement.getCode())!=null){
            return -1;
        }else{
             dao.save(typePaiement);
             return 1;
        }

    }


}
