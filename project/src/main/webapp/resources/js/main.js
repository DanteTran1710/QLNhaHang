/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Template Name: Shuffle - v2.3.1
 * Template URL: https://bootstrapmade.com/bootstrap-3-one-page-template-free-shuffle/
 * Author: BootstrapMade.com
 * License: https://bootstrapmade.com/license/
 */

// HOME PAGE

!(function ($) {
    "use strict";

    // Stick the header at top on scroll
    $("#header").sticky({
        topSpacing: 0,
        zIndex: '50'
    });

    // Test fixed - scroll menu header


    // Smooth scroll for the navigation menu and links with .scrollto classes
    var scrolltoOffset = $('#header').outerHeight() - 1;
    $(document).on('click', '.nav-menu a, .mobile-nav a, .scrollto', function (e) {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            if (target.length) {
                e.preventDefault();

                var scrollto = target.offset().top - scrolltoOffset;

                if ($(this).attr("href") == '#header') {
                    scrollto = 0;
                }

                $('html, body').animate({
                    scrollTop: scrollto
                }, 1500, 'easeInOutExpo');

                if ($(this).parents('.nav-menu, .mobile-nav').length) {
                    $('.nav-menu .active, .mobile-nav .active').removeClass('active');
                    $(this).closest('li').addClass('active');
                }

                if ($('body').hasClass('mobile-nav-active')) {
                    $('body').removeClass('mobile-nav-active');
                    $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
                    $('.mobile-nav-overly').fadeOut();
                }
                return false;
            }
        }
    });

    // Activate smooth scroll on page load with hash links in the url
    $(document).ready(function () {
        if (window.location.hash) {
            var initial_nav = window.location.hash;
            if ($(initial_nav).length) {
                var scrollto = $(initial_nav).offset().top - scrolltoOffset;
                $('html, body').animate({
                    scrollTop: scrollto
                }, 1500, 'easeInOutExpo');
            }
        }
    });

    // Mobile Navigation
    if ($('.nav-menu').length) {
        var $mobile_nav = $('.nav-menu').clone().prop({
            class: 'mobile-nav d-lg-none'
        });
        $('body').append($mobile_nav);
        $('body').prepend('<button type="button" class="mobile-nav-toggle d-lg-none"><i class="icofont-navigation-menu"></i></button>');
        $('body').append('<div class="mobile-nav-overly"></div>');

        $(document).on('click', '.mobile-nav-toggle', function (e) {
            $('body').toggleClass('mobile-nav-active');
            $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
            $('.mobile-nav-overly').toggle();
        });

        $(document).on('click', '.mobile-nav .drop-down > a', function (e) {
            e.preventDefault();
            $(this).next().slideToggle(300);
            $(this).parent().toggleClass('active');
        });

        $(document).click(function (e) {
            var container = $(".mobile-nav, .mobile-nav-toggle");
            if (!container.is(e.target) && container.has(e.target).length === 0) {
                if ($('body').hasClass('mobile-nav-active')) {
                    $('body').removeClass('mobile-nav-active');
                    $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
                    $('.mobile-nav-overly').fadeOut();
                }
            }
        });
    } else if ($(".mobile-nav, .mobile-nav-toggle").length) {
        $(".mobile-nav, .mobile-nav-toggle").hide();
    }

    // Navigation active state on scroll
    var nav_sections = $('section');
    var main_nav = $('.nav-menu, .mobile-nav');

    $(window).on('scroll', function () {
        var cur_pos = $(this).scrollTop() + 200;

        nav_sections.each(function () {
            var top = $(this).offset().top,
                    bottom = top + $(this).outerHeight();

            if (cur_pos >= top && cur_pos <= bottom) {
                if (cur_pos <= bottom) {
                    main_nav.find('li').removeClass('active');
                }
                main_nav.find('a[href="#' + $(this).attr('id') + '"]').parent('li').addClass('active');
            }
            if (cur_pos < 300) {
                $(".nav-menu ul:first li:first").addClass('active');
            }
        });
    });

    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });

    $('.back-to-top').click(function () {
        $('html, body').animate({
            scrollTop: 0
        }, 1500, 'easeInOutExpo');
        return false;
    });

    // Skills section
    $('.skills-content').waypoint(function () {
        $('.progress .progress-bar').each(function () {
            $(this).css("width", $(this).attr("aria-valuenow") + '%');
        });
    }, {
        offset: '80%'
    });

    // jQuery counterUp
    $('[data-toggle="counter-up"]').counterUp({
        delay: 10,
        time: 1000
    });

    // Porfolio isotope and filter
    $(window).on('load', function () {
        var portfolioIsotope = $('.portfolio-container').isotope({
            itemSelector: '.portfolio-item',
            layoutMode: 'fitRows'
        });

        $('#portfolio-flters li').on('click', function () {
            $("#portfolio-flters li").removeClass('filter-active');
            $(this).addClass('filter-active');

            portfolioIsotope.isotope({
                filter: $(this).data('filter')
            });
        });

        // Initiate venobox (lightbox feature used in portofilo)
        $(document).ready(function () {
            $('.venobox').venobox();
        });
    });

    // Portfolio details carousel
    $(".portfolio-details-carousel").owlCarousel({
        autoplay: true,
        dots: true,
        loop: true,
        items: 1
    });

})(jQuery);

