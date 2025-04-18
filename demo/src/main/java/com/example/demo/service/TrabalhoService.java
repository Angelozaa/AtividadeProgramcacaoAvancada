package com.example.demo.service;


import com.example.demo.DTO.TrabalhoDTO;
import com.example.demo.models.TrabalhoModel;
import com.example.demo.repository.trabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private trabalhoRepository repository;

    public TrabalhoDTO salvar(TrabalhoDTO dto) {
        TrabalhoModel trabalhoModel = new TrabalhoModel(null, dto.getEndereco());
        TrabalhoModel salvo = repository.save(trabalhoModel);
        return mapToDTO(salvo);
    }

    public List<TrabalhoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TrabalhoDTO buscarPorId(Long id) {
        TrabalhoModel trabalhoModel= repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabalho nao encontrado"));
        return mapToDTO(trabalhoModel);
    }

    public TrabalhoDTO atualizar(Long id, TrabalhoDTO dto) {
        TrabalhoModel trabalhoModel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabalho nao encontrado"));

        trabalhoModel.setEndereco(dto.getEndereco());

        TrabalhoModel atualizado = repository.save(trabalhoModel);
        return mapToDTO(atualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private TrabalhoDTO mapToDTO(TrabalhoModel trabalhoModel) {
        TrabalhoDTO dto = new TrabalhoDTO();
        dto.setId(trabalhoModel.getId());
        dto.setEndereco(trabalhoModel.getEndereco());
        return dto;
    }
}
