package locators

import construction_classes.LocatorsConstructor


class CitySelectionScreenLocators {

    val AllertGeolocationConfirmationButtonOneTime = LocatorsConstructor(
        androidId = "com.android.permissioncontroller:id/permission_allow_one_time_button"
    )
    val AllertCityConfirmationButtonYes = LocatorsConstructor(
        androidId = "android:id/button1"
    )
}