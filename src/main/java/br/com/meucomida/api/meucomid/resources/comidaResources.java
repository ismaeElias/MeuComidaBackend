/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.meucomida.api.meucomid.resources;

import br.com.meucomida.api.meucomid.models.Comida;
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
@Path("comida")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class comidaResources {
    
    static List<Comida> comida = new ArrayList<>();
    
    @PersistenceContext(unitName = "MeuComidaPU")
    EntityManager entityManager;
    
    @GET
    public List<Comida> getComidas(@QueryParam("nome") String nome, @QueryParam("restauranteId") Integer restauranteId){
        if( nome == null){
          return entityManager.createNamedQuery("Comida.findByRestaurante").setParameter("restauranteId", restauranteId).getResultList();
        }else if(nome.length() > 1){
          return entityManager.createNamedQuery("Comida.findByComida")
                              .setParameter("nome", nome)
                              .setParameter("restauranteId", restauranteId).getResultList();
        }else{
          return entityManager.createQuery("SELECT C FROM Comida C", Comida.class).getResultList();
        }
    }
    
    @POST
    public Response addComida(Comida comida){
        entityManager.persist(comida);
        
        return Response
                .status(Response.Status.CREATED)
                .entity(comida)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Comida getComida(@PathParam("id") Integer id){
        return entityManager.find(Comida.class,id);
    }
    
    @DELETE
    @Path("{id}")
    public void removeComida(@PathParam("id") Integer id){
        Comida comidaEncontrada = entityManager.find(Comida.class, id);
        entityManager.remove(comidaEncontrada);
    }
    
    @PUT
    @Path("{id}")
    public Comida updateComida(@PathParam("id") Integer id,Comida c){
        c.setId(id);
        entityManager.merge(c);
        return c;
    }
}
