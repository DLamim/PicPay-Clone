package br.com.dlm.picpayclone.service;

import br.com.dlm.picpayclone.model.Transaction;
import br.com.dlm.picpayclone.model.User;

public interface IUserService {

    User queryEntity(String login);

    void validate(User... users);

    void updateBalance(Transaction transaction, Boolean isCreditCard);
}
