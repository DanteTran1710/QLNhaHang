/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.nhtc.pojos.NhanVien;
import com.nhtc.pojos.TaiKhoan;
import com.nhtc.service.NhanVienService;
import com.nhtc.service.TaiKhoanService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NhanVienController {
    @Autowired
    public NhanVienService nhanVienService;
    @Autowired
    private TaiKhoanService userDetailsService;
    
     @GetMapping("/admin/signuptoempl")
    public String SignupForEmployeeView(Model model) {
        model.addAttribute("taiKhoan", new TaiKhoan());
        return "addEmployeeAccount";
    }
//    

    @PostMapping("/admin/signuptoempl")
    public String SignupForEmployee(Model model, 
            @ModelAttribute(value = "taiKhoan") TaiKhoan user) {
        String errorMessage;
        
        user.setLoaiTaiKhoan("nhân viên");

        if (this.userDetailsService.addUser(user) == true) {
            return "redirect:/admin/newnhanvien/" +user.getTenDangNhap();
        } else {
            errorMessage = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }
        model.addAttribute("errorMessage", errorMessage);

        return "addEmployeeAccount";
    }
    
     @GetMapping("/admin/newnhanvien/{username}")
    public String newNV(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "addEmployee";
        
    }

    @PostMapping("/admin/newnhanvien/{username}")
    public String addDV(Model model,
            @ModelAttribute(value = "nhanVien") NhanVien nv,
            @PathVariable(value = "username") String username) {
        String errorMessage;

        if (this.nhanVienService.addorUpdateNhanVien(nv, username)) {
            return "redirect:/admin";
        } else {
            errorMessage = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }
        model.addAttribute("errMsg", errorMessage);

        return "addEmployee";
    }
    
    
    @GetMapping("/admin/listnv")
    public String listST(Model model) {
        model.addAttribute("nhanViens", this.nhanVienService.getNhanVien());

        return "listEmployee";
    }
    
    @GetMapping("/admin/listnv/{idNV}")
    public String editNhanVienView(Model model,
            @PathVariable(value = "idNV") int idNV) {

        model.addAttribute("nhanVien",
                this.nhanVienService.getNhanVienById(idNV));

        return "editEmployee";
    }

    @PostMapping(path = "/admin/listnv/{idNV}")
    public String editSanhTiec(Model model,
            @ModelAttribute(value = "idNV") NhanVien e) {
        String message;

        if (this.nhanVienService.addorUpdateNhanVien(e, "")) {
            return "redirect:/admin";
        } else {
            message = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
        }

        model.addAttribute("message", message);

        return "editEmployee";
    }
}
