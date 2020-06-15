package com.APIProject.apiProject.service;

import com.APIProject.apiProject.domain.business.UnidadBatalla;
import com.APIProject.apiProject.exceptions.RecordNotFoundException;
import com.APIProject.apiProject.repository.Unidades_BatallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadBatallaService {

    @Autowired
    private Unidades_BatallaRepository repository;

    public UnidadBatalla save(UnidadBatalla unidades) {
        try {
            return repository.save(unidades);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public UnidadBatalla update(UnidadBatalla unidades) {
        find(unidades.getID_unidades());
        return repository.save(unidades);
    }

//    public Optional<Supporter> findByEmail(String email) {
//        return repository.findByEmail(email);
//    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<UnidadBatalla> findAll() {
        return repository.findAll();
    }

    public List<UnidadBatalla> findAllByQuery(Integer id) {
        return repository.findAllByQuery(id);
    }

    public UnidadBatalla find(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new RecordNotFoundException(UnidadBatalla.class, id));
    }
}









