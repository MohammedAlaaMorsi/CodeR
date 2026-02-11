# Smart Code Reviewer: Idea and Approach Summary

The **Smart Code Reviewer** acts as an automated pair programmer, designed to perform a preliminary review of code before it reaches human eyes. Leveraging the advanced capabilities of Large Language Models (LLMs) like GPT-4o, the agent analyzes code for patterns, best practices, and potential issues that static analysis tools might miss.

**Key capabilities include:**
*   **Readability Analysis**: Evaluates variable naming, code clarity, and ease of understanding.
*   **Structural Review**: Checks for code organization, function size, and class responsibilities.
*   **Maintainability Assessment**: Identifies potential technical debt and areas that might be hard to modify in the future.


This approach reduces cognitive load on human reviewers by catching common issues early, ensuring a higher baseline of code quality and allowing developers to focus on more complex logic and architectural decisions.


**Repository:**
[https://github.com/MohammedAlaaMorsi/CodeR](https://github.com/MohammedAlaaMorsi/CodeR)

## How to Run
To run the Smart Code Reviewer on the provided sample code:

1.  **Set your OpenAI API Key:**
    ```bash
    export OPEN_AI_API_TEST_KEY=your_key_here
    ```

2.  **Run the Reviewer:**
    ```bash
    ./gradlew -p examples/smart-code-reviewer run --args="/home/mohammed/AndroidStudioProjects/CodeR/examples/smart-code-reviewer/sample/BadCode.kt"
    ```
