package testsMultiSense;

import login.LoginPage;
import multiSense.AdministrationMultiSense;
import multiSense.DeviceManagement;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DeviceType {

    @Test
    public void deviceType(){
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/apps/multisense/index.html#");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        AdministrationMultiSense administrationMultiSense = new AdministrationMultiSense(driver);
        administrationMultiSense.openAdministration();
        DeviceManagement deviceManagement = new DeviceManagement(driver);

        int deviceTypeNumber = 3001;
        String deviceTypeUrl = "a[href=\"#/administration/devicetypes/";
        String deviceType = deviceTypeUrl + deviceTypeNumber + "\"]";
        String loadProfile = deviceTypeUrl + deviceTypeNumber + "/loadprofiles\"]";

        String dataSources = "//span[text()='Data sources']"; // select Configurations in left side panel
        String configurations = "//span[text()='Configurations']"; // select Configurations in left side panel
        String customAttributes = "//span[text()='Custom attributes']"; // select Configurations in left side panel
        String specifications = "//span[text()='Specifications']"; // select Configurations in left side panel

        // to go to a specific device type
//        deviceManagement.toDeviceType(deviceType);

        // navigate to Data sources in side panel
//        deviceManagement.toSidePanel(dataSources);
//        deviceManagement.addLogbookType(); // werkt!
//        deviceManagement.addRegisterType(); // werkt!
//        deviceManagement.addLoadProfile(loadProfile); // werkt!

        // navigate to Configurations in side panel
//        deviceManagement.toSidePanel(configurations);
//        deviceManagement.addDeviceConfiguration();

        // navigate to Custom attributes in side panel
        // add a CAS to an existing device
//        deviceManagement.toSidePanel(customAttributes);
//        String customAttributeSets = deviceTypeUrl + deviceTypeNumber + "/customattributesets\"]";
//        deviceManagement.addCAS(customAttributeSets);

        // navigate to Specifications in side panel
//        deviceManagement.toSidePanel(specifications);

//        deviceManagement.addDeviceType();
        deviceManagement.createLogbookType("logbookTestTom", "1.1.1.1.1.1");
    }
}
