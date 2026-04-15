# QA Spec-Driven POC - Java + Selenium + TestNG

> A Proof of Concept for **Spec-Driven Development (SDD)** in QA Automation using **GitHub Spec Kit**, **Java**, **Selenium WebDriver**, and **TestNG**.

---

## Objective

Demonstrate how a **feature specification** becomes:
- Structured acceptance criteria
- A testcase matrix with traceability
- An automation plan with scope classification
- Executable Selenium tests with TestNG

---

## Stack

| Tool | Purpose |
|---|---|
| GitHub Spec Kit | Spec-first workflow - spec, plan, tasks |
| Java 17+ | Automation language |
| Selenium WebDriver 4.x | Browser automation |
| TestNG 7.x | Test runner and suite management |
| Maven | Dependency and build management |

---

## Repository Structure

```
qa-spec-driven-poc-java/
├── README.md
├── .gitignore
├── LICENSE
├── pom.xml
├── testng.xml
├── docs/
│   ├── installation.md
│   ├── setup.md
│   ├── workflow.md
│   ├── testcase-template.md
│   └── selenium-automation-approach.md
├── specs/
│   └── 001-login/
│       ├── spec.md
│       ├── plan.md
│       ├── tasks.md
│       └── quickstart.md
├── examples/
│   └── login-test-matrix.md
└── src/
    └── test/
        └── java/
            └── com/
                └── example/
                    ├── base/
                    │   └── BaseTest.java
                    ├── pages/
                    │   └── LoginPage.java
                    └── tests/
                        └── LoginTest.java
```

---

## Spec-Driven Workflow

```
Spec (spec.md)
    ↓
Plan (plan.md)
    ↓
Tasks (tasks.md)
    ↓
Testcase Matrix (login-test-matrix.md)
    ↓
Automation Scope Classification (UI / API / Manual)
    ↓
Selenium Tests (LoginTest.java)
    ↓
Traceability (Spec ID → Testcase ID → Test Method)
```

---

## Prerequisites

- Git
- Java 17+
- Maven 3.9+
- Python 3.11+ (for Spec Kit)
- uv
- Chrome browser
- IntelliJ IDEA or VS Code

---

## Quick Start

### 1. Clone the repository

```bash
git clone https://github.com/pavankumarh14/qa-spec-driven-poc-java.git
cd qa-spec-driven-poc-java
```

### 2. Install GitHub Spec Kit

```bash
uvx --from git+https://github.com/github/spec-kit.git specify init .
```

### 3. Run the tests

```bash
mvn clean test
```

---

## Spec Kit Commands

| Command | Purpose |
|---|---|
| `/speckit.specify` | Create or refine a feature spec |
| `/speckit.plan` | Generate a plan from the spec |
| `/speckit.tasks` | Break the plan into actionable tasks |

---

## Example Feature - Login

The POC demonstrates the full SDD flow for a **Login feature**:

| Spec ID | Testcase ID | Scenario | Automation |
|---|---|---|---|
| AUTH-001 | TC-LOGIN-001 | Valid login | Selenium UI |
| AUTH-002 | TC-LOGIN-002 | Invalid password | Selenium UI |
| AUTH-003 | TC-LOGIN-003 | Blank field validation | Selenium UI |
| AUTH-004 | TC-LOGIN-004 | Locked account | API/Manual |

---

## Docs

- [Installation Guide](docs/installation.md)
- [Setup Guide](docs/setup.md)
- [Workflow Guide](docs/workflow.md)
- [Testcase Template](docs/testcase-template.md)
- [Selenium Automation Approach](docs/selenium-automation-approach.md)

---

## Demo App

Tests run against: [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login)

Credentials: `tomsmith` / `SuperSecretPassword!`

---

## License

MIT License - see [LICENSE](LICENSE)
