package com.thollands.app.ws;

import com.thollands.app.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
  //    UserEntity findUserByEmail(String email); // Don't need this due to repository annotation.
}
