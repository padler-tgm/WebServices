package demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Dieses Interface stellt alle CRUD Funktionen fuer den User zur Verfuegung
 * @author Philipp Adler
 * @version 2016-02-18
 */
public interface CRUD extends CrudRepository<User, Long> {

    /**
     * Findet den User zur uebergebenen Email-Adresse
     * @param email die Email des gesuchten Users
     * @return der gefundene User
     */
    public User findByEmail(String email);
}
