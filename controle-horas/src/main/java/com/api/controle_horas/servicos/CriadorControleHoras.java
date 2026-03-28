package com.api.controle_horas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import com.api.controle_horas.mappers.ControleHorasMapper;
import com.api.controle_horas.modelos.dto.ControleHorasRequestDto;
import com.api.controle_horas.modelos.entidades.ControleHoras;
import com.api.controle_horas.repositorios.ControleHorasRepositorio;

@Service
public class CriadorControleHoras {

  @Autowired
  ControleHorasRepositorio repositorio;

  public void criar(ControleHorasRequestDto requestDto) {
    RestTemplate restTemplate = new RestTemplate();

    try {
      restTemplate.getForObject(
        "http://localhost:8081/tarefas/" + requestDto.getTarefa_id(),
        String.class
      );

      ControleHoras controleHoras = ControleHorasMapper.toEntity(requestDto);
      repositorio.save(controleHoras);

    } catch (RestClientException e) {
      throw new RuntimeException("Tarefa não encontrada");
    }
  }
}
