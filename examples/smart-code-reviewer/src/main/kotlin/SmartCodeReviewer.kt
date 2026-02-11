package ai.koog.examples.smartcodereviewer

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.singleRunStrategy
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.ext.tool.file.ListDirectoryTool
import ai.koog.agents.ext.tool.file.ReadFileTool
import ai.koog.agents.features.eventHandler.feature.handleEvents
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.rag.base.files.JVMFileSystemProvider
import kotlinx.coroutines.runBlocking

val executor = simpleOpenAIExecutor(System.getenv("OPEN_AI_API_TEST_KEY"))

val agent = AIAgent(
    promptExecutor = executor,
    llmModel = OpenAIModels.Chat.GPT4o,
    toolRegistry = ToolRegistry {
        tool(ListDirectoryTool(JVMFileSystemProvider.ReadOnly))
        tool(ReadFileTool(JVMFileSystemProvider.ReadOnly))
    },
    systemPrompt = """
        You are a Smart Code Reviewer Assistant.
        Your goal is to review code for readability, structure, and maintainability.
        
        When given a file or directory path:
        1. List the files if it's a directory.
        2. Read the content of the relevant code files.
        3. Analyze the code.
        4. Provide a review that includes:
           - **Readability**: Is the code easy to understand? Are variable names descriptive?
           - **Structure**: Is the code well-organized? Are functions and classes of appropriate size?
           - **Maintainability**: Is the code easy to modify? Are there any potential technical debt items?
           - **Suggestions**: Concrete examples of how to improve the code.
           
        Be constructive and specific. If the code is good, say so, but still look for minor improvements.
    """.trimIndent(),
    strategy = singleRunStrategy(),
    maxIterations = 20
) {
    handleEvents {
        onToolCallStarting { ctx ->
            println("Tool '${ctx.toolName}' called with args: ${ctx.toolArgs}")
        }
        onAgentExecutionFailed {
            println("Agent execution failed: ${it.throwable}")
        }
    }
}

fun main(args: Array<String>) = runBlocking {
    if (args.isEmpty()) {
        println("Error: Please provide the project absolute path or file path to review.")
        println("Usage: ./gradlew :examples:smart-code-reviewer:run --args=\"<absolute_path>\"")
        return@runBlocking
    }

    val path = args[0]
    println("Starting Smart Code Review for: \$path")
    
    try {
        val result = agent.run("Please review the code at: \$path")
        println("\n=== Code Review Result ===\n")
        println(result)
    } finally {
        executor.close()
    }
}
