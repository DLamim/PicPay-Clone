package br.com.dlm.picpayclone.service.impl;

import br.com.dlm.picpayclone.dto.TransactionDTO;
import br.com.dlm.picpayclone.mapper.TransactionMapper;
import br.com.dlm.picpayclone.model.Transaction;
import br.com.dlm.picpayclone.repository.TransactionRepository;
import br.com.dlm.picpayclone.service.ICreditCardService;
import br.com.dlm.picpayclone.service.ITransactionService;
import br.com.dlm.picpayclone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ICreditCardService creditCardService;

    @Override
    public TransactionDTO process(TransactionDTO transactionDTO) {
        Transaction transaction = save(transactionDTO);
        creditCardService.save(transactionDTO.getCreditCard());
        userService.updateBalance(transaction, transactionDTO.getIsCreditCard());
        return transactionMapper.mapEntityToDto(transaction);
    }

    @Override
    public Page<TransactionDTO> list(Pageable pageable, String login) {
        Page<Transaction> transactions = transactionRepository.findByOrigen_LoginOrDestiny_Login(login, login, pageable);
        return transactionMapper.mapPageEntityToDto(transactions);
    }

    private Transaction save(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.mapDtoToEntity(transactionDTO);
        userService.validate(transaction.getDestiny(), transaction.getOrigen());
        return transactionRepository.save(transaction);
    }
}
