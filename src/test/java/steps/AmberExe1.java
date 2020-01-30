package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AmberExe1 {

    ChromeDriver driver;
    final String informacja1 = "/html/body/div/table/tbody/tr[2]/td[2]/code";
    final String informacja2 = "/html/body/div/table/tbody/tr[3]/td[2]/code";
    final String informacja3 = "/html/body/div/table/tbody/tr[4]/td[2]/code";
    final String przycisk1 = "btnButton1";
    final String przycisk2 = "btnButton2";
    final String checkSolution = "solution";
    final String responseID = "trail";

    @Given("Uzytkownik wchodzi na strone {string}")
    public void uzytkownik_wchodzi_na_strone(String url) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "c://chromewebdriver//chromedriver.exe"); //System.setProperty(nazwa wlasciwosci systemowej,)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
    }

    @When("Uzytkownik klika w pierwszy przycisk")
    public void uzytkownik_klika_w_pierwszy_przycisk() {
        if(driver.findElementByXPath(informacja1).getText().equals("B1")) {
            driver.findElementById(przycisk1).click();
        } else {
            driver.findElementById(przycisk2).click();
        }
    }
    @When("Uzytkownik klika w drugi przycisk")
    public void uzytkownik_klika_w_drugi_przycisk() {
        if (driver.findElementByXPath(informacja2).getText().equals("B1")) {
            driver.findElementById(przycisk1).click();
        } else {
            driver.findElementById(przycisk2).click();
        }
    }
    @When("Uzytkownik klika w trzeci przycisk")
    public void uzytkownik_klika_w_trzeci_przycisk()  {
        if (driver.findElementByXPath(informacja3).getText().equals("B1")) {
            driver.findElementById(przycisk1).click();
        } else {
            driver.findElementById(przycisk2).click();
        }
    }
    @When("Uzytkownik klika w przcisk uzyskania rozwiazania")
    public void uzytkownik_klika_w_przcisk_uzyskania_rozwiazania() {
        driver.findElementById(checkSolution).click();
    }

    @Then("Uzytkownik widzi OK. Good Answer")
    public void uzytkownik_widzi_OK_Good_Answer() {
        WebDriverWait wait =  new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById(responseID),"OK. Good answer"));
        Assert.assertEquals("OK. Good answer", driver.findElementById(responseID).getText());
        driver.close();
    }
}
