package main

import construction_classes.locatorTypes
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import utils.PlatformTouchAction
import java.time.Duration

open class TestMethods: BaseClass() {


    fun clickToElement(locatorType: String, locator: String){
        lateinit var element: MobileElement
        when (locatorType){
            locatorTypes.id -> element = driver.findElement(MobileBy.id(locator))
            "AccesebilityIs" -> element = driver.findElement(MobileBy.AccessibilityId(locator))
            locatorTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.click()
    }

    fun inputTextInField (locatorType: String,locator: String, text: String){
        lateinit var element: MobileElement
        when (locatorType){
            locatorTypes.id -> element = driver.findElement(MobileBy.id(locator))
            "AccesebilityIs" -> element = driver.findElement(MobileBy.AccessibilityId(locator))
            locatorTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element = driver.findElement(MobileBy.id(locator))
        element.sendKeys(text)
    }

    fun scrollAndClickToElement(locatorType: String, locator: String ){
        lateinit var element: MobileElement
        when (locatorType){
            locatorTypes.id -> element = driver.findElement(
                MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceIdMatches(\""+locator+"\"))"))
            "AccesebilityIs" -> element = driver.findElement(MobileBy.AccessibilityId(locator))
            locatorTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.click()
    }

    fun swipeOnScreen(startCordX: Int, startCordY: Int, moveCordX: Int, moveCordY: Int) {
        PlatformTouchAction(driver)
            .longPress(PointOption.point(startCordX, startCordY))
            .moveTo(PointOption.point(moveCordX, moveCordY))
            .release()
            .perform()
    }

    // Тап по координатам на экране
    fun tapByCoordinates(cordX: Int, cordY: Int) {
        PlatformTouchAction(driver)
            .tap(PointOption.point(cordX, cordY))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
            .perform()
    }

}