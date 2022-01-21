package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.interactions.touch.TouchActions
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.util.concurrent.TimeUnit
import main.TestMethods
import utils.appPath


open class BaseClass {
    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun setupDriver() {

        val url = URL("http://0.0.0.0:4723/wd/hub")
        val caps = DesiredCapabilities()


        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        //caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0")
       // caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel")
        caps.setCapability(MobileCapabilityType.NO_RESET, false)
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "7200")
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.sportmaster.app.presentation.start.StartActivity")
        caps.setCapability(MobileCapabilityType.APP, appPath.fullAppLocalPathAndroid)

        caps.setCapability(MobileCapabilityType.UDID, "R58N11EQ2BL")
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A51")

        driver = AndroidDriver(url, caps)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)

    }

    @AfterSuite

    fun end() {
        driver.quit()
    }







}