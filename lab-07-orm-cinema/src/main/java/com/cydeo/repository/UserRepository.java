package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    User findByEmail(String email);
    //Write a derived query to read a user with a username?
    User findByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?
List<User>  findByAccountNameContaining(String pattern);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User>  findByAccountNameContainingIgnoreCase(String pattern);


    //Write a derived query to list all users with an age greater than a specified age?
    List<User>  findByAccountAgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
@Query("select u from User u where u.email=?1")
    User  getUserMail(@Param("email")String email);
    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username=?1")
    User  getUserUserName(@Param("username")String userName);

    //Write a JPQL query that returns all users?
    @Query("select u from User u ")
   List<User> getUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
@Query(value="select * from user_account where username ilike concat('%',?1,'%')",nativeQuery = true)
List<User> returnUsersContainName(@Param("pattern")String pattern);
    //Write a native query that returns all users?
    @Query(value="select * from user_account ",nativeQuery = true)
    List<User> returnUsers();
    //Write a native query that returns all users in the range of ages?
@Query(value="select * from user_account u join account_details a on u.accoun_details_id=a.id where age between ?1 and ?2 ",nativeQuery = true)
   List<User> returnUsersAge(@Param("age1")Integer age1,@Param("age2")Integer age2);
    //Write a native query to read a user by email?
@Query(value="select * from user_account where email=?1 ",nativeQuery = true)
User readUserByEmail(@Param("email")String email);
}
