$(document).ready(function(){
  $('.carousel').slick({
    autoplay: true,
    speed: 1000,
    adaptiveHeight: true,
    nextArrow: "<i class=\"right arrow icon\"></i>",
    prevArrow: "<i class=\"left arrow icon\"></i>",
    appendArrows: $("#carousel-arrows")
  });
});