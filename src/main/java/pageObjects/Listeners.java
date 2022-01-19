package pageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;

public class Listeners extends base implements ITestListener {

    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
    extent.flush();
    }


    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }


    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        test.fail(result.getThrowable());
        //Capture which test is failing
        String testMethodName = result.getMethod().getMethodName();
        WebDriver driver = null;
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        //Screenshot

        try {
            getScreenshotPath(testMethodName, driver);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        test.log(Status.PASS, "Test Passed");
    }
}
