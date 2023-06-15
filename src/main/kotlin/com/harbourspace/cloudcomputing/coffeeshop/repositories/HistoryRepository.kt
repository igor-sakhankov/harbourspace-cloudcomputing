package com.harbourspace.cloudcomputing.coffeeshop.repositories

import com.harbourspace.cloudcomputing.coffeeshop.entities.HistoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HistoryRepository : JpaRepository<HistoryEntity, Long>