package com.trading.trading_up_backend.repository;
import com.trading.trading_up_backend.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso,Integer>{}
