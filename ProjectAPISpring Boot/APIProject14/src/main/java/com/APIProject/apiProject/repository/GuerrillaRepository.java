package com.APIProject.apiProject.repository;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuerrillaRepository extends JpaRepository<GuerrillaUsuario, Integer> {
//        Optional<GuerrillaUsuario> findByEmail(String email);
//        @Query("SELECT s FROM Guerrilla s WHERE s.email=email")
//        GuerrillaUsuario findEmail(@Param("email") String email);
}
