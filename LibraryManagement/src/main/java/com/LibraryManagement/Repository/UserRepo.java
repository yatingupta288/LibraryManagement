package com.LibraryManagement.Repository;

import com.LibraryManagement.Entity.UserEntity;
import com.LibraryManagement.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {

}
