package br.com.aleandro.java.back.end.repositories;

import br.com.aleandro.java.back.end.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
