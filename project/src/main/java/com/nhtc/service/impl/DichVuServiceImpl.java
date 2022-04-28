/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.DichVu;
import com.nhtc.repository.DichVuRepository;
import com.nhtc.service.DichVuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuServiceImpl implements DichVuService{
    @Autowired
    private DichVuRepository dichVuRepository;
    
    
    @Override
    public boolean addOrUpdate(DichVu dv) {
        return this.dichVuRepository.addOrUpdate(dv);
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
    
}
