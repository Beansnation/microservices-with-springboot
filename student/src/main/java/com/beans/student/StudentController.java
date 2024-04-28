package com.beans.student;

import com.beans.library.dtos.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<List<Student>> createStudents(@RequestBody List<Student> students){
        return ResponseEntity.ok(studentService.createStudents(students));
    }

    @GetMapping("/get/{school-id}")
    public List<StudentDto> findStudentsBySchoolId(@PathVariable("school-id") Integer schoolId){
        return studentService.findStudentsBySchoolId(schoolId);
    }
}
