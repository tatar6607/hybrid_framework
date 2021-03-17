package ui_tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class DataProviderDemo {
//    FhcLoginPage fhcLoginPage;
    // @Test annotation una data provider i bagladik ==> istenilirse provider ismi ile degilde method ismi ilede  baglanabilir.
    //    (dataProvider = "getData") seklinde method ismiylede baglanabilir
    @Test(dataProvider = "loginData")
    // Datalari gondermek icin method parantezine String tanimladik.
    public void bothFalseTest(String username, String password) {

        Driver.getDriver().get("http://fhctrip-qa.com/Account/Logon");
  //      fhcLoginPage = new FhcLoginPage(Driver.getDriver());

//        fhcLoginPage.username.sendKeys(username);
//        fhcLoginPage.password.sendKeys(password);
//        fhcLoginPage.loginButton.click();
//        Assert.assertTrue(fhcLoginPage.errorMessage.isDisplayed());

    }

    // Siteye gonderilecek datalari altta tanimladik bunun icin @DataProvider annotation unu kullandik.
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        // {{user1, pass1},
        // {user2, pass2},
        // {user3, pass3}}
        Object[][] data = new Object[3][2];
        //1.siradaki  datalar
        data[0][0]="user1";
        data[0][1]="pass1";
        //2.siradaki datalar
        data[1][0]="user2";
        data[1][1]="pass2";
        //3.siradaki datalar
        data[2][0]="user3";
        data[2][1]="pass3";
        return data;
    }
}
