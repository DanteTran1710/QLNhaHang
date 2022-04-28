/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service;

import com.nhtc.pojos.DichVu;
import java.util.List;

/**
 *
 * @author hp
 */
public interface DichVuService {
    List<DichVu> getDichVus(String kw, int page);
    DichVu getDichVuById(int idSanhTiec);
    long countDichVu();
    boolean addOrUpdate(DichVu sanhTiec);
}
