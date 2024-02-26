package edu.icet.repository;

import edu.icet.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    UserEntity findByUserName(String userName);

    Boolean existsByUserName(String userName);
}
