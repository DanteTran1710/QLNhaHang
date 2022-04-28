/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.LoaiMon;
import com.nhtc.repository.LoaiMonRepository;
import com.nhtc.service.LoaiMonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LoaiMonServiceImpl implements LoaiMonService{
    @Autowired
    private LoaiMonRepository loaiMonRepository;
    
    @Override
    public List<LoaiMon> getLoaiMons() {
        return this.loaiMonRepository.getLoaiMons();
    }
    
    @Override
    public LoaiMon getLoaiMonById(int idLoaiMon){
        return this.loaiMonRepository.getLoaiMonById(idLoaiMon);
    }
}
