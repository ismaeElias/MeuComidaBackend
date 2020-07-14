/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.meucomida.api.meucomid.resources;

import br.com.meucomida.api.meucomid.models.Pedido;
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
@Path("pedidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class pedidoResources {
    
    static List<Pedido> pedido = new ArrayList<>();
    
    @PersistenceContext(unitName = "MeuComidaPU")
    EntityManager entityManager;
    
    @GET
    public List<Pedido> getPedidos(){
        return entityManager.createQuery("SELECT P FROM Pedido P", Pedido.class).getResultList();
    }
    
    @POST
    public Response addPedido(Pedido pedido){
        entityManager.persist(pedido);
        
        return Response
                .status(Response.Status.CREATED)
                .entity(pedido)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Pedido getPedido(@PathParam("id") Integer id){
        return entityManager.find(Pedido.class,id);
    }
    
    @DELETE
    @Path("{id}")
    public void removePedido(@PathParam("id") Integer id){
        Pedido pedidoEncontrado = entityManager.find(Pedido.class, id);
        entityManager.remove(pedidoEncontrado);
    }
    
    @PUT
    @Path("{id}")
    public Pedido updatePedido(@PathParam("id") Integer id,Pedido p){
        p.setId(id);
        entityManager.merge(p);
        return p;
    }
}
