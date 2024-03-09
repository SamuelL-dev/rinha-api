package rinha.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false)
    private Integer balance;

    @Column(nullable = false)
    private final Integer balanceLimit;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private final List<Transaction> lastTransactions = new ArrayList<>(0);


    public Client(Long id, String name, Integer balance, Integer balanceLimit) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.balanceLimit = balanceLimit;
    }

    public Integer getTotalAvailable(){
       return this.balance + this.balanceLimit;
    }
}
