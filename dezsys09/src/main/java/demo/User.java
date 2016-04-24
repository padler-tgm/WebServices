package demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * User Model, welches in der Datenbank persistiert wird
 * @author Philipp Adler
 * @version 2016-02-18
 */
@Entity
@Table(name="User")
public class User implements Serializable{

    @NotNull
    private String name;

    @Id
    @NotNull
    private String email;

    @NotNull
    private String password;

    /**
     * Default-Konstruktor
     */
    public User(){}

    /**
     * Konstruktor erstellt einen User anhand Email und seines Passworts
     * @param email Email des Users
     * @param password Passwort des Users
     */
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    /**
     * Konstruktor erstellt einen User anhand seines Namens, Email und seines Passworts
     * @param name Name des Users
     * @param email Email des Users
     * @param password Passwort des Users
     */
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Lierfert den Namen des Users
     * @return Username
     */
    public String getName() {
        return name;
    }

    /**
     * Hier wird der Username geaendert
     * @param name neue Username
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Lierfert die Email des Users
     * @return Useremail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Hier wird die Useremail geaendert
     * @param email neue Useremail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Lierfert das Passwort des Users
     * @return Userpasswort
     */
    public String getPassword() {
        return password;
    }

    /**
     * Hier wird das Userpasswort geaendert
     * @param password neue Userpasswort
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
