package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    //to take a screenshot on failure
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        Path destination = Paths.get("./Screenshots",screenshotName+".png");
        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream output = new FileOutputStream(destination.toString());
            output.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            output.close();
        } catch (IOException e) {
            System.out.println("Exception while taking Screenshot"+ e.getMessage());
        }
    }
}
