/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.meucomida.api.meucomid.resources;

import br.com.meucomida.api.meucomid.models.Avaliacao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author fabio
 */
@Stateless
@Path("avaliacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class avaliacaoResources {
    
    static List<Avaliacao> avaliacao = new ArrayList<>();
    
    @PersistenceContext(unitName = "MeuComidaPU")
    EntityManager entityManager;
    
    
    
    @GET
    public List<Avaliacao> getAvaliacoesRestaurante(@QueryParam("restaurante") String res){
        return entityManager.createNamedQuery("Ava.findByAva")
                            .setParameter("restaurante", res)
                            .getResultList();
    }
    
    @POST
    public Response addAvaliacao(Avaliacao avaliacao){
        entityManager.persist(avaliacao);
        
        return Response
                .status(Response.Status.CREATED)
                .entity(avaliacao)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Avaliacao getAvaliacao(@PathParam("id") Integer id){
        return entityManager.find(Avaliacao.class,id);
    }
    
    @DELETE
    @Path("{id}")
    public void removeAvaliacao(@PathParam("id") Integer id){
        Avaliacao avaliacaoEncontrada = entityManager.find(Avaliacao.class, id);
        entityManager.remove(avaliacaoEncontrada);
    }
    
    @PUT
    @Path("{id}")
    public Avaliacao updateAvaliacao(@PathParam("id") Integer id,Avaliacao a){
        a.setId(id);
        entityManager.merge(a);
        return a;
    }
}
