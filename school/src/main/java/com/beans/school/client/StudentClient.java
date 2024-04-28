package com.beans.school.client;


import com.beans.library.dtos.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "school-service", url = "${service.students-url}")
public interface StudentClient {

    @GetMapping("/get/{school-id}")
    List<StudentDto> findSchoolsWithStudentsUsingSchoolId(@PathVariable("school-id") Integer schoolId);
}