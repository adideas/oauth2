package online.zavgar.oauth2.helper.jwt

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator
import io.jsonwebtoken.impl.crypto.DefaultJwtSigner
import javax.crypto.spec.SecretKeySpec



class JWTBuilder {

    interface TypeClass {
        fun check(string: String, sign: String, key: ByteArray): Boolean
        fun encode(string: String, key: ByteArray): String
    }

    class RS256 : TypeClass {

        override fun check(string: String, sign: String, key: ByteArray): Boolean = DefaultJwtSignatureValidator(
            SignatureAlgorithm.RS256,
            SecretKeySpec(key, SignatureAlgorithm.RS256.jcaName)
        ).isValid(string, sign)

        override fun encode(string: String, key: ByteArray): String =
            DefaultJwtSigner(SignatureAlgorithm.RS256, SecretKeySpec(key, SignatureAlgorithm.RS256.jcaName)).sign(string)

    }

    class RS512 : TypeClass {

        override fun check(string: String, sign: String, key: ByteArray): Boolean = DefaultJwtSignatureValidator(
            SignatureAlgorithm.RS512,
            SecretKeySpec(key, SignatureAlgorithm.RS512.jcaName)
        ).isValid(string, sign)

        override fun encode(string: String, key: ByteArray): String =
            DefaultJwtSigner(SignatureAlgorithm.RS512, SecretKeySpec(key, SignatureAlgorithm.RS512.jcaName)).sign(string)

    }

    class HS256 : TypeClass {

        override fun check(string: String, sign: String, key: ByteArray): Boolean = DefaultJwtSignatureValidator(
            SignatureAlgorithm.HS256,
            SecretKeySpec(key, SignatureAlgorithm.HS256.jcaName)
        ).isValid(string, sign)

        override fun encode(string: String, key: ByteArray): String =
            DefaultJwtSigner(SignatureAlgorithm.HS256, SecretKeySpec(key, SignatureAlgorithm.HS256.jcaName)).sign(string)

    }

    class HS512 : TypeClass {

        override fun check(string: String, sign: String, key: ByteArray): Boolean = DefaultJwtSignatureValidator(
            SignatureAlgorithm.HS512,
            SecretKeySpec(key, SignatureAlgorithm.HS512.jcaName)
        ).isValid(string, sign)

        override fun encode(string: String, key: ByteArray): String =
            DefaultJwtSigner(SignatureAlgorithm.HS512, SecretKeySpec(key, SignatureAlgorithm.HS512.jcaName)).sign(string)

    }

    class Random {
        fun key(): ByteArray {
            fun byteArrayOfInts(vararg ints: Int) = ByteArray(ints.size) { pos -> ints[pos].toByte() }
            return byteArrayOfInts(0xA1, 0x2E, 0x38, 0xD4, 0x89, 0xC3)
        }
    }

}