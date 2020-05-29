import com.jfrog.bintray.gradle.BintrayExtension.PackageConfig
import com.jfrog.bintray.gradle.BintrayExtension.VersionConfig
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.*

plugins {
    kotlin("jvm") version "1.3.70"
    id("io.gitlab.arturbosch.detekt").version("1.6.0")
    id("org.jetbrains.dokka").version("0.10.1")
    id("com.jfrog.bintray").version("1.8.5")
    `maven-publish`
    jacoco
}

group = "dev.fakek"
version = "0.0.1"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    api("com.github.javafaker:javafaker:1.0.2")

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

tasks.withType<DokkaTask> {
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

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        xml.destination = file("build/reports/jacoco/xml/report.xml")
        html.isEnabled = true
        html.destination = file("build/reports/jacoco/html")
        csv.isEnabled = false
    }
}

val codeCoverage by tasks.registering {
    group = "verification"
    description = "Runs unit test suite with coverage."
    dependsOn(":test", ":jacocoTestReport", ":jacocoTestCoverageVerification")

    val jacocoTestReport = tasks.findByName("jacocoTestReport")
    jacocoTestReport?.mustRunAfter(tasks.findByName("test"))
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    classifier = "javadoc"
    from(tasks.dokka)
}

val sourcesJar by tasks.creating(Jar::class) {
    classifier = "sources"
    from(tasks.kotlinSourcesJar)
}

publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
            artifact(sourcesJar)
            artifact(dokkaJar)
        }
    }
    repositories {
        maven {
            url = uri("$buildDir/repository")
        }
    }
}

bintray {
    user = System.getenv("BINTRAY_USER")
    key = System.getenv("BINTRAY_KEY")
    setPublications("default")

    pkg(delegateClosureOf<PackageConfig> {
        repo = "FakeK"
        name = "fakek"
        userOrg = "codyengel"
        websiteUrl = "https://fakek.dev"
        githubRepo = "CodyEngel/fakek"
        vcsUrl = "https://github.com/CodyEngel/fakek.git"
        description = "A faker library for Kotlin."
        desc = description
        setLicenses("Apache-2.0")
        setLabels("kotlin")

        version(delegateClosureOf<VersionConfig> {
            name = System.getenv("CIRCLE_TAG") ?: "0.0.1"
            desc = "Pre-release version of FakeK"
            released = Date().toString()
        })
    })
}