package com.baser.test_dashboard_final.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user") // user rezerve kelime, bu yüzden tablo adı app_user
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    // Getter ve Setter elle yazılmış

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
