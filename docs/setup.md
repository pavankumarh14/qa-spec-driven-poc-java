# Setup Guide

## Project Structure

```
src/
  test/
    java/
      com/
        example/
          base/       - BaseTest.java (browser setup/teardown)
          pages/      - Page Object classes
          tests/      - TestNG test classes
```

---

## Framework Stack

| Component | Tool | Version |
|---|---|---|
| Language | Java | 17+ |
| Browser Automation | Selenium WebDriver | 4.20+ |
| Test Runner | TestNG | 7.10+ |
| Build | Maven | 3.9+ |
| Driver Management | Selenium Manager (built-in) | Auto |

> Selenium 4.x includes Selenium Manager which automatically handles ChromeDriver - no manual driver setup needed.

---

## Maven Dependencies (pom.xml)

Key dependencies already configured:

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.20.0</version>
</dependency>
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
</dependency>
```

---

## Running Tests

### Run full suite

```bash
mvn clean test
```

### Run with explicit TestNG suite file

```bash
mvn -DsuiteXmlFile=testng.xml test
```

### Run a specific test class

```bash
mvn -Dtest=LoginTest test
```

---

## Test Reports

After running tests, reports are available at:

```
target/surefire-reports/index.html
target/surefire-reports/emailable-report.html
```

Open in browser:

```bash
open target/surefire-reports/emailable-report.html
```

---

## IDE Setup - IntelliJ IDEA

1. File > Open > select `qa-spec-driven-poc-java` folder
2. IntelliJ auto-detects Maven project
3. Wait for dependency download
4. Right-click `testng.xml` > Run

## IDE Setup - VS Code

1. Install Extension Pack for Java
2. Open folder
3. Maven auto-detected
4. Run tests from Testing sidebar

---

## Good Practices Applied

- Page Object Model separates locators from test logic
- BaseTest manages browser lifecycle
- Explicit waits preferred over thread.sleep
- Stable locators: id > name > CSS > XPath
- Every test method references Spec ID and Testcase ID in description
