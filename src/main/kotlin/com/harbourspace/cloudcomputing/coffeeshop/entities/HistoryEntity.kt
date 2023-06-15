package com.harbourspace.cloudcomputing.coffeeshop.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "history")
data class HistoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "lastName")
    val lastName: String,
    val votes: Int,
    @Column(name = "status")
    val status: String,
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    val created: LocalDateTime? = null
)