package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.AttestationThemeDTO;
import ova.example.adminpanel.models.AttestationTheme;
import ova.example.adminpanel.models.Course;
import ova.example.adminpanel.repository.AttestationThemeRepository;
import ova.example.adminpanel.service.AttestationThemeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttestationThemeServiceImpl implements AttestationThemeService {
    private final AttestationThemeRepository attestationThemeRepo;
    private final CourseServiceImpl courseService;

    @Override
    public List<AttestationThemeDTO> getAllAttestationTheme() {
        List<AttestationThemeDTO> attestationThemeDTOList = new ArrayList<>();
        for(AttestationTheme attestationTheme : attestationThemeRepo.findAll()){
            attestationThemeDTOList.add(AttestationThemeDTO.fromModel(attestationTheme));
        }
        return attestationThemeDTOList;
    }

    @Override
    public AttestationThemeDTO getAttestationThemeById(Long id) {
        Optional<AttestationTheme> attestationThemeOptional= attestationThemeRepo.findById(id);
        if(attestationThemeOptional.isEmpty()){
            log.info("Аттестационная тема с id - {} не существует", id);
        }
        return AttestationThemeDTO.fromModel(attestationThemeOptional.get());
    }

    @Override
    public AttestationThemeDTO createAttestationTheme(AttestationThemeDTO attestationThemeDTO) {
        AttestationTheme attestationTheme = new AttestationTheme(attestationThemeDTO);
        Course course = new Course(courseService.getCourseById(attestationThemeDTO.getId()));
        attestationTheme.setCourse(course);

        return AttestationThemeDTO.fromModel(attestationThemeRepo.saveAndFlush(attestationTheme));
    }

    @Override
    public AttestationThemeDTO updateAttestationTheme(AttestationThemeDTO details) {
        Optional<AttestationTheme> attestationThemeOptional = attestationThemeRepo.findById(details.getId());
        if(attestationThemeOptional.isEmpty()){
            log.info("Аттестационная тема с id - {} не существует", details.getId());
        }
        AttestationTheme attestationTheme = attestationThemeOptional.get();
        attestationTheme.setTheme(details.getTheme());
        Course course = new Course(courseService.getCourseById(details.getId()));
        attestationTheme.setCourse(course);

        return AttestationThemeDTO.fromModel(attestationThemeRepo.saveAndFlush(attestationTheme));
    }

    @Override
    public void deleteAttestationTheme(Long id) {
        attestationThemeRepo.deleteById(id);
    }
}
