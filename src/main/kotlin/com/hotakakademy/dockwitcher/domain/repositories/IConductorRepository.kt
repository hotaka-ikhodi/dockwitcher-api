package com.hotakakademy.dockwitcher.domain.repositories

import com.hotakademy.dockwitcher.domain.repositories.IMongoRepository
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface IConductorRepository : IMongoRepository<Conductor> {
    fun findAll(paging: PageRequest): Page<Conductor>
}