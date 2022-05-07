/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.controllers;

import com.nhtc.pojos.DichVu;
import com.nhtc.pojos.HoaDon;
import com.nhtc.pojos.KhachHang;
import com.nhtc.pojos.MonAn;
import com.nhtc.pojos.SanhTiec;
import com.nhtc.pojos.TaiKhoan;
import com.nhtc.service.DichVuService;
import com.nhtc.service.SanhTiecService;
import com.nhtc.service.HoaDonService;
import com.nhtc.service.KhachHangService;
import com.nhtc.service.MonAnService;
import com.nhtc.service.TaiKhoanService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private HoaDonService hoaDonService;
    
    @Autowired
    private MonAnService monAnService;
    
    @Autowired
    private DichVuService dichVuService1;
    
    @Autowired 
    private TaiKhoanService taiKhoanService;
    
    @Autowired
    private KhachHangService khachHangService;

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

    @PostMapping(path = "/api/tieccuoi-statis")
    public ResponseEntity<List<Object>> getStatisticOfTiecCuoi(@RequestBody Map<String, String> params, Model model) {
        try {
            String timeFrom = null, timeTo = null;

            String year = params.get("year");
            String period = params.get("period");
            String month = params.get("month");

            Date fromDate = null, toDate = null;
            List<Object> l = null;

            if (month != null) {
                 l = this.hoaDonService.getListHoaDonByElements(1, month, year, fromDate, toDate);
            } else if (year != null) {
                if (period != null) {
                    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                    switch (period) {
                        case "spring":
                            timeFrom = year + "-1-1";
                            timeTo = year + "-3-31";
                            break;
                        case "summer":
                            timeFrom = year + "-4-1";
                            timeTo = year + "-6-30";
                            break;
                        case "fall":
                            timeFrom = year + "-7-1";
                            timeTo = year + "-9-30";
                            break;
                        case "winter":
                            timeFrom = year + "-10-1";
                            timeTo = year + "-12-31";
                            break;
                    }

                    fromDate = f.parse(timeFrom);
                    toDate = f.parse(timeTo);
                    l = this.hoaDonService.getListHoaDonByElements(3, month, year, fromDate, toDate);
                } else {
                    l = this.hoaDonService.getListHoaDonByElements(2, month, year, fromDate, toDate);
                }
            }
            return ResponseEntity.ok(l);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    //GetSanhTiec
    @GetMapping(path = "/api/getSanhTiec/{idSanhTiec}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SanhTiec>  getSanhTiecById(@PathVariable(value = "idSanhTiec") int idSanhTiec) {
        try {
            SanhTiec st = this.sanhTiecService.getSanhTiecById(idSanhTiec);
            return new ResponseEntity<>(st, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //GetMonAn
    @GetMapping(path = "/api/getMonAn/{idMonAn}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
     public ResponseEntity<MonAn>  getMonAnById(@PathVariable(value = "idMonAn") int idMonAn) {
        try {
            MonAn m = this.monAnService.getMonAnById(idMonAn);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     
    //GetDichVu
    @GetMapping(path = "/api/getDichVu/{idDichVu}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
     public ResponseEntity<DichVu>  getDichVuById(@PathVariable(value = "idDichVu") int idDichVu) {
        try {
            DichVu d = this.dichVuService.getDichVuById(idDichVu);
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     
    //GetListMonAn
    @GetMapping(path = "/api/getListMonAn", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MonAn>> getListMonAn(){
        try {
            List<MonAn> m = this.monAnService.getListMonAn();
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //GetListMonAn
    @GetMapping(path = "/api/getListDichVu", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DichVu>> getListDichVu(){
        try {
            List<DichVu> dv = this.dichVuService.getListDichVu();
            return new ResponseEntity<>(dv, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //GetTaiKhoanByUserName
    @GetMapping(path = "/api/getTaiKhoan/{username}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TaiKhoan>  getTaiKhoanByUsername(@PathVariable(value = "username") String username) {
        try {
            TaiKhoan t = this.taiKhoanService.getUserByUsername(username);
            return new ResponseEntity<>(t, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //AddHoaDon
    @PostMapping(path = "/api/addHoaDon", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HoaDon> addHoaDon(@Valid @RequestBody HoaDon hoaDon){
        if(this.hoaDonService.addOrUpdate(hoaDon) == true){
            return new ResponseEntity<>(hoaDon, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //GetKhachHangByIDTaiKhoan
    @GetMapping(path = "/api/getKhachHang/{idTaiKhoan}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<KhachHang>  getKhachHangByIDTaiKhoan(@PathVariable(value = "idTaiKhoan") int idTaiKhoan) {
        try {
            KhachHang kh = this.khachHangService.getKhachHangByIDTaiKhoan(idTaiKhoan);
            return new ResponseEntity<>(kh, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
