plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    checkstyle
}

group = "com.greenfox"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {

    implementation ("io.github.cdimascio:dotenv-java:3.0.0")

    implementation("io.github.cdimascio:dotenv-java:3.0.0")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("junit:junit:4.13.1")
    implementation("com.h2database:h2:2.1.212")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
checkstyle {
    toolVersion = "8.40"
    maxWarnings = 0
}

tasks.withType<Test> {
    useJUnitPlatform()
}

