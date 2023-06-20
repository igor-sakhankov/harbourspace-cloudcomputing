package com.harbourspace.cloudcomputing.coffeeshop.services

import com.harbourspace.cloudcomputing.coffeeshop.entities.HistoryEntity
import com.harbourspace.cloudcomputing.coffeeshop.repositories.HistoryRepository
import com.harbourspace.cloudcomputing.coffeeshop.dtos.Votes
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class HistoryService(val historyRepository: HistoryRepository) {
    /**
     * Method for saving message to history.
     *
     * @param votes DTO with information about votes to be added.
     */
    @Synchronized
    fun saveMessageToHistory(votes: Votes, status: String) {
        historyRepository.save<HistoryEntity>(
            HistoryEntity(
                lastName = votes.lastName,
                votes = votes.votes,
                status = status
            )
        )
    }
}