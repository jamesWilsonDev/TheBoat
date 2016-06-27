package com.example;

import com.example.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TheBoatApplication.class)
public class TheBoatApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testApp(){
		HomeController hc = new HomeController();
		assertEquals(hc.home(), "Yes boi!!!");
	}

}
