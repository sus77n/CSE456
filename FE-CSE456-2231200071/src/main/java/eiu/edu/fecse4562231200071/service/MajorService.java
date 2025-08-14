package eiu.edu.fecse4562231200071.service;

import eiu.edu.fecse4562231200071.entity.Major;
import eiu.edu.fecse4562231200071.repo.MajorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    private MajorRepo majorRepo;

    public void save(Major major){
        majorRepo.save(major);
    }

    public List<Major> getAllMajors() {
        return majorRepo.findAll();
    }
}
