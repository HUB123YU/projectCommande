package com.example.tpjee.ws.facad;

import com.example.tpjee.bean.Commande;
import com.example.tpjee.service.facade.CommandeService;
import com.example.tpjee.service.impl.CommandeServiceImpl;
import com.example.tpjee.ws.converter.CommandeConverter;
import com.example.tpjee.ws.dto.CommandeDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/commande")

public class CommandeProvided {

@PutMapping("/")
    public void update(@RequestBody CommandeDto dto){
        //service.update(c);
    }
    @PostMapping("/")
    public int save(@RequestBody CommandeDto dto) {
        Commande bean = converter.toBean(dto);
        return service.save(bean);
    }

    @GetMapping("/ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande commande = service.findByRef(ref);
        return converter.toDto(commande);
    }


    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {

    return service.deleteByRef(ref);
    }

    @GetMapping("/totale/{totale}")
    public List<CommandeDto> findByTotaleLesseThan(@PathVariable double total) {
        List<Commande> commandes = service.findByTotaleLesseThan(total);
        return converter.toDto(commandes);
    }

    @GetMapping("/")
    public List<CommandeDto> findAll() {
        List<Commande> commandes = service.findAll();
        return converter.toDto(commandes);
    }
    @GetMapping("/ref/{ref}/mt/{mt}")
    public int payer(@PathVariable String ref,@PathVariable double mt) {
        return service.payer(ref, mt);
    }

    @Autowired
    private CommandeConverter converter;
    @Autowired
    private CommandeService service;

}

