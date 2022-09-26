package com.projectweb.api;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUserName(String uname);
    List<User> findByToken(String token);
    User findByActiveTrue();
    List<User> findByActiveFalse();
}

