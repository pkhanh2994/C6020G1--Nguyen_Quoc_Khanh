function Diemtong() {
    let diemvatly;
    let diemhoahoc;
    let diemsinhhoc;
    diemvatly=document.getElementById("ly").value;
    diemhoahoc=document.getElementById("hoa").value;
    diemsinhhoc=document.getElementById("sinh").value;
    let tinhDiem;
    tinhDiem=parseInt(diemvatly)+parseInt(diemhoahoc)+parseInt(diemsinhhoc);
    let trungBinh;
    trungBinh=(parseInt(diemvatly)+parseInt(diemhoahoc)+parseInt(diemsinhhoc))/3;
    document.getElementById("tong").value = tinhDiem;
    document.getElementById("ketquatrungbinh").value =trungBinh;

}