package com.meruvia.facturation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.meruvia.facturation.model.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long>{

	public abstract List<Factura> findAll();
}
