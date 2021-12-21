package br.com.dlm.picpayclone.repository;

import br.com.dlm.picpayclone.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
