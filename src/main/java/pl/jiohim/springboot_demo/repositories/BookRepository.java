package pl.jiohim.springboot_demo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jiohim.springboot_demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
