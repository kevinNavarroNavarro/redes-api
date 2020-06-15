package com.APIProject.apiProject.service;

import com.APIProject.apiProject.Model.BuyUnit;
import com.APIProject.apiProject.Model.FactionProperties;
import com.APIProject.apiProject.Model.IndiceCalculator;
import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.exceptions.RecordNotFoundException;
import com.APIProject.apiProject.repository.Tipo_UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_UnidadService {

    IndiceCalculator indiceCalculator;
    private FactionProperties factionProperties;
    private BuyUnit buyUnit;

    @Autowired
    private Tipo_UnidadRepository repository;

    public TipoUnidad save(TipoUnidad tipo_Unidad) {
        try {
            factionProperties = new FactionProperties();
            indiceCalculator = new IndiceCalculator();
            indiceCalculator.SetIndex(tipo_Unidad);
            return repository.save(factionProperties.PropertiesFractionTipoUnidad(tipo_Unidad));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public TipoUnidad update(TipoUnidad tipo_Unidad) {
        factionProperties = new FactionProperties();
        buyUnit = new BuyUnit();
        indiceCalculator = new IndiceCalculator();
        tipo_Unidad = buyUnit.BuyUnit(tipo_Unidad);
        indiceCalculator.SetIndex(tipo_Unidad);
        tipo_Unidad = factionProperties.PropertiesFractionTipoUnidad(tipo_Unidad);
        return repository.save(tipo_Unidad);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<TipoUnidad> findAll() {
        return repository.findAll();
    }

//    public Optional<TipoUnidad> findByEmail(String email) {
//        return repository.findByEmail(email);
//    }

    public TipoUnidad find(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        ()-> new RecordNotFoundException(TipoUnidad.class, id));
    }
}









