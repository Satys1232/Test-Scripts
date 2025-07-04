package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_D2_01 {

	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		Assert.assertTrue(false);
	}
    @DataProvider
	public Object getData() {
		// LIST COMBINATION USERNAME AND PASSOWORD.
		// 2ND , 3RD .. MANY MORE.
		Object[][] data = new Object[3][2];
		// first set data.
		data[0][0] = "firstsetusername";
		data[0][1] = "firstsetpassword";
		// second set data.
		data[1][0] = "secondsetusername";
		data[1][1] = "secondsetpassword";
		// third set
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdsetpassword";
		return data;
	}

}
