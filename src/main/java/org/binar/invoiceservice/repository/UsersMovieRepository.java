package org.binar.invoiceservice.repository;

import org.binar.invoiceservice.model.UsersMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UsersMovieRepository extends JpaRepository<UsersMovie, String> {

    //Service addNewFilm
    @Modifying
    @Query(value = "insert into users_movie (email, password, username) values (?1, ?2, ?3)", nativeQuery = true)
     void insertUserToDb(String email, String password, String username);

    //Service deleteUser
    @Modifying
    @Query(value = "delete from users_movie u where u.username = :username", nativeQuery = true)
    void deleteUserFromDb(@Param("username")String username);

    //Service updateUser
    @Modifying
    @Query(value = "update users_movie set email = :email, password = :password where username = :username", nativeQuery = true)
    void updateUserToDb(@Param("email") String email, @Param("password") String password, @Param("username") String username);

    @Transactional
    @Query(value = "select * from users_movie where username = :username", nativeQuery = true)
    UsersMovie getUsername(@Param("username") String username);
}
