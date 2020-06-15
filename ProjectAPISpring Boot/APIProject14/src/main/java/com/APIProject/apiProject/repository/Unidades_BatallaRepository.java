package com.APIProject.apiProject.repository;

import com.APIProject.apiProject.domain.business.UnidadBatalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface Unidades_BatallaRepository extends JpaRepository<UnidadBatalla, Integer> {

   @Query("SELECT s FROM UnidadBatalla s where s.ID_unidad=?1")
   List<UnidadBatalla> findAllByQuery(@Param("ID_guerrilla") Integer guerrilla);
}
