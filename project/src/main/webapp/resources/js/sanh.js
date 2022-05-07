/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let tongTien = 0;

$(document).ready(function () {
    // Set lại css 
    $('.navbar-nav .nav-item').css("margin", "4px 39px");
    
    //Search sảnh tiệc
    $('.navbar .navbar-nav').append(`
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="search">
        <form class="form-inline" action="/NhaHangTiecCuoi/sanhtiec">
          <input class="form-control mr-sm-2" name="kw"  type="text" placeholder="Nhập từ khóa">
          <button class="btn btn-success" type="submit">Tìm Kiếm</button>
        </form>
    </nav>`);
});

function getSanhTiecByID(id){
    let fetchDate = {
        method: 'GET',
        headers: {
                'Content-Type': 'application/json'
            },
        body: JSON.stringify()
    }
    return fetch(`http://localhost:8000/NhaHangTiecCuoi/api/getSanhTiec/` + id, fetchDate)
                .then(res => res.json())
                .then(data => data)
                .catch(err => err)
}

function getMonAnByID(id){
    let fetchDate = {
        method: 'GET',
        headers: {
                'Content-Type': 'application/json'
            },
        body: JSON.stringify()
    }
    return fetch(`http://localhost:8000/NhaHangTiecCuoi/api/getMonAn/` + id, fetchDate)
                .then(res => res.json())
                .then(data => data)
                .catch(err => err)
}

function getDichVuByID(id){
    let fetchDate = {
        method: 'GET',
        headers: {
                'Content-Type': 'application/json'
            },
        body: JSON.stringify()
    }
    return fetch(`http://localhost:8000/NhaHangTiecCuoi/api/getDichVu/` + id, fetchDate)
                .then(res => res.json())
                .then(data => data)
                .catch(err => err)
}

function getSanhTiec(id){
    getSanhTiecByID(id).then(res=>{
        $('#tenSanhTiec').text(res.tenSanhTiec);
        tongTien = 0;
    });
}

function isCheckedMonAn(e){
    if($(e).prop("checked") == true){
        let idMonAn = $(e).attr("id");
        getMonAnByID(idMonAn).then(res=>{
            tongTien += res.giaMonAn;
            $('#tongTien').text("Tổng tiền: " + tongTien);
        });
    }
}

function isCheckedDichVu(e){
    if($(e).prop("checked") == true){
        let idDichVu = $(e).attr("id");
        getDichVuByID(idDichVu).then(res=>{
            tongTien += res.bangGia;
            $('#tongTien').text("Tổng tiền: " + tongTien);
        });
    }
}