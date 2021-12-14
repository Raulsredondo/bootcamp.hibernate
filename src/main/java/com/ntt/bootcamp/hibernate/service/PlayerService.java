package com.ntt.bootcamp.hibernate.service;

import com.ntt.bootcamp.hibernate.bdd.Player;

public interface PlayerService {

	/**
	 * Método que inserta un nuevo jugador
	 * @param player nuevo jugador a guardar
	 */
	public void insertNewPlayer(Player player);
	
	/**
	 * Método que busca un jugador por id
	 * @param id del jugador
	 * @return Jugador encontrado
	 */
	
	public Player searchById(Long id);
}
