package rinha.backend.domain.repositories;

import jakarta.persistence.OrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rinha.backend.api.dtos.response.TransactionDTO;
import rinha.backend.domain.model.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTop10ByClientIdOrderByRealizedInDesc(Long clientId);

}
