package com.nmutistr.service;

import com.nmutistr.model.Arrays;

/**
 * Clase Service
 * @author nicolas
 *
 */
public interface IArraysService {
	
	/**
	 * Metodo para obtener un array segun su id
	 * @param id
	 */
	Arrays getArrayById(Integer id);

	/**
	 * Metodo encargado de determinar el orden de los vasos segun la lista de numeros primos
	 * @param Q
	 * @param idArray
	 */
	String getArrays(Integer Q, Integer idArray) throws Exception;
}
