package com.trading.trading_up_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.trading.trading_up_backend.model.Inscripccion;

public interface IInscripcionRepository extends JpaRepository<Inscripccion, Integer>{}
