package gustavo.acacio.desafiopicpay.picpay.entity;

import gustavo.acacio.desafiopicpay.picpay.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wallet_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class WalletType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public enum Value {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        Value(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        private Long id;
        private String description;

        public WalletType get() {
            return new WalletType(id, description);
        }
    }
}
