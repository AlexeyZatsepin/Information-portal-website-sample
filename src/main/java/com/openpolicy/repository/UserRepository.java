package com.openpolicy.repository;

import com.openpolicy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

//    @Query("SELECT p FROM User p WHERE LOWER(p.login) = LOWER(:login)")
    User findByUsername(String username);;
}
