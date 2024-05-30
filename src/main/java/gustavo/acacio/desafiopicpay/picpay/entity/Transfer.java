package gustavo.acacio.desafiopicpay.picpay.entity;

import gustavo.acacio.desafiopicpay.picpay.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transfer")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transfer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet receiver;

    @Column(name = "value")
    private BigDecimal value;

    public Transfer(Wallet sender, Wallet receiver, BigDecimal value) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }
}
