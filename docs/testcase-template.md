# Testcase Template

Use this template for every testcase derived from a feature spec.

---

## Template

| Field | Description |
|---|---|
| **Spec ID** | Acceptance criteria ID from spec.md (e.g. AUTH-001) |
| **Testcase ID** | Unique testcase identifier (e.g. TC-LOGIN-001) |
| **Feature** | Feature name |
| **Scenario** | Business scenario in plain language |
| **Preconditions** | State required before test execution |
| **Test Steps** | Step-by-step execution instructions |
| **Expected Result** | Clearly defined expected behavior |
| **Test Type** | UI / API / DB / Manual |
| **Automation Candidate** | Yes / No / Partial |
| **Automation Script** | Class name and method (e.g. LoginTest.validLoginTest) |
| **Priority** | P1 / P2 / P3 |
| **Status** | Draft / Ready / Automated / Blocked |

---

## Example - Login Feature

### TC-LOGIN-001

| Field | Value |
|---|---|
| Spec ID | AUTH-001 |
| Testcase ID | TC-LOGIN-001 |
| Feature | Login |
| Scenario | Successful login with valid credentials |
| Preconditions | User account exists and is active. Application is accessible. |
| Test Steps | 1. Navigate to login page. 2. Enter valid username. 3. Enter valid password. 4. Click login button. |
| Expected Result | User is authenticated and redirected to dashboard. Success message is displayed. |
| Test Type | UI |
| Automation Candidate | Yes |
| Automation Script | LoginTest.validLoginTest |
| Priority | P1 |
| Status | Automated |

---

### TC-LOGIN-002

| Field | Value |
|---|---|
| Spec ID | AUTH-002 |
| Testcase ID | TC-LOGIN-002 |
| Feature | Login |
| Scenario | Login fails with invalid password |
| Preconditions | User account exists and is active. |
| Test Steps | 1. Navigate to login page. 2. Enter valid username. 3. Enter incorrect password. 4. Click login button. |
| Expected Result | Login fails. Error message is shown. User stays on login page. |
| Test Type | UI |
| Automation Candidate | Yes |
| Automation Script | LoginTest.invalidPasswordTest |
| Priority | P1 |
| Status | Automated |

---

### TC-LOGIN-003

| Field | Value |
|---|---|
| Spec ID | AUTH-003 |
| Testcase ID | TC-LOGIN-003 |
| Feature | Login |
| Scenario | Validation shown for blank credentials |
| Preconditions | Login page is displayed. |
| Test Steps | 1. Navigate to login page. 2. Leave username blank. 3. Leave password blank. 4. Click login button. |
| Expected Result | Validation or error message is displayed. User is not logged in. |
| Test Type | UI |
| Automation Candidate | Yes |
| Automation Script | LoginTest.blankCredentialsValidationTest |
| Priority | P2 |
| Status | Automated |

---

## Priority Guide

| Priority | Meaning |
|---|---|
| P1 | Must automate - critical business flow |
| P2 | Should automate - important validation |
| P3 | Nice to automate - edge case or low frequency |
