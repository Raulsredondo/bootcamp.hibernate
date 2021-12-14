package com.ntt.bootcamp.hibernate.service;

import java.util.List;



import com.ntt.bootcamp.hibernate.bdd.Cliente;


public interface ClienteService {
	
	/**
	 * Método que inserta un nuevo cliente
	 * @param cliente nuevo cliente a guardar
	 */
	public void insertCliente(Cliente cliente);
	
	/**
	 * Método que modifica un  cliente
	 * @param cliente modificado cliente a guardar
	 */
	public void updateCliente(Cliente cliente);
	
	/**
	 * Método que devuelve una lista con todos los clientes
	 * @param Lista de todos los clientes
	 */
	public List<Cliente> findAllCliente();
	
	/**
	 * Método que busca un cliente por el id
	 * @param cliente encontrado
	 */
	public Cliente searchByIdCliente(Long id);

	/**
	 * Método que elimina un cliente
	 * @param cliente eliminado
	 */
	public void deleteByIdCliente(Cliente cliente);

	List<Cliente> findByNameYApellido(String nombre, String apellido);

}
