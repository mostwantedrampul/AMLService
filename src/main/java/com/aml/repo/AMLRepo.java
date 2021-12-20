package com.aml.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aml.model.Currency;

@Repository
public interface AMLRepo  extends CrudRepository<Currency, Long>{

}
