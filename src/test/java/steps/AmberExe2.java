package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmberExe2 {

    WebDriver driver;

    String tekstWElemencieXPath = "/html/body/div/table/tbody/tr[2]/td[2]/code[1]";
    String formularzId = "t14";
    String przyciskName = "btnButton1";
    String przciskCheckSolutionId = "solution";
    String poleDoSprawdzeniaId = "trail";


    @Given("Uzytkownik jest na stronie {string}")
    public void uzytkownik_jest_na_stronie(String url) {
//        System.setProperty("webdriver.chrome.driver", "c://chromewebdriver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }
    @When("Uzytkownik wpisuje tekst do pola")
    public void uzytkownik_wpisuje_tekst_do_pola() {
        driver.findElement(By.id(formularzId)).clear();
        String zapamietanyTekst = driver.findElement(By.xpath(tekstWElemencieXPath)).getText();
        driver.findElement(By.id(formularzId)).sendKeys(zapamietanyTekst);
    }
    @When("Uzytkownik klika w przycisk B1")
    public void uzytkownik_klika_w_przycisk_B1(){
        driver.findElement(By.name(przyciskName)).click();
    }
    @When("Uzytkownik klika przcisk uzyskania rozwiazania")
    public void uzytkownik_klika_przcisk_uzyskania_rozwiazania() {
        driver.findElement(By.id(przciskCheckSolutionId)).click();
    }
    @Then("Uzytkownik widzi OK. Good answer")
    public void uzytkownik_widzi_OK_Good_answer() {
        driver.findElement(By.id(poleDoSprawdzeniaId)).getText();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id(poleDoSprawdzeniaId)), "OK. Good answer"));
        Assert.assertEquals("OK. Good answer", driver.findElement(By.id(poleDoSprawdzeniaId)).getText());
        driver.close();
    }
}
