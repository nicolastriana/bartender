package com.nmutistr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nmutistr.exception.ModelNotFoundException;
import com.nmutistr.model.Arrays;
import com.nmutistr.repo.IArraysRepo;
import com.nmutistr.service.IArraysService;
import com.nmutistr.util.Constants;


/**
 * Clase Service Implement
 * @author nicolas
 *
 */
@Service
public class ArraysServiceImpl implements IArraysService {

	/**
	 * Invocacion de la interfaz Repository a traves de la inyeccion de dependencias
	 */
	@Autowired
	private IArraysRepo arraysRepo;
	
	/**
	 * Metodo para obtener un array segun su id
	 * @param id
	 */
	@Override
	public Arrays getArrayById(Integer id) {
		return arraysRepo.findById(id).orElseThrow(() -> new ModelNotFoundException(
				Constants.ARRAY_NOT_FOUND));
	}

	/**
	 * Metodo encargado de determinar el orden de los vasos segun la lista de numeros primos
	 * @param Q
	 * @param idArray
	 */
	@Override
	public String getArrays(Integer Q, Integer idArray) throws Exception {
		
		try {
			// Se obtiene la lista de numeros primos segun el numero de iteraciones
			List<Integer> P = getPrime(Q);
	        
			// Se obtiene el array de vasos de la base de datos y se guardan en una lista
	        Arrays glass = arraysRepo.getById(idArray);
	        String[] array = glass.getInputArray().split(",");
	        List<String> A = new ArrayList<>();
	        for (int i = 0; i < array.length; i++) {
	            A.add(array[i]);
	        }
	        
	        // Se crean los arreglos donde se van a gestionar los elementos del arreglo A y el de respuesta
	        List<String> A1 = new ArrayList<>();
	        List<String> B = new ArrayList<>();
	        List<String> response = new ArrayList<>();
	        for (int i = 0; i < Q; i++) {
	            for (int j = A.size()-1; j >= 0; j--) {
	            	// Se define si el numero es divisible uniformemente por el numero primo, para que asi sea, el resto debe der igual a 0
	            	// si es asi, se agrega el numero al arreglo B y se elimina del arreglo A, de no ser asi, se agrega el numero al arreglo
	            	// A1 y se elimina del arreglo A
	                double result = Double.parseDouble(A.get(j))/P.get(i);
	                if(result%1 == 0){ // 
	                    B.add(String.valueOf(A.get(j))); 
	                    A.remove(j); 
	                }else{ 
	                    A1.add(String.valueOf(A.get(j))); 
	                    A.remove(j); 
	                }
	            }
	            // Finalizada cada iteracion, los elementos del arreglo A1 pasan al arreglo A y se eliminan de A1, los elementos del arreglo
	            // B pasan al arreglo Respuesta y se eliminan de B.
	            A.addAll(A1); 
	            A1.clear(); 
	            response.addAll(B); 
	            B.clear(); 
	        }
	        response.addAll(A);
	        return response.toString();
		} catch (Exception e) {
			throw new Exception(Constants.ARRAY_NOT_FOUND);
		}
		
	}
	
	/**
	 * Metodo encargado de obtener la lista de numeros primos segun el tamaño de Q
	 * @param Q
	 * @return
	 */
	private List<Integer> getPrime(Integer Q) {
        List<Integer> P = new ArrayList();
        int var = 2;
        while(P.size() < Q){
            if(primeNumber(var)) {
                P.add(var);
            }
            var++;
        }
        return P;
	}
	
	/**
	 * Metodo para validar si un numero es primo
	 * @param num
	 * @return
	 */
	private boolean primeNumber(Integer num) {
        boolean primo = true;
        int var = 2;
        while(primo && var != num){
            if (num % var == 0){
                primo = false;
            }
            var ++;
        }                 
        return primo;
    }	
}
