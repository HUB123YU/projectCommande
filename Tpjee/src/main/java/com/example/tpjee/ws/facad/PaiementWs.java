package com.example.tpjee.ws.facad;

import com.example.tpjee.bean.Paiement;
import com.example.tpjee.service.facade.PaiementService;
import com.example.tpjee.ws.converter.PaiementConverter;
import com.example.tpjee.ws.dto.PaiementDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paiement")
public class PaiementWs {
    @Autowired
    private PaiementService paiementService;
    @Autowired
    private PaiementConverter converter;

    @PostMapping("/")
    public int save(@RequestBody Paiement paiement) {
         return paiementService.save(paiement);
    }
    @PutMapping("/encaisser/code/{code}")
    public int encaisser(@PathVariable String code) {
        return paiementService.encaisser(code);
    }
    @GetMapping("/")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/ref/{ref}")
    public PaiementDto findByRef(@PathVariable String ref) {
        Paiement bean = paiementService.findByRef(ref);
        PaiementDto dto = converter.toDto(bean);
        return dto;
    }

    @GetMapping("/commande/ref/{ref}")
    public List<PaiementDto> findByCommandeRef(@PathVariable String ref) {
        List<Paiement> beans = paiementService.findByCommandeRef(ref);
        List<PaiementDto> dtos = converter.toDto(beans);
        return dtos;
    }

    @DeleteMapping("/commande/ref/{ref}")
    @Transactional
    public int deleteByCommandeRef(@PathVariable String ref) {
        return paiementService.deleteByCommandeRef(ref);
    }
}

