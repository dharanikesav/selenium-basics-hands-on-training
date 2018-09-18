package com.frauscher.selenium

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService

class ReadValues {

    @Test
    fun `read properties`() {
        val chromeDriver = ChromeDriver() as WebDriver
        chromeDriver.get("http://www.google.com")
        println(chromeDriver.findElement(By.ByXPath("//*[@id='lst-ib']")).getAttribute("class"))
        println(chromeDriver.findElement(By.ByXPath("//*[@name='btnK']")).isEnabled)
        println(chromeDriver.findElement(By.ByXPath("//*[@name='btnK']")).size.height)
        println(chromeDriver.findElement(By.ByXPath("//*[@name='btnK']")).getCssValue("font-family"))

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