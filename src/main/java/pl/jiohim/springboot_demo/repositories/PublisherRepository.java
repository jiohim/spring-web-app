package pl.jiohim.springboot_demo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jiohim.springboot_demo.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
