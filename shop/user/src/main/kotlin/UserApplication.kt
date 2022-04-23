package shop.user.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class UserApplication

fun main(args: Array<String>) {
    runApplication<UserApplication>(*args)
}
