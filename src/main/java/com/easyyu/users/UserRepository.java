package com.easyyu.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value="update users u set u.token = ?1 where u.username = ?2")
    int setTokenForUsers(String token, String username);

    @Query(value="select token from users where token = :token", nativeQuery = true)
    String getToken(@Param("token") String token);

}
