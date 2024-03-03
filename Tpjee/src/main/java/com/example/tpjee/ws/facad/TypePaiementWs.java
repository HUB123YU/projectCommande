package com.example.tpjee.ws.facad;

import com.example.tpjee.bean.Paiement;
import com.example.tpjee.bean.TypePaiement;
import com.example.tpjee.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/typePaiement")
public class TypePaiementWs {
    private @Autowired TypePaiementService typePaiementService;
    @PostMapping("/")
    public int save(@RequestBody TypePaiement typePaiement) {
        return typePaiementService.save(typePaiement);
    }
}
