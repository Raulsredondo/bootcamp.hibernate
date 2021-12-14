package com.ntt.bootcamp.hibernate.bdd.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import com.ntt.bootcamp.hibernate.bdd.Player;
import com.ntt.bootcamp.hibernate.bdd.dao.PlayerDao;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	/**
	 * Manejador de entidades 
	 */
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insert(Player player) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Insertar en bdd
		currentSession.save(player);
		
		//Cerrar la bdd
		currentSession.close();
	}

	@Override
	@Transactional
	public Player searchById(Long id) {
		//Obtenemos la sesión
				Session currentSession = entityManager.unwrap(Session.class);
				
				//Insertar en bdd
				Player player = currentSession.find(Player.class, id);
				
				//Cerrar la bdd
				currentSession.close();
		
		
		return player;
	}

	
}
