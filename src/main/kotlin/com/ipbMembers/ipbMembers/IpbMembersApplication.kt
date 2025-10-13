package com.ipbMembers.ipbMembers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
@SpringBootApplication
class IpbMembersApplication

fun main(args: Array<String>) {
	runApplication<IpbMembersApplication>(*args)
}
