plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.shadow)
    application
}

application.mainClass.set("ai.koog.examples.smartcodereviewer.SmartCodeReviewerKt")

dependencies {
    implementation("ai.koog:koog-agents")
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.logback.classic)
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    archiveBaseName.set("smart-code-reviewer")
    mergeServiceFiles()
}
