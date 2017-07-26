package com.park9eon.boot.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class PostComment(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false, columnDefinition = "TEXT")
        var message: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_id", referencedColumnName = "id")
        var post: Post? = null

): TimestampEntity {

        override
        var createDate: Date? = null

        override
        var updateDate: Date? = null

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other?.javaClass != javaClass) return false

                other as PostComment

                if (id != other.id) return false

                return true
        }

        override fun hashCode(): Int {
                return id?.hashCode() ?: 0
        }

        override fun toString(): String {
                return "PostComment(id=$id, message=$message, post=$post, createDate=$createDate, updateDate=$updateDate)"
        }
}