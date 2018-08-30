package multiSense;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WorkspaceMultiSense {
    WebDriver driver;

    // Constructor initializes the state of the driver
    public WorkspaceMultiSense(WebDriver driver) {
        this.driver = driver;
    }

    // verify the links on this page
    public void openWorkspace() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("button-1048")).click();
    }

    public void verifyLinks() {
        // Alarms
        driver.findElement(By.linkText("Alarms")).click(); // Alarms
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Alarms overview")).click(); // Alarms overview
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My open alarms")).click(); // My open alarms
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My workgroups alarms")).click(); // My workgroups alarms
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Data collection
        driver.findElement(By.linkText("Issues")).click(); // Issues
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My open issues")).click(); // My open issues
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My workgroups issues")).click(); // My workgroup issues
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Data communication
        driver.findElement(By.linkText("Commands")).click(); // Commands
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Communications")).click(); // Communications
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Communications overview")).click(); // Communications overview
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Connections")).click(); // Connections
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Connections overview")).click(); // Connections overview
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Registered devices")).click(); // Registered devices
        driver.findElement(By.id("button-1048")).click(); // Workspace
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
        //driver.findElement(By.linkText("Issues")).click(); // Issues
        //driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My open issues")).click(); // My open issues
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My workgroup issues")).click(); // My workgroup issues
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Firmware management
        driver.findElement(By.linkText("Firmware campaigns")).click(); // Firmware campaigns
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Issues
        //driver.findElement(By.linkText("Issues")).click(); // Issues
        //driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Issues overview")).click(); // Issues overview
        driver.findElement(By.id("button-1048")).click(); // Workspace
        //driver.findElement(By.linkText("My open issues")).click(); // My open issues
        //driver.findElement(By.id("button-1048")).click(); // Workspace
        //driver.findElement(By.linkText("My workgroup issues")).click(); // My workgroup issues
        //driver.findElement(By.id("button-1048")).click(); // Workspace
        // Service calls
        driver.findElement(By.linkText("Service calls")).click(); // Service calls
        driver.findElement(By.id("button-1048")).click(); // Workspace
        // Task management
        driver.findElement(By.linkText("My open tasks")).click(); // My open tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("My workgroups tasks")).click(); // My workgroups tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Overdue tasks")).click(); // Overdue tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Tasks")).click(); // Tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace
        driver.findElement(By.linkText("Unassigned tasks")).click(); // Unassigned tasks
        driver.findElement(By.id("button-1048")).click(); // Workspace

    }
}
