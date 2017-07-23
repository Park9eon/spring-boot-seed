import com.google.cloud.tools.gradle.appengine.standard.DevAppServerRunTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        maven { setUrl("https://repo.spring.io/milestone") }
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://maven-central.storage.googleapis.com") }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.BUILD-SNAPSHOT")
        classpath(kotlin("gradle-plugin"))
        classpath(kotlin("allopen"))
        classpath(kotlin("noarg"))
        classpath("com.google.cloud.tools:appengine-gradle-plugin:1.3.2")
    }
}

apply {
    plugin("war")
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("kotlin-jpa")
    plugin("org.springframework.boot")
    plugin("com.google.cloud.tools.appengine")
    plugin("io.spring.dependency-management")
}

plugins {
    kotlin("jvm")
}

version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven { setUrl("https://repo.spring.io/milestone") }
    maven { setUrl("https://repo.spring.io/snapshot") }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    testCompile("org.springframework.boot:spring-boot-starter-test")

    compile("org.springframework.boot:spring-boot-starter-webflux") {
        exclude("org.slf4j", "jul-to-slf4j")
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
    compile("org.springframework.boot:spring-boot-starter-security")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("javax.servlet:javax.servlet-api:3.1.0")
    compile(kotlin("stdlib-jre8"))
    compile(kotlin("reflect"))
    compile("jstl:jstl:1.2")
    compile("com.google.appengine:appengine-api-1.0-sdk:1.9.54")
    compile("mysql:mysql-connector-java")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
}