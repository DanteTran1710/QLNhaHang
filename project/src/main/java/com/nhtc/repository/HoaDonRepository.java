/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository;

import com.nhtc.pojos.HoaDon;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hp
 */
public interface HoaDonRepository {
    List<Object> getListHoaDonByElements(int option, String month, String year, Date fromDate, Date toDate);
}
