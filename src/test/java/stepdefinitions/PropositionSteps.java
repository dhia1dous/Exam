package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

public class PropositionSteps {
    WebDriver driver;

    @Given("l'étudiant est sur la page {string}")
    public void studentOnHomePage(String fileName) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        
        fileName = "src\\main\\resources\\static\\" + fileName;
        File file = new File(fileName);
        driver.get("file:///" + file.getAbsolutePath());
    }

    @When("il saisit le sujet {string}")
    public void fillSubject(String subject) {
        driver.findElement(By.id("sujet")).sendKeys(subject);
    }

    @When("il saisit les objectifs {string}")
    public void fillObjectives(String objectives) {
        driver.findElement(By.id("objectifs")).sendKeys(objectives);
    }

    @When("il saisit les technologies {string}")
    public void fillTechnologies(String tech) {
        driver.findElement(By.id("technologies")).sendKeys(tech);
    }

    @When("il clique sur le bouton {string}")
    public void clickSubmit(String buttonText) {
        // Find button by its id since we might have multiple buttons or changing text
        driver.findElement(By.id("submit-btn")).click();
    }

    @Then("un message de succès {string} s'affiche")
    public void verifySuccessMessage(String expectedMessage) {
        // Use explicit wait because of the 800ms delay in JS
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement successDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-message")));
        
        String actualMessage = successDiv.getText().trim();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }
}
