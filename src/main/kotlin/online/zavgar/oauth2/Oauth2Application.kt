package online.zavgar.oauth2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Oauth2Application

fun main(args: Array<String>) {
	runApplication<Oauth2Application>(*args)
}