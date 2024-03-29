package com.randomService.restService.service;

import com.randomService.restService.entity.Bolge;
import com.randomService.restService.entity.Sehir;
import com.randomService.restService.repository.BolgeRepository;
import com.randomService.restService.repository.SehirRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SehirService {
    @Autowired
    SehirRepository sehirRepository;
    @Autowired
    BolgeRepository bolgeRepository;


    public List<Sehir> getService() {
        return sehirRepository.getAllSehir();


        //  return sehirRepository.findAll();
    }
    public List<Bolge> getBolge() {
        return bolgeRepository.getAllBolge();


        //  return sehirRepository.findAll();
    }
    

    public Sehir addSehir(Sehir sehir) {
        return sehirRepository.save(sehir);
    }

    public boolean deleteSehirById(Long id) {
        if(sehirRepository.existsById(id)) {
            sehirRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Sehir getSehirById(Long id) {
        Optional<Sehir> sehirOptional = sehirRepository.findById(id);
        return sehirOptional.orElse(null);
    }

    public Sehir updateSehir(Long id, Sehir updatedSehir ) {
        Optional<Sehir> optionalSehir = sehirRepository.findById(id);

        if (optionalSehir.isPresent()) {
            Sehir sehir = optionalSehir.get();
            sehir.updateSehir(updatedSehir);

            return sehirRepository.save(sehir);
        } else {
            throw new EntityNotFoundException("Sehir kaydı bulunamadı---: " + id);
        }
    }

    public Bolge addBolge(Bolge bolge) {
        return bolgeRepository.save(bolge);
    }
}
