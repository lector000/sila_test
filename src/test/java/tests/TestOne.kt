package tests

import construction_classes.locatorTypes
import locators.*
import main.TestMethods
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestOne: TestMethods() {
    @Test
    fun testOne() {

        //закрытие сплеша

        try {
            clickToElement(
                locatorType = locatorTypes.xpath,
                locator = SplashScreenLocators().exitButtonOnSplashScreen.androidXpath
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, идем дальше")
        }


        //ввод номера
        inputTextInField(locatorType = locatorTypes.id,
            locator = AuthorizationPhoneNumberScreenLocators().editTextPhone.androidId,
            text = "9999999927" )

        clickToElement(
            locatorType = locatorTypes.id,
            locator =AuthorizationPhoneNumberScreenLocators().buttonGetCode.androidId
        )


        //ввод кода и подтверждение авторизации
        inputTextInField(locatorType = locatorTypes.id,
            locator = AuthorizationCodeScreenLocators().inputCodePoints.androidId,
            text = "1111" )

        TimeUnit.SECONDS.sleep(7)


        //разрешение на геолокацию и подтверждение города
        clickToElement(
            locatorType = locatorTypes.id,
            locator = CitySelectionScreenLocators().AllertGeolocationConfirmationButtonOneTime.androidId
        )

        clickToElement(
            locatorType = locatorTypes.id,
            locator = CitySelectionScreenLocators().AllertCityConfirmationButtonYes.androidId
        )
        TimeUnit.SECONDS.sleep(1)

            //Открытие профиля и переход к редактированию
        clickToElement(
            locatorType = locatorTypes.id,
            locator = BottomBarMenuLocators().ParofileButton.androidId
        )

        clickToElement(
            locatorType = locatorTypes.id,
            locator = AuthorizedUserProfileScreenLocators().buttonEditProfile.androidId
        )


        // Скролл до логаута
        scrollToElement(
            locatorType = locatorTypes.id,
            locator = EditProfileScreenLocators().buttonLogout.androidId
        )

        clickToElement(
            locatorType = locatorTypes.id,
            locator = EditProfileScreenLocators().buttonLogout.androidId
        )

        TimeUnit.SECONDS.sleep(1)


        if (checkAvaliableElement (
                locatorType = locatorTypes.id,
                locator = NotAuthorizedUserProfileScreenLocators().loginButton.androidId
            ))
            tapByCoordinates(160, 2150)

        swipeOnScreen(500, 1500,500, 300)

        TimeUnit.SECONDS.sleep(5)



    }


}