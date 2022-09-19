	package Selenium.Test.DataProvider;

	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.testng.annotations.DataProvider;

	import Selenium.Test.Utility.NewExcelLibrary;

	/**
	 * @author kanwaljeetsingh DataProviders class is used To use data from excel
	 *         sheets from Workbook - TestData.xlsx located in
	 *         src\test\resources\testdata, This uses the excelLibrary object
	 *         reference (of NewExcelLibrary,java class) to getData from the sheets
	 *         in excel workbook
	 */
	public class DataProviders {

		NewExcelLibrary excelLibrary = new NewExcelLibrary();

		// get data from Credentials sheet
		@DataProvider(name = "credentials")
		public Object[][] getCredentials() throws EncryptedDocumentException, IOException {
			return excelLibrary.getData("Credentials");
		}

		// get data from AccountCreationEmail sheet
		@DataProvider(name = "accountCreationEmail")
		public Object[][] getAccountCreationEmail() throws EncryptedDocumentException, IOException {
			return excelLibrary.getData("AccountCreationEmail");
		}

		// get data from ProductDetails sheet
		@DataProvider(name = "getProduct")
		public Object[][] getProduct() throws EncryptedDocumentException, IOException {
			return excelLibrary.getData("ProductDetails");
		}

		// get data from SearchProduct sheet
		@DataProvider(name = "searchProduct")
		public Object[][] searchProduct() throws EncryptedDocumentException, IOException {
			return excelLibrary.getData("SearchProduct");
		}

		// get data from ExpectedStoreTitle sheet
		@DataProvider(name = "getStoreTitle")
		public Object[][] getStoreTitle() throws EncryptedDocumentException, IOException {
			return excelLibrary.getData("ExpectedStoreTitle");
		}

	}
