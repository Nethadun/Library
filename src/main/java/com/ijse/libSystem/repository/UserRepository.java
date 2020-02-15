package com.ijse.libSystem.repository;

import com.ijse.libSystem.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Long> {
    User findByUserName(String userName);
}
