/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhtc.pojos.MonAn;
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

/**
 *
 * @author ACER
 */
//@Controller
public class MonAnController {
    @Autowired
    private MonAnService monAnService;
    
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
}
