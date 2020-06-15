package com.APIProject.apiProject.service;

import com.APIProject.apiProject.Model.FactionProperties;
import com.APIProject.apiProject.domain.business.GuerrillaUsuario;
import com.APIProject.apiProject.exceptions.RecordNotFoundException;
import com.APIProject.apiProject.repository.GuerrillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuerrillaService {

    private FactionProperties factionProperties;

    @Autowired
    private GuerrillaRepository repository;

    public GuerrillaUsuario save(GuerrillaUsuario guerrilla) {
        factionProperties = new FactionProperties();
        return repository.save(factionProperties.PropertiesFractionGuerrilla(guerrilla));
    }

    public GuerrillaUsuario update(GuerrillaUsuario guerrilla) {
        find(guerrilla.getID_Guerrilla_Usuario());
        return repository.save(guerrilla);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<GuerrillaUsuario> findAll() {
        return repository.findAll();
    }

    public GuerrillaUsuario find(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new RecordNotFoundException(GuerrillaUsuario.class, id));
    }

    public GuerrillaUsuario findByEmail(String email) {
        List<GuerrillaUsuario> usuarios = findAll();
        for(GuerrillaUsuario usuario: usuarios){
            if(usuario.getEmail().equals(email))
                return usuario;
        }
        return null;
    }

}









