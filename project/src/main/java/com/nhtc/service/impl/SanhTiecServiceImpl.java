/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhtc.pojos.SanhTiec;
import com.nhtc.repository.SanhTiecRepository;
import com.nhtc.service.SanhTiecService;
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
public class SanhTiecServiceImpl implements SanhTiecService{
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private SanhTiecRepository sanhTiecRepository; 
    
    @Override
    public List<SanhTiec> getSanhTiecs(String kw, int page) {
        return this.sanhTiecRepository.getSanhTiecs(kw, page);
    }
    
    @Override
    public boolean addOrUpdate(SanhTiec sanhTiec){
        try {
            Map r = this.cloudinary.uploader().upload(sanhTiec.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            sanhTiec.setAnhSanhTiec((String) r.get("secure_url"));

            return this.sanhTiecRepository.addOrUpdate(sanhTiec);
        } catch (IOException ex) {
            System.err.println("==THÊM SẢNH TIỆC==" + ex.getMessage());
        }
        
        return false;
    }

    @Override
    public long countSanhTiec() {
        return this.sanhTiecRepository.countSanhTiec();
    }

    @Override
    public SanhTiec getSanhTiecById(int idSanhTiec) {
        return this.sanhTiecRepository.getSanhTiecById(idSanhTiec);
    }

}
