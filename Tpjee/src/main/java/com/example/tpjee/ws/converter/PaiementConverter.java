package com.example.tpjee.ws.converter;

import com.example.tpjee.bean.Paiement;
import com.example.tpjee.ws.dto.PaiementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaiementConverter {


    public Paiement toBean(PaiementDto dto) {
        Paiement bean = new Paiement();
        BeanUtils.copyProperties(dto, bean); // copyProperties: copier les valeurs des propriétés d'un objet source (bean) vers un objet cible (dto).
        return bean;
    }
    public PaiementDto toDto(Paiement bean) { //Cette ligne copie les propriétés de l'objet bean (Paiement) dans l'objet dto (PaiementDto)
        PaiementDto dto = new PaiementDto();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }
    public List<Paiement> toBean(List<PaiementDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }
    public List<PaiementDto> toDto(List<Paiement> beans) {
        return beans.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }


}
