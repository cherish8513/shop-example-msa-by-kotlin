package shop.member.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class MemberApplication

fun main(args: Array<String>) {
    runApplication<MemberApplication>(*args)
}
