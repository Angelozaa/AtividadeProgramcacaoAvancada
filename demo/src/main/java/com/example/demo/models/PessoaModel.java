package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class PessoaModel{

    @ManyToOne
    @JoinColumn(name = "trabalho_model_id")
    private TrabalhoModel trabalhoModel;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private String CPF;

    public TrabalhoModel getTrabalhoModel() {
        return trabalhoModel;
    }

    public void setTrabalhoModel(TrabalhoModel trabalhoModel) {
        this.trabalhoModel = trabalhoModel;
    }

    public PessoaModel(Object o, String nome, String cpf) {
    }

    public PessoaModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return CPF;
    }

    public String setCpf(String cpf) {
        this.CPF = CPF;
        return cpf;
    }


}
