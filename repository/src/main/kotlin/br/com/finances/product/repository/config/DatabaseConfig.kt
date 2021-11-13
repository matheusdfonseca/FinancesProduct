package br.com.finances.product.repository.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "DatabaseProductFactory",
    basePackages = ["br.com.finances.product.repository.interfaces"]
)
class DatabaseConfig {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Value("\${database.username}")
    private val username:String? = null
    @Value("\${database.password}")
    private val password:String? = null
    @Value("\${database.host}")
    private val host:String? = null
    @Value("\${database.dbname}")
    private val dbname:String? = null
    @Value("\${database.port}")
    private val port:String? = null

    @Bean(name = ["DatabaseSource"])
    fun dataSource(): DataSource {


        return DataSourceBuilder.create()
            .url("jdbc:postgresql://${host}:${port}/${dbname}")
            .username(username)
            .password(password)
            .driverClassName("org.postgresql.Driver")
            .build()
    }


    @Bean(name = ["DatabaseProductFactory"])
    fun bankingEntityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("DatabaseSource") dataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {

        return builder.dataSource(dataSource)
            .packages("br.com.finances.product.repository.domain")
            .persistenceUnit("product")
            .build()
    }
}
