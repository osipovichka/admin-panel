package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.ProgramDetailsDTO;
import ova.example.adminpanel.models.CourseProgram;
import ova.example.adminpanel.models.ProgramDetails;
import ova.example.adminpanel.repository.CourseProgramRepository;
import ova.example.adminpanel.repository.ProgramDetailsRepository;
import ova.example.adminpanel.service.ProgramDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProgramDetailsServiceImpl implements ProgramDetailsService {

    private final ProgramDetailsRepository programDetailsRepo;
    private  final CourseProgramRepository courseProgramRepo;

    @Override
    public List<ProgramDetailsDTO> getAllProgramDetails() {
        List<ProgramDetailsDTO> programDetailsDTOList = new ArrayList<>();
        for(ProgramDetails pd : programDetailsRepo.findAll()){
            programDetailsDTOList.add(ProgramDetailsDTO.fromModel(pd));
        }

        return programDetailsDTOList;
    }

    @Override
    public ProgramDetailsDTO getProgramDetailsById(Long id) {
        Optional<ProgramDetails> programDetailsOptional = programDetailsRepo.findById(id);
        if(programDetailsOptional.isEmpty()){
            log.error("Модуль с id - {} не найден", id);
        }
        ProgramDetails programDetails = programDetailsOptional.get();

        return ProgramDetailsDTO.fromModel(programDetails);
    }

    @Override
    public ProgramDetailsDTO createProgramDetails(ProgramDetailsDTO programDetailsDTO) {
        ProgramDetails programDetails = new ProgramDetails(programDetailsDTO);
        Optional<CourseProgram> courseProgramOptional = courseProgramRepo.findById(programDetailsDTO.getCourseProgramId());
        if(courseProgramOptional.isEmpty()){
            log.error("Программа курса с id {} не существует", programDetailsDTO.getCourseProgramId());
        }
        CourseProgram courseProgram = courseProgramOptional.get();
        programDetails.setCourseProgram(courseProgram);
        ProgramDetailsDTO programDetailsDto = ProgramDetailsDTO.fromModel(programDetailsRepo.saveAndFlush(programDetails));

        return programDetailsDto;
    }

    @Override
    public ProgramDetailsDTO updateProgramDetails(ProgramDetailsDTO details) {
        Optional<ProgramDetails> programDetailsOptional = programDetailsRepo.findById(details.getId());
        if(programDetailsOptional.isEmpty()){
            log.error("Программа курса с id - {} не существует", details.getId());
        }
        ProgramDetails programDetails = programDetailsOptional.get();
        programDetails.setLessonNumber(details.getLessonNumber());
        programDetails.setLessonTheme(details.getLessonTheme());
        ProgramDetailsDTO programDetailsDTO = ProgramDetailsDTO.fromModel(programDetailsRepo.saveAndFlush(programDetails));

        return programDetailsDTO;
    }

    @Override
    public void deleteProgramDetails(Long id) {
        programDetailsRepo.deleteById(id);
    }
}
