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
}

plugins {
    kotlin("jvm")
}

version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.slf4j", "jul-to-slf4j")
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    compile("javax.servlet:javax.servlet-api:3.1.0")
    testCompile("org.springframework.boot:spring-boot-starter-test")

    compile(kotlin("stdlib-jre8"))
    compile(kotlin("reflect"))
    compile("jstl:jstl:1.2")
    compile("com.google.appengine:appengine-api-1.0-sdk:1.9.54")

    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("mysql:mysql-connector-java")
}