package com.ntt.bootcamp.hibernate.bdd.dao;

import java.util.List;

import com.ntt.bootcamp.hibernate.bdd.Cliente;

public interface ClienteDao {
	
	public void insert(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public List<Cliente> findAll();
	
	public Cliente searchById(Long id);

	public void deleteById(Cliente cliente);

	public List<Cliente> findByNameYApellido(String nombre, String apellido);

}
