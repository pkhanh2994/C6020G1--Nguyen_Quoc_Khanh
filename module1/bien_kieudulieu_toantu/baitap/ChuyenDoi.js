function caculator() {
    let moneyput = document.getElementById("money").value;
    let fromcurrency1 = document.getElementById("fromcurrency").value;
    let tocurrency1 = document.getElementById("tocurrency").value;
    let result;
    if ((fromcurrency1 === "dollar") && (tocurrency1 === "VN")) {
        result = parseInt(moneyput) * 23000;
        document.getElementById("convert").innertext = result;
    }
    if ((fromcurrency1 === "VN") && (tocurrency1 === "dollar")) {
        result = parseInt(moneyput) / 23000;
        document.getElementById("convert").innerText = result;
    }
    if ((fromcurrency1 === "VN") && (tocurrency1 === "VN")) {
        document.getElementById("convert").innerText = result;
    }
    if ((fromcurrency1 === "dollar") && (tocurrency1 === "dollar")) {
        document.getElementById("ketQua").innerText = result;
    }

}