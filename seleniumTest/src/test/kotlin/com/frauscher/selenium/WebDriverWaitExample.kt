package com.frauscher.selenium

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

class WebDriverWaitExample {

    @Test
    fun `implicit wait`() {
        val chromeDriver = ChromeDriver() as WebDriver
        chromeDriver.manage().timeouts().implicitlyWait(5_000L, TimeUnit.MILLISECONDS)
        chromeDriver.get("http://www.google.com")
        chromeDriver.findElement(By.ByXPath("//*[@id='lst-i']")).sendKeys("clear this text")
        chromeDriver.close()
    }

    @Test
    fun `explicit wait`() {
        val chromeDriver = ChromeDriver() as WebDriver
        chromeDriver.get("http://www.google.com")
        chromeDriver.waitForElement(By.xpath("//*[@id='lst-i']")).sendKeys("clear this text")
        chromeDriver.close()
    }

    private fun WebDriver.waitForElement(by: By) =
            WebDriverWait(this, 1L).until(ExpectedConditions.visibilityOfElementLocated(by))

    companion object {
        @JvmStatic
        @BeforeAll
        fun `before all`() {
            val currentDir = System.getProperty("user.dir")
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "$currentDir/resources/drivers/chromedriver")
        }
    }
}
