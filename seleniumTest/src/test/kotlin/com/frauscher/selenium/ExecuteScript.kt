package com.frauscher.selenium

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService

class ExecuteScript {

    @Test
    fun `send keys and click`() {
        val chromeDriver = ChromeDriver() as WebDriver
        chromeDriver.get("http://www.google.com")

        val element = chromeDriver.findElement(By.ByXPath("//*[@name='btnK']"))
        Thread.sleep(1000)
        (chromeDriver as JavascriptExecutor).executeScript("arguments[0].hidden = true;", element)
        Thread.sleep(1000)
        (chromeDriver as JavascriptExecutor).executeScript("document.getElementsByName('btnK').item(0).hidden = false;")
        Thread.sleep(1000)

        chromeDriver.close()
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun `before all`() {
            val currentDir = System.getProperty("user.dir")
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "$currentDir/resources/drivers/chromedriver")
        }
    }
}