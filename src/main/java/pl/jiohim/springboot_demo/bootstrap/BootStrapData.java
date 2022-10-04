package pl.jiohim.springboot_demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.jiohim.springboot_demo.domain.Author;
import pl.jiohim.springboot_demo.domain.Book;
import pl.jiohim.springboot_demo.domain.Publisher;
import pl.jiohim.springboot_demo.repositories.AuthorRepository;
import pl.jiohim.springboot_demo.repositories.BookRepository;
import pl.jiohim.springboot_demo.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository
            , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFGE");
        publisher.setCity("Wroclaw");
        publisher.setState("Lower Silesia");

        publisherRepository.save(publisher);

        System.out.println("Publisher repository count:"+ publisherRepository.count());


        Author ser = new Author("Sergei", "Dovlatov");
        Book chemodan = new Book("Chemodan", "2689239048961");
        ser.getBooks().add(chemodan);
        chemodan.getAuthors().add(ser);

        chemodan.setPublisher(publisher);
        publisher.getBooks().add(chemodan);

        authorRepository.save(ser);
        bookRepository.save(chemodan);
        publisherRepository.save(publisher);

        Author ern = new Author("Ernest", "Hemingway");
        Book sun = new Book("The Sun Also Rises", "26892390489653");
        ern.getBooks().add(sun);
        sun.getAuthors().add(ern);

        sun.setPublisher(publisher);
        publisher.getBooks().add(sun);


        authorRepository.save(ern);
        bookRepository.save(sun);
        publisherRepository.save(publisher);


        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Publisher Number of books:"+ publisher.getBooks().size());



    }
}
