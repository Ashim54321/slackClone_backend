package com.project.workmanagemantSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.workmanagemantSystem.domain.enumeration.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user",schema = "public")
@JsonIgnoreProperties(value = { "password","role","authorities","status","accountNonLocked", "username","accountNonExpired","credentialsNonExpired","enabled"}, allowSetters = true)
public class User implements UserDetails {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String password;
    private  String Phone;
    private String email;
    private UserRole role;
    private String status;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
