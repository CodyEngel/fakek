import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.70"
    id("io.gitlab.arturbosch.detekt").version("1.6.0")
    id("org.jetbrains.dokka").version("0.10.1")
}

group = "dev.engel.fakek"
version = "0.1-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.javafaker:javafaker:1.0.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    testImplementation("io.mockk:mockk:1.9")
    testImplementation("io.strikt:strikt-core:0.24.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTask> {
    outputFormat = "html"
    outputDirectory = "build/output/documentation"
}

detekt {
    input = files("src/main/kotlin")
    parallel = false
    config = files("detekt/config.yml")
    buildUponDefaultConfig = false
    baseline = file("detekt/baseline.xml")
    disableDefaultRuleSets = false
    debug = false
    ignoreFailures = false
    reports {
        xml {
            enabled = true
            destination = file("build/reports/detekt/detekt.xml")
        }
        html {
            enabled = true
            destination = file("build/reports/detekt/detekt.html")
        }
        txt {
            enabled = true
            destination = file("build/reports/detekt/detekt.txt")
        }
    }
}