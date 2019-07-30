package pl.koscielecki.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.koscielecki.app.Repository.CityRepository;
import pl.koscielecki.app.model.City;

import java.util.List;

@Service
@Transactional
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public void save(City city){
        cityRepository.save(city);
    }
    public void delete(Long id){
        cityRepository.deleteById(id);
    }
    public List<City> all()    {
        return cityRepository.findAll();
    }
   public City findById(Long id){
        return cityRepository.findById(id).get();
   }
}
