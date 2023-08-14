package com.trading.trading_up_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trading.trading_up_backend.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{}
