package com.workintech.university.service;

import com.workintech.university.entity.University;
import com.workintech.university.exceptions.UniversityNotFoundException;
import com.workintech.university.repository.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService{
    @Autowired
    private final UniversityRepository universityRepository;

    @Override
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    @Override
    public University findById(Long id) {
        return universityRepository
                .findById(id)
                .orElseThrow(()-> new UniversityNotFoundException(id+"li university bulunamadı"));
    }

    @Override
    public University create(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University replaceOrCreate(Long id, University university) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if(optionalUniversity.isPresent()){
            university.setId(id);
            return universityRepository.save(university);
        }
        return universityRepository.save(university);
    }

    @Override
    public University update(Long id, University university) {
        University universityToUpdate = universityRepository
                .findById(id)
                .orElseThrow(()-> new UniversityNotFoundException(id+"li university bulunamadı"));
        if(university.getName() != null) university.setName(university.getName());

        return universityRepository.save(universityToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        universityRepository.deleteById(id);
    }
}
