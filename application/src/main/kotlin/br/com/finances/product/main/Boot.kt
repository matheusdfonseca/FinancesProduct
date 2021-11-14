package br.com.finances.product.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import java.util.TimeZone

@SpringBootApplication
@ComponentScan("br.com.finances.product")
class Boot {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"))
            runApplication<Boot>(*args)
        }
    }
}
