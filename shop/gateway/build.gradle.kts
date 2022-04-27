extra["springCloudVersion"] = "2021.0.1"

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}