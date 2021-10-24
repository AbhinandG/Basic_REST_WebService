package com.abhi.demorest;


import java.util.Arrays;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("users")
public class alienresource {
	
	mockRepo repo=new mockRepo();
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ali> getIt() {
        System.out.println("Inside funcx");
        return repo.getUsers();
       
	}

    
    @POST
    @Path("user")
    public ali createUser(ali a)
    {
    	System.out.println(a);
    	repo.create(a);
    	return a;
    }
    
    @GET
    @Path("user/{user1}/{pass1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkUser(@PathParam("user1") String user1, @PathParam("pass1") String pass1)
    {
    	boolean ans=repo.checkUsers(user1,pass1);
    	if(ans==true)
    		return "Account exists";
    	return "Account doesn't exist!";
    }
    
	
}
