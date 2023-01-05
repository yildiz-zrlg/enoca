package com.example.enoca.Controller;

import com.example.enoca.Model.Calisan;
import com.example.enoca.Service.CalisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calisan")
public class CalisanController {
    @Autowired
    private CalisanService calisanService;

    @GetMapping
    public List<Calisan> getAllCalisan(){
        return calisanService.findAllCalisan();
    }
    @GetMapping("/{id}")
    public Calisan getCalisanById(@PathVariable("id") String calisanId){
        return calisanService.getCalisanById(calisanId);
    }
    @PostMapping
    public Calisan insert(@RequestBody Calisan calisan){
        return calisanService.createCalisan(calisan);
    }
    @PutMapping("/{id}")
    public Calisan update(@PathVariable("id") String calisanId,@RequestBody Calisan calisan){
        return calisanService.updateCalisan(calisanId,calisan);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")String calisanId){
        calisanService.deleteCalisanById(calisanId);
    }

}
