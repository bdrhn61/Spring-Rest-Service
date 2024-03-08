package com.randomService.restService.service;

import com.randomService.restService.entity.Sehir;
import com.randomService.restService.repository.SehirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SehirService {
    @Autowired
    SehirRepository sehirRepository;


    public List<Sehir> getService() {
        return sehirRepository.findAll();
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
}
