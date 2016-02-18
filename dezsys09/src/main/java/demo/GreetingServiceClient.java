package demo;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Client zum testen der implementierten Funktionen
 * @author Philipp Adler
 * @version 2016-02-18
 */
@Named
public class GreetingServiceClient {

    @Inject
    private UserService userService;

    /**
     * Testet ob ein User erzeugt und gesucht werden kann
     */
    @PostConstruct
    public void afterPropertiesSet(){
        userService.createUser("Phil","Email","12");
        userService.createUser("Dave","A@a","33");
        System.out.println(userService.findByEmail("A@a").getName());
        System.out.println(userService.findByEmail("A@ab"));
        userService.findAll().forEach(System.out::println);
    }
}