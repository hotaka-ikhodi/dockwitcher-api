package com.hotakakademy.dockwitcher.controllers

import com.hotakakademy.dockwitcher.contracts.ConductorDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import com.hotakakademy.dockwitcher.domain.services.IConductorService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class ConductoresController (
        private val repository: IConductorRepository,
        private val conductorService: IConductorService
)

{
    @GetMapping("/conductores")

    fun lista(@RequestParam(defaultValue = "0") page: Int,
                @RequestParam(defaultValue = "10") size: Int,
                @RequestParam(defaultValue = "date") sort: String,
                @RequestParam(defaultValue = "desc") direction: String
    ): Page<Conductor>{

        val paging = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sort))
        return repository.findAll(paging)

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