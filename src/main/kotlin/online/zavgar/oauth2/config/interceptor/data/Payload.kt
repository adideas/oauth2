package online.zavgar.oauth2.config.interceptor.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Payload(
    @JsonProperty("jti") val jti: String?,
    @JsonProperty("dom") val dom: String?,
    @JsonProperty("type") val type: String? = "",
    @JsonProperty("auf") val auf: Array<String>?,
    @JsonProperty("gst") val gst: Array<String>?,
    @JsonProperty("nbf") val nbf: Number?,
    @JsonProperty("iat") val iat: Number?,
    @JsonProperty("exp") val exp: Number?,
    @JsonProperty("sub") val sub: String? = ""
)