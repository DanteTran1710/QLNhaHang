/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhtc.pojos.LoaiMon;
import com.nhtc.pojos.MonAn;
import com.nhtc.service.LoaiMonService;
import com.nhtc.service.MonAnService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class MonAnController {
    @Autowired
    private MonAnService monAnService;
    @Autowired
    private LoaiMonService loaiMonService;
        
    @GetMapping("/admin/monan")
    public String list(Model model){
        model.addAttribute("monan", new MonAn());
        return "monan";
    }
    
    @PostMapping("/admin/monan")
    public  String add(Model model, @ModelAttribute(value = "monan") @Valid MonAn monan,
            BindingResult result){
        
        if(!result.hasErrors()){
            if (this.monAnService.addOrUpdate(monan) == true)
            return "redirect:/admin";
            else
                model.addAttribute("errMsg", "Something wrong!!!");
        }
        
        return "monan";       
    }
    
    @GetMapping("/thucdon")
    public String thucdon(Model model, 
            @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        String idLoaiMon = params.get("idLoaiMon");
        if (idLoaiMon == null) {
            model.addAttribute("monan", this.monAnService.getMonAns(kw, page));
        } else {
            LoaiMon l = this.loaiMonService.getLoaiMonById(Integer.parseInt(idLoaiMon)); 
            model.addAttribute("monan", l.getMonAnCollection());
        }
        
        model.addAttribute("monAnCounter", this.monAnService.countMonAn());
        return "thucdon";
    }
}
