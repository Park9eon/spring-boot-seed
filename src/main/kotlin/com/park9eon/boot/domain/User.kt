package com.park9eon.boot.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name="system-uuid", strategy = "uuid")
        var id: String? = null,

        @get:Email
        @get:Length(max = 50)
        @Column(unique = true)
        var username: String? = null,

        @JsonIgnore
        var password: String? = null,

        @get:JsonIgnore
        @set:JsonIgnore
        var authorities: UserRole = UserRole.READER,

        @get:JsonIgnore
        @set:JsonIgnore
        var isEnabled: Boolean = true,

        @get:JsonIgnore
        @set:JsonIgnore
        var isCredentialsExpired: Boolean = false,

        @get:JsonIgnore
        @set:JsonIgnore
        var isAccountExpired: Boolean = false,

        @get:JsonIgnore
        @set:JsonIgnore
        var isAccountLocked: Boolean = false

): TimestampEntity {

    override
    var updateDate: Date? = null

    override
    var createDate: Date? = null

    override fun toString(): String {
        return "User(id=$id, username=$username, password=$password, authorities=$authorities, isEnabled=$isEnabled, isCredentialsExpired=$isCredentialsExpired, isAccountExpired=$isAccountExpired, isAccountLocked=$isAccountLocked, updateDate=$updateDate, createDate=$createDate)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

enum class UserRole {
    ADMIN, USER, READER
}

class UserDetails(private val user: User): UserDetails {

    override
    fun getUsername() = user.id

    override
    fun getPassword() = user.password

    override
    fun getAuthorities() = listOf(GrantedAuthority { user.authorities.name })

    override
    fun isEnabled() = user.isEnabled

    override
    fun isCredentialsNonExpired() = !user.isCredentialsExpired

    override
    fun isAccountNonExpired() = !user.isAccountExpired

    override
    fun isAccountNonLocked() = !user.isAccountLocked

}