package com.park9eon.boot.repository

import com.park9eon.boot.domain.PostComment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: CrudRepository<PostComment, Long>
