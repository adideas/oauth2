package online.zavgar.oauth2.config.interceptor.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Head(
    @JsonProperty("fake") val fake: Boolean? = true,
    @JsonProperty("typ") val typ: String? = "JWT",
    @JsonProperty("alg") val alg: String?
)
