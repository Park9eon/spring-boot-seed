import com.google.cloud.tools.gradle.appengine.core.AppEngineCorePlugin

buildscript {
    repositories {
        maven {
            url = uri("https://maven-central.storage.googleapis.com")
        }
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.4.RELEASE")
        classpath(kotlin("gradle-plugin"))
        classpath(kotlin("allopen"))
        classpath("com.google.cloud.tools:appengine-gradle-plugin:1.3.2")
    }
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
    plugin("com.google.cloud.tools.appengine")
}

version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    "compile"("org.springframework.boot:spring-boot-starter-web")
    "testCompile"("org.springframework.boot:spring-boot-starter-test")

    "compile"(kotlin("stdlib"))
    "compile"(kotlin("reflect"))

    "compile"("com.google.appengine:appengine:+")
}