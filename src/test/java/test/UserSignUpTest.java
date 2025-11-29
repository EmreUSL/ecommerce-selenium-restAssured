package test;

import base.HomePage;
import core.DriverManager;
import core.util.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserSignUpTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/testData/testData.xlsx";
        ExcelUtil.loadExcel(filePath, "Register");
        int rowCount = ExcelUtil.getRowNum();
        Object[][] data = new Object[rowCount - 1][2];
        for (int i = 1; i < rowCount; i++) {
             data[i-1][0] = ExcelUtil.getCellData(i,0); //username
             data[i-1][1] = ExcelUtil.getCellData(i,1); //password
        }
        ExcelUtil.closeWorkbook();
        return data;
    }

    @Test
    public void shouldRegisterUserSuccessfully() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickSignUpButton();
        Assert.assertTrue(homePage.isSignUpModalDisplayed());
        homePage.setUserName("TestUser001");
        homePage.setPassword("test001");
        homePage.clickSignButton();
    }

    @Test
    public void shouldShowErrorUserAlreadyExists() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickSignUpButton();
        Assert.assertTrue(homePage.isSignUpModalDisplayed());
        homePage.setUserName("TestUser001");
        homePage.setPassword("test001");
    }


}
