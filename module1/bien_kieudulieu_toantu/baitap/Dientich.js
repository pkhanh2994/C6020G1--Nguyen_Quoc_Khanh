function tinhtoan() {
    let banKinhR;
    const pi=3.14;
    banKinhR=document.getElementById("bankinh").value;
    parseInt(banKinhR);
    let dientich;
    dientich=(banKinhR*banKinhR)*pi;
    document.getElementById("tinhdientich").value=dientich;

}