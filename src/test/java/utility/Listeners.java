package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//We need to provide the detail of this Listener class to the testng.xml file
/*
Write below code in testng.xml file after the suite and before the test tag
<listeners>
    <listener class-name = "utility.Listeners/">
</listeners>
 */

//ITestListener -> Interface
public class Listeners extends Helper implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting the test case");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Successfully executed the test case");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //print the response if API is failed
        //take the screenshot when TC failed
        System.out.println("*********Capturing Screenshot*******************");
        Helper.getScreenshot("345");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
