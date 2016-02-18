package demo;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

/**
 * Hier werden alle Endpoints bzw. Schnittstellen fuer die Applikation erstellt
 * @author Philipp Adler
 * @version 2016-02-18
 */
@Named
public class JerseyConfig extends ResourceConfig {

    /**
     * Inizialiserit alle Endpoints
     */
    public JerseyConfig() {
        this.register(UserRegisterEndpoint.class);
        this.register(UserLoginEndpoint.class);
        this.register(JacksonFeature.class);
    }
}