import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

application.mainClass.set("com/Franz3/Main.java")
group = "com.Franz3"
version = "1.0-SNAPSHOT"

tasks.withType<ShadowJar> {
    archiveFileName.set("BluetopiaDisordBot.jar")
}
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.dv8tion:JDA:5.0.0-beta.9")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.isIncremental = true
    sourceCompatibility = "1.8"
}