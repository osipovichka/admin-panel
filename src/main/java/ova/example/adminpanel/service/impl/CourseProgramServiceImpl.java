package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.CourseProgramDTO;
import ova.example.adminpanel.models.Course;
import ova.example.adminpanel.models.CourseProgram;
import ova.example.adminpanel.repository.CourseProgramRepository;
import ova.example.adminpanel.repository.CourseRepository;
import ova.example.adminpanel.service.CourseProgramService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseProgramServiceImpl implements CourseProgramService {
    private final CourseProgramRepository courseProgramRepo;
    private final CourseRepository courseRepo;

    @Override
    public List<CourseProgramDTO> getAllCourseProgram() {
        List<CourseProgramDTO> courseProgramDTOList = new ArrayList<>();
        for(CourseProgram courseProgram : courseProgramRepo.findAll()){
            courseProgramDTOList.add(CourseProgramDTO.fromModel(courseProgram));
        }
        return courseProgramDTOList;
    }

    @Override
    public CourseProgramDTO getCourseProgramById(Long id) {
        Optional<CourseProgram> courseProgramOptional = courseProgramRepo.findById(id);
        if(courseProgramOptional.isEmpty()){
            log.error("Программа с id - {} не найдена", id);
        }
        return CourseProgramDTO.fromModel(courseProgramOptional.get());
    }

    @Override
    public CourseProgramDTO createCourseProgram(CourseProgramDTO courseProgramDTO) {
        CourseProgram courseProgram = new CourseProgram(courseProgramDTO);
        Optional<Course> courseOptional = courseRepo.findById(courseProgramDTO.getCourseId());
        if(courseOptional.isEmpty()){
            log.error("Курса с id {} для программы {} не существует", courseProgramDTO.getCourseId(), courseProgramDTO.getTitle());
        }
        Course course = courseOptional.get();
        courseProgram.setCourse(course);
        CourseProgramDTO courseProgDTO = CourseProgramDTO.fromModel(courseProgramRepo.saveAndFlush(courseProgram));
        return courseProgDTO;
    }

    @Override
    public CourseProgramDTO updateCourseProgram(CourseProgramDTO courseProgramDetails) {
        Optional<CourseProgram> courseProgramOptional = courseProgramRepo.findById(courseProgramDetails.getId());
        if(courseProgramOptional.isEmpty()){
            log.error("Программа с id - {} не найдена", courseProgramDetails.getId());
        }
        CourseProgram courseProgram = courseProgramOptional.get();
        courseProgram.setActual(courseProgramDetails.isActual());
        courseProgram.setTitle(courseProgramDetails.getTitle());
        courseProgramRepo.saveAndFlush(courseProgram);

        return CourseProgramDTO.fromModel(courseProgram);
    }

    @Override
    public void deleteCourseProgram(Long id) {
        courseProgramRepo.deleteById(id);
    }
}
