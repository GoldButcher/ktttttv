package ktv.model;

import javax.persistence.*;

/**
 * Created by evam on 16-12-21.
 */
@Entity
public class Manager {
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private String authority;
    private String telephone;
    private String email;

    public Manager() {
    }

    public Manager(String username, String password, String authority, String telephone, String email) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.telephone = telephone;
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
