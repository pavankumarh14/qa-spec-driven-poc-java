# Installation Guide

## Prerequisites

Install the following tools before setting up the project:

| Tool | Version | Purpose |
|---|---|---|
| Git | Latest | Version control |
| Java JDK | 17+ | Automation language |
| Maven | 3.9+ | Build and dependency management |
| Python | 3.11+ | Required for GitHub Spec Kit |
| uv | Latest | Python package manager for Spec Kit |
| Chrome | Latest | Browser for Selenium tests |
| IntelliJ IDEA / VS Code | Latest | IDE |

---

## Step 1 - Install uv

### macOS / Linux

```bash
curl -LsSf https://astral.sh/uv/install.sh | sh
```

### Windows (PowerShell)

```powershell
powershell -ExecutionPolicy ByPass -c "irm https://astral.sh/uv/install.ps1 | iex"
```

Verify:

```bash
uv --version
```

---

## Step 2 - Clone the repository

```bash
git clone https://github.com/pavankumarh14/qa-spec-driven-poc-java.git
cd qa-spec-driven-poc-java
```

---

## Step 3 - Install GitHub Spec Kit

```bash
uvx --from git+https://github.com/github/spec-kit.git specify init .
```

Optional - specify shell type:

```bash
# For bash/zsh
uvx --from git+https://github.com/github/spec-kit.git specify init . --script sh

# For PowerShell
uvx --from git+https://github.com/github/spec-kit.git specify init . --script ps
```

This creates the Spec Kit project structure including `.specify/` folder and workflow artifacts.

---

## Step 4 - Verify Java and Maven

```bash
java -version
# Expected: java version "17.x.x" or higher

mvn -version
# Expected: Apache Maven 3.9.x
```

---

## Step 5 - Install Maven dependencies

```bash
mvn clean install -DskipTests
```

This downloads:
- Selenium WebDriver 4.x
- TestNG 7.x
- Maven Surefire Plugin

---

## Step 6 - Run the test suite

```bash
mvn clean test
```

This will:
- Launch Chrome browser
- Execute all login tests
- Generate TestNG report in `target/surefire-reports/`

---

## Verify installation

After running tests you should see:

```
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## Troubleshooting

| Issue | Fix |
|---|---|
| ChromeDriver mismatch | Selenium 4.x manages drivers automatically - no manual setup needed |
| Java not found | Check JAVA_HOME environment variable |
| Maven not found | Check M2_HOME and PATH |
| uv not found | Re-run the uv install script and restart terminal |
| Tests fail on demo app | Check https://the-internet.herokuapp.com/login is accessible |
