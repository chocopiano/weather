package  com.example.tiempo1.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.tiempo1.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface WeatherRepository extends CrudRepository<Weather, Integer>{}