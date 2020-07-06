function cong() {

    let nhap1=0;
    let nhap2=0;
    nhap1 = document.getElementById("input1").value;
    nhap2 = document.getElementById("input2").value;
    let ketQua;
    ketQua=parseInt(nhap1)+parseInt(nhap2);
    document.getElementById("hienThi").innerText= ketQua;
}
function tru() {
    let nhap1=0;
    let nhap2=0;
    nhap1 = document.getElementById("input1").value;
    nhap2 = document.getElementById("input2").value;
    let ketQua;
    ketQua=parseInt(nhap1)-parseInt(nhap2);
    document.getElementById("hienThi").innerText= ketQua;

}
function nhan() {
    let nhap1=0;
    let nhap2=0;
    nhap1 = document.getElementById("input1").value;
    nhap2 = document.getElementById("input2").value;
    let ketQua;
    ketQua=parseInt(nhap1)*parseInt(nhap2);
    document.getElementById("hienThi").innerText= ketQua;

}function chia() {
    let nhap1=0;
    let nhap2=0;
    nhap1 = document.getElementById("input1").value;
    nhap2 = document.getElementById("input2").value;
    let ketQua;
    ketQua=parseInt(nhap1)/parseInt(nhap2);
    document.getElementById("hienThi").innerText= ketQua;

}