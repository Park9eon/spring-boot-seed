package com.park9eon.boot.domain

import org.hibernate.validator.constraints.NotEmpty
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

/**
 * Created by park9eon on 21/07/2017.
 */
@Entity
class Post(

        @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       var id: Long? = null,

        @NotEmpty
       @Column(columnDefinition = "TEXT")
       var content: String? = null,

       @ManyToOne(fetch = FetchType.LAZY)
       @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
       var user: User? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_category_id", referencedColumnName = "name", nullable = false)
        var postCategory: PostCategory? = null

): TimestampEntity {

       @JoinColumn
       @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
       var postComments: Set<PostComment>? = null

       override
       var updateDate: Date? = null

       override
       var createDate: Date? = null

       override fun toString(): String {
              return "Post(id=$id, content=$content, user=$user, postComments=$postComments, updateDate=$updateDate, createDate=$createDate)"
       }

       override fun equals(other: Any?): Boolean {
              if (this === other) return true
              if (other?.javaClass != javaClass) return false

              other as Post

              if (id != other.id) return false

              return true
       }

       override fun hashCode(): Int {
              return id?.hashCode() ?: 0
       }
}