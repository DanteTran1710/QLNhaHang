/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.nhtc.pojos.LoaiMon;
import com.nhtc.pojos.LoaiSanh;
import com.nhtc.service.LoaiMonService;
import com.nhtc.service.LoaiSanhService;
import com.nhtc.service.MonAnService;
import com.nhtc.service.SanhTiecService;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private LoaiMonService loaiMonService;
    @Autowired
    private MonAnService monAnService; 
    @Autowired
    private LoaiSanhService loaiSanhService;
    @Autowired
    private SanhTiecService sanhTiecService; 
    
    
    @ModelAttribute
    public void commonAttr(Model model){
        model.addAttribute("loaisanh", this.loaiSanhService.getLoaiSanhs());
        model.addAttribute("loaimon", this.loaiMonService.getLoaiMons());
    }
    
    @RequestMapping("/")
    public String index(Model model, 
            @RequestParam(required = false) Map<String, String> params){
        
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        String idLoaiSanh = params.get("idLoaiSanh");
        if (idLoaiSanh == null) {
            model.addAttribute("sanhtiec", this.sanhTiecService.getSanhTiecs(kw, page));
        } else {
            LoaiSanh l = this.loaiSanhService.getLoaiSanhById(Integer.parseInt(idLoaiSanh)); 
            model.addAttribute("sanhtiec", l.getSanhTiecCollection());
        }
        
        model.addAttribute("sanhTiecCounter", this.sanhTiecService.countSanhTiec());
        
        String idLoaiMon = params.get("idLoaiMon");
        if (idLoaiMon == null) {
            model.addAttribute("monan", this.monAnService.getMonAns(kw, page));
        } else {
            LoaiMon l = this.loaiMonService.getLoaiMonById(Integer.parseInt(idLoaiMon)); 
            model.addAttribute("monan", l.getMonAnCollection());
        }
        
        model.addAttribute("monAnCounter", this.monAnService.countMonAn());
        
        
        return "index";
    }
    
//    @RequestMapping("/")
//    public String index(Model model, 
//            @RequestParam(required = false) Map<String, String> params){
//        
//        String kw = params.getOrDefault("kw", null);
//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        
//        String idLoaiMon = params.get("idLoaiMon");
//        if (idLoaiMon == null) {
//            model.addAttribute("monan", this.monAnService.getMonAns(kw, page));
//        } else {
//            LoaiMon l = this.loaiMonService.getLoaiMonById(Integer.parseInt(idLoaiMon)); 
//            model.addAttribute("monan", l.getMonAnCollection());
//        }
//        
//        model.addAttribute("monAnCounter", this.monAnService.countMonAn());
//        
//        
//        return "index";
//    }
    
    
    @RequestMapping(path = "/dattiec")
    public String datTiec(Model model){
        return "dattiec";
    }
    
}
