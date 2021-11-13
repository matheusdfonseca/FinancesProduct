dependencies {
    implementation("org.postgresql:postgresql:42.2.6")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.4.RELEASE")
    implementation("com.vladmihalcea:hibernate-types-52:2.12.0")
    implementation(project(":output-boundary"))
}