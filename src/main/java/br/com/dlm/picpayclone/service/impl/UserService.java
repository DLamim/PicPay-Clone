package br.com.dlm.picpayclone.service.impl;

import br.com.dlm.picpayclone.exceptions.BusinessException;
import br.com.dlm.picpayclone.model.Transaction;
import br.com.dlm.picpayclone.model.User;
import br.com.dlm.picpayclone.repository.UserRepository;
import br.com.dlm.picpayclone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User queryEntity(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void validate(User... users) {
        Arrays.asList(users).stream().forEach(user -> {
            if (user == null) {
                throw new BusinessException("User not found.");
            }
        });

    }

    @Override
    @Async("asyncExecutor")
    public void updateBalance(Transaction transaction, Boolean isCreditCard) {
        decrementBalance(transaction, isCreditCard);
        incrementBalance(transaction);
    }

    private void incrementBalance(Transaction transaction) {
        userRepository.updateIncrementBalance(transaction.getDestiny().getLogin(), transaction.getValue());
    }

    private void decrementBalance(Transaction transaction, Boolean isCreditCard) {
        if (!isCreditCard) {
            userRepository.updateDecrementBalance(transaction.getOrigen().getLogin(), transaction.getValue());
        }
    }
}
