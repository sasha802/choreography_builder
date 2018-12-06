package dance.builder.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class that represents User entity
 */
@Entity(name = "User")
@Table(name = "users")
@Data
public class User {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private int roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;


    /**
     * No argument constructor
     */
    public User() {

    }

    /**
     * Constructor
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     * @param roleId
     */
    public User(String lastName, String firstName, String email, String password, int roleId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }




}
