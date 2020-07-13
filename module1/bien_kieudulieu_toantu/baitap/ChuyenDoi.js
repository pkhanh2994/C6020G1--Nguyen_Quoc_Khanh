function caculator() {
    let moneyput = document.getElementById("money").value;
    let fromcurrency1 = document.getElementById("fromcurrency").value;
    let tocurrency1 = document.getElementById("tocurrency").value;
    let tong;
    if ((fromcurrency1 === "USD") && (tocurrency1 === "VN")) {
        tong=moneyput*23000;
    } else if ((fromcurrency1 === "VN") && (tocurrency1 === "USD")) {
        tong=moneyput/23000;
    }
        else{
            tong=moneyput;
    }
    document.getElementById("ketQua").innerHTML="result: "+tong;
}