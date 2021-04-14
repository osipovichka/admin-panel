package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.GroupDTO;
import ova.example.adminpanel.models.Group;
import ova.example.adminpanel.repository.GroupRepository;
import ova.example.adminpanel.service.GroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepo;

    @Override
    public List<GroupDTO> getAllGroup() {
        List<GroupDTO> lGroupDto = new ArrayList<>();
        for (Group gr: groupRepo.findAll()) {
            lGroupDto.add(GroupDTO.fromModel(gr));
        }

        return lGroupDto;
    }

    @Override
    public GroupDTO getGroupById(long id) {
        GroupDTO groupDTO = null;
        try {
            groupDTO = GroupDTO.fromModel(groupRepo.findById(id).orElseThrow());
        } catch (NoSuchElementException e) {
            log.error("Группа с id - {} не найден в БД {}", id, e.getMessage(), e);
        }
        return groupDTO;
    }

    @Override
    public GroupDTO createGroup(GroupDTO groupDTO) {
        return null;
    }

    @Override
    public GroupDTO updateGroup(GroupDTO groupDetails) {
        return null;
    }

    @Override
    public void deleteGroup(long id) {

    }
}
