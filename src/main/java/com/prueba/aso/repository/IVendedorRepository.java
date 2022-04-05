package com.prueba.aso.repository;

import com.prueba.aso.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor,Integer> {
}
