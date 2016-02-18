package demo;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by philippadler on 15.02.16.
 */
@Named
public class GreetingServiceClient {

    @Inject
    private UserService userService;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        userService.createUser("Phil","Email","12");
        userService.createUser("Dave","A@a","33");
        System.out.println(userService.findByEmail("A@a").getName());
        System.out.println(userService.findByEmail("A@ab"));
        userService.findAll().forEach(System.out::println);
    }
}