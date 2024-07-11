package com.hotakakademy.dockwitcher.controllers

import com.hotakakademy.dockwitcher.contracts.ConductorDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.factories.IConductorFactory
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import com.hotakakademy.dockwitcher.domain.services.ConductorService
import com.hotakakademy.dockwitcher.domain.services.IConductorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
class ConductoresController (
        private val repository: IConductorRepository,
        private val conductorService: IConductorService
) {
    @GetMapping("/conductores")
    fun listado(): List<Conductor>{
        return repository.findAll()
    }

    @GetMapping("/conductores/nuevo")
    fun nuevo(model: Model
    ): String {
        return "nuevoconductor"
    }

    @PostMapping("/conductores/nuevo")
    fun create(@ModelAttribute conductorDto: ConductorDto
    ): String {
        conductorService.create(conductorDto)
        return "listadoconductores"
    }

}