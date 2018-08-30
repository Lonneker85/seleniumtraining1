package multiSense;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeviceManagement {
    WebDriver driver;

    // Constructor initializes the state of the driver

    public DeviceManagement(WebDriver driver) {
        this.driver = driver;
    }

    public void addDeviceType() {
        driver.findElement(By.linkText("Device types")).click();
        driver.findElement(By.linkText("Add device type")).click();
        driver.findElement(By.name("deviceProtocolPluggableClass")).sendKeys("Ametek JemStar"); // communication protocol
        driver.findElement(By.name("name")).sendKeys("Ametek JemStar TestTom"); // Enter name
        driver.findElement(By.name("deviceLifeCycleId")).click(); // open device life cycle dropdown
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("x-boundlist-item"))).click(); // select device life cycle
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.x-boundlist-item"))).click(); // select device life cycle
        //driver.findElement(By.linkText("Add")).click(); // Add the new device type
    }

    // go to specific device type
    public void toDeviceType(String deviceType){
        driver.findElement(By.linkText("Device types")).click(); // open Device types on Administration page
        driver.findElement(By.cssSelector(deviceType)).click(); // open specific device type
    }

    public void toSidePanel(String sidePanel){
        driver.findElement(By.xpath(sidePanel)).click();
    }

    // add existing logbook type to existing device type -> start from specific device type
    public void addLogbookType(){
        driver.findElement(By.xpath("//span[text()='Logbook types']")).click(); // select Logbook types in left side panel
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add logbook types"))).click(); // select link Add logbook types
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/td[1]/div/div"))).click(); // add logbook type
        driver.findElement(By.linkText("Add")).click(); // logbook type added
    }

    // add existing register type to existing device type -> start from specific device type
    public void addRegisterType() {
        driver.findElement(By.xpath("//span[text()='Register types']")).click(); // select Register types from left side panel
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add register types"))).click(); // select link Add register types
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/td[1]/div/div"))).click(); // add register type
        driver.findElement(By.linkText("Add")).click(); // register type added
    }

    // add existing load profile type to existing device type -> start from specific device type
    public void addLoadProfile(String loadProfile) {
        driver.findElement(By.cssSelector(loadProfile)).click(); // select load profiles
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add load profile type"))).click(); // Add load profile type
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/td[1]/div/div"))).click(); // select first load profile type
        driver.findElement(By.linkText("Add")).click();
    }

    // add new device configuration to existing device type -> start from specific device type
    public void addDeviceConfiguration() {
        driver.findElement(By.linkText("No device configurations")).click(); // if no configurations are available, add a new one
        driver.findElement(By.linkText("Add device configuration")).click(); // click add new
        driver.findElement(By.name("name")).sendKeys("Config 1"); // enter Name
        driver.findElement(By.name("description")).sendKeys("Test"); // enter Description
        driver.findElement(By.linkText("Add")).click();
    }

    // add new CAS to existing device type -> start from device type overview
    public void addCAS(String customAttributeSets) {
        driver.findElement(By.xpath("//span[text()='Custom attributes']")).click(); // open Custom Attributes tab in left panel
        driver.findElement(By.cssSelector(customAttributeSets)).click();
        driver.findElement(By.xpath("//span[text()='Custom attribute sets']")).click(); // open Custom Attributes tab in left panel
        driver.findElement(By.linkText("Add custom attribute sets")).click(); // if no CAS available, select Add CAS
        driver.findElement(By.xpath("//*/td[1]/div/div")).click(); // select first checkbox in CAS overview
        driver.findElement(By.linkText("Add")).click(); // add the selected CAS
    }

    // creating new items
    // create a new load profile type
    public void createLoadProfileType(String name, String obisCode) {
        driver.findElement(By.linkText("Load profile types")).click(); // select Load profiles
        driver.findElement(By.linkText("Add load profile type")).click(); // add load profile type
        driver.findElement(By.name("name")).sendKeys(name); // enter Name
        driver.findElement(By.name("obisCode")).sendKeys(obisCode); // enter Obis code
        driver.findElement(By.linkText("Add register types")).click(); // add register types
        driver.findElement(By.cssSelector("//*/td[1]/div/div")).click(); // radio button Selected register types
        driver.findElement(By.cssSelector("//*/td[1]/div/div")).click(); // select first checkbox reading type
        driver.findElement(By.linkText("Add")).click(); // Add load profile type
    }

    // create a new logbook type
    public void createLogbookType(String logbookName, String obisCode){
        driver.findElement(By.linkText("Logbook types")).click(); // select Logbook types
        driver.findElement(By.linkText("Add logbook type")).click(); // add Logbook types
        driver.findElement(By.name("name")).sendKeys(logbookName);
        driver.findElement(By.name("obisCode")).sendKeys(obisCode);
        driver.findElement(By.linkText("Add")).click(); // Add logbook type

    }
}