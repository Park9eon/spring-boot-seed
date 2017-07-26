package com.park9eon.boot.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
class PostCategory(

        @Id
        var name: String? = null,
        @NotNull // 디스플레이 내임? 요런 느낌?으로다가
        var _name: String? = null

) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other?.javaClass != javaClass) return false

                other as PostCategory

                if (name != other.name) return false

                return true
        }

        override fun hashCode(): Int {
                return name?.hashCode() ?: 0
        }

        override fun toString(): String {
                return "PostCategory(name=$name, _name=$_name)"
        }


}