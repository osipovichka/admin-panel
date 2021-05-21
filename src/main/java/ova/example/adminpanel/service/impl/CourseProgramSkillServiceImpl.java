package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.CourseProgramSkillDTO;
import ova.example.adminpanel.models.CourseProgram;
import ova.example.adminpanel.models.CourseProgramSkill;
import ova.example.adminpanel.repository.CourseProgramSkillRepository;
import ova.example.adminpanel.service.CourseProgramService;
import ova.example.adminpanel.service.CourseProgramSkillService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseProgramSkillServiceImpl implements CourseProgramSkillService {
    private final CourseProgramSkillRepository courseProgramSkillRepo;
    private final CourseProgramService courseProgramService;

    @Override
    public List<CourseProgramSkillDTO> getAllCourseProgramSkill() {
        List<CourseProgramSkillDTO> courseProgramSkillDTOList = new ArrayList<>();
        for (CourseProgramSkill courseProgramSkill : courseProgramSkillRepo.findAll()){
            courseProgramSkillDTOList.add(CourseProgramSkillDTO.fromModel(courseProgramSkill));
        }
        return courseProgramSkillDTOList;
    }

    @Override
    public CourseProgramSkillDTO getCourseProgramSkillById(Long id) {
        Optional<CourseProgramSkill> courseProgramSkillOptional = courseProgramSkillRepo.findById(id);
        if(courseProgramSkillOptional.isEmpty()){
            log.error("Скилл с id - {} не найден", id);
        }

        return CourseProgramSkillDTO.fromModel(courseProgramSkillOptional.get());
    }

    @Override
    public CourseProgramSkillDTO createAndUpdateCourseProgramSkill(CourseProgramSkillDTO courseProgramSkillDTO) {
        Optional<CourseProgramSkill> courseProgramSkillOptional = courseProgramSkillRepo.findById(courseProgramSkillDTO.getId());
        CourseProgramSkill courseProgramSkill;
        if(courseProgramSkillOptional.isEmpty()){
            courseProgramSkill = new CourseProgramSkill(courseProgramSkillDTO);
            CourseProgram courseProgram = new CourseProgram(courseProgramService.getCourseProgramById(courseProgramSkillDTO.getCourseProgramId()));
            courseProgramSkill.setCourseProgram(courseProgram);
        } else {
            courseProgramSkill = courseProgramSkillOptional.get();
            courseProgramSkill.setName(courseProgramSkillDTO.getName());
        }
        return CourseProgramSkillDTO.fromModel(courseProgramSkillRepo.saveAndFlush(courseProgramSkill));
    }

    @Override
    public void deleteCourseProgramSkill(Long id) {
        courseProgramSkillRepo.deleteById(id);
    }
}
