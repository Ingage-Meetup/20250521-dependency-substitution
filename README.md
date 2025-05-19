# 20250521-dependency-substitution

## Multiplication Flash Card Kata

This exercise introduces **dependency substitution** for better testing practices using **fakes and mocks**. The kata focuses on building a small console-based flash card quiz while practicing **Test-Driven Development (TDD)** and **integration testing**.

---

## Kata Overview

Build a command-line app that quizzes users with multiplication problems.

### Requirements:
- Prompt user: *"How many problems would you like to solve?"*
- For each problem:
  - Generate two random digits (0–9)
  - Ask the user: `What is X * Y?`
  - Track whether the answer was correct or incorrect
- At the end, display: `You got 7 out of 10 correct!`

---

## What You’ll Practice

- TDD (Test-Driven Development)
- Integration testing
- Creating abstractions for testability
- Mocking or faking:
  - Random number generation
  - Input/output
- Designing your code to substitute dependencies cleanly

---

## Questions to Consider

- How do you test something random?
- How can you simulate a user in your tests?
- Should you fake input/output or test the console directly?

---

## Why This Matters

Real-world systems often rely on unpredictable inputs: time, randomness, users. By learning to **substitute dependencies**, you make your code more **testable**, **predictable**, and **robust**—without relying on heavyweight frameworks.

---

## Ready to fake it 'til you test it?


## Repo Layout

This repo supports multiple programming languages. Choose the one you're comfortable with.

### Language Templates
You'll find starter projects inside the `/Templates` directory. Each template includes:
- A sample project structure
- Unit test setup (runnable out of the box)
- Interface abstractions you can modify to introduce mocks or fakes

Open your chosen language directory in your favorite IDE and start coding.

---

## Recommended IDEs

You may use any IDE you're comfortable with. These are suggested for convenience:

- [C#](Templates/C%23) – [Visual Studio](https://visualstudio.microsoft.com/vs/community/)
- [Java](Templates/Java) – [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
- [JavaScript](Templates/JavaScript) – [Visual Studio Code](https://code.visualstudio.com/)
- [Kotlin](Templates/Kotlin) – [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
- [Python](Templates/Python) – [PyCharm](https://www.jetbrains.com/pycharm/)

---

## Duplicating This Repository

To create a personal copy of this repo with full history:

1. Create a new GitHub repo (e.g., `MyFlashCardKata`)
2. Open a terminal and clone this repo as a bare copy:

    ```bash
    git clone --bare https://github.com/Ingage-Meetup/20250521-dependency-substitution.git
    ```

3. Push the mirrored content to your new repo:

    ```bash
    cd 20250521-dependency-substitution.git
    git push --mirror https://github.com/your-user/MyFlashCardKata.git
    ```

4. Clean up:

    ```bash
    cd ..
    rm -rf 20250521-dependency-substitution.git
    ```