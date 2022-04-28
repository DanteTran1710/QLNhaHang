/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.MonAn;
import com.nhtc.repository.MonAnRepository;
import com.nhtc.service.MonAnService;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class MonAnServiceImpl implements MonAnService{
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private MonAnRepository monAnRepository; 
    
    @Override
    public List<MonAn> getMonAns(String kw, int page) {
        return this.monAnRepository.getMonAns(kw, page);
    }
    
    @Override
    public boolean addOrUpdate(MonAn monAn){
        try {
            Map r = this.cloudinary.uploader().upload(monAn.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            monAn.setAnhMonAn((String) r.get("secure_url"));

            return this.monAnRepository.addOrUpdate(monAn);
        } catch (IOException ex) {
            System.err.println("==THÊM MÓN ĂN==" + ex.getMessage());
        }
        
        return false;
    }

    @Override
    public long countMonAn() {
        return this.monAnRepository.countMonAn();
    }

    @Override
    public MonAn getMonAnById(int idMonAn) {
        return this.monAnRepository.getMonAnById(idMonAn);
    }
    
}
