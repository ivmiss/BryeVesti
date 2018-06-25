package category;

import framework.Helper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCategories {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static DateFormat dateFormat = dateFormat = new SimpleDateFormat("HH:mm:ss");

    @BeforeClass
    public static void setUpClass() {
        
        System.out.println("@BeforeClass" + dateFormat.format(new Date()));
        
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
        
        System.out.println("@AfterClass" + dateFormat.format(new Date()));
        
        Thread.sleep(3000);
        driver.quit();
    }

    @Before
    public void setUp() {

        System.out.println("@Before" + dateFormat.format(new Date()));
        
        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("@After" + dateFormat.format(new Date()));
    }

    @Test
    public void testCreateNewCategory() {

        for (int i = 0; i < 5; i++) {

            WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
            addCategoryButton.click();

            WebElement titleCategoriesField = driver.findElement(By.id("title"));
            titleCategoriesField.sendKeys(Helper.getRandomText());

            WebElement saveCategoriesButton = driver.findElement(By.id("save-category-button"));
            saveCategoriesButton.click();

            String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals("URL doesn't match! ", expectedUrl, actualUrl);

            String expectedTitle = "Brze vesti admin  | Categories ".replaceAll("\\s+", " ").trim();
//        System.out.println("Expected title: " + expectedTitle + "");
            String actualTitle = driver.getTitle();
//        System.out.println("Actual title: " + actualTitle + "");

            Assert.assertEquals("Title doesn't match! ", expectedTitle, actualTitle);
        }

    }

    @Test
    public void testEditLastCategory() {

        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement lastRow = rows.get(rows.size() - 1);
        WebElement editButton = lastRow.findElement(By.className("btn-default"));
        editButton.click();

        WebElement titleCategoriesField = driver.findElement(By.id("title"));
        titleCategoriesField.clear();
        titleCategoriesField.sendKeys(Helper.getRandomText());

        WebElement saveCategoriesButton = driver.findElement(By.id("save-category-button"));
        saveCategoriesButton.click();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("URL doesn't match! ", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Categories ".replaceAll("\\s+", " ").trim();
//        System.out.println("Expacted title: " + expectedTitle + "");
        String actualTitle = driver.getTitle();
//        System.out.println("Actual title: " + actualTitle + "");

        Assert.assertEquals("Title doesn't match! ", expectedTitle, actualTitle);
    }

    @Test
    public void testDeleteFirstCategory() {

        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());
        
        WebElement firstRow = rows.get(0);
        
        WebElement deleteButton = firstRow.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
        
        WebElement deleteConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categoryDeleteDialog button[data-task='confirm']")));
        deleteConfirm.click();
    }
}
