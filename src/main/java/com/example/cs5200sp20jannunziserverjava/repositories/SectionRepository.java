package com.example.cs5200sp20jannunziserverjava.repositories;

import com.example.cs5200sp20jannunziserverjava.models.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository
        extends CrudRepository<Section, Integer> {
}
