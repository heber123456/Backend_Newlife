package com.unab.apinewlife.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apinewlife.models.peticiones.CitaCrearRequestModel;
import com.unab.apinewlife.models.respuestas.CitaDataRestModel;
import com.unab.apinewlife.services.ICitaService;
import com.unab.apinewlife.shared.CitaDto;

@RestController
@RequestMapping("/cita")
public class CItaController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ICitaService iCitaService;

    @GetMapping
    public CitaDataRestModel leerCita(){

        String codigo="1258";

        CitaDto citaDto= iCitaService.leerCita(codigo);
        CitaDataRestModel citaDataRestModel= modelMapper.map(citaDto, CitaDataRestModel.class);
        return citaDataRestModel;
    }
    
    @PostMapping
    public CitaDataRestModel CrearCita(@RequestBody CitaCrearRequestModel citaCrearRequestModel) {
        CitaDto citaCrearDto= modelMapper.map(citaCrearRequestModel, CitaDto.class);
        CitaDto citaDto= iCitaService.crearCita(citaCrearDto);
        CitaDataRestModel citaDataRestModel= modelMapper.map(citaDto, CitaDataRestModel.class);
        
        return citaDataRestModel;
    }

}
