package com.LibraryManagement.Repository;

import com.LibraryManagement.Entity.UserBookHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookHistoryDetails extends CrudRepository<UserBookHistoryEntity, Long> {

}
