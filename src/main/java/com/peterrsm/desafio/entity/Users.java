package com.peterrsm.desafio.entity;

import com.peterrsm.desafio.enumerator.UsersTypeEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double portfolio;

    @Column
    private String full_name;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    @Email
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private UsersTypeEnum type;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", carteira=R$" + portfolio +
                ", nomeCompleto='" + full_name + '\'' +
                ", cpf='" + document + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return Objects.equals(getId(), users.getId()) && Objects.equals(getPortfolio(), users.getPortfolio()) && Objects.equals(getFull_name(), users.getFull_name()) && Objects.equals(getDocument(), users.getDocument()) && Objects.equals(getEmail(), users.getEmail()) && Objects.equals(getPassword(), users.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPortfolio(), getFull_name(), getDocument(), getEmail(), getPassword());
    }
}
