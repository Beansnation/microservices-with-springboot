package com.beans.library.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {
    private String name;
    private String email;
    private List<StudentDto> students;
}