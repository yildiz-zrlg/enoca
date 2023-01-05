package com.example.enoca.Service;

import com.example.enoca.Model.Calisan;
import com.example.enoca.Model.Sirket;
import com.example.enoca.Repository.CalisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalisanService {


    private CalisanRepository calisanRepository;
    private SirketService sirketService;

    public CalisanService(CalisanRepository calisanRepository, SirketService sirketService) {
        this.calisanRepository = calisanRepository;
        this.sirketService = sirketService;
    }

    public Calisan createCalisan(Calisan calisan){
        Sirket sirket=sirketService.getSirketById(calisan.getCalisan_id());
        Calisan lastCalisan= new Calisan();
        lastCalisan.setCalisan_adi(calisan.getCalisan_adi());
        lastCalisan.setCalisan_soyadi(calisan.getCalisan_soyadi());
        lastCalisan.setCalisan_mail(calisan.getCalisan_mail());
        lastCalisan.setSirket(sirket);
        return calisanRepository.save(lastCalisan);
    }
    public List<Calisan> findAllCalisan(){
        return calisanRepository.findAll();
    }
    public Calisan getCalisanById(String calisanId){
        return calisanRepository.findById(calisanId).orElse(null);
    }
    public Calisan updateCalisan(String calisanId, Calisan calisan){
        Sirket sirket=sirketService.getSirketById(calisanId);
        Calisan lastCalisan= this.calisanRepository.findById(calisanId).get();
        lastCalisan.setCalisan_adi(calisan.getCalisan_adi());
        lastCalisan.setCalisan_soyadi(calisan.getCalisan_soyadi());
        lastCalisan.setCalisan_mail(calisan.getCalisan_mail());
        lastCalisan.setSirket(sirket);
        return calisanRepository.save(lastCalisan);
    }


    public void deleteCalisanById(String calisanId){
        calisanRepository.deleteById(calisanId);
    }
}


