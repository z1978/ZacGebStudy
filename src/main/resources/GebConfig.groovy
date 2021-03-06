//choose "htmlunit", "firefox", "ie", "chrome"
driver = "firefox"

//chrome - http://chromedriver.storage.googleapis.com/index.html
//System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe")

//For Mac
System.setProperty("webdriver.chrome.driver", "driver/chromedriver2.32")

//ie - http://selenium-release.storage.googleapis.com/index.html
System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe")

//reports setting
reportsDir = "target/geb-reports"
reportOnTestFailureOnly = false

googleUserId = "****@gmail.com"
googlePassword = "****"

waiting {
  timeout = 20
  retryInterval = 0.5
}