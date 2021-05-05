package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.ThemeDetailsDTO;
import ova.example.adminpanel.models.ProgramDetails;
import ova.example.adminpanel.models.ThemeDetails;
import ova.example.adminpanel.repository.ProgramDetailsRepository;
import ova.example.adminpanel.repository.ThemeDetailsRepository;
import ova.example.adminpanel.service.ThemeDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThemeDetailsServiceImpl implements ThemeDetailsService {
    private final ThemeDetailsRepository themeDetailsRepo;
    private final ProgramDetailsRepository programDetailsRepo;

    @Override
    public List<ThemeDetailsDTO> getAllThemeDetails() {
        List<ThemeDetailsDTO> themeDetailsDTOList = new ArrayList<>();
        for(ThemeDetails td : themeDetailsRepo.findAll()){
            themeDetailsDTOList.add(ThemeDetailsDTO.fromModel(td));
        }
        return themeDetailsDTOList;
    }

    @Override
    public ThemeDetailsDTO getThemeDetailsById(Long id) {
        Optional<ThemeDetails> optionalProgramDetails = themeDetailsRepo.findById(id);
        if(optionalProgramDetails.isEmpty()){
            log.error("Тема с id - {} не найден", id);
        }
        ThemeDetails themeDetails = optionalProgramDetails.get();

        return ThemeDetailsDTO.fromModel(themeDetails);
    }

    @Override
    public ThemeDetailsDTO createThemeDetails(ThemeDetailsDTO themeDetailsDTO) {
        ThemeDetails themeDetails = new ThemeDetails(themeDetailsDTO);
        Optional<ProgramDetails> optionalProgramDetails = programDetailsRepo.findById(themeDetailsDTO.getProgramDetailsId());
        if(optionalProgramDetails.isEmpty()){
            log.error("Программа курса с id - {} не найдена", themeDetailsDTO.getProgramDetailsId());
        }
        themeDetails.setProgramDetails(optionalProgramDetails.get());

        return ThemeDetailsDTO.fromModel(themeDetailsRepo.saveAndFlush(themeDetails));
    }

    @Override
    public ThemeDetailsDTO updateThemeDetails(ThemeDetailsDTO details) {
        Optional<ThemeDetails> optionalThemeDetails = themeDetailsRepo.findById(details.getId());
        if(optionalThemeDetails.isEmpty()){
            log.error("Тема с id - {} не найден", details.getId());
        }
        ThemeDetails themeDetails = optionalThemeDetails.get();
        themeDetails.setTopic(details.getTopic());

        return ThemeDetailsDTO.fromModel(themeDetailsRepo.saveAndFlush(themeDetails));
    }

    @Override
    public void deleteThemeDetails(Long id) {
        themeDetailsRepo.deleteById(id);
    }
}
