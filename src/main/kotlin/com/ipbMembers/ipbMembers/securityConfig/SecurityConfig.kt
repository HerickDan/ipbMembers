package com.ipbMembers.ipbMembers.securityConfig

import com.ipbMembers.ipbMembers.api.representation.repository.IMemberRepository
import com.ipbMembers.ipbMembers.api.representation.repository.IRoleRepository
import com.ipbMembers.ipbMembers.securityConfig.authentication.AuthFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig {

    @Bean
    fun userDetailsService(
        userRepository: IMemberRepository,
        roleRepository: IRoleRepository
    ): UserDetailsService {
        return CustomUserDetails(userRepository, roleRepository)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authProvider(
        userRepository: IMemberRepository,
        roleRepository: IRoleRepository
    ): AuthenticationProvider {
        return DaoAuthenticationProvider().also {
            it.setUserDetailsService(userDetailsService(userRepository, roleRepository))
            it.setPasswordEncoder(passwordEncoder())
        }
    }

    @Bean
    fun authManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }

    @Bean
    fun securityFilter(
        http: HttpSecurity,
        jwtFilter: AuthFilter,
        authProvider: AuthenticationProvider
    ): SecurityFilterChain {
        http.csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/auth/login", "/auth/refresh").permitAll() // libera login
                it.anyRequest().fullyAuthenticated() // resto precisa de token
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authenticationProvider(authProvider)
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

}