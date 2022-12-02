const myJson = require('./archives/exemplo_json.json')

const obj1 = myJson[0];
const obj2 = myJson[1];

function comparaJS (obj1, obj2) {
    if(JSON.stringify(Object.keys(obj1).sort()) !== JSON.stringify(Object.keys(obj2).sort())) {
        return `Keys Diferentes:`;
    }
    else if (JSON.stringify(Object.values(obj1).sort()) !== JSON.stringify(Object.values(obj2).sort())) {
        return `json diferentes`;
    } 
    else {
        return `Os dois são iguais!`
    }   
}



/* console.log(comparaJS(obj1, obj2)) */