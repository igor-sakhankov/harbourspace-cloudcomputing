package com.harbourspace.cloudcomputing.coffeeshop.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "baristas")
data class BaristaEntity(
    @Id val id: Long,
    @Column(name = "firstname") val firstName: String,
    @Column(name = "lastname") val lastName: String,
    var votes: Int,
    @CreationTimestamp
    @Column(updatable = false, nullable = false) val created: LocalDateTime,
    @UpdateTimestamp
    @Column(nullable = false) val updated: LocalDateTime
)