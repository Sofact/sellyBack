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

    @Column(name="conv_id")
    private Long convId;

    @Column(name="mun_id")
    private Long munId;

    @Column(name="role")
    private Long role;

    @Column(name="cli_banco")
    private String cliBanco;

    @Column(name="cli_tipo_cuenta")
    private String cliTipoCuenta;

    @Column(name="cli_num_cuenta")
    private String cliNumCuenta;

    @Column(name="cli_password")
    private String cliPassword;

    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
*/
    public User() {
    }

    public User(String username, String email, String password, Long convId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.convId = convId;
    }

    public User(String username, String email, String password, Long convId, Long munId, String cliBanco, String cliTipoCuenta, String cliNumCuenta) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.convId = convId;
        this.munId = munId;
        this.cliBanco = cliBanco;
        this.cliTipoCuenta = cliTipoCuenta;
        this.cliNumCuenta = cliNumCuenta;
    }

    public User(String username, String email, String encode, Long convId, Long munId) {
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




    public Long getConvId() {
        return convId;
    }

    public void setConvId(Long convId) {
        this.convId = convId;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public Long getMunId() {
        return munId;
    }

    public void setMunId(Long munId) {
        this.munId = munId;
    }

    public String getCliBanco() {
        return cliBanco;
    }

    public void setCliBanco(String cliBanco) {
        this.cliBanco = cliBanco;
    }

    public String getCliTipoCuenta() {
        return cliTipoCuenta;
    }

    public void setCliTipoCuenta(String cliTipoCuenta) {
        this.cliTipoCuenta = cliTipoCuenta;
    }

    public String getCliNumCuenta() {
        return cliNumCuenta;
    }

    public void setCliNumCuenta(String cliNumCuenta) {
        this.cliNumCuenta = cliNumCuenta;
    }

    public String getCliPassword() {
        return cliPassword;
    }

    public void setCliPassword(String cliPassword) {
        this.cliPassword = cliPassword;
    }
}
