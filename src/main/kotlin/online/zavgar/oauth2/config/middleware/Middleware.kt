package online.zavgar.oauth2.config.middleware

import online.zavgar.oauth2.config.interceptor.Interceptor
import org.springframework.web.servlet.HandlerInterceptor

class Middleware() {
    data class Item (val interceptor: HandlerInterceptor, val pattern: String)

    // Only register Interceptor
    fun register():Array<Item> {
        return arrayOf(
            Item(Interceptor(), "/api/**")
        );
    }
}
