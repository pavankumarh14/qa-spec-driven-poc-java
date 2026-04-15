# Workflow Guide

## QA Spec-Driven Development (SDD) Flow

```
1. Feature request arrives
        |
        v
2. Create feature branch (e.g. 001-login)
        |
        v
3. Run /speckit.specify
   -> Generates spec.md with acceptance criteria
        |
        v
4. Run /speckit.plan
   -> Generates plan.md with scope and risks
        |
        v
5. Run /speckit.tasks
   -> Generates tasks.md with implementation checklist
        |
        v
6. QA reviews spec and derives testcase matrix
   -> examples/login-test-matrix.md
        |
        v
7. QA classifies automation scope
   -> UI (Selenium) / API / Manual
        |
        v
8. Implement Selenium tests for UI candidates only
        |
        v
9. Run tests - mvn clean test
        |
        v
10. Update traceability
    -> Spec ID -> Testcase ID -> Test method
        |
        v
11. Merge branch when coverage complete
```

---

## Branch Strategy

| Branch Pattern | Purpose |
|---|---|
| `main` | Stable, always tested |
| `001-login` | Feature: Login spec and automation |
| `002-password-reset` | Feature: Password reset spec and automation |
| `003-user-registration` | Feature: User registration |

Spec Kit uses branch-aware feature context, so each feature branch contains its own spec artifacts.

---

## Spec Kit Commands Reference

### /speckit.specify

Creates `spec.md` with:
- Feature name and description
- Business goal
- Acceptance criteria in Given/When/Then style
- Non-functional expectations
- Edge cases

### /speckit.plan

Creates `plan.md` with:
- Objective
- Scope (in/out)
- Test design strategy
- Risks and assumptions

### /speckit.tasks

Creates `tasks.md` with:
- Checkbox task list
- Implementation order
- QA and automation tasks separated

---

## Traceability Model

Every Selenium test method must reference:

```java
@Test(description = "SPEC-ID | TC-ID | Scenario name")
```

Example:

```java
@Test(description = "AUTH-001 | TC-LOGIN-001 | Successful login with valid credentials")
public void validLoginTest() { ... }
```

This creates a direct traceable link:

```
spec.md (AUTH-001)
    -> login-test-matrix.md (TC-LOGIN-001)
        -> LoginTest.java (validLoginTest)
```

---

## Automation Scope Classification

| Scenario Type | Recommended Layer |
|---|---|
| Critical user journey (UI visible) | Selenium UI test |
| Business rule validation | API / service test |
| Data integrity check | DB / API test |
| Error message display | Selenium UI test |
| Audit log creation | API / non-UI test |
| Performance measurement | Non-Selenium |
| Exploratory behavior | Manual test |

---

## Team Usage

- **Product / BA**: writes feature brief
- **QA Lead**: runs `/speckit.specify` to create structured spec
- **QA Lead**: creates testcase matrix from acceptance criteria
- **Automation Engineer**: implements Selenium tests for UI candidates
- **All**: use Spec ID for traceability in code comments and test descriptions
