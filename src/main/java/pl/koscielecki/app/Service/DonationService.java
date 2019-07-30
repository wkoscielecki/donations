package pl.koscielecki.app.Service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.koscielecki.app.Repository.DonationRepository;
import pl.koscielecki.app.model.Donation;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class DonationService {

    @Autowired
    DonationRepository donationRepository;

    public void save(Donation donation){
        donation.setDonated(false);
        donation.setCreationTime(LocalDateTime.now());
        donation.setPickedUp(false);
        donationRepository.save(donation);
    }
    public void delete(Long id){
        donationRepository.deleteById(id);
    }
    public void update(Donation donation){
        donationRepository.save(donation);
    }

    public List<Donation> findAll(){
        return donationRepository.findAll();
    }
    public List<Donation> pickedUpListASC(){
        return donationRepository.findAll(sortBy("ASC", "pickedUp"));
    }

    public List<Donation> findAllSortedByAcualDate(){
        return donationRepository.findAll(sortBy("ASC","actualPickUpDate"));
    }
    public List<Donation> findAllSortedByCreationDate(){
        return donationRepository.findAll(sortBy("ASC","creationTime"));
    }


    private Sort sortBy(String sort, String status) {
        return new Sort(Sort.Direction.fromString(sort),status);
    }
}
