/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhtc.pojos.DichVu;
import com.nhtc.repository.DichVuRepository;
import com.nhtc.service.DichVuService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    private DichVuRepository dichVuRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addOrUpdate(DichVu dv, int id) {
        Map r;
        try {
            r = this.cloudinary.uploader().upload(dv.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            dv.setAnhDV((r.get("secure_url").toString()));
            return this.dichVuRepository.addOrUpdate(dv, id);
        } catch (IOException ex) {
            Logger.getLogger(DichVuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<DichVu> getDichVus(String string, int i) {
        return this.dichVuRepository.getDichVus(string, i);
    }

    @Override
    public DichVu getDichVuById(int i) {
        return this.dichVuRepository.getDichVuById(i);
    }

    @Override
    public long countDichVu() {
        return this.dichVuRepository.countDichVu();
    }

    @Override
    public boolean delete(DichVu dichvu) {
        return this.dichVuRepository.delete(dichvu);
    }

}
