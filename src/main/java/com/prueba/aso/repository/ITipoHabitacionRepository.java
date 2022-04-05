package com.prueba.aso.repository;

import com.prueba.aso.entities.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoHabitacionRepository extends JpaRepository<TipoHabitacion,Integer> {
}
