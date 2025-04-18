package com.example.demo.service;

import com.example.demo.DTO.PessoaDTO;
import com.example.demo.models.PessoaModel;
import com.example.demo.repository.pessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private pessoaRepository repository;

    public PessoaDTO salvar(PessoaDTO dto) {
        PessoaModel pessoaModel = new PessoaModel(null, dto.getNome(), dto.getCpf());
        PessoaModel salvo = repository.save(pessoaModel);
        return mapToDTO(salvo);
    }

    public List<PessoaDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO buscarPorId(Long id) {
        PessoaModel pessoaModel= repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrado"));
        return mapToDTO(pessoaModel);
    }

    public PessoaDTO atualizar(Long id, PessoaDTO dto) {
        PessoaModel pessoaModel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa nao encontrada"));

        pessoaModel.setNome(dto.getNome());
        pessoaModel.setCpf(dto.getCpf());

        PessoaModel atualizado = repository.save(pessoaModel);
        return mapToDTO(atualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private PessoaDTO mapToDTO(PessoaModel pessoaModel) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoaModel.getId());
        dto.setNome(pessoaModel.getNome());
        dto.setCpf(pessoaModel.getCpf());
        return dto;
    }
}
