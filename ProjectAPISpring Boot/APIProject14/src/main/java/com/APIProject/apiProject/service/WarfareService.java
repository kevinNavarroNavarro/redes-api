package com.APIProject.apiProject.service;

import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.repository.WarfareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarfareService {

    @Autowired
    private WarfareRepository repository;

    public Warfare save(Warfare warfare) {
        return repository.save(warfare);
    }

    public Warfare update(Warfare warfare) {
        findByWarfareName(warfare.getWarfareName());
        return repository.save(warfare);
    }

    public void delete(String warfareName) {
        repository.delete(findByWarfareName(warfareName));
    }

    public List<Warfare> findAll() {
        return repository.findAll();
    }

    //Encuentra una guerrilla determinada por el nombre
    public Warfare findByWarfareName(String warfare) {
        return repository
                .findByWarfareName(warfare);
    }

    //Encuentra una lista de guerrillas que pertenecen a una determinada faction
    public List<Warfare> findByFaction(String faction) {
        return repository
                .findByFaction(faction);
    }

    //Encuentra la guerrilla con un email
    public Warfare findByEmail(String email) {
        return repository
                .findByEmail(email);
    }


}









