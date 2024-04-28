package com.beans.student;

import com.beans.library.dtos.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> createStudents(List<Student> students) {
        students.forEach(student -> {
            if (student.getSchoolId() == null)
                throw new RuntimeException("school id cannot be empty");
        });
        return studentRepository.saveAll(students);
    }

    public List<StudentDto> findStudentsBySchoolId(Integer schoolId) {
        List<Student> students = studentRepository.findAllBySchoolId(schoolId);
        return students.stream()
                .map(student -> {
                    StudentDto dto = new StudentDto();
                    BeanUtils.copyProperties(student, dto);
                    return dto;
                }).toList();
    }
}