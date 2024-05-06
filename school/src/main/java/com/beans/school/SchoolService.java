package com.beans.school;

import com.beans.library.dtos.FullSchoolResponse;
import com.beans.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId, String token) {
        var school = schoolRepository.findById(schoolId)
                .orElseThrow( ()-> new RuntimeException("school does not exist"));
        var students = studentClient.findSchoolsWithStudentsUsingSchoolId(schoolId, token);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
