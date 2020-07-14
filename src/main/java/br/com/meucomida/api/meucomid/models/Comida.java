/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.meucomida.api.meucomid.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fabio
 */

@Entity
@Table(name = "comida", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Comida.findByComida", query = "SELECT C FROM Comida C WHERE C.nome = :nome"),
    @NamedQuery(name = "Comida.findByRestaurante", query = "SELECT C FROM Comida C WHERE C.restauranteId = :id")
})
public class Comida implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer restauranteId;
    
    @Column(nullable = false)
    private String itens_composicao;
    
    @Column(nullable = false)
    private String usuario;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String detalhes;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private Integer popularidade;
    
    @Column(nullable = false)
    private Integer valor;
    
    @Column(nullable = false)
    private String urlImagem;
    
    public Comida(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Integer restauranteId) {
        this.restauranteId = restauranteId;
    }

    public String getItens_composicao() {
        return itens_composicao;
    }

    public void setItens_composicao(String itens_composicao) {
        this.itens_composicao = itens_composicao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(Integer popularidade) {
        this.popularidade = popularidade;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
    
    
    
}
