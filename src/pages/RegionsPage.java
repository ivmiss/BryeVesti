
package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegionsPage {
    
    private void clickOnAddRegion(WebDriver driver){
            WebElement addRegionButton = driver.findElement(By.className("pull-right"));
            addRegionButton.click(); 
    }
    
    private void clickOnEditButton(WebElement row){
            WebElement editButton = row.findElement(By.cssSelector(".ui-sortable a[title='Edit']"));
            editButton.click();
    }
    
    private void clickOnSaveRegionButton(WebDriver driver){
            WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
            saveRegionButton.click();
    }
    
    private void sendTextOnTitleField(WebDriver driver){
            WebElement titleRegionField = driver.findElement(By.id("title"));
            titleRegionField.sendKeys(Helper.getRandomText());
    }
    
    private void sendTextOnTitleFieldWithClear(WebDriverWait wait){
            WebElement titleRegionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
            titleRegionField.clear();
            titleRegionField.sendKeys(Helper.getRandomText());
    }

    private WebElement chooseFirstRow(WebDriverWait wait) {
        List<WebElement> rows = getRowsFromTable(wait);
        WebElement firstRow = rows.get(0);

        return firstRow;
    }

    private WebElement chooseRandomRow(WebDriverWait wait) {
        List<WebElement> rows = getRowsFromTable(wait);
        WebElement randomRow = rows.get(Helper.getRandomIntiger(rows.size()));

        return randomRow;
    }

    private WebElement chooseLastRow(WebDriverWait wait) {
        List<WebElement> rows = getRowsFromTable(wait);
        
        return rows.get(rows.size() - 1);
    }
    
    private void clickOnDisableButton(WebElement row){
        WebElement disableRegionButton = row.findElement(By.cssSelector("button[title='Disable']"));
        disableRegionButton.click();
    }

    private void clickOnConfirmButtonDisable(WebDriverWait wait) {
        WebElement deleteConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#regionDisableDialog button[data-task='confirm']")));
        deleteConfirm.click();
    }
    
    private void clickOnEnableButton(WebElement row){
        WebElement enableRegionButton = row.findElement(By.cssSelector("button[title='Enable']"));
        enableRegionButton.click();
    }
    
    private void clickOnConfirmButtonEnable(WebDriverWait wait){
        WebElement enableConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#regionEnableDialog button[data-task='confirm']")));
        enableConfirm.click();
    }

    private void clickOnDeleteButton(WebElement row) {
        row.findElement(By.cssSelector("button[title='Delete']")).click();

    }

    private void clickOnConfirmButton(WebDriverWait wait) {
        WebElement deleteConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#regionDeleteDialog button[data-task='confirm']")));
        deleteConfirm.click();
    }

//    -- PUBLIC METHODS --
    
    public List<WebElement> getRowsFromTable(WebDriverWait wait) {
        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        return rows;
    }

    public void createNewRegion(WebDriver driver){
        clickOnAddRegion(driver);
        sendTextOnTitleField(driver);
        clickOnSaveRegionButton(driver);
    }
    
    public void editFirstRegion(WebDriverWait wait, WebDriver driver){
        WebElement firstRow = chooseFirstRow(wait);
        clickOnEditButton(firstRow);
        sendTextOnTitleFieldWithClear(wait);
        clickOnSaveRegionButton(driver);
    }
    
    
    public void editRandomRegion(WebDriverWait wait, WebDriver driver){
        WebElement randomRow = chooseRandomRow(wait);
        clickOnEditButton(randomRow);
        sendTextOnTitleFieldWithClear(wait);
        clickOnSaveRegionButton(driver);
    }
    
    public void editLastRegion(WebDriverWait wait, WebDriver driver){
        WebElement lastRow = chooseLastRow(wait);
        clickOnEditButton(lastRow);
        sendTextOnTitleFieldWithClear(wait);
        clickOnSaveRegionButton(driver);
    }
    
    public void disableFirstRegion(WebDriverWait wait){
        WebElement firstRow = chooseFirstRow(wait);
        clickOnDisableButton(firstRow);
        clickOnConfirmButtonDisable(wait);
    }

       
    public void enableFirstRegion(WebDriverWait wait){
        WebElement firstRow = chooseFirstRow(wait);
        clickOnEnableButton(firstRow);
        clickOnConfirmButtonEnable(wait);
    }
    
    public void deleteFirstRegion(WebDriver driver, WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow(wait);
        clickOnDeleteButton(firstRow);
        clickOnConfirmButton(wait);
    }

    public void deleteRandomRegion(WebDriver driver, WebDriverWait wait) {
        WebElement randomRow = chooseRandomRow(wait);
        clickOnDeleteButton(randomRow);
        clickOnConfirmButton(wait);
    }

    public void deleteLastRegion(WebDriver driver, WebDriverWait wait) {
        WebElement lastRow = chooseLastRow(wait);
        clickOnDeleteButton(lastRow);
        clickOnConfirmButton(wait);
    }
}
