package demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Der Controller, welcher alle CRUD Methoden des Users zur Verfügung stellt
 * @author Philipp Adler
 * @version 2016-02-18
 */
@Named
@Transactional
public class UserService {


    @Autowired
    private CRUD entityManager;

    /**
     * Hier werden alle Daten uebernommen, kontrolliert und persistiert
     * @param name Username
     * @param email Useremail
     * @param password Userpasswort
     */
    public void createUser(String name, String email, String password) {
        if(!(name.isEmpty() || email.isEmpty() || password.isEmpty())) {
            User user = new User(name, email, password);
            this.createUser(user);
        }
    }

    /**
     * Hier wird der User in die Datenbank persistiert
     * @param user der zu persistierende User
     */
    public void createUser(User user) {
        this.entityManager.save(user);
    }

    /**
     * Liefert alle registrierten User von der Datenbank
     * @return Liste der User
     */
    public Collection<User> findAll() {
        List<User> collection = new ArrayList<User>();
        this.entityManager.findAll().forEach(collection::add);
        return collection;
    }

    /**
     * Hier wird nach einem spezifischen User anhand seiner Email-Adresse gesucht
     * @param email die Email-Adresse des zu suchenden Users
     * @return User
     */
    public User findByEmail(String email) {
        return this.entityManager.findByEmail(email);
    }
}