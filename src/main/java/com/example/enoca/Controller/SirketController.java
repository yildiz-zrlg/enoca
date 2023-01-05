package com.example.enoca.Controller;


import com.example.enoca.Model.Sirket;
import com.example.enoca.Service.SirketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sirket")
public class SirketController {


    private SirketService sirketService;

    public SirketController(SirketService sirketService) {
        this.sirketService = sirketService;
    }

    @GetMapping
    public List<Sirket> getAllSirket(){
        return sirketService.findAllSirket();
    }
    @GetMapping("/{id}")
    public Sirket getSirketById(@PathVariable("id") String sirketId){
        return sirketService.getSirketById(sirketId);
    }
    @PostMapping
    public Sirket insert(@RequestBody Sirket sirket){
        return sirketService.createSirket(sirket);
    }
    @PutMapping("/{id}")
    public Sirket update(@PathVariable("id") String sirketId,@RequestBody Sirket sirket){
        return sirketService.updateSirket(sirketId,sirket);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String sirketId){
        sirketService.deleteSirketById(sirketId);

    }
}

