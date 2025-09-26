package org.example.library.Repository;

import org.example.library.model.Category;
import org.example.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c JOIN c.books b WHERE b.id = :bookId")
    Category findCategoryByBookId(@Param("bookId") Long bookId);
}
