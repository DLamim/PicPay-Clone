package br.com.dlm.picpayclone.service.impl;

import br.com.dlm.picpayclone.dto.TransactionDTO;
import br.com.dlm.picpayclone.mapper.TransactionMapper;
import br.com.dlm.picpayclone.model.Transaction;
import br.com.dlm.picpayclone.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public TransactionDTO process(TransactionDTO transactionDTO) {
        Transaction transaction = save(transactionDTO);
        creditCardService.save(transactionDTO.getCreditCard());
        userService.updateBalance(transaction, transactionDTO.getIsCreditCard());
        return transactionMapper.mapEntityToDto(transaction);
    }

    private Transaction save(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.mapDtoToEntity(transactionDTO);
        userService.validate(transaction.getDestiny(), transaction.getOrigen());
        return transactionRepository.save(transaction);
    }
}