function deleteDichVu(id) {
    if (confirm("Do you want to delete this services?") == true) {
        fetch(`/NhaHangTiecCuoi/api/delete-dichvu/${id}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                location.reload();
            } else
                alert("Error!!");
        })
    }
}

function deleteSanhTiec(id) {
    if (confirm("Do you want to delete this Order-Table?") == true) {
        fetch(`/NhaHangTiecCuoi/api/delete-sanhtiec/${id}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                location.reload();
            } else
                alert("Error!!");
        })
    }
}

// CHART STATISTIC
function generateColor() {
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);

    return `rgb(${r},${g},${b})`;
}

function cvChart(cvLabels = [], cvInfo = []) {
    let colors = [];

    for (let i = 0; i < cvInfo.length; i++)
        colors.push(generateColor());

    const data = {
        labels: cvLabels,
        datasets: [{
                label: 'Doughnut Chart For Ordered-Wedding Statistic',
                data: cvInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'doughnut',
        data: data
    };

    let ctx = document.getElementById("doughnutchart").getContext("2d");
    new Chart(ctx, config);
}

function sendCondition() {
    let sM = document.getElementsByName("rdbM");
    let sY = document.getElementsByName("rdbY");
    let sS = document.getElementsByName("rdbS");

    var year = null;
    var period = null;
    var month = null;

    for (var i = 0; i < sY.length; i++) {
        if (sY[i].checked == true)
            year = sY[i].value;
    }

    for (var i = 0; i < sS.length; i++) {
        if (sS[i].checked == true)
            period = sS[i].value;
    }
    for (var i = 0; i < sM.length; i++) {
        if (sM[i].checked == true)
            month = sM[i].value;
    }
    if (month != null && year != null || month != null && period != null) {
        alert("CANT CHOOSE YEAR AND MONTH OR PERIOD AT THE SAME TIME");
    } else {
        getCVStatistic(month, year, period);
    }
}
function getCVStatistic(month, year, period) {
    event.preventDefault();

    fetch("/NhaHangTiecCuoi/api/tieccuoi-statis", {
        method: 'post',
        body: JSON.stringify({
            "period": period,
            "year": year,
            "month": month
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {

        let area = document.getElementById("chartTable");
        let section = document.getElementById("doughnutchart");
        let cvLabels = [], cvInfo = [];

        data.forEach(i => {
            area.innerHTML += `
                                   <tr>
                                        <td>${i[0]}</td>
                                        <td>${i[1]}</td>                                        
                                    </tr>
                            `;
            cvLabels.push(i[0]);
            cvInfo.push(i[1]);
            
        });

        cvChart(cvLabels, cvInfo);
    });
}
