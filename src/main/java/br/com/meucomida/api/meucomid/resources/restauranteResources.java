/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.meucomida.api.meucomid.resources;

import br.com.meucomida.api.meucomid.models.Restaurante;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author fabio
 */

@Stateless
@Path("restaurante")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class restauranteResources {
    
     static List<Restaurante> restaurante  = new ArrayList<>();
    
    @PersistenceContext(unitName = "MeuComidaPU")
    EntityManager entityManager;
    
    @GET
    public List<Restaurante> getRestaurantes(){
        return entityManager.createQuery("SELECT R FROM Restaurante R", Restaurante.class).getResultList();
    }
    
    @POST
    public Response addRestaurante (Restaurante restaurante){
        entityManager.persist(restaurante);
        
        return Response
                .status(Response.Status.CREATED)
                .entity(restaurante)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Restaurante getRestaurante(@PathParam("id") Integer id){
        return entityManager.find(Restaurante.class,id);
    }
    
    @DELETE
    @Path("{id}")
    public void removeRestaurante(@PathParam("id") Integer id){
        Restaurante restauranteEncontrado = entityManager.find(Restaurante.class, id);
        entityManager.remove(restauranteEncontrado);
    }
    
    @PUT
    @Path("{id}")
    public Restaurante updateUsuario(@PathParam("id") Integer id,Restaurante r){
        r.setId(id);
        entityManager.merge(r);
        return r;
    }
}
