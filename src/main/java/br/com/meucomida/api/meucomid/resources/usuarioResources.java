/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.meucomida.api.meucomid.resources;

import br.com.meucomida.api.meucomid.models.Usuario;
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
@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class usuarioResources {

    
    @PersistenceContext(unitName = "MeuComidaPU")   
    EntityManager entityManager;
    
    @GET
    public List<Usuario> getUsuarios(@QueryParam("usuario") String usuario, @QueryParam("senha") String senha){
        return entityManager.createNamedQuery("Usuario.findByUsuario")
                            .setParameter("usuario", usuario)
                            .setParameter("senha", senha)
                            .getResultList();
    }
    
    @POST
    public Response addUsuario(Usuario usuario){
        entityManager.persist(usuario);
        
        return Response
                .status(Response.Status.CREATED)
                .entity(usuario)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Usuario getUsuario(@PathParam("id") Integer id){
        return entityManager.find(Usuario.class,id);
    }
    
    @DELETE
    @Path("{id}")
    public void removeUsuario(@PathParam("id") Integer id){
        Usuario usuarioEncontrado = entityManager.find(Usuario.class, id);
        entityManager.remove(usuarioEncontrado);
    }
    
    @PUT
    @Path("{id}")
    public Usuario updateUsuario(@PathParam("id") Integer id,Usuario u){
        u.setId(id);
        entityManager.merge(u);
        return u;
    }
}
