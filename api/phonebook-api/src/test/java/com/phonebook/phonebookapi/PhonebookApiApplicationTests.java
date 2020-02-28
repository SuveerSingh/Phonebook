package com.phonebook.phonebookapi;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PhonebookApiApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void applicationContextTest() {
		PhonebookApiApplication.main(new String[] {});
	}

}
