/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.nhtc.pojos.BaoCao;
import com.nhtc.service.BaoCaoService;
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
public class BaoCaoController {
    @Autowired
    private BaoCaoService baoCaoService;
    
     @GetMapping("/baocao")
    public String baoCaoView(Model model) {
        model.addAttribute("baoCao", new BaoCao());
        return "baocao";
    }
//    

    @PostMapping("/baocao")
    public String addBC(Model model, @ModelAttribute(value = "baoCao") BaoCao bc) {
        String errorMessage;

        if (this.baoCaoService.addBaoCao(bc) == true) {
            return "redirect:/";
        } else {
            errorMessage = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }
        model.addAttribute("errorMessage", errorMessage);

        return "baocao";
    }

}
