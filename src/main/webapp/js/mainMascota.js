var usernameD = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    getUsuario().then(function () {
       $("#mascota_perdida-btn").attr("href","form_pet_loss.html?username=" + usernameD);
       $("#mascota_encontrada-btn").attr("href","form_pet_find.html?username=" + usernameD);

        getmascota(false, "ASC");
        
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: usernameD
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario"+usernameD);
            }
        }
    });

}

function getmascota(ordenar, orden) {
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletListarMascotas",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarMascota(parsedResult);
            } else {
                console.log("Error recuperando los datos de las mascotas");
            }
        }
    });
}
function mostrarMascota(mascota) {

    let contenido = "";

    $.each(mascota, function (index, mascota) {

        mascota = JSON.parse(mascota);
        
           
           contenido += '<tr><th scope="row">' + mascota.nombre_mascota  + '</th>' +
                    '<td><img src = ' + mascota.foto_mascota + '></td>' +
                    '<td>' + mascota.username_mascota + '</td>' +
                    '<td>' + mascota.raza_mascota + '</td>' +
                    '<td>' + mascota.especie_mascota + '</td>' +
                    '<td>' + mascota.tipo_busqueda_mascota + '</td>' +
                    '<td>' + mascota.edad_aproximada_mascota + '</td>' +
                    '<td>' + mascota.sexo_mascota + '</td>' +
                    '<td>' + mascota.color_mascota + '</td>' +
                    '<td>' + mascota.descripcion_mascota + '</td>' +
                    '<td>' + mascota.fecha_mascota + '</td>' +
                    '<td>' + mascota.estado_busqueda_mascota + '</td>'   +                  
                    '<td>' + mascota.id_correo_usuario_mascota + '</td>' 
    });
    $("#mascota-tbody").html(contenido);
}

