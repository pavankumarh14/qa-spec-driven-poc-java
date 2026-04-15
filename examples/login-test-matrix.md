# Login Feature - Testcase Matrix

**Feature**: User Login
**Spec**: specs/001-login/spec.md
**Date**: 2026-04-15

---

## Testcase Matrix

| Spec ID | Testcase ID | Scenario | Priority | Test Type | Automation Candidate | Automation Script | Status |
|---|---|---|---|---|---|---|---|
| AUTH-001 | TC-LOGIN-001 | Successful login with valid credentials | P1 | UI | Yes | LoginTest.validLoginTest | Automated |
| AUTH-002 | TC-LOGIN-002 | Login fails with invalid password | P1 | UI | Yes | LoginTest.invalidPasswordTest | Automated |
| AUTH-003 | TC-LOGIN-003 | Validation shown for blank credentials | P2 | UI | Yes | LoginTest.blankCredentialsValidationTest | Automated |
| AUTH-004 | TC-LOGIN-004 | Locked account login attempt | P2 | API/Manual | Partial | TBD | Pending |

---

## Coverage Summary

| Layer | Count | Notes |
|---|---|---|
| Selenium UI Tests | 3 | AUTH-001, AUTH-002, AUTH-003 |
| API/Manual | 1 | AUTH-004 - locked account |
| Total Acceptance Criteria | 4 | AUTH-001 to AUTH-004 |
| Automated Coverage | 75% | 3 of 4 criteria have Selenium coverage |

---

## Traceability

```
AUTH-001 -> TC-LOGIN-001 -> LoginTest.validLoginTest
AUTH-002 -> TC-LOGIN-002 -> LoginTest.invalidPasswordTest
AUTH-003 -> TC-LOGIN-003 -> LoginTest.blankCredentialsValidationTest
AUTH-004 -> TC-LOGIN-004 -> TBD (API/manual)
```

---

## Detailed Testcase Notes

### TC-LOGIN-001 - Successful Login
- **Preconditions**: Valid account exists. App is accessible.
- **Steps**: Navigate to login > Enter `tomsmith` / `SuperSecretPassword!` > Click login
- **Expected**: Redirected to secure area. Success message visible.
- **Automation**: BaseTest + LoginPage.loginAs() + Assert flash message

### TC-LOGIN-002 - Invalid Password
- **Preconditions**: Valid account exists.
- **Steps**: Navigate to login > Enter `tomsmith` / `WrongPassword` > Click login
- **Expected**: Error message shown. User stays on login page.
- **Automation**: LoginPage.loginAs() + Assert error in flash message

### TC-LOGIN-003 - Blank Credentials
- **Preconditions**: Login page is displayed.
- **Steps**: Navigate to login > Leave fields blank > Click login
- **Expected**: Error or validation message shown. Not logged in.
- **Automation**: LoginPage.loginAs with empty strings + Assert flash message exists

### TC-LOGIN-004 - Locked Account
- **Preconditions**: Account locked in system.
- **Steps**: Navigate to login > Enter correct credentials for locked account > Click login
- **Expected**: Authentication denied. Account locked message shown.
- **Automation**: Demo app does not support this scenario directly. Recommend API-level test in real environment.
