Para correr el archivo, usar: './gradlew bootRun'<br />
Lo anterior correra en http://localhost:8080

Base de datos:

Tabla: weather_tbl (id int, name varchar(20), lat int, longitud int, wind int, cloud int, temp int, date varchar(20))<br />
Se usó la tabla anterior por simplicidad del ejercicio ya que  no se utiliza una gran base de datos sino que solo se usó Santiago y Lima con los días 3,4,5 y 6 de mayo.<br />

Endpoints:<br />
 POST /addWeather -> agrega un nuevo atributo a la tabla<br />
 GET /weathers -> muestra el clima de todas las ciudades en todos los días.<br />
 GET /weathers/{lat1}/{lat2}/{longitud1}/{longitud2} -> donde se muestra el tiempo del día actual para las ciudades que cumplen con la1 < lat < lat2 y longitud1 < longitud < longitud2<br />
 GET /weather/{name} -> muestra el clima del día actual de la ciudad con nombre name como por ejemplo /weather/Santiago, /weather/Lima.<br />


Para llevar acabo lo anterior se utilizo MYSQL mediante google cloud.
