package edu.eiu.service;

import edu.eiu.entity.School;
import edu.eiu.reposibility.SchoolRepo;
import java.util.List;

public class SchoolService {
    public void createSchool(School school) {
        SchoolRepo.save(school);
    }

    public void updateSchool(School school) {
        SchoolRepo.update(school);
    }

    public void deleteSchool(School school) {
        SchoolRepo.remove(school);
    }

    public School getSchoolById(String schoolId) {
        return SchoolRepo.findById(schoolId);
    }

    public List<School> getAllSchools() {
        return SchoolRepo.findAll();
    }

    public List<School> findSchoolsByName(String name) {
        return SchoolRepo.findByName(name);
    }
}
