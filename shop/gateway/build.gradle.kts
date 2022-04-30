extra["springCloudVersion"] = "2021.0.1"

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.11.2")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}