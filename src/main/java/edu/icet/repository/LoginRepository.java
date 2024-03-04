package edu.icet.repository;

import edu.icet.entity.LoginEntity;
import edu.icet.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginEntity,Long> {
    Boolean existsByEmailAndPassword(String email,String password);
}
