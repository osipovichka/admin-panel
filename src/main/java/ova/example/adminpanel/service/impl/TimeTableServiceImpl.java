package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.TimeTableDTO;
import ova.example.adminpanel.models.Group;
import ova.example.adminpanel.models.TimeTable;
import ova.example.adminpanel.repository.GroupRepository;
import ova.example.adminpanel.repository.TimeTableRepository;
import ova.example.adminpanel.service.TimeTableService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository timeTableRepo;
    private final GroupServiceImpl groupService;

    @Override
    public List<TimeTableDTO> getAllTimeTable() {
        List<TimeTableDTO> timeTableDTOList = new ArrayList<>();
        for(TimeTable timeTable : timeTableRepo.findAll()){
            timeTableDTOList.add(TimeTableDTO.fromModel(timeTable));
        }
        return timeTableDTOList;
    }

    @Override
    public TimeTableDTO getTimeTableById(Long id) {
        Optional<TimeTable> optionalTimeTable = timeTableRepo.findById(id);
        if(optionalTimeTable.isEmpty()){
            log.error("Расписание с id - {} не найден", id);
        }

        return TimeTableDTO.fromModel(optionalTimeTable.get());
    }

    @Override
    public TimeTableDTO createTimeTable(TimeTableDTO timeTableDTO) {
        TimeTable timeTable = new TimeTable(timeTableDTO);
        Group group = new Group(groupService.getGroupById(timeTableDTO.getGroupId()));
        timeTable.setGroup(group);
        return TimeTableDTO.fromModel(timeTableRepo.saveAndFlush(timeTable));
    }

    @Override
    public TimeTableDTO updateTimeTable(TimeTableDTO details) {
        Optional<TimeTable> optionalTimeTable = timeTableRepo.findById(details.getId());
        if(optionalTimeTable.isEmpty()){
            log.error("Расписание с id - {} не найден", details.getId());
        }
        TimeTable timeTable = optionalTimeTable.get();
        timeTable.setRoomNumber(details.getRoomNumber());
        timeTable.setDay(details.getDay());
        timeTable.setTimeStart(details.getTimeStart());
        timeTable.setTimeEnd(details.getTimeEnd());

        return TimeTableDTO.fromModel(timeTableRepo.saveAndFlush(timeTable));
    }

    @Override
    public void deleteTimeTable(Long id) {
        timeTableRepo.deleteById(id);
    }
}
