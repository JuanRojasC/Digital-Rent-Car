

const featuresjson = [
    {
      id: 18,
      img: ["/car-images/Chevrolet_Captiva-Image.png",
        "/car-images/Chevrolet_Captiva-Image2.png",
        "/car-images/Chevrolet_Captiva-Image3.png",
        "/car-images/Chevrolet_Captiva-Image4.jpg",
        "/car-images/Chevrolet_Captiva-Image5.png"],
      category: 1,
      title: "Chevrolet Captiva",
      location: 1,
      images: [35,36,37,38,39],
      description : {
          enginePower: "145 HP",
          airConditioning: true,
          seats: 7,
          combustible: "Diesel",
          text: "Captiva Turbo llega para desafiar todas las expectativas de lo que se espera de un SUV. Más allá de su atractivo diseño, tiene el espacio suficiente para todo y todos, gracias a su capacidad para 5 o 7 pasajeros. Está equipada con tecnología superior y atributos avanzados de seguridad."
      }
    },
    {
      id: 17,
      img: "/car-images/Chevrolet_Camaro-Image.png",
      category: 3,
      title: "Chevrolet Camaro",
      location: 1,
      images: [30,31,32,33,34],
      description : {
          enginePower: "455 HP",
          airConditioning: false,
          seats: 4,
          combustible: "Gasolina",
          text: "El Chevrolet Camaro ofrece buen nivel de equipamiento y asistencias al conductor para que el viaje en ciudad y carretera sea más seguro, pero no deja de lado sus raíces deportivas y puede liberar todo su potencial cuando uno lo desee. Si eres fanático de los autos americanos, este muscle car es uno de los más fieles a su origen."
      }
    },
    {
      id: 23,
      img: "/car-images/Nissan_Frontier-Image.png",
      category: 4,
      title: "Nissan Frontier",
      location: 1,
      images: [60,61,62,63,64],
      description : {
          enginePower: "310 HP",
          airConditioning: true,
          seats: 4,
          combustible: "Gasolina",
          text: "Durante generaciones, Nissan ha fabricado las pick ups más confiables, manteniéndose así siempre a la delantera en resistencia y durabilidad. Nissan NP300® está diseñada para satisfacer todas tus necesidades gracias a su motor, capacidad de carga y chasis reforzado ademas de sus extraordinarios ángulos de entrada (28.5°) y salida (23.6°) le permiten enfrentarse sin problema a terrenos inclinados  e inhóspitos."
      }
    }
    ,
    {
      id: 19,
      img: "/car-images/Chrysler_Town-Image.png",
      category: 1,
      title: "Chrysler Town",
      location: 1,
      images: [40,41,42,43,44],
      description : {
          enginePower: "283 HP",
          airConditioning: true,
          seats: 4,
          combustible: "Gasolina",
          text: "El Chrysler Town & Country es un gran vehículo para familias que necesitan transportar personas y carga con regularidad. Para obtener el máximo espacio para pasajeros y carga, una minivan es difícil de superar, y las opciones de asientos de Town & Country se encuentran entre las mejores de su clase. Y su manejo controlado convierte la experiencia de conducción en algo muy comodo. Las opciones de entretenimiento incluyen TV en el asiento trasero, reproductores de DVD o DVD / Blu-Ray, un potente estéreo y conectividad para iPod."
      }
    }
    ,
    {
      id: 20,
      img: "/car-images/Ford_Mustang-Image.png",
      category: 3,
      title: "Ford Mustang",
      location: 1,
      images: [45,46,47,48,49],
      description : {
          enginePower: "480 HP",
          airConditioning: true,
          seats: 4,
          combustible: "Gasolina",
          text: "Escucha el rugido de un Mustang cuando el suelo comienza a temblar y las piernas a agitarse. Como siempre, el Mustang invoca su desempeño con características de manejo mejorado, opciones de motor súper potente y diseño de Mustang clásico. El habitáculo del Ford Mustang cuenta con un diseño muy personal que aboga por las líneas curvas y la profusión de botones e interruptores, recordando enormemente a los salpicaderos que el propio Mustang ofrecía en los años 60 y 70."
      }
    }
    ,
    {
      id: 22,
      img: "/car-images/Honda_CRV-Image.png",
      category: 1,
      title: "Honda CRVs",
      location: 1,
      images: [55,56,57,58,59],
      description : {
          enginePower: "200 HP",
          airConditioning: true,
          seats: 4,
          combustible: "Gasolina",
          text: "Diseñado para llevarte más lejos, El CR-V ofrece millas y millas de diversión al conducir, con tracción total, 212 caballos de fuerza en total del sistema, y con mucho espacio de carga. Su exterior deportivo cuenta con líneas esculpidas y rines de aleación de 19 pulgadas disponibles, mientras que su espacio interior ofrece uun volante con calefacción disponible, asientos tapizados en cuero y otros materiales premium."
      }
    }
    ,
    {
      id: 24,
      img: "/car-images/Nissan_Versa-Image.png",
      category: 2,
      title: "Nissan Versa",
      location: 1,
      images: [65,66,67,68,69],
      description : {
          enginePower: "122 HP",
          airConditioning: false,
          seats: 4,
          combustible: "Gasolina",
          text: "El sedán Nissan Versa es una excelente herramienta de transporte para llevar a los pasajeros del punto A al punto B, pero también hace que el viaje sea más agradable que muchos otros autos subcompactos. El Nissan no solo es atractivo, su motor de cuatro cilindros tiene una economía de combustible en las carreteras impresionante. El suave andar del Versa y los cómodos asientos delanteros lo convierten en un carro relajante para los desplazamientos diarios, y está disponible con más asistencia al conductor que sus compañeros de clase."
      }
    }
    ,
    {
      id: 26,
      img: "/car-images/Renault_Sandero-Image.png",
      category: 1,
      title: "Renault Sandero",
      location: 1,
      images: [70,71,72,73,74],
      description : {
          enginePower: "85 HP",
          airConditioning: false,
          seats: 5,
          combustible: "Gasolina",
          text: "El Renault SANDERO es el auto para todo lo que sos y entre todas tus versiones, sos alguien que disfruta del diseño. Empieza cuando lo ves por primera vez. Es más que el perfil, es más que el frente, es un estilo único; es el diseño que hace que quieras subirte y manejarlo. Aún con el auto detenido, es fluido, dinámico y avanzado."
      }
    }
    ,
    {
      id: 28,
      img: "/car-images/Toyota_Hilux-Image.png",
      category: 4,
      title: "Toyota Hilux",
      location: 1,
      images: [75,76,77,78,79],
      description : {
          enginePower: "204 HP",
          airConditioning: true,
          seats: 5,
          combustible: "diesel",
          text: "Bajo la musculosa y gran carrocería del Hilux se esconde un chasis tradicional de pick-up y vehículo todoterreno. Se trata de una plataforma de largueros y travesaños con suspensión trasera de ballesta diseñada especialmente para soportar grandes cargas, una gran capacidad off-road y una elevada versatilidad de carrocerías. La capacidad de carga de la caja permite hasta 1.040 kilogramos de carga. En función de la cabina puede albergar entre dos y cinco pasajeros, y en cuanto a cotas todoterreno ofrece 27 grados de ángulo de entrada, 27 grados de ángulo de salida y 23 grados de ángulo ventral con una profundidad de vadeo de hasta 70 centímetros con una altura libre de 29,3 centrímetros."
      }
    }
    ,
    {
      id: 29,
      img: "/car-images/Toyota_Vios-Image.png",
      category: 2,
      title: "Toyota Vios",
      location: 1,
      images: [80,81,82,83,84],
      description : {
          enginePower: "98 HP",
          airConditioning: true,
          seats: 4,
          combustible: "Electrico",
          text: "Toyota ha declarado explícitamente que, con el modelo Toyota Vios, se han propuesto conservar las mejores cualidades que los clientes han llegado a conocer, amar, a saber, la calidad y la comodidad. Fieles a su palabra, parecen estar en el camino correcto con la nueva generación. más equipamiento, un interior más refinado y una caja de cambios completamente nueva, son propiedades del nuevo Toyota Vios, disponible en nuestras vitrinas."
      }
    }
    
]
var counter = 1;

// for(let feature of featuresjson){
//     console.log(`INSERT INTO products (name, description, main_image_id, category_id, city_id, specs_id) VALUES ('${feature.title}', '${feature.description.text}', ${feature.id}, ${feature.category}, ${feature.location}, ${counter});`);
//     counter++;
// }
for(let feature of featuresjson){
    for(let id of feature.images){
      console.log(`INSERT INTO product_images_ids VALUES (${counter}, ${id});`);
    }
    counter++;
}



