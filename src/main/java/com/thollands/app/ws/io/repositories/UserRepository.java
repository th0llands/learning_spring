package com.thollands.app.ws.io.repositories;

import com.thollands.app.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
In spring framework, @Component annotation marks a java class as a bean so the component-scanning
mechanism can pick it up and pull it into the application context.

As @Repository serves as a specialization of @Component, it also enable annotated classes to be
discovered and registered with application context.

CrudRepository implements basic CRUD operations, including count, delete, deleteById, save, saveAll,
findById, and findAll.
 */

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
  // This method will query database table "users" (by looking at @Entity(name="users) within
  // UserEntity class) BY email and return it as a UserEntity
}
