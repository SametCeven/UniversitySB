package com.workintech.university.service;

import com.workintech.university.entity.Department;
import com.workintech.university.exceptions.DepartmentNotFoundException;
import com.workintech.university.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository
                .findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id +"li depatment bulunamadı."));
    }

    @Override
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department replaceOrCreate(Long id, Department department) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isPresent()){
            department.setId(id);
            return departmentRepository.save(department);
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Long id, Department department) {
        Department departmentToUpdate = departmentRepository
                .findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id +"li depatment bulunamadı."));
        if(department.getName() != null) departmentToUpdate.setName(department.getName());
        if(department.getFaculty() != null) departmentToUpdate.setFaculty(department.getFaculty());
        return departmentRepository.save(departmentToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
