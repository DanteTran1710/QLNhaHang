/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.nhtc.pojos.SanhTiec;
import com.nhtc.service.LoaiSanhService;
import com.nhtc.service.SanhTiecService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class SanhTiecController {

    @Autowired
    private SanhTiecService sanhTiecService;
    @Autowired
    private LoaiSanhService loaiSanhService;

    @GetMapping("/admin/newsanhtiec")
    public String list(Model model) {
        model.addAttribute("sanhtiec", new SanhTiec());
        model.addAttribute("loaisanh", this.loaiSanhService.getLoaiSanhs());
        return "addSanhCuoi";
    }

    @PostMapping("/admin/newsanhtiec")
    public String add(Model model,
            @ModelAttribute(value = "sanhtiec") SanhTiec sanhTiec) {
        String errorMessage;

        if (this.sanhTiecService.addOrUpdate(sanhTiec) == true) {
            return "redirect:/admin";
        } else {
            errorMessage = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }
        model.addAttribute("errMsg", errorMessage);

        return "listSanhCuoi";
    }

    @GetMapping("/admin/listsanhtiec")
    public String listST(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        model.addAttribute("sanhTiecs", this.sanhTiecService.getSanhTiecs(kw, 1));

        return "listSanhCuoi";
    }

    @GetMapping("/admin/listsanhtiec/{idSanhTiec}")
    public String editSanhTiecView(Model model,
            @PathVariable(value = "idSanhTiec") int idSanhTiec) {

        model.addAttribute("sanhTiec",
                this.sanhTiecService.getSanhTiecById(idSanhTiec));

        return "editSanhCuoi";
    }

    @PostMapping(path = "/admin/listsanhtiec/{idSanhTiec}")
    public String editSanhTiec(Model model,
            @ModelAttribute(value = "sanhTiec") SanhTiec e) {
        String message;

        if (this.sanhTiecService.addOrUpdate(e)) {
            return "redirect:/admin";
        } else {
            message = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }

        model.addAttribute("message", message);

        return "editSanhCuoi";
    }
}
