Para correr el archivo, usar: './gradlew bootRun'<br />
Lo anterior correra en http://localhost:8080

Base de datos:

Tabla: weather_tbl (id int, name varchar(20), wind float, cloud float, temp float, date varchar(20))<br />
Se usó la tabla anterior por simplicidad del ejercicio ya que  no se utiliza una gran base de datos.<br />

Endpoints:<br />
 GET /weathers/{lat1}/{lat2}/{longitud1}/{longitud2} -> donde se muestra el tiempo del día actual para las ciudades que cumplen con la1 < lat < lat2 y longitud1 < longitud < longitud2 y zoom 10 (por default)<br />
 GET /weather/{name} -> muestra el clima del día actual de la ciudad con nombre name como por ejemplo /weather/Santiago, /weather/Lima.<br />


Para llevar acabo lo anterior se utilizo MYSQL mediante google cloud.
