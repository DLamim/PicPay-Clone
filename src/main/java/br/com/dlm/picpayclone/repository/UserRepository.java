package br.com.dlm.picpayclone.repository;

import br.com.dlm.picpayclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
