package br.com.dlm.picpayclone.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    @Column(name = "USER_LOGIN", nullable = false)
    private String login;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "USER_FULLNAME", nullable = false)
    private String fullName;

    @Column(name = "USER_CPF", nullable = false)
    private String cpf;

    @Column(name = "USER_BIRTHDAY", nullable = false)
    private LocalDate birthday;

    @Column(name = "USER_PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<CreditCard> creditCardList;

    @Column(name = "USER_BALANCE", nullable = false)
    private Double balance;

    @Column(name = "USER_ASSET", nullable = false)
    private Boolean asset;
}
