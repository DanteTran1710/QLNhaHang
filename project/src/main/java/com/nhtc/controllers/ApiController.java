/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.nhtc.pojos.DichVu;
import com.nhtc.pojos.SanhTiec;
import com.nhtc.service.DichVuService;
import com.nhtc.service.SanhTiecService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
public class ApiController {
    @Autowired
    private DichVuService dichVuService;
    
    @Autowired
    private SanhTiecService sanhTiecService;
    
    @DeleteMapping("/api/delete-dichvu/{id}")
    public void deleteDivhVu(@PathVariable(value = "id") int reId, HttpSession session) {
        String msg;
        DichVu dv = this.dichVuService.getDichVuById(reId);
        
        if (this.dichVuService.delete(dv)) {
            msg = "Delete services successful!";
        } else {
            msg = "Delete services unsuccessful!";
        }

        session.setAttribute("msg", msg);
    }
    
    @DeleteMapping("/api/delete-sanhtiec/{id}")
    public void deleteSanhTiec(@PathVariable(value = "id") int reId, HttpSession session) {
        String msg;
        SanhTiec st = this.sanhTiecService.getSanhTiecById(reId);
        
        if (this.sanhTiecService.delete(st)) {
            msg = "Delete table successful!";
        } else {
            msg = "Delete table unsuccessful!";
        }
        
        session.setAttribute("msg", msg);
    }   
}
