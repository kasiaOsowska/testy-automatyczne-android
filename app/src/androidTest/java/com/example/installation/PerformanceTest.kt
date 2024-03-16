package com.example.installation

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.Test

class PerformanceTest {
    private var device: UiDevice? = null

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    @Throws(InterruptedException::class)
    fun appLaunchPerformance() {
        val packageName = "com.bernaferrari.changedetection"
        val launcherActivity = "com.bernaferrari.changedetection.MainActivity"

        val startTime = System.currentTimeMillis()
        device!!.executeShellCommand("am start -W -n $packageName/$launcherActivity")
        val endTime = System.currentTimeMillis()

        val launchTime = endTime - startTime
        println("Application launch time: $launchTime ms")
        assert(launchTime < 5000) {"Application launch time was longer than 5 seconds."}

    }
}