package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.repository.FacultyRepository;
import edu.miu.waabackend.service.IFacultyService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService implements IFacultyService {

    private FacultyRepository facultyRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, DtoUtils dtoUtils) {
        this.facultyRepository = facultyRepository;
        this.dtoUtils = dtoUtils;
    }
}
