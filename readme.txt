

package seleniumfirst;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class firsttest {

   public static void main(String[] args) throws InterruptedException {
       // Path to the geckodriver executable file
       System.setProperty("webdriver.gecko.driver", "C:\\Users\\");

       // Create a new Firefox driver
       WebDriver driver = new FirefoxDriver();
       driver.manage().window().maximize();
       // Navigate to the website
      // driver.get("https://www.medicare.gov/care-compare/?providerType=Hospital");


driver.get("https://www.medicare.gov/");

   //  Find and click the subscription button
   WebElement subscription_button = driver.findElement(By.xpath("//button[contains(text(),'Close subscription dialog')]"));
   subscription_button.click();

   // Find the "Providers & Services" button and click it
   WebElement providers_services_button = driver.findElement(By.xpath("//span[contains(text(),'Providers & Services')]"));
   providers_services_button.click();

   // Find the "Find care providers" link and click it
   WebElement find_care_providers_link = driver.findElement(By.xpath("//a[contains(@class,'ch-c-nav-menu-link')][normalize-space()='Find care providers']"));
   find_care_providers_link.click();

   // click hospital:
   WebElement hospitals_link = driver.findElement(By.xpath("//ccxp-provider-search-search-menu[@class='ng-star-inserted']//div[3]"));
   hospitals_link.click();


   // Find the input field and enter the value
   WebElement input_field = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
   input_field.sendKeys("22122");

   // Wait for the dropdown to appear
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   By option_locator = By.cssSelector(".mat-option-text > span");
   wait.until(ExpectedConditions.visibilityOfElementLocated(option_locator));

   // Select the first option and hit enter
   WebElement first_option = driver.findElements(option_locator).get(0);
   Actions actions = new Actions(driver);
   actions.moveToElement(first_option).sendKeys(Keys.ENTER).build().perform();

   // Find the search button and click it
   WebElement search_button = driver.findElement(By.xpath("//span[@class='ProviderSearchSearchButton__submit-text_wrapper']"));
   search_button.click();


  

   //Method 2: Print Values
   int count=0;
   List<WebElement> list_Options= driver.findElements(By.xpath("//span[@class='mat-option-text']"));

   for (WebElement ele:list_Options){
       String currentOption=ele.getText();
       if(currentOption.contains(ValueSelect)){
           Thread.sleep(5000);
           ele.click();
           count++;
           break;
       }
   }
   if(count!=0){
       System.out.println(ValueSelect + "has been selected");
   }
   else{
       System.out.println("Rerun again");
   }



   // Close the browser
   // driver.close();
}
