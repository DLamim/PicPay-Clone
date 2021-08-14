package br.com.dlm.picpayclone.model;

import br.com.dlm.picpayclone.enums.CardFlag;
import lombok.*;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class CreditCard extends BaseEntity {

    @Column(name = "CC_NUMBER", nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "CC_FLAG", nullable = false)
    private CardFlag flg;

    @Column(name = "CC_TOKEN", nullable = false)
    private String tokenNumber;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "CC_USER_ID", nullable = false)
    private User user;
}
