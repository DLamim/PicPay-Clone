package br.com.dlm.picpayclone.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction extends BaseEntity {

    @Column(name = "TR_CODE", nullable = false)
    private String code;

    @ManyToOne(cascade = {CascadeType.MERGE })
    @JoinColumn(name = "TR_USER_ORIGEN", nullable = false)
    private User origen;

    @ManyToOne(cascade = {CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinColumn(name = "TR_USER_DESTINY", nullable = false)
    private User destiny;

    @Column(name = "TR_DATE_TIME", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "TR_VALUE", nullable = false)
    private Double value;

}
