package demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by philippadler on 14.02.16.
 */
public interface CRUD extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}
