package id.ac.ui.cs.advprog.book;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
class BookApplicationTests {

  @Autowired
  private BookApplication bookApplication;

	@Test
	void contextLoads() {
    assertNotNull(bookApplication);
	}
}
