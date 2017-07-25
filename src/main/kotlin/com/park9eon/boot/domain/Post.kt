package com.park9eon.boot.domain

import org.hibernate.validator.constraints.NotEmpty
import java.util.*
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

       @NotEmpty
       @Column(columnDefinition = "TEXT")
       var content: String? = null,

       @NotNull
       @ManyToOne(fetch = FetchType.LAZY)
       @JoinColumn(name = "user_id", referencedColumnName = "id")
       var user: User? = null,

       @Temporal(TemporalType.TIMESTAMP)
       var updateDate: Date? = null,
       @Temporal(TemporalType.TIMESTAMP)
       var createDate: Date? = null
)