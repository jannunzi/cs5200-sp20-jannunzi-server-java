package com.example.cs5200sp20jannunziserverjava.repositories;

import com.example.cs5200sp20jannunziserverjava.models.Widget;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {
}
