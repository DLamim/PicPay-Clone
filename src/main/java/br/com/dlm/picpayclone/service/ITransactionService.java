package br.com.dlm.picpayclone.service;

import br.com.dlm.picpayclone.dto.TransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransactionService {

    TransactionDTO process(TransactionDTO transactionDTO);

    Page<TransactionDTO> list(Pageable pageable, String login);
}
