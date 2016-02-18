package demo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by philippadler on 15.02.16.
 */

@Named
@Path("/register")
@Produces({MediaType.APPLICATION_JSON})
public class UserRegisterEndpoint {

    @Inject
    private UserService userService;

    @POST
    public Response post(User user) {
        if(userService.findByEmail(user.getEmail()) != null){
            if(!(user.getEmail().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty())) {
                this.userService.createUser(user);
                return Response.status(Response.Status.OK).entity("Erfolgreich registriert").build();
            }else{
                return Response.status(Response.Status.CONFLICT).entity("Bitte füllen Sie alle Felder aus").build();
            }
        }else{
            return Response.status(Response.Status.FORBIDDEN).entity("Der User existiert bereits").build();
        }
    }

}