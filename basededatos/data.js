var data = `INSERT INTO products_terms_and_conditions VALUES ();`;

function createQuery(data){
    // var array = data.split(/\r?\n|\r/g);
    // for(const [index, query] of array.entries()){
    //     console.log(query.replace("(name, value, image_id)", "(id, name, value, image_id)").replace("('", `(${index+ 1}, '`))
    // }
    for(var i = 1; i<=25; i++){
        for(var o = 1; o<=6; o++){
            console.log(data.replace("()", `(${i}, ${o})`))
        }
    }
}


createQuery(data)

