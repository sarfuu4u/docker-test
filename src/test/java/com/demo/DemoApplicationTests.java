package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
        System.out.println("world");
	}
    @Test
    void content(){
        System.out.println("hello");
    }
}
