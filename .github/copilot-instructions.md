# GitHub Copilot Instructions

## Project Overview
This is a **Spec-Driven Development (SDD) POC** for QA Automation using:
- **Language**: Java 11
- **Framework**: Selenium WebDriver 4.18 + TestNG 7.9
- **Build Tool**: Maven
- **Driver Management**: WebDriverManager (auto, no manual chromedriver needed)
- **Target App**: https://the-internet.herokuapp.com/login

## Project Structure
```
src/test/java/
  base/BaseTest.java      # WebDriver setup/teardown
  pages/LoginPage.java    # Page Object Model
  tests/LoginTest.java    # TestNG test cases
pom.xml                   # Maven dependencies
testng.xml                # TestNG suite config
specs/001-login/          # Feature specs (source of truth)
examples/                 # Test matrices
docs/                     # Documentation
```

## How to Run Tests

### Via Maven (terminal)
```bash
mvn test
```

### Via GitHub Actions
Push to main or trigger manually via Actions tab.

### Via Copilot Agent
You can ask Copilot to:
- Run the test suite: `Run mvn test`
- Run a specific test: `Run LoginTest#validLoginTest`
- Add a new test mapped to a spec criterion
- Generate a new Page Object for a new feature

## Coding Conventions
- All test methods MUST include a `@Test(description = "TC-XXX: ...")` annotation
- Each test class MUST have a Javadoc block with Spec Traceability
- Page Objects go in `pages/` package
- Base infrastructure goes in `base/` package
- Tests go in `tests/` package
- New specs go in `specs/NNN-featurename/spec.md`

## Spec-to-Test Mapping Pattern
```
specs/001-login/spec.md  ->  AUTH-001  ->  TC-LOGIN-001  ->  LoginTest.validLoginTest()
```

## Key Credentials for Demo App
- Valid: username=`tomsmith`, password=`SuperSecretPassword!`
- Invalid: any other combination

## Headless Mode (for CI)
In `BaseTest.java`, uncomment:
```java
options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
```
This is handled automatically in GitHub Actions workflow.
