/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service;

import com.nhtc.pojos.MonAn;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface MonAnService {
    List<MonAn> getMonAns(String kw, int page);
    MonAn getMonAnById(int idMonAn);
    long countMonAn();
    boolean addOrUpdate(MonAn monAn);
}
