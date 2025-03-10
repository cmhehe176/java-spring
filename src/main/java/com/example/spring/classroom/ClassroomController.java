package com.example.spring.classroom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.classroom.dto.request.GetDetailClassroomReqDto;
import com.example.spring.classroom.dto.request.GetListClassroomReqDto;
import com.example.spring.classroom.dto.response.GetDetailClassroomDto;
import com.example.spring.classroom.dto.response.GetListClassroomDto;

@RestController
@RequestMapping("classroom")
public class ClassroomController {
	@Autowired
	private ClassroomService classroomService;

	@GetMapping("/{id}")
	Optional<GetDetailClassroomDto> getDetailClassroom(@PathVariable Long id) {

		return this.classroomService.getDetailClassroom(new GetDetailClassroomReqDto(id).getId());
	}

	@GetMapping()
	List<GetListClassroomDto> getListClassroom(@RequestParam(defaultValue = "") List<String> relations) {

		return this.classroomService.getListClassroom(new GetListClassroomReqDto(relations).getRelations());
	}
}
