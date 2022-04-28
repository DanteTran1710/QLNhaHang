/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.LoaiSanh;
import com.nhtc.repository.LoaiSanhRepository;
import com.nhtc.service.LoaiSanhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LoaiSanhServiceImpl implements LoaiSanhService{
    @Autowired
    private LoaiSanhRepository loaiSanhRepository;
    
    @Override
    public List<LoaiSanh> getLoaiSanhs() {
        return this.loaiSanhRepository.getLoaiSanhs();
    }

    @Override
    public LoaiSanh getLoaiSanhById(int idLoaiSanh) {
        return this.loaiSanhRepository.getLoaiSanhById(idLoaiSanh);
    }
    
}
