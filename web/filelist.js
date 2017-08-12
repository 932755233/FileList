function hoverShowDiv(n) {
    document.getElementById("divHover").style.display = "block";
    document.getElementById("bigimg").src = n.href;

    document.getElementById("divHover").style.top =10;
    document.getElementById("divHover").style.left =  10;
}

function hoverHiddendiv(n) {
    document.getElementById("divHover").style.display = "none";
}