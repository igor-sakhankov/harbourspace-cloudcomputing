package com.harbourspace.cloudcomputing.coffeeshop.repositories

import com.harbourspace.cloudcomputing.coffeeshop.entities.BaristaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BaristaRepository : JpaRepository<BaristaEntity, Long> {
    fun findByLastName(name: String): BaristaEntity?
}

