package com.harbourspace.cloudcomputing.coffeeshop.services

import com.harbourspace.cloudcomputing.coffeeshop.entities.HistoryEntity
import com.harbourspace.cloudcomputing.coffeeshop.repositories.BaristaRepository
import com.harbourspace.cloudcomputing.coffeeshop.repositories.HistoryRepository
import com.harbourspace.cloudcomputing.dtos.Votes
import jakarta.transaction.Transactional
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service


@Service
class BaristaService(val baristaRepository: BaristaRepository, val historyRepository: HistoryRepository) {

    /**
     * Method for adding votes to Barista.
     *
     * @param votes DTO with information about votes to be added.
     */
    @Transactional
    @Retryable(maxAttempts = 10)
    fun addVotesToBarista(votes: Votes) {
        val baristaEntity = baristaRepository.findByLastName(votes.lastName)
        if (baristaEntity == null) {
            saveMessageToHistory(votes, "ORPHANED")
        } else {
            baristaEntity.votes = (baristaEntity.votes + votes.votes)
            baristaRepository.save(baristaEntity)

            saveMessageToHistory(votes, "RECEIVED")
        }
    }

    private fun saveMessageToHistory(votes: Votes, status: String) {
        try {
            historyRepository.save(
                HistoryEntity(
                    lastName = votes.lastName,
                    votes = votes.votes,
                    status = status
                )
            )
        } catch (ex: RuntimeException) {
            // do nothing
        }
    }
}
