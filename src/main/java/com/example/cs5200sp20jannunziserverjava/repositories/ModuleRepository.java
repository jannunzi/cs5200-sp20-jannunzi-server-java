package com.example.cs5200sp20jannunziserverjava.repositories;

import com.example.cs5200sp20jannunziserverjava.models.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository
        extends CrudRepository<Module, Integer> {
//    @Query(value = "SELECT * FROM MODULES", nativeQuery = true)
    @Query("SELECT module FROM Module module")
    public List<Module> findAllModules();

//    @Query(value = "SELECT * FROM MODULES WHERE MODULES.ID=:mid", nativeQuery = true)
    @Query("SELECT module FROM Module module WHERE module.id=:mid")
    public Module findModuleById(
            @Param("mid") Integer moduleId);
}
