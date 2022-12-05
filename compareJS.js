const myJson = require('./archives/exemplo_json.json')

const comparaJS = (x, y) => {
    let stringX = JSON.stringify(Object.entries(x).sort());
    let stringY = JSON.stringify(Object.entries(y).sort());
    if (stringX == stringY) return [];
    return encontraDiferença(x, y);
}
const encontraDiferença = (x, y) => {
    let mapX = new Map(Object.entries(x).sort());
    let mapY = new Map(Object.entries(y).sort());
    let isKeydifferent = JSON.stringify(Object.keys(x).sort()) == JSON.stringify(Object.keys(y).sort());
    return isKeydifferent ? compararValores(mapX, mapY) : compararChaves(mapX, mapY);
}
const compararValores = (mapX, mapY) => {
    let arrayDiff = [];
    mapX.forEach((xValue, key) => {
        let yValue = mapY.get(key);
        if (yValue != xValue) {
            arrayDiff.push([{ 'Objeto': 1, xValue, key }, { 'Objeto': 2, yValue, key }])
        }
    })
    return arrayDiff;
}
const compararChaves = (mapX, mapY) => {
    let arrayDiff = [];
    /*loop pelos dois array,
     não é perfomatico, caso as entradas forem  muito grande fazer, diversos if para não iterar pelos dois objetos*/
    mapX.forEach((value, key) => {
        if (!mapY.has(key)) {
            arrayDiff.push({ 'Objeto': 1, value, key })
        }
    });
    mapY.forEach((value, key) => {
        if (!mapX.has(key)) {
            arrayDiff.push({ 'Objeto': 2, value, key })
        }
    });

    return arrayDiff
}        
let obj1 = myJson[0];
let obj2 = myJson[1];
let diferenca = comparaJS(obj1, obj2);
console.log(diferenca);


