package com.park9eon.boot.domain

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by park9eon on 21/07/2017.
 */
@Entity
class Post(
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       var id: Long? = null,

       @Length(max = 250)
       @NotEmpty()
       var content: String? = null,

       @NotNull
       @ManyToOne(cascade = arrayOf(CascadeType.ALL))
       @JoinColumn(name = "user_id", referencedColumnName = "id")
       var user: User? = null
)

@OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER, orphanRemoval = true)
private fun User.getPosts(): Iterable<Post>? = null