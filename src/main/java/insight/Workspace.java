package insight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Workspace {
    WebDriver driver;

    // Constructor initializes the state of the driver
    public Workspace(WebDriver driver) {
        this.driver = driver;

    }

    // verify the links on this page
    public void openWorkspace() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("button-1048")).click();

    }

    public void verifyLinks() {
        // Data exchange
        driver.findElement(By.linkText("Export history")).click(); // Export history
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Import history")).click(); // Import history
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Upload file for import")).click(); // Upload file for import
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Data validation
        driver.findElement(By.linkText("Data quality")).click(); // Data quality
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Service calls
        driver.findElement(By.linkText("Service calls")).click(); // Service calls
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Task management
        driver.findElement(By.linkText("My open tasks")).click(); // My open tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My workgroups tasks")).click(); // My workgroup tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Overdue tasks")).click(); // Overdue tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Tasks")).click(); // Tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Unassigned tasks")).click(); // Unassigned tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
    }
}
