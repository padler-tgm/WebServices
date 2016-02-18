package demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by philippadler on 15.02.16.
 */
@Named
@Transactional
public class UserService {


    @Autowired
    private CRUD entityManager;

    public void createUser(String name, String email, String password) {
        if(!(name.isEmpty() || email.isEmpty() || password.isEmpty())) {
            User user = new User(name, email, password);
            this.createUser(user);
        }
    }

    public void createUser(User user) {
        this.entityManager.save(user);
    }

    public Collection<User> findAll() {
        List<User> collection = new ArrayList<User>();
        this.entityManager.findAll().forEach(collection::add);
        return collection;
    }

    public User findByEmail(String email) {
        return this.entityManager.findByEmail(email);
    }
}