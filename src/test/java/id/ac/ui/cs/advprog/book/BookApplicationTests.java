package id.ac.ui.cs.advprog.book;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
class BookApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMain() {
		BookApplication.main(new String[]{"args"});
	}
}
