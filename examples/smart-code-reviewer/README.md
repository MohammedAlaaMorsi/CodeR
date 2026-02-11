# Smart Code Reviewer

An AI-powered assistant that reviews code for readability, structure, and maintainability.

## Overview
This example demonstrates how to build a specialized agent using the Koog framework. The Smart Code Reviewer:
1.  Takes a file or directory path as input.
2.  Uses tools to explore and read the code.
3.  Analyzes the code using a Large Language Model (GPT-4o).
4.  Provides a structured review focusing on key quality metrics.


## Quick Start

Run the following commands in your terminal to review the provided sample code:

```bash
export OPEN_AI_API_TEST_KEY=your_key_here
./gradlew -p examples/smart-code-reviewer run --args="/home/mohammed/AndroidStudioProjects/CodeR/examples/smart-code-reviewer/sample/BadCode.kt"
```

## How to Run on Your Code

1.  Set your OpenAI API key (if not already set):
    ```bash
    export OPEN_AI_API_TEST_KEY=your_key_here
    ```

2.  Run the reviewer on your own file or directory:
    ```bash
    ./gradlew -p examples/smart-code-reviewer run --args="/absolute/path/to/your/code"
    ```

## Idea Summary
The "Smart Code Reviewer" acts as an automated pair programmer, performing a first-pass review before human eyes see the code. By leveraging LLMs' understanding of code patterns and best practices, it identifies readability issues, structural flaws, and maintainability concerns. This tool reduces the cognitive load on human reviewers and ensures a baseline of code quality, catching common issues early in the development cycle.
