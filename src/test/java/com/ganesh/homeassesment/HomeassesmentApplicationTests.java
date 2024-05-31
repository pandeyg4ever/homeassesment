package com.ganesh.homeassesment;

import com.ganesh.homeassesment.rest.api.PlacesV1Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class HomeassesmentApplicationTests {

	@Autowired
	PlacesV1Controller placesV1Controller;

	@Test
	void contextLoads() {
		Assert.notNull(placesV1Controller.list(10), "result of list should never be null");
	}

}
