package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.ProgramDetailsDTO;
import ova.example.adminpanel.DTO.ThemeDetailsDTO;
import ova.example.adminpanel.service.ThemeDetailsService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThemeDetailsServiceImpl implements ThemeDetailsService {
    @Override
    public List<ThemeDetailsDTO> getAllThemeDetails() {
        return null;
    }

    @Override
    public ProgramDetailsDTO getThemeDetailsById(Long id) {
        return null;
    }

    @Override
    public ThemeDetailsDTO createThemeDetailsDTO(ThemeDetailsDTO themeDetailsDTO) {
        return null;
    }

    @Override
    public ThemeDetailsDTO updateThemeDetailsDTO(ThemeDetailsDTO details) {
        return null;
    }

    @Override
    public void deleteThemeDetailsDTO(Long id) {

    }
}
