package com.example.installation

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstallationTest {
    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        device = UiDevice.getInstance(instrumentation)
    }

    @Test
    fun installAppWithPlayStore() {

        device.pressRecentApps()
        val playStoreDaemon = device.findObject(UiSelector().descriptionContains("Play Store"))
        playStoreDaemon?.swipeUp(10)
        device.pressHome()

        val playStore = device.findObject(UiSelector().descriptionContains("Play Store"))
        playStore.clickAndWaitForNewWindow()
        val searchBox = device.findObject(UiSelector().descriptionContains("Search"))
        if (searchBox.waitForExists(5000)) {
            searchBox.click()
        }
        val searchText = device.findObject(UiSelector().descriptionContains("com.bernaferrari.changedetection"))
        if (searchText.waitForExists(5000)) {
            searchText.click()
        }
        val appTitle = device.findObject(UiSelector().descriptionContains("Change Detection - Monitor web"))
        if (appTitle.waitForExists(5000)) {
            appTitle.click()
        }
        val installButton = device.findObject(UiSelector().descriptionContains("Install"))
        if (installButton.waitForExists(5000)) {
            installButton.click()
        }
        val openButton = device.findObject(UiSelector().descriptionContains("Open"))
        if (openButton.waitForExists(30000)) {
            device.pressHome()
        }
        val welcomeElement = device.findObject(UiSelector().descriptionContains("New Tracking"))
        TestCase.assertNotNull("New Tracking element should be present", welcomeElement)
    }
}
