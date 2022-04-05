package com.prueba.aso.repository;

import com.prueba.aso.entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabitacionRepository extends JpaRepository<Habitacion,Integer> {
}
