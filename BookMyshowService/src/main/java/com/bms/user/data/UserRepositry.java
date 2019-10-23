package com.bms.user.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositry extends JpaRepository<UserDao, Integer> {

}
