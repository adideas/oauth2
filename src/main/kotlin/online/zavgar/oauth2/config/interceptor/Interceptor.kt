package online.zavgar.oauth2.config.interceptor

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import online.zavgar.oauth2.config.interceptor.data.Head
import online.zavgar.oauth2.config.interceptor.data.Payload
import online.zavgar.oauth2.config.interceptor.data.Token
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *
 */
class Interceptor : HandlerInterceptor {

    val mapper = jacksonObjectMapper()

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val authorization: Array<String> = getAuthorization(request);
        val type: String = authorization[0]

        if (type == "Bearer") {
            val token: Token = getToken(authorization)
            if (token.check()) {
                return super.preHandle(request, response, handler)
            }
        }

        response.status = 401
        return false
    }

    fun getAuthorization(request: HttpServletRequest): Array<String> = request
        .getHeader("Authorization").split(" ").toTypedArray()

    fun decode(string: String): String = String(Base64.getDecoder().decode(string))

    fun getToken(authorization: Array<String>): Token {
        val token = authorization[1].split(".").toTypedArray()
        //
        return Token(
            mapper.readValue(decode(token[0]), Head::class.java),
            mapper.readValue(decode(token[1]), Payload::class.java),
            token[0] + "." + token[1], token[2]
        )
    }
}