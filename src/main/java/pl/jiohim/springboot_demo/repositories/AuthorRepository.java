package pl.jiohim.springboot_demo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jiohim.springboot_demo.domain.Author;

public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
