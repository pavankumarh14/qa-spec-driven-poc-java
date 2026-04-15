# Login Feature Quickstart

## Goal

Run the login Selenium tests in under 5 minutes.

---

## Prerequisites

- Java 17+ installed
- Maven 3.9+ installed
- Chrome browser installed
- Repository cloned locally

---

## Steps

### 1. Clone the repo

```bash
git clone https://github.com/pavankumarh14/qa-spec-driven-poc-java.git
cd qa-spec-driven-poc-java
```

### 2. Install dependencies

```bash
mvn clean install -DskipTests
```

### 3. Run login tests

```bash
mvn clean test
```

---

## Expected Behavior

1. Chrome browser launches
2. Test 1: navigates to login page, enters valid credentials, verifies success message
3. Test 2: enters invalid password, verifies error message
4. Test 3: submits blank credentials, verifies validation message
5. Browser closes after each test
6. TestNG suite completes

---

## Expected Output

```
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## View Report

```bash
open target/surefire-reports/emailable-report.html
```

---

## Demo App

Tests use: https://the-internet.herokuapp.com/login

| Credential | Value |
|---|---|
| Username | tomsmith |
| Password | SuperSecretPassword! |

---

## Traceability

| Test Method | Spec ID | TC ID |
|---|---|---|
| validLoginTest | AUTH-001 | TC-LOGIN-001 |
| invalidPasswordTest | AUTH-002 | TC-LOGIN-002 |
| blankCredentialsValidationTest | AUTH-003 | TC-LOGIN-003 |
