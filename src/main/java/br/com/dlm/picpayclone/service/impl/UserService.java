package br.com.dlm.picpayclone.service.impl;

import br.com.dlm.picpayclone.model.User;
import br.com.dlm.picpayclone.repository.UserRepository;
import br.com.dlm.picpayclone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User queryEntity(String login) {
        return userRepository.findByLogin(login);
    }
}
