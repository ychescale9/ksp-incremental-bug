plugins {
    id("com.apollographql.apollo3")
    id("com.google.devtools.ksp")
    kotlin("jvm")
}

apollo {
    service("dogService") {
        packageNamesFromFilePaths()
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":annotations"))
    ksp(project(":test-processor"))

    implementation("com.apollographql.apollo3:apollo-runtime")

    testImplementation("junit:junit:4.13.2")
}