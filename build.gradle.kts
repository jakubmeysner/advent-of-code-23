plugins {
    kotlin("jvm") version "1.9.21"
}

group = "com.jakubmeysner.adventofcode.y23"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
