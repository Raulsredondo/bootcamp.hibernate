package com.ntt.bootcamp.hibernate.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.bootcamp.hibernate.bdd.Player;
import com.ntt.bootcamp.hibernate.bdd.dao.PlayerDao;
import com.ntt.bootcamp.hibernate.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;
	
	@Override
	@Transactional
	public void insertNewPlayer(Player player) {
		// TODO Auto-generated method stub
		playerDao.insert(player);
	}

	@Override
	@Transactional
	public Player searchById(Long id) {
		Player player = null;
		if(null != id) {
			player = playerDao.searchById(id);	
		}
		return player;
	}

}
