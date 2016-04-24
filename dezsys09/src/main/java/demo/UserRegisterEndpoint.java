package demo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Registrierung Endpoint
 * @author Philipp Adler
 * @version 2016-02-18
 */

@Named
@Path("/register")
@Produces({MediaType.APPLICATION_JSON})
public class UserRegisterEndpoint {

    @Inject
    private UserService userService;

    /**
     * Hier registriert sich der User, es wird ueberprueft ob der User bereits existiert oder
     * alle notwendigen Daten ausgefuellt wurden
     * @param user der User der sich registrieren möchte
     * @return ob erfolgreich oder bereits existiert oder nicht alle Felder ausgefuellt hat
     */
    @POST
    public Response post(User user) {
        System.out.println("REGISTER");
        if(userService.findByEmail(user.getEmail()) == null){
            if(!(user.getEmail().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty())) {
                this.userService.createUser(user);
                return Response.status(Response.Status.CREATED).entity("Erfolgreich registriert").build();
            }else{
                return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Bitte füllen Sie alle Felder aus").build();
            }
        }else{
            return Response.status(Response.Status.FORBIDDEN).entity("Der User existiert bereits").build();
        }
    }

}