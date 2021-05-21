package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.UserAttestationDTO;
import ova.example.adminpanel.models.AttestationTheme;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.models.UserAttestation;
import ova.example.adminpanel.repository.UserAttestationRepository;
import ova.example.adminpanel.service.UserAttestationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAttestationServiceImpl implements UserAttestationService {
    private final UserAttestationRepository userAttestationRepo;
    private final UserServiceImpl userService;
    private final AttestationThemeServiceImpl attestationThemeService;

    @Override
    public List<UserAttestationDTO> getAllUserAttestation() {
        List<UserAttestationDTO> attestationDTOList = new ArrayList<>();
        for (UserAttestation userAttestation : userAttestationRepo.findAll()){
            attestationDTOList.add(UserAttestationDTO.fromModel(userAttestation));
        }

        return attestationDTOList;
    }

    @Override
    public UserAttestationDTO getUserAttestationById(Long id) {
        Optional<UserAttestation> userAttestation = userAttestationRepo.findById(id);
        if(userAttestation.isEmpty()){
            log.error("Аттестация с id - {} не найдена", id);
        }

        return UserAttestationDTO.fromModel(userAttestation.get());
    }

    @Override
    public UserAttestationDTO createAndUpdateUserAttestation(UserAttestationDTO userAttestationDTO) {
        Optional<UserAttestation> userAttestationOptional = userAttestationRepo.findById(userAttestationDTO.getId());
        UserAttestation userAttestation;
        if(userAttestationOptional.isEmpty()){
            userAttestation = new UserAttestation(userAttestationDTO);
            User user = new User(userService.getUserById(userAttestationDTO.getUserId()));
            userAttestation.setUser(user);
            AttestationTheme attestationTheme = new AttestationTheme(attestationThemeService
                    .getAttestationThemeById(userAttestationDTO.getAttestationThemeId()));
            userAttestation.setAttestationTheme(attestationTheme);
        } else {
            userAttestation = userAttestationOptional.get();
            userAttestation.setTheoryPassed(userAttestationDTO.isTheoryPassed());
            userAttestation.setPracticePassed(userAttestationDTO.isPracticePassed());
        }
        return UserAttestationDTO.fromModel(userAttestationRepo.saveAndFlush(userAttestation));
    }

    @Override
    public void deleteUserAttestation(long id) {
        userAttestationRepo.deleteById(id);
    }
}
