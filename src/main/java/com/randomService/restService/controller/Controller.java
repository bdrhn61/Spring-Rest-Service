package com.randomService.restService.controller;


import com.randomService.restService.entity.Bolge;
import com.randomService.restService.entity.Sehir;


import com.randomService.restService.service.SehirService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sehirler")
public class Controller {

    @Autowired
    SehirService sehirService;
    @Autowired
    private RestTemplate restTemplate;

    // bütün şehirleri listeler
    @GetMapping
    List<Sehir> getSehir(){
        return sehirService.getService();
    }
    //id ye göre 1 şehir listeler
    @GetMapping("/{id}")
    public Sehir getSehirById(@PathVariable Long id) {
        return sehirService.getSehirById(id);
    }

    //Dışarıdan bir servise istek atıp dönen verileri görüntüleme
    @GetMapping("/get-data-from-web-service")
    public String getDataFromWebService() {
        String url = "https://dummyjson.com/products/1"; // Dışarıdan alınan web servisi URL'si
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
    // Veri tabanına veri ekleme
    // curl -X POST -H "Content-Type: application/json" --data-binary "{\"name\": \"İl Adı\"}" http://localhost:8080/sehirler/products
    // http://localhost:8080/sehirler/products    heders   "Content-Type"  Değeri "application/json" olmalıdır.
    // body  {
    //    "name": "İstanbul"
    //}
    @PostMapping("products")
    public ResponseEntity<?> addProduct(@RequestBody Sehir sehir) {
        try {
            Sehir newSehir = sehirService.addSehir(sehir);
            return new ResponseEntity<>(newSehir, HttpStatus.CREATED);
        } catch (Exception e) {
            // Eğer bölge ID girilmemişse özel bir hata mesajı döndür
            if (e instanceof ConstraintViolationException) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            } else if (sehir.getBolge() == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bolge ID girmek zorunludur.");
            }
            // Diğer hatalar için genel hata mesajı döndür
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/bolgeEkle")
    public ResponseEntity<Bolge> addBolge(@RequestBody Bolge bolge) {
        Bolge newBolge = sehirService.addBolge(bolge);
        return new ResponseEntity<>(newBolge, HttpStatus.CREATED);
    }
    @GetMapping("/bolge")
    List<Bolge> getBolge(){
        return sehirService.getBolge();
    }

    //   id ile veri tabanından şehir silmek
    //   http://localhost:8080/sehirler/sil/5
    //   curl -X DELETE http://localhost:8080/sehirler/sil/6
    @DeleteMapping("/sil/{id}")
    public ResponseEntity<String> deleteSehir(@PathVariable Long id) {
        if(sehirService.deleteSehirById(id)) {
            return new ResponseEntity<>("Sehir başarıyla silindi", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sehir bulunamadı", HttpStatus.NOT_FOUND);
        }
    }

    // http://localhost:8080/sehirler/degistir/2?yeniSehirAdi=adana
    // id ile şehir ismini değiştirmek
    @PutMapping("/degistir/{id}")
    public Sehir updateSehir(@PathVariable Long id,  @RequestBody Sehir updatedSehir) {
        return sehirService.updateSehir(id, updatedSehir);
    }


}
