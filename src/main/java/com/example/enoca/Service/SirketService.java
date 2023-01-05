package com.example.enoca.Service;

import com.example.enoca.Model.Sirket;
import com.example.enoca.Repository.SirketRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SirketService {


    private SirketRespository sirketRespository;

    public SirketService(SirketRespository sirketRespository) {
        this.sirketRespository = sirketRespository;
    }

    public Sirket createSirket(Sirket sirket){
        return sirketRespository.save(sirket);
    }
    public List<Sirket> findAllSirket(){
        return sirketRespository.findAll();
    }
    public Sirket getSirketById(String sirketId){
        return sirketRespository.findById(sirketId).orElse(null);
    }
    public Sirket updateSirket(String sirketId, Sirket sirket){
        Sirket lastSirket= this.sirketRespository.findById(sirketId).get();
        lastSirket.setSirket_adi(sirket.getSirket_adi());
        lastSirket.setAdres(sirket.getAdres());
        lastSirket.setSirket_mail(sirket.getSirket_mail());
        return sirketRespository.save(lastSirket);
    }


    public void deleteSirketById(String sirketId){
        sirketRespository.deleteById(sirketId);
    }
}
