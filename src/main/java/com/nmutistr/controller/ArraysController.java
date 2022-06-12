package com.nmutistr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmutistr.model.Arrays;
import com.nmutistr.service.IArraysService;
import com.nmutistr.util.Constants;

/**
 * Clase Controller
 * @author nicolas
 *
 */
@RestController
@RequestMapping(Constants.API_VERSION + Constants.ARRAY)
public class ArraysController {
	
	/**
	 * Invocacion de la interfaz Service a traves de la inyeccion de dependencias
	 */
	@Autowired
	private IArraysService arraysService;
	
	/**
	 * Metodo encargado de recibir la peticion REST GET y retornar la solucion del arreglo especificado en los parametros
	 * @param Q
	 * @param idArray
	 * @return
	 * @throws Exception
	 */
	@GetMapping(Constants.GET_ARRAY + Constants.Q + Constants.ID_ARRAY)
	public ResponseEntity<String> getArrays(@PathVariable("Q") Integer Q, @PathVariable("idArray") Integer idArray) throws Exception {
		String obj = arraysService.getArrays(Q, idArray);
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
}
