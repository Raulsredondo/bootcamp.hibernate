package com.ntt.bootcamp.hibernate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.bootcamp.hibernate.bdd.Cliente;
import com.ntt.bootcamp.hibernate.bdd.dao.ClienteDao;
import com.ntt.bootcamp.hibernate.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	@Transactional
	public void insertCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.insert(cliente);
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.update(cliente);
		
	}

	@Override
	@Transactional
	public List<Cliente> findAllCliente() {
		// TODO Auto-generated method stub
		List<Cliente> clientes;
        clientes = clienteDao.findAll();
		return clientes;
	}
	
	@Override
	@Transactional
	public List<Cliente> findByNameYApellido(String nombre, String apellido){
		
		List<Cliente> clientes;
        clientes = clienteDao.findByNameYApellido(nombre, apellido);
		return clientes;
		
	}

	@Override
	@Transactional
	public Cliente searchByIdCliente(Long id) {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		if(null != id) {
			cliente = clienteDao.searchById(id);
		}
		
		return cliente;
	}

	@Override
	@Transactional
	public void deleteByIdCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(cliente);
		
	}
	


}
