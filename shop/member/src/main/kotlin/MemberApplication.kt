package shop.member.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
class MemberApplication

fun main(args: Array<String>) {
    runApplication<MemberApplication>(*args)
}
