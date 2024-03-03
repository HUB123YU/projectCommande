package com.example.tpjee.ws.converter;

import com.example.tpjee.bean.Commande;
import com.example.tpjee.ws.dto.CommandeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeConverter {
    public Commande toBean(CommandeDto dto) {
        Commande bean = new Commande();
        bean.setId(dto.getId());
        bean.setRef(dto.getCode());
        bean.setTotal(dto.getTotal());
        bean.setTotalPaye(dto.getTotalPaye());
        bean.setMontantPayeCheque(dto.getMontantPayeCheque());
        bean.setMontantPayeEspece(dto.getMontantPayeEspece());
        bean.setPaiments(dto.getPaiments());
        return bean;
    }

    public CommandeDto toDto(Commande bean) {
        CommandeDto dto = new CommandeDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getRef());
        dto.setTotal(bean.getTotal());
        dto.setTotalPaye(bean.getTotalPaye());
        dto.setMontantPayeCheque(bean.getMontantPayeCheque());
        dto.setMontantPayeEspece(bean.getMontantPayeEspece());
        dto.setPaiments(bean.getPaiments());
        return dto;
    }



    public List<Commande> toBean(List<CommandeDto> dtos) { //convertir les dtos a des beans
        //return dtos.stream().map(e->toBean(e)).collect(Collectors.toList());
        List<Commande> result = new ArrayList<>();
        for (CommandeDto dto : dtos) { //dtos.for
            result.add(toBean(dto));//Ajouter un result a le arrayList
        }

        return result;// Une fois que tous les objets CommandeDto ont été convertis et ajoutés à la liste result, cette liste est retournée en tant que résultat de la méthode.
    }

    public List<CommandeDto> toDto(List<Commande> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}

