package com.park9eon.boot.repository

import com.park9eon.boot.domain.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by park9eon on 21/07/2017.
 */
@Repository
interface PostRepository: CrudRepository<Post, Long>