package edu.eiu.service;

import edu.eiu.entity.Major;
import edu.eiu.repository.MajorRepo;
import java.util.List;

public class MajorService {
    public void createMajor(Major major) {
        MajorRepo.save(major);
    }

    public void updateMajor(Major major) {
        MajorRepo.update(major);
    }

    public void deleteMajor(Major major) {
        MajorRepo.remove(major);
    }

    public Major getMajorById(String majorId) {
        return MajorRepo.findById(majorId);
    }

    public List<Major> getAllMajors() {
        return MajorRepo.findAll();
    }

    public List<Major> findMajorsByName(String name) {
        return MajorRepo.findByName(name);
    }
}
