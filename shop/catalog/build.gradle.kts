extra["springCloudVersion"] = "2021.0.1"

plugins {
    kotlin("plugin.serialization") version "1.6.21"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    /* h2 */
    runtimeOnly("com.h2database:h2:1.3.176")
    implementation("org.modelmapper:modelmapper:3.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}