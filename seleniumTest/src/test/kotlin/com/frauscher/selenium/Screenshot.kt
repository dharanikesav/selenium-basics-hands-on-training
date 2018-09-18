package com.frauscher.selenium

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import java.io.File
import java.nio.file.Files
import java.time.LocalDateTime

class Screenshot {

    @Test
    fun `send keys and click`() {
        val options = ChromeOptions()
        options.setHeadless(true)

        val chromeDriver = ChromeDriver(options) as WebDriver
        chromeDriver.get("http://www.google.com")
        chromeDriver.findElement(By.ByXPath("//*[@id='lst-ib']")).sendKeys("clear this text")
        chromeDriver.findElement(By.ByXPath("//*[@id='lst-ib']")).clear()
        chromeDriver.findElement(By.ByXPath("//*[@id='lst-ib']")).sendKeys("frauscher", Keys.ENTER)
        //Thread.sleep(2000)
        //chromeDriver.findElement(By.ByXPath("//input[@class='lsb' and @value='Google Search']")).click()

        chromeDriver.captureScreenShot()

        chromeDriver.close()
    }

    private fun WebDriver.captureScreenShot() {
        val currentDir = System.getProperty("user.dir")
        val screenshot = (this as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        val destPath = File("$currentDir/out/${LocalDateTime.now().toString().replace(":","_")}.png")
        Files.copy(screenshot.toPath(), destPath.toPath())
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