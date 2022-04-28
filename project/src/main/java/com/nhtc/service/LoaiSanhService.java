/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service;

import com.nhtc.pojos.LoaiSanh;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface LoaiSanhService {
    List<LoaiSanh> getLoaiSanhs();
    LoaiSanh getLoaiSanhById(int idLoaiSanh);
}

