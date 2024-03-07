package com.randomService.restService.service;

import com.randomService.restService.entity.Sehir;
import com.randomService.restService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SehirService {
    @Autowired
    UserRepository userRepository;


    public List<Sehir> getService() {
        return userRepository.findAll();
    }

    public Sehir addSehir(Sehir sehir) {
        return userRepository.save(sehir);
    }

    public boolean deleteSehirById(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
