package pl.koscielecki.app.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.koscielecki.app.Repository.InstitutionsRepository;
import pl.koscielecki.app.model.TrustedInstitutions;

import java.util.List;

@Service
@Transactional
public class InstitutionsService {

    @Autowired
    InstitutionsRepository institutionsRepository;

    public List<TrustedInstitutions> findAll(){return institutionsRepository.findAll();
    }
    public void save(TrustedInstitutions institutions){
        institutionsRepository.save(institutions);
    }
    public void delete(Long id){
        institutionsRepository.deleteById(id);
    }
}
