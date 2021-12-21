package br.com.dlm.picpayclone.repository;

import br.com.dlm.picpayclone.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByOrigen_LoginOrDestiny_Login(String login, String login1, Pageable pageable);
}
