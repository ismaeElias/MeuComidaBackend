package br.com.meucomida.api.meucomid.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author fabio
 */
@Entity
@Table(name = "usuario", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT A FROM Usuario A WHERE A.usuario = :usuario and A.senha = :senha")
})
public class Usuario implements Serializable{
    
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(nullable = false)
   private Boolean pessoaJuridica;
   
   @Column(nullable = false)
   private String nome;
   
   @Column(nullable = false, unique = true)
   private String telefone;
   
   @Column(nullable = false, unique = true)
   private String CPF;
   
   @Column(nullable = false, unique = true)
   private String email;
   
   @Column(nullable = false)
   private String endereco;
   
   @Column(nullable = false)
   private Integer numResidencia;
   
   @Column(nullable = false)
   private String bairro;
   
   @Column(nullable = false)
   private String usuario;
   
   @Column(nullable = false)
   private String senha;
    
   
   
   public Usuario(){
       
   }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(Boolean pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumResidencia() {
        return numResidencia;
    }

    public void setNumResidencia(Integer numResidencia) {
        this.numResidencia = numResidencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
   
   
}
