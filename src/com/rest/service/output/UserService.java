package com.rest.service.output;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.service.entities.User;

@Path("/users")
public class UserService {

	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser( @PathParam("id") int id ) {
        User user = new User(id, "Anicet", 18);
        return user;
    }    
	

	  @POST
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public User postUser( @PathParam("id") int id ) {
	        User user = new User(id, "Eric", 25);
	        return user;
	    }    
	  
	  	@POST
	  	@Path("/listUsers")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<User> listUs() {
	  		
	  		List<User> us = new ArrayList<User>();
	  		us.add(new User(1, "Aek", 18));
	  		us.add(new User(2, "Keric", 20));
	  		us.add(new User(3, "Anicet", 25));
	       
	        return us;
	    }    
	  
}
