package com.frauscher.selenium

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.GeckoDriverService

class LaunchAndNavigate {
    @Test
    fun `launch different browsers`() {
        val chromeDriver = ChromeDriver()
        chromeDriver.get("http://www.google.com")
        chromeDriver.close()

        val firefoxDriver = FirefoxDriver()
        firefoxDriver.get("http://www.google.com")
        firefoxDriver.close()
    }

    @Test
    fun `navigate`() {
        val chromeDriver = ChromeDriver()
        chromeDriver.navigate().to("http://www.google.com")
        Thread.sleep(500)
        chromeDriver.navigate().to("http://www.gmail.com")
        Thread.sleep(500)
        chromeDriver.navigate().refresh()
        Thread.sleep(500)
        chromeDriver.navigate().back()
        Thread.sleep(500)
        chromeDriver.navigate().forward()
        Thread.sleep(500)
        chromeDriver.close()
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun `before all`() {
            val currentDir = System.getProperty("user.dir")
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "$currentDir/resources/drivers/chromedriver")
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "$currentDir/resources/drivers/geckodriver")
        }
    }
}