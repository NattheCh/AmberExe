package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class AmberExe4 {

    ChromeDriver driver;
    final String pozycjazPierwszejGrupyXPath = "/html/body/div/table/tbody/tr[2]/td[2]/code";
    final String pozycjaDrugiejGrupyXPath = "/html/body/div/table/tbody/tr[3]/td[2]/code";
    final String pozycjaTrzeciejGrupyXPath = "/html/body/div/table/tbody/tr[4]/td[2]/code";
    private String pozycjaCzwartejGrupyXPath = "/html/body/div/table/tbody/tr[5]/td[2]/code";
    final List<String> nazwykolorow = Arrays.asList("Beluga Brown", "Mango Orange", "Verdoro Green", "Freudian Gilt", "Pink Kong", "Duck Egg Blue", "Anti - Establishment Mint", "Amberlite Firemist");
    final String sprawdzenieRozwiazaniaID = "solution";
    final String potwierdzenieRozwiazaniaKoncowegoID = "trail";



    @Given("Uzytkownik wlacza strone {string}")
    public void uzytkownik_wlacza_strone(String url) {
        System.setProperty("webdriver.chrome.driver", "c://chromewebdriver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @When("Uzytkownik wybiera pozycje z pierwszej grupy")
    public void uzytkownik_wybiera_pozycje_z_pierwszej_grupy() {
        String wyborPierwszy = driver.findElement(By.xpath(pozycjazPierwszejGrupyXPath)).getText();
        int index = nazwykolorow.indexOf(wyborPierwszy);
        if (index > 2) // warunek dla wartosci powyzej 2 ponieważ index numer 3 nie istnieje, a pozostałe wartości są przesunięte o 1
            index++;
        String value = "\"v" + index + "0\"";
        driver.findElement(By.xpath("//input[@value="+value+"]")).click();

    }

    @When("Uzytkownik wybiera pozycje z drugiej grupy")
    public void uzytkownik_wybiera_pozycje_z_drugiej_grupy() {
        String wyborDrugi = driver.findElement(By.xpath(pozycjaDrugiejGrupyXPath)).getText();
        int index = nazwykolorow.indexOf(wyborDrugi);
        if (index > 2) // warunek dla wartosci powyzej 2 ponieważ index numer 3 nie istnieje, a pozostałe wartości są przesunięte o 1
            index++;
        String value = "\"v" + index + "1\"";
        driver.findElement(By.xpath("//input[@value="+value+"]")).click();
    }
    @When("Uzytkownik wybiera pozycje z trzeciej grupy")
    public void uzytkownik_wybiera_pozycje_z_trzeciej_grupy() {
        String wyborTrzeci = driver.findElement(By.xpath(pozycjaTrzeciejGrupyXPath)).getText();
        int index = nazwykolorow.indexOf(wyborTrzeci);
        if (index > 2) // warunek dla wartosci powyzej 2 ponieważ index numer 3 nie istnieje, a pozostałe wartości są przesunięte o 1
            index++;
        String value = "\"v" + index + "2\"";
        driver.findElement(By.xpath("//input[@value="+value+"]")).click();
    }
    @When("Uzytkownik wybiera pozycje z czwartej grupy")
    public void uzytkownik_wybiera_pozycje_z_czwartej_grupy() {
        String wyborCzwarty = driver.findElement(By.xpath(pozycjaCzwartejGrupyXPath)).getText();
        int index = nazwykolorow.indexOf(wyborCzwarty);
        if (index > 2) // warunek dla wartosci powyzej 2 ponieważ index numer 3 nie istnieje, a pozostałe wartości są przesunięte o 1
            index++;
        String value = "\"v" + index + "3\"";
        driver.findElement(By.xpath("//input[@value="+value+"]")).click();
    }
    @When("Uzytkownik klika przcisk potwierdzenia poprawnosci wyniku")
    public void uzytkownik_klika_przcisk_potwierdzenia_poprawnosci_wyniku() {
        driver.findElementById(sprawdzenieRozwiazaniaID).click();
    }
    @Then("Uzytkownik uzyskuje potwierdzenie poprawnosci wyniku OK. Good answer")
    public void uzytkownik_uzyskuje_potwierdzenie_poprawnosci_wyniku_OK_Good_answer() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById(potwierdzenieRozwiazaniaKoncowegoID), "OK. Good answer"));
        Assert.assertEquals("OK. Good answer", driver.findElementById(potwierdzenieRozwiazaniaKoncowegoID).getText());
    }
}
