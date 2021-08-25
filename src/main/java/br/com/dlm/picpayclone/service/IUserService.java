package br.com.dlm.picpayclone.service;

import br.com.dlm.picpayclone.model.User;

public interface IUserService {

    User queryEntity(String login);
}
