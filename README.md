Para correr el archivo, usar: ./gradlew bootRun 
Lo anterior correra en http://localhost:8080

Base de datos:

Tabla: weather_tbl (id int, name varchar(20), lat int, longitud int, wind int, cloud int, temp int, date varchar(20))
Se usó la tabla anterior por simplicidad del ejercicio donde no se usara una gran base de datos sino que solo se poblo con Santiago y Lima para los días 3,4,5 y 6 de mayo.

Endpoints:
 POST /addWeather -> agrega un nuevo atributo a la tabla
 GET /weathers -> muestra el clima de todas las ciudades en todos los días.
 GET /weathers/{lat1}/{lat2}/{longitud1}/{longitud2} -> donde se muestra el tiempo del día actual para las ciudades que cumplen con la1 < lat < lat2 y longitud1 < longitud < longitud2
 GET /weather/{name} -> muestra el clima del día actual de la ciudad con nombre name como por ejemplo /weather/Santiago, /weather/Lima.


Para llevar acabo lo anterior se utilizo MYSQL mediante google cloud.
