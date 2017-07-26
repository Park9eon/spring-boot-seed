package com.park9eon.boot.domain

import java.util.*
import javax.persistence.PrePersist
import javax.persistence.PreUpdate
import javax.persistence.Temporal
import javax.persistence.TemporalType

interface TimestampEntity {
    @get:Temporal(TemporalType.TIMESTAMP)
    var updateDate: Date?
    @get:Temporal(TemporalType.TIMESTAMP)
    var createDate: Date?
    @PrePersist
    fun onCreate() {
        createDate = Date()
        updateDate = createDate
    }
    @PreUpdate
    fun onUpdate() {
        updateDate = Date()
    }
}