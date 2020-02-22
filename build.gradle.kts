plugins {
    java
    kotlin("jvm") version "1.3.50"
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.6.0")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("io.cucumber:cucumber-java8:5.4.0")
    testImplementation("io.cucumber:cucumber-junit:5.4.0")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

application {
    // Define the main class for the application
    mainClassName = "io.github.rstraub.codekatas.App"
}
