package com.park9eon.boot.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

/**
 * Created by park9eon on 21/07/2017.
 */
@Entity
class Post(
        @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       var id: Long? = null,
       @NotNull
       var content: String? = null
)