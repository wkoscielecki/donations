package pl.koscielecki.app.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.koscielecki.app.Repository.ItemsRepository;
import pl.koscielecki.app.model.Items;

import java.util.List;

@Service
@Transactional
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public List<Items> findAll(){
        return itemsRepository.findAll();
    }
    public void save(Items item){
        itemsRepository.save(item);
    }
    public void delete(Long id){
        itemsRepository.deleteById(id);
    }
}
