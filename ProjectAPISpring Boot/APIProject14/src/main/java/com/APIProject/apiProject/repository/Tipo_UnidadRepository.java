package com.APIProject.apiProject.repository;

import com.APIProject.apiProject.domain.business.TipoUnidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tipo_UnidadRepository extends JpaRepository<TipoUnidad, Integer> {
//        Optional<Supervisor> findByEmail(String email);
//
//        @Query("SELECT s FROM Supervisor s where s.email=email")
//        Supervisor findEmail(@Param("email") String email);
}

