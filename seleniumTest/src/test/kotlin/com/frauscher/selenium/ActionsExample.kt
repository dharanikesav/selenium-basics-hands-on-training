package com.frauscher.selenium

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.interactions.Actions

class ActionsExample {

    @Test
    fun `actions example`() {
        val chromeDriver = ChromeDriver() as WebDriver
        chromeDriver.get("http://www.ebay.de")

        val actions = Actions(chromeDriver)

        val electronikElement = chromeDriver.findElement(By.ByXPath("//li/a[@href='https://www.ebay.de/rpp/elektronik-technik']"))
        val handyElement = chromeDriver.findElement(By.ByXPath("//a[text()='Handys & Kommunikation' and @class='hl-cat-nav__js-link']"))

        actions.moveToElement(electronikElement).perform()
        Thread.sleep(2000)
        actions.moveToElement(handyElement).click().perform()
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