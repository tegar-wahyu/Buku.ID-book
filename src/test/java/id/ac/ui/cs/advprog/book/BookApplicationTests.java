package id.ac.ui.cs.advprog.book;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class BookApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMain() {
		BookApplication.main(new String[]{"args"});
	}
}
