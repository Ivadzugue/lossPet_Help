var usernameD = new URL(location.href).searchParams.get("username");
var user;


$(document).ready(function () {
 
    $("#form-register-mascota-perdida").submit(function (event) {
        event.preventDefault();        
        registrarMascotaPerdida();
    });    
    
     $("#form-register-mascota-encontrada").submit(function (event) {
        event.preventDefault();
        registrarMascotaEncontradas();
    });
  

});


function registrarMascotaPerdida() {
   
    let username = $("#pet-name").val();
    let nombre = $("#nombre").val();
    let raza = $("#raza").val();
    let especie = $("#especie").val();
    let tipo_busqueda = "Cuidador busca mascota";
    let edad = $("#edad").val();
    let sexo = $("#sexo").val();
    let color = $("#color").val();
    let descripcion = $("#descripcion").val();
    let fecha = $("#fecha").val();
    let foto = $("#foto").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMascotaPerdidaRegister",
        data: $.param({
            username: username,
            nombre: nombre,
            raza: raza,
            especie: especie,
            tipo_busqueda: tipo_busqueda,
            edad: edad,
            sexo: sexo,
            color: color,
            descripcion: descripcion,
            fecha: fecha,
            foto: foto,
            correo: usernameD
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                $("#register-error").addClass("d-none");              
                 document.location.href = "homeMascota.html?username=" + usernameD;
            } else {
                $("#register-error").removeClass("d-none");
                $("#register-error").html("Ya se encuentra una mscota copn el mismo --- pet's name ---, Error en el registro del usuario");
            }
        }
    });
    }
    
  

function registrarMascotaEncontradas() {
    let username = $("#pet-name").val();
    let raza = $("#raza").val();
    let especie = $("#especie").val();
    let tipo_busqueda = "Mascota busca su Hogar";
    let edad = $("#edad").val();
    let sexo = $("#sexo").val();
    let color = $("#color").val();
    let descripcion = $("#descripcion").val();
    let fecha = $("#fecha").val();
    let foto = $("#foto").val();


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMascotaPerdidaRegister",
        data: $.param({
            username: username,
            nombre: "NN",
            raza: raza,
            especie: especie,
            tipo_busqueda: tipo_busqueda,
            edad: edad,
            sexo: sexo,
            color: color,
            descripcion: descripcion,
            fecha: fecha,
            foto: foto,
            correo: usernameD

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                $("#register-error").addClass("d-none");
                  console.log("mascota encontrada resgistarao");                
                  document.location.href = "homeMascota.html?username=" + usernameD;
            } else {
                  console.log("no se pudo?");
                $("#register-error").removeClass("d-none");
                $("#register-error").html("Ya se encuentra una mscota copn el mismo --- pet's name ---, Error en el registro del usuario");
            }
        }
    });

}

