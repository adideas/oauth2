package online.zavgar.oauth2.config.interceptor.data

import online.zavgar.oauth2.helper.jwt.JWTBuilder
import java.lang.System.currentTimeMillis


class Token(val head: Head, val payload: Payload, val string: String, val sign: String) {

    // TODO logic token check
    fun check(): Boolean {

        // val now = currentTimeMillis() / 1000L;

        if (head.fake == true) {
            //return false
        }

        if (payload.dom == "localhost") {
            //return false
        }

        if (payload.jti == "none") {
            //return false
        }

        /*if (payload.exp < now) {
            //return false
        }

        if (payload.exp < payload.nbf || payload.exp < payload.iat) {
            //return false
        }*/

        // eyJmYWtlIjp0cnVlLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJub25lIiwiZG9tIjoibG9jYWxob3N0IiwidHlwZSI6InNlcnZlciIsImF1ZiI6WyJhcHAiXSwiZ3N0IjpbImFwcCJdLCJuYmYiOjE2Mjg2MjExNDksImlhdCI6MTYyODYyMTE0OSwiZXhwIjoxNjI4NzA3NTQ5LCJzdWIiOiJhcHAuemF2Z2FyLm9ubGluZSJ9.Avbg-48smkyCM7Wpg3wWAIs64EhbkF5-bJZf9ezB9AD8eDRcpE9O2V9FKsgmOntvA2gJDA34sxxtwowtNbH8Zw
        return JWTBuilder.HS512().check(string, sign, JWTBuilder.Random().key())
    }
}