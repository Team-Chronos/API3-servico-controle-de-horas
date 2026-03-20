package com.api.controle_horas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controle_horas.mappers.ControleHorasMapper;
import com.api.controle_horas.modelos.dto.ControleHorasRequestDto;
import com.api.controle_horas.modelos.entidades.ControleHoras;
import com.api.controle_horas.repositorios.ControleHorasRepositorio;

@Service
public class CriadorControleHoras {
  
  @Autowired
  ControleHorasRepositorio repositorio;

  public void criar(ControleHorasRequestDto requestDto){
    ControleHoras controleHoras = ControleHorasMapper.toEntity(requestDto);
    repositorio.save(controleHoras);
  }
}
