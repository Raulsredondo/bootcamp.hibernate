package com.ntt.bootcamp.hibernate.bdd.dao;

import com.ntt.bootcamp.hibernate.bdd.Player;

public interface PlayerDao {

	/*
	 * Método para insertar un nuevo jugador
	 * @param player Nuevo jugador a guardar
	 */
	
	public void insert(Player player);
	
	/*
	 * Método para buscar un jugador por id
	 * @param id del jugador a buscar
	 * @return Jugador encontrado
	 */
	
	public Player searchById(Long id);
	
}
