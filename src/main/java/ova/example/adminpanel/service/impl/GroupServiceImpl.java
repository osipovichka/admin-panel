package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.GroupDTO;
import ova.example.adminpanel.models.CourseProgram;
import ova.example.adminpanel.models.Group;
import ova.example.adminpanel.repository.GroupRepository;
import ova.example.adminpanel.service.GroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepo;
    private final CourseProgramServiceImpl courseProgramService;

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
        Group group = new Group(groupDTO);
        CourseProgram courseProgram = new CourseProgram(courseProgramService.getCourseProgramById(groupDTO.getCourseProgramId()));
        group.setCourseProgram(courseProgram);
        GroupDTO groupDto = GroupDTO.fromModel(groupRepo.saveAndFlush(group));
        return groupDto;
    }

    @Override
    public GroupDTO updateGroup(GroupDTO groupDetails) {
        Optional<Group> opGroup = groupRepo.findById(groupDetails.getId());
        if (opGroup.isEmpty()){
            log.error("Группа с id - {} не найдена", groupDetails.getId());
        }
        Group group = opGroup.get();
        group.setStartDate(groupDetails.getStartDate());
        group.setEndDate(groupDetails.getEndDate());
        groupRepo.saveAndFlush(group);

        return GroupDTO.fromModel(group);
    }

    @Override
    public void deleteGroup(long id) {
        groupRepo.deleteById(id);
    }
}
