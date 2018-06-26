
package portals;

import static category.TestCategories.driver;
import static category.TestCategories.wait;
import framework.Helper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestPortals {
    
    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");

        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();

        System.out.println("Page title is: " + driver.getTitle());
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    
    @Before
    public void setUp() {
        WebElement categoriesLink = driver.findElement(By.linkText("Portals"));
        categoriesLink.click();
    }
    
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
    }

   
    @Test
    public void testCreateNewRegion() {
            
            WebElement addPortalButton = driver.findElement(By.className("pull-right"));
            addPortalButton.click();
            
            WebElement titlePortalField = driver.findElement(By.id("title"));
            titlePortalField.sendKeys(Helper.getRandomText());
            
            WebElement urlPortalField = driver.findElement(By.id("url"));
            urlPortalField.sendKeys("http://test.rs");
            
            WebElement regionPortalField = driver.findElement(By.cssSelector(".col-md-5 select[name='region_id']"));
            List<WebElement> regionOptionsList = regionPortalField.findElements(By.cssSelector("option"));
            
            WebElement randomOption = regionOptionsList.get(Helper.getRandomRegion(regionOptionsList.size()));
            randomOption.click();
                    
            WebElement savePortalButton = driver.findElement(By.id("save-portal-button"));
            savePortalButton.click();
}

}
