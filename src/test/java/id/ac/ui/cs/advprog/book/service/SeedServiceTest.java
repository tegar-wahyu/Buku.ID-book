package id.ac.ui.cs.advprog.book.service;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.model.BookBuilder;
import id.ac.ui.cs.advprog.book.repository.BookRepository;
import net.datafaker.Faker;
import net.datafaker.Internet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class SeedServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private SeedService seedService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSeed() {
        Faker faker = new Faker(new Locale("id_ID"));

        int numberOfBooks = 1000;

        seedService.seed();

        verify(bookRepository, times(numberOfBooks)).save(any(Book.class));
    }
}
