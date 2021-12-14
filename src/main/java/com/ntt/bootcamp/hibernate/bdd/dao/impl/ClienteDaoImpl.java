package com.ntt.bootcamp.hibernate.bdd.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ntt.bootcamp.hibernate.bdd.Cliente;
import com.ntt.bootcamp.hibernate.bdd.dao.ClienteDao;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insert(Cliente cliente) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(cliente);
		
		currentSession.close();
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		currentSession.update(cliente);
		
		currentSession.close();
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		List<Cliente> listaclientes = null;
		//Insertar en bdd
		 listaclientes = currentSession.createQuery("FROM Cliente").list();
		
		//Cerrar la bdd
		currentSession.close();
		
		return listaclientes;

		
	}
	
	
	@Override
	@Transactional
	public List<Cliente> findByNameYApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		List<Cliente> listaclientes = null;
		//Insertar en bdd
		 listaclientes = currentSession.createQuery("FROM Cliente c WHERE nombre =  '"+nombre+"'  AND primer_apellido = '"+apellido+"' ").list();
		
		//Cerrar la bdd
		currentSession.close();
		
		return listaclientes;

		
	}

	@Override
	@Transactional
	public Cliente searchById(Long id) {
		// TODO Auto-generated method stub
		
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Insertar en bdd
		Cliente cliente = currentSession.find(Cliente.class, id);
		
		//Cerrar la bdd
		currentSession.close();
		
		return cliente;
	}

	@Override
	@Transactional
	public void deleteById(Cliente cliente) {
		// TODO Auto-generated method stub
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.remove(currentSession.contains(cliente) ? cliente : currentSession.merge(cliente));
		
		//Cerrar la bdd
		currentSession.close();
		
		
	}


}
