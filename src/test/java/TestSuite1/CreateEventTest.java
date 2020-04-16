package TestSuite1;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;


import io.appium.java_client.AppiumDriver;


public class CreateEventTest {

    static WebDriver driver;

    @Test
    public void createEvent(){
        try{
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("deviceName", "Android SDK built for x86");
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "7.0");

            caps.setCapability("appPackage", "com.google.android.calendar");
            caps.setCapability("appActivity", "com.android.calendar.AllInOneCalendarActivity");

            //caps.setCapability("appPackage", "com.android.contacts");
            //caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
            caps.setCapability("automationName", "UiAutomator2");

            URL url = new URL("http://localhost:4723/wd/hub");

            driver = new AppiumDriver<MobileElement>(caps);

            System.out.println("Application Started");

            driver.findElement(By.id("com.google.android.calendar:id/floating_action_button")).click();

            Thread.sleep(1500);

            driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Event')]")).click();

            Thread.sleep(1500);

            /**
             * Test Event Description input
             */
            driver.findElement(By.id("com.google.android.calendar:id/input")).sendKeys("Sample Event");
            Thread.sleep(1500);

            /**
             * Test all day toggle on/off
             */
            //Toggle ON
            driver.findElement(By.id("com.google.android.calendar:id/all_day_switch")).click();
            Thread.sleep(1500);
            driver.findElement (By.xpath ("//*[contains(@text,'ON')]"));
            Thread.sleep(1500);

            //Toggle OFF
            driver.findElement(By.id("com.google.android.calendar:id/all_day_switch")).click();
            Thread.sleep(1500);
            driver.findElement (By.xpath ("//*[contains(@text,'OFF')]"));

            /**
             * Test set event date and time
             */

            //open more date and time options
            driver.findElement(By.id("com.google.android.calendar:id/more_options")).click();
            Thread.sleep(1500);

            //start date
            driver.findElement(By.id("com.google.android.calendar:id/start_date")).click();
            Thread.sleep(1500);

            //set event month
            for (int i = 0; i < 2; i++){
                driver.findElement(By.id("android:id/next")).click();
                Thread.sleep(1500);
            }

            //set event day
            driver.findElement(By.xpath("//android.view.View[@content-desc=\'25 June 2020\']")).click();
            Thread.sleep(1500);
            driver.findElement(By.id("android:id/button1")).click();
            Thread.sleep(1500);


            //set start time
            driver.findElement(By.id("com.google.android.calendar:id/start_time")).click();
            Thread.sleep(1500);

            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'PM')]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'PM')]")).isSelected();
            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'AM')]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'AM')]")).isSelected();

            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\'7\']")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\'0\']")).click();
            Thread.sleep(1500);

            driver.findElement(By.id("android:id/button1")).click();

            Thread.sleep(1500);

            driver.findElement(By.id("com.google.android.calendar:id/start_time")).getText().equals("7:00 AM");

            //set end time
            driver.findElement(By.id("com.google.android.calendar:id/end_time")).click();
            Thread.sleep(1500);

            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'PM')]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'PM')]")).isSelected();
            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'AM')]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'AM')]")).isSelected();

            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\'11\']")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\'55\']")).click();
            Thread.sleep(1500);

            driver.findElement(By.id("android:id/button1")).click();

            Thread.sleep(1500);

            driver.findElement(By.id("com.google.android.calendar:id/start_time")).getText().equals("7:00 AM");

//            //end date
//            driver.findElement(By.id("com.google.android.calendar:id/end_date")).click();
//            Thread.sleep(3000);
//
//            //set event month
//            for (int i = 0; i < 2; i++){
//                driver.findElement(By.id("android:id/next")).click();
//                Thread.sleep(3000);
//            }
//
//            //set event day
//            driver.findElement(By.xpath("//android.view.View[@content-desc=\'26 June 2020\']")).click();
//            driver.findElement(By.id("android:id/button1")).click();
//            Thread.sleep(3000);

//
//            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TimePicker/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RadioGroup/android.widget.RadioButton[2]"));
//            driver.findElement(By.id(""));
//            driver.findElement(By.id(""));
//            driver.findElement(By.id(""));
//            driver.findElement(By.id(""));
//            driver.findElement(By.id(""));
//            driver.findElement(By.id(""));





            //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
            //MobileElement eventPane = driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,'Event button')]"));
            //MobileElement eventPane = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Event')]");


        }catch(MalformedURLException exc){
            //do exception handling here
            System.out.print("Invalid server url: " + exc.getCause());
            exc.getMessage();
            exc.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
