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
import com.nhtc.service.HoaDonService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
}
