import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    kotlin("plugin.jpa") version "1.5.31"
    jacoco
    java
}

jacoco {
    toolVersion = "0.8.7"
}

repositories {
    mavenCentral()
    mavenLocal()
}

subprojects {
    group = "br.com.finances"
    version = "1.0-SNAPSHOT"

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.31")

        //Spring framework
        implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.12.RELEASE")
        implementation("org.apache.commons:commons-lang3:3.12.0")

        //Swagger
        compileOnly("io.springfox:springfox-swagger2:2.9.2")
        compileOnly("io.springfox:springfox-swagger-ui:2.9.2")

        //Logback
        implementation("ch.qos.logback:logback-core:1.2.3")
        implementation("ch.qos.logback.contrib:logback-json-classic:0.1.5")
        implementation("ch.qos.logback.contrib:logback-jackson:0.1.5")

        compileOnly(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = "2.10.3")

        //Test
        testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
        testImplementation("io.mockk:mockk:1.9.3")
    }

    sourceSets.main{
        java.srcDirs("src/main/kotlin")
    }
    java.sourceCompatibility = JavaVersion.VERSION_1_8

    tasks.test {
        useJUnit()
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "1.8"
    }
}


