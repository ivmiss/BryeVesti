
package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CategoriesPage {
    
    public void clickOnAddCategoryButton(WebDriver driver){
            WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
            addCategoryButton.click();
    }
    
    public void sendTextOnTitleField(WebDriver driver){
            WebElement titleCategoryField = driver.findElement(By.id("title"));
            titleCategoryField.sendKeys(Helper.getRandomText());

    }
    
    public void clickOnSaveCategoryButton(WebDriver driver){
            WebElement saveCategoryButton = driver.findElement(By.id("save-category-button"));
            saveCategoryButton.click();
    }
    
    public void addNewCategoy(WebDriver driver){
            clickOnAddCategoryButton(driver);
            sendTextOnTitleField(driver);
            clickOnSaveCategoryButton(driver);
    }
    
    public List<WebElement> getRowsFromTable(WebDriverWait wait){
        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size()); 
        
        return rows;
    }
    
    public WebElement chooseFirstRow(WebDriverWait wait){
       List<WebElement> rows = getRowsFromTable(wait);

        WebElement firstRow = rows.get(0);
        
        return firstRow;
    }
   
    public WebElement chooseRandomRow(WebDriverWait wait){
        List<WebElement> rows = getRowsFromTable(wait);

        WebElement randomRow = rows.get(Helper.getRandomIntiger(rows.size()));
        
        return randomRow;
    }
    
    public WebElement chooseLastRow(WebDriverWait wait){
        List<WebElement> rows = getRowsFromTable(wait);

//        WebElement lastRow = rows.get(rows.size() - 1);
//        return lastRow;

        return rows.get(rows.size() - 1);
    }
    
    public void clickOnEditButton(WebElement row){
        WebElement editButton = row.findElement(By.className("btn-default"));
        editButton.click();
    }
   
    
    public void sendTextOnTitleFieldWithClear(WebDriver driver){
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        titleField.sendKeys(Helper.getRandomText());
    }
    
    public void editLastCategory(WebDriver driver, WebDriverWait wait) {
        
        WebElement lastRow = chooseLastRow(wait);
        clickOnEditButton(lastRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);
      
    }
    
 public void editRandomCategory(WebDriver driver, WebDriverWait wait) {
        
        WebElement randomRow = chooseRandomRow(wait);
        clickOnEditButton(randomRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);
      
    }
    public void editFirstCategory(WebDriver driver, WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow(wait);
        clickOnEditButton(firstRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);
    }
    
    public void clickOnDeleteButton(WebElement row){
        row.findElement(By.cssSelector("button[title='Delete']")).click();
        
    }
    
    public void clickOnConfirmButton(WebDriverWait wait){
        WebElement deleteConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categoryDeleteDialog button[data-task='confirm']")));
        deleteConfirm.click();
    }
    
    public void deleteFirstCategory(WebDriver driver, WebDriverWait wait){
        WebElement firstRow = chooseFirstRow(wait);  
        clickOnDeleteButton(firstRow);
        clickOnConfirmButton(wait);
    }
    
    public void deleteRandomCategory(WebDriver driver, WebDriverWait wait){
        WebElement randomRow = chooseRandomRow(wait);
        clickOnDeleteButton(randomRow);
        clickOnConfirmButton(wait);
    }
    
    public void deleteLastCategory(WebDriver driver, WebDriverWait wait){
        WebElement lastRow = chooseLastRow(wait);
        clickOnDeleteButton(lastRow);
        clickOnConfirmButton(wait);
    }
}
