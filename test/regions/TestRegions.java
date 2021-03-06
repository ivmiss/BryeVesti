
package regions;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegionsPage;


public class TestRegions {
   
    
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
        Thread.sleep(8000);
        driver.quit();
    }
    
    @Before
    public void setUp() {
        WebElement categoriesLink = driver.findElement(By.linkText("Regions"));
        categoriesLink.click();
    }
    
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
    }

     @Test
     public void testCreateNewRegion() {
            
            RegionsPage regionsPage = new RegionsPage();
            regionsPage.createNewRegion(driver);
                    
//            WebElement addRegionButton = driver.findElement(By.className("pull-right"));
//            addRegionButton.click();

//            WebElement titleRegionField = driver.findElement(By.id("title"));
//            titleRegionField.sendKeys(Helper.getRandomText());
            
//            WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
//            saveRegionButton.click();
     }
     
     @Test
     public void testEditFirstRegion(){
        
        RegionsPage regionsPage = new RegionsPage();
//        regionsPage.getRowsFromTable(wait);
        regionsPage.editFirstRegion(wait, driver);

     }
     
     @Test
     public void testEditRandomRegion(){
        
        RegionsPage regionsPage = new RegionsPage();
//        regionsPage.getRowsFromTable(wait);
        regionsPage.editRandomRegion(wait, driver);
     }
     
     @Test
     public void testEditLastRagion(){
         
        RegionsPage regionsPage = new RegionsPage();
        regionsPage.editLastRegion(wait, driver);
     }
     
     @Test
     public void testFirstRegionDisable(){
        
         RegionsPage regionsPage = new RegionsPage();
         regionsPage.disableFirstRegion(wait);
//        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//
//        System.out.println("Number of rows: " + rows.size());
        
//        WebElement firstRow = rows.get(0);
//        WebElement disableRegionButton = firstRow.findElement(By.cssSelector("button[title='Disable']"));
//        disableRegionButton.click();
        
//        WebElement disableConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#regionDisableDialog button[data-task='confirm']")));
//        disableConfirm.click();
     }
     
     @Test
     public void testFirstRegionEnable(){
         RegionsPage regionsPage = new RegionsPage();
         regionsPage.enableFirstRegion(wait);
//        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//
//        System.out.println("Number of rows: " + rows.size());
//
//        WebElement firstRow = rows.get(0);
//        WebElement enableRegionButton = firstRow.findElement(By.cssSelector("button[title='Enable']"));
//        enableRegionButton.click();
        
//        WebElement enableConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#regionEnableDialog button[data-task='confirm']")));
//        enableConfirm.click();
     }
     
    @Test
    public void testFirstRegionDelete(){
          RegionsPage regionsPage = new RegionsPage();
          regionsPage.deleteFirstRegion(driver, wait);
    
     }
    
     @Test
    public void testRandomRegionDelete(){
          RegionsPage regionsPage = new RegionsPage();
          regionsPage.deleteRandomRegion(driver, wait);
    
     }
    
    @Test
    public void testLastRegionDelete(){
          RegionsPage regionsPage = new RegionsPage();
          regionsPage.deleteLastRegion(driver, wait);
    
     }
}
