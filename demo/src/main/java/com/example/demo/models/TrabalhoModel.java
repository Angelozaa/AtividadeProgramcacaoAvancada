package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "trabalhos")
public class TrabalhoModel {


    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaModel pessoa;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;

    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }

    public TrabalhoModel(Object o, String endereco) {
    }

    public TrabalhoModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
