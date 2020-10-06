package dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "SearchData")
	public  static Object[][] getDataProvider() {
		/*String[][] arr = new String[2][1];
		arr[0][0]="Keyboard";
		arr[1][0] = "Mouse";
		return arr;
*/
	return new Object[][] {
		{"Keyboard"},
		{"Mouse"}
	};
	}
}
