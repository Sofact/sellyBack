package selly.cash.back.models.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users", schema="sc",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "user_name"),
                @UniqueConstraint(columnNames = "user_email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;



    @Column(name="user_name")
    private String username;

    @Column(name="user_email")
    private String email;

    @Column(name="user_password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
