package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    User findByEmail(String email);
    //Write a derived query to read a user with a username?
    User findByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?
List<User>  findByUsernameContaining(String pattern);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User>  findByUsernameContainingIgnoreCase(String pattern);


    //Write a derived query to list all users with an age greater than a specified age?
    List<User>  findByAccountAgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
@Query("select u from User u where u.email=?1")
    User  getUserMail(String email);
    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username=?1")
    User  getUserUserName(String userName);

    //Write a JPQL query that returns all users?
    @Query("select u from User u ")
   List<User> getUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
//@Query(value="select * from user_account where user like%?1% ",nativeQuery = true)
//List<User> returnUsersContainName(String pattern);
    //Write a native query that returns all users?
    @Query(value="select * from user_account ",nativeQuery = true)
    List<User> returnUsers();
    //Write a native query that returns all users in the range of ages?
//@Query(value="",nativeQuery = true)
 //   List<User> returnUsersAge();
    //Write a native query to read a user by email?


}
