package online.zavgar.oauth2.model

import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
data class Article (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val title: String = "",

    @get: NotBlank
    val content: String = ""
)