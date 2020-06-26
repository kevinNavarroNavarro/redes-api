package com.APIProject.apiProject.service;

import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.exceptions.RecordNotFoundException;
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

    public List<Warfare> findAll() {
        return repository.findAll();
    }

    //Encuentra una guerrilla determinada por el nombre
    public List<Warfare> findByWarfareName(String warfare) {
        if(repository.findByWarfareName(warfare).isEmpty())
             throw new RecordNotFoundException(Warfare.class, warfare);

        return repository.findByWarfareName(warfare);
    }

    //Encuentra una lista de guerrillas que pertenecen a una determinada faction
    public List<Warfare> findByFaction(String faction) {
        if(repository.findByFaction(faction).isEmpty())
            throw new RecordNotFoundException(Warfare.class, faction);

        return repository.findByFaction(faction);
    }

    //Encuentra la guerrilla con un email
    public List<Warfare> findByEmail(String email) {
        if(repository.findByEmail(email).isEmpty())
            throw new RecordNotFoundException(Warfare.class, email);

        return repository.findByEmail(email);
    }


}









