package ova.example.adminpanel.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.repository.RoleRepository;
import ova.example.adminpanel.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepo;

    @Mock
    private RoleRepository roleRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() {
        UserDTO user = new UserDTO();

        User dbUser = new User();
        Set<Role> role = new HashSet<>();
        role.add(new Role());
        dbUser.setRoles(role);

        Mockito.when(roleRepo.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(new Role()));
        Mockito.when(userRepo.saveAndFlush(ArgumentMatchers.any())).thenReturn(dbUser);

        userService.createUser(user);

        Mockito.verify(roleRepo, Mockito.times(1)).findById(1l);
        Mockito.verify(userRepo, Mockito.times(1)).saveAndFlush(dbUser);

    }

}