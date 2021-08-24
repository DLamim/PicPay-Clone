package br.com.dlm.picpayclone.service;

import br.com.dlm.picpayclone.dto.TransactionDTO;

public interface ITransactionService {

    TransactionDTO process(TransactionDTO transactionDTO);
}
