package  com.example.tiempo1.repository;

import com.example.tiempo1.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface WeatherRepository extends JpaRepository<Weather,Integer>{
    Weather findByNameAndDate(String name, String date);
    List<Weather> findByLatGreaterThanEqualAndLatLessThanEqualAndLongitudGreaterThanEqualAndLongitudLessThanEqualAndDate(int lat1, int lat2, int longitud1, int longitud2, String date);
}