/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service;

import com.nhtc.pojos.SanhTiec;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface SanhTiecService {
    List<SanhTiec> getSanhTiecs(String kw, int page);
    SanhTiec getSanhTiecById(int idSanhTiec);
    long countSanhTiec();
    boolean addOrUpdate(SanhTiec idSanhTiec);
}
