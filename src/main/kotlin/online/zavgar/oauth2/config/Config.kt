package online.zavgar.oauth2.config

import online.zavgar.oauth2.config.interceptor.Interceptor
import online.zavgar.oauth2.config.middleware.Middleware
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class Config : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {

        // autoload Middleware
        Middleware().register().forEach {
            registry.addInterceptor(it.interceptor).addPathPatterns(it.pattern)
        }

    }
}