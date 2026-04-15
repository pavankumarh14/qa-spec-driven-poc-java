# Selenium Automation Approach

## Purpose

This document defines the automation strategy for the POC.
Selenium is used **selectively** for UI acceptance scenarios only.

---

## Core Principle

> Selenium tests should validate what a real user sees and does in the browser.
> Not every acceptance criterion belongs in Selenium.

---

## What to Automate with Selenium

| Scenario Category | Include in Selenium? | Reason |
|---|---|---|
| Critical happy path journeys | Yes | High business value, high visibility |
| Error/validation messages visible in UI | Yes | User-facing feedback |
| Navigation and redirect flows | Yes | Browser-level behavior |
| Form submission and response handling | Yes | Direct user interaction |
| Business rule calculations | No | Better at API/service level |
| Audit log creation | No | Not user-visible |
| Database state verification | No | Not browser concern |
| Email delivery validation | No | Not browser concern |
| Performance benchmarking | No | Not Selenium's scope |
| Exploratory testing | No | Manual |

---

## Framework Pattern

### Page Object Model (POM)

```
LoginPage.java
  -> contains all locators for login page
  -> contains reusable action methods
  -> no assertions inside page objects

LoginTest.java
  -> contains test methods with assertions
  -> calls page object methods
  -> references Spec ID and TC ID in description
```

### BaseTest

```
BaseTest.java
  -> @BeforeMethod: launches browser, navigates to base URL
  -> @AfterMethod: closes browser
  -> all test classes extend BaseTest
```

---

## Locator Strategy

Use locators in this preferred order:

1. **id** - most stable, preferred
2. **name** attribute
3. **CSS selector** - readable and fast
4. **relative locators** (Selenium 4 feature)
5. **XPath** - last resort, use only when nothing else works

### Good
```java
By.id("username")
By.cssSelector("button[type='submit']")
By.name("email")
```

### Avoid
```java
By.xpath("//div[3]/form/input[1]")  // fragile - breaks on layout change
```

---

## Wait Strategy

Use **explicit waits** for dynamic content:

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
```

Avoid:
- `Thread.sleep()` - slow and brittle
- `implicitlyWait` alone for dynamic pages - can mask real timing issues

---

## Test Anatomy

Every test method must:
1. Reference Spec ID and TC ID in `@Test(description = ...)`
2. Use Page Object methods - not raw driver calls
3. Have a clear assertion
4. Be independent - no dependencies between test methods

```java
@Test(description = "AUTH-001 | TC-LOGIN-001 | Successful login with valid credentials")
public void validLoginTest() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.loginAs("tomsmith", "SuperSecretPassword!");
    Assert.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
}
```

---

## Test Data

For the POC, test data is hardcoded using the public demo app:
- URL: `https://the-internet.herokuapp.com/login`
- Valid username: `tomsmith`
- Valid password: `SuperSecretPassword!`

In a production framework, externalise test data to:
- properties files
- JSON/CSV files
- TestNG DataProvider for data-driven tests

---

## Reporting

Default TestNG reports are generated at:
```
target/surefire-reports/
```

For enhanced reporting in future iterations, consider:
- ExtentReports
- Allure Report
- ReportNG
