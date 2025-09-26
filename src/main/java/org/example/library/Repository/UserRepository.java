package org.example.library.Repository;

import org.example.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN u.books b WHERE b.id = :bookId")
    List<User> findUsersByBookId(@Param("bookId") Long bookId);

    Optional<User> findUserByPassport(String passport);

    User findByPassport(String passport);

    boolean existsUserByPassport(String passport);
}
