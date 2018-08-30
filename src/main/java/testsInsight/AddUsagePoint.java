package testsInsight;

import insight.UsagePoints;
import login.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.NameGenerator;

public class AddUsagePoint {
    //WebDriver driver;

    @Test
    public void addUsagePoint() {
        // Login class -> null pointer exception
        WebDriver driver = utilities.DriverFabriek.openBrowser("chrome");
        driver.get("https://enexis.energyict.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Enexis_General");
        loginPage.setPassword("DukeS01");
        loginPage.clickSubmit();

        // mandatory fields
        UsagePoints usagePoints = new UsagePoints(driver);
        usagePoints.openUsagePoints();

        String nameGas = "UPGas";
        String nameHeat = "UPHeat";
        String nameWater = "UPWater";

        String serviceCategoryE = "Electricity";
        String serviceCategoryG = "Gas";
        String serviceCategoryH = "Heat";
        String serviceCategoryW = "Water";

        String typeOfUsagePointSDP = "Physical SDP";
        String typeOfUsagePointNonSDP = "Physical non-SDP";

        String marketCodeSectorDomestic = "Domestic";
        String marketCodeSectorIndustrialCommercial = "Industrial & Commercial";

        String meteringPointTypeConsumption = "E17 - Consumption";
        String meteringPointTypeProduction = "E18 - Production";
        String meteringPointTypeCombined = "E19 - Combined";
        String meteringPointTypeExchange = "E20 - Exchange";

        usagePoints.addUsagePoint(NameGenerator.generateName("UPElectricity"), serviceCategoryE, typeOfUsagePointSDP, marketCodeSectorDomestic, meteringPointTypeExchange);

    }
}

