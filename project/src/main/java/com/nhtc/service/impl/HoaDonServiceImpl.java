/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.HoaDon;
import com.nhtc.repository.HoaDonRepository;
import com.nhtc.service.HoaDonService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class HoaDonServiceImpl implements HoaDonService{
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public List<Object> getListHoaDonByElements(int i, String string, String string1, Date date, Date date1) {
        return this.hoaDonRepository.getListHoaDonByElements(i, string, string1, date, date1);
    }

    @Override
    public boolean addOrUpdate(HoaDon hoadon) {
        
        hoadon.setNgayDat(new Date());
        return this.hoaDonRepository.addOrUpdate(hoadon);
    }
    
}
