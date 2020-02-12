package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmberExe3 {

    ChromeDriver driver;
    final String tekstDoWybraniaXPath = "/html/body/div/table/tbody/tr[2]/td[2]/code";
    final String SELECTOR_ID = "s13";
    final String przyciskCheckSolutionID = "solution";
    final String potwierdzenieRozwiazaniaID = "trail";


    @Given("Uzytkownik otwiera strone {string}")
    public void uzytkownik_otwiera_strone(String url) {
        System.setProperty("webdriver.chrome.driver", "c://chromewebdriver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }
    @When("Uzytkownik wybiera pozycje z listy")
    public void uzytkownik_wybiera_pozycje_z_listy() {
        String zapamietanyTekst = driver.findElement(By.xpath(tekstDoWybraniaXPath)).getText();
        Select dropdown = new Select(driver.findElement(By.id(SELECTOR_ID)));
        dropdown.selectByVisibleText(zapamietanyTekst);

//        new Select(driver.findElement(By.id(SELECTOR_ID))).selectByVisibleText(driver.findElement(By.xpath(tekstDoWybraniaXPath)).getText()); # zagnieżdżenie metod z trzech linii powyżej
    }
    @When("Uzytkownik klika przcisk potwierdzenia rozwiazania")
    public void uzytkownik_klika_przcisk_potwierdzenia_rozwiazania() {
        driver.findElementById(przyciskCheckSolutionID).click();

    }
    @Then("Uzytkownik uzyskuje potwierdzenie OK. Good answer")
    public void uzytkownik_uzyskuje_potwierdzenie_OK_Good_answer() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById(potwierdzenieRozwiazaniaID), "OK. Good answer"));
        Assert.assertEquals("OK. Good answer", driver.findElementById(potwierdzenieRozwiazaniaID).getText());
        driver.close();

    }

}
