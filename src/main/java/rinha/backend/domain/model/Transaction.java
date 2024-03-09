package rinha.backend.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import rinha.backend.domain.enuns.TransactionType;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String description;

    @CreationTimestamp
    private LocalDateTime realizedIn;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @Builder
    public Transaction(TransactionType type, Integer amount, String description, Client client) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.client = client;
    }
}
