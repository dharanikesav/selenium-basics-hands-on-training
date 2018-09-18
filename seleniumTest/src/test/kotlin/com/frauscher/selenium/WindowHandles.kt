package com.frauscher.selenium

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService

class WindowHandles {

    @Test
    fun `window handles`() {
        val chromeDriver = ChromeDriver() as WebDriver
        chromeDriver.get("http://www.google.com")
        chromeDriver.findElement(By.ByXPath("//*[@id='lst-ib']")).sendKeys("clear this text")
        Thread.sleep(1000)
        (chromeDriver as JavascriptExecutor).executeScript("window.open()")
        Thread.sleep(1000)

        chromeDriver.windowHandles.forEach {
            if(chromeDriver.title != "Google")
                chromeDriver.switchTo().window(it)
        }
        chromeDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP)
        Thread.sleep(1000)
        chromeDriver.findElement(By.ByXPath("//*[@id='lst-ib']")).clear()
        chromeDriver.findElement(By.ByXPath("//*[@id='lst-ib']")).sendKeys("frauscher")
        Thread.sleep(1000)
        chromeDriver.findElement(By.ByXPath(" //input[@class='lsb' and @value='Google Search']")).click()
        Thread.sleep(1000)

        chromeDriver.close()
        //chromeDriver.quit()
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