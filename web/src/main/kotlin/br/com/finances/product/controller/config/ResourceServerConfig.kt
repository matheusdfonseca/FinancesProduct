package br.com.finances.product.controller.config
/*
//@EnableWebSecurity
class ResourceServerConfig : WebSecurityConfigurerAdapter() {

    val whitelist = arrayOf(
        "/v2/api-docs",
        "/configuration/ui",
        "/swagger-resources/**",
        "/configuration/security",
        "/swagger-ui.html",
        "/v1/**",
        "/v0/**",
        "/webjars/**",
        "/actuator/**",
        "/v3/api-docs/**",
        "/swagger-ui/**"
    )

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers(*whitelist).permitAll()
            .mvcMatchers("/**")
            .hasAuthority("SCOPE_banking/caas.full")
            .anyRequest()
            .authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt()
    }
}*/