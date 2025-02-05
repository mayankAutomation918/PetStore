package apiUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;

public class ExtentReportManager implements ITestListener {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter sparkReporter;

    public void onStart(ITestContext context) {
        File reportDir = new File("report");
        if (!reportDir.exists()) {
            reportDir.mkdir();
        }
        sparkReporter = new ExtentSparkReporter("report/test-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped: " + result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
