package com.reagan.webservertask;

import com.reagan.webservertask.service.CalcServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class WebMainTests {


	CalcServiceImpl calcService = new CalcServiceImpl();
	int x =10;
	int y = 6;
	String s1 = "show me how to multiply";
	String s2 = "What if i ask you to find the difference between 20 and 15";
	String s3 = "add 4 and 5 for me";
	@Test
	public void basicOpts() {
		assertThat(calcService.add(x,y)).isEqualTo(16);
		assertThat(calcService.subtract(x,y)).isEqualTo(4);
		assertThat(calcService.multiply(x,y)).isEqualTo(60);
	}

	@Test
	public void checkResultParams() {
		calcService.checkType(s2);
		calcService.checkInt(s2);
		assertThat(calcService.getX()).isEqualTo(20);
		assertThat(calcService.getY()).isEqualTo(15);
		assertThat(calcService.getOperation_type()).isEqualToIgnoringCase("subtraction");
	}

	@Test
	void getResult () {
		calcService.setX(10);
		calcService.setY(6);
		calcService.checkType(s1);
		calcService.checkInt(s3);
		Integer result = calcService.getResult();
		assertThat(result).isEqualTo(20);
	}

	@Test
	void checkResult() {
		calcService.checkType(s3);
		Integer result = calcService.getResult();
		assertThat(result).isEqualTo(9);
	}
	@Test
	void contextLoads() {
	}

}
