/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    // Set lại css 
    $('.navbar-nav .nav-item').css("margin", "4px 39px");
    
    //Search sảnh tiệc
    $('.navbar .navbar-nav').append(`
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="search">
        <form class="form-inline" action="/NhaHangTiecCuoi/dichvu">
          <input class="form-control mr-sm-2" name="kw"  type="text" placeholder="Nhập từ khóa">
          <button class="btn btn-success" type="submit">Tìm Kiếm</button>
        </form>
    </nav>`);
});
