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
 * Login Endpoint
 * @author Philipp Adler
 * @version 2016-02-18
 */
@Named
@Path("/login")
@Produces({MediaType.APPLICATION_JSON})
public class UserLoginEndpoint {

    @Inject
    private UserService greetingService;

    /**
     * Hier wird der User eingeloggt, es wird ueberprueft ob seine Daten korrekt sind
     * @param user der User der sich anmelden möchte
     * @return ob erfolgreich oder ob die Anmeldedaten falsch sind
     */
    @POST
    public Response post(User user) {
        User loginuser = this.greetingService.findByEmail(user.getEmail());
        try{
            if(loginuser != null) {
                if (loginuser.getPassword().equals(user.getPassword())) {
                    return Response.status(Response.Status.OK).entity("Herzlich Willkommen: " + user.getEmail()).build();
                }
            }
        }catch(NullPointerException e){
        }
        return Response.status(Response.Status.FORBIDDEN).entity("Falsche Anmeldedaten").build();
    }

}
