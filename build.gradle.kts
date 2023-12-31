import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.detekt)
    java
    id("my-plugin") apply false
}

dependencies {
    detektPlugins(libs.detektFormatting)
}

detekt {
    source.setFrom(file(projectDir))
    parallel = true
    autoCorrect = true

    tasks.withType<Detekt> {
        exclude("**/resources/**")
        exclude("**/build/**")
        include("**/*.kt")
        include("**/*.kts")
    }
}
