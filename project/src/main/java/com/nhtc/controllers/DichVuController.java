/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.nhtc.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.nhtc.pojos.DichVu;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
public class DichVuController {
        @Autowired
        private DichVuService dichVuService;
    
    @GetMapping("/admin/newdvc")
    public String listDV(Model model) {
        model.addAttribute("dichVu", new DichVu());
        return "addDVC";
        
    }

    @PostMapping("/admin/newdvc")
    public String addDV(Model model,
            @ModelAttribute(value = "dichVu") DichVu dv) {
        String errorMessage;

        if (this.dichVuService.addOrUpdate(dv,0) == true) {
            return "redirect:/admin";
        } else {
            errorMessage = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }
        model.addAttribute("errMsg", errorMessage);

        return "addDVC";
    }
    @GetMapping("/admin/listdv")
    public String listDV(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        model.addAttribute("dichVus", this.dichVuService.getDichVus(kw, 1));
        
        model.addAttribute("counter",  this.dichVuService.getDichVus(kw, 1).size());

        return "listDVC";
    }

    @GetMapping("/admin/listdichvu/{idDV}")
    public String editSanhTiecView(Model model,
            @PathVariable(value = "idDV") int idDV) {

        model.addAttribute("dv",
                this.dichVuService.getDichVuById(idDV));

        return "editDVC";
    }

    @PostMapping(path = "/admin/listdichvu/{idDV}")
    public String editSanhTiec(Model model,
            @ModelAttribute(value = "dv") DichVu e,
            @PathVariable(value = "idDV") int idDV) {
        String message;

        if (this.dichVuService.addOrUpdate(e, idDV)) {
            return "redirect:/admin";
        } else {
            message = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }

        model.addAttribute("message", message);

        return "editDVC";
    }
    
    @GetMapping(path="/dichvu")
    public String dichVu(Model model, 
            @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        String idDichVu = params.get("idDichVu");
        if (idDichVu == null) {
            model.addAttribute("dichvu", this.dichVuService.getDichVus(kw, page));
        }
        
        model.addAttribute("dichVuCounter", this.dichVuService.countDichVu());
        return "dichvu";
    }
}
