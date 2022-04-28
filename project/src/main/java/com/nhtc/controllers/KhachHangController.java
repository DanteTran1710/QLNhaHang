/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.nhtc.pojos.KhachHang;
import com.nhtc.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author hp
 */
@Controller
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/newKhachHang")
    public String khProfileView(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "addCustomer";
    }
//    

    @PostMapping("/newKhachHang")
    public String addKH(Model model, @ModelAttribute(value = "khachHang") KhachHang kh) {
        String errorMessage;

        if (this.khachHangService.addKH(kh) == true) {
            return "redirect:/login";
        } else {
            errorMessage = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }
        model.addAttribute("errorMessage", errorMessage);

        return "addCustomer";
    }
}
