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


class BaseClass {
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
        caps.setCapability(MobileCapabilityType.APP, "/Users/lector/Downloads/sportmaster-4.0.13.5605_dev_beta.apk")

        caps.setCapability(MobileCapabilityType.UDID, "R58M63L5GLX")
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A30")

        driver = AndroidDriver(url, caps)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)

    }

    @AfterSuite

    fun end() {
        driver.quit()
    }

    @Test
    fun testOne() {
        // TimeUnit.SECONDS.sleep(1)
        try {
            lateinit var element: MobileElement
            element = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton"))
            element.click()
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, идем дальше")
        }


        //TimeUnit.SECONDS.sleep(3)

        lateinit var element2: MobileElement
        element2 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone"))
        element2.sendKeys("9999999927")

        lateinit var element3: MobileElement
        element3 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonGetCode"))
        element3.click()

        TimeUnit.SECONDS.sleep(1)

        lateinit var pinCodeEditText: MobileElement
        pinCodeEditText = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/pinCodeEditText"))
        pinCodeEditText.sendKeys("1111")

        TimeUnit.SECONDS.sleep(7)

        lateinit var permission_allow_one_time_button: MobileElement
        permission_allow_one_time_button = driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button"))
        permission_allow_one_time_button.click()
        //TimeUnit.SECONDS.sleep(1)

        lateinit var city_allert: MobileElement
        city_allert = driver.findElement(MobileBy.id("android:id/button1"))
        city_allert.click()
        TimeUnit.SECONDS.sleep(1)



        lateinit var profile_graph: MobileElement
        profile_graph = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/profile_graph"))
        profile_graph.click()

        TimeUnit.SECONDS.sleep(7)




    }


}