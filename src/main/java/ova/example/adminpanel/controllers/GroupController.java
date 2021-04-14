package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ova.example.adminpanel.DTO.GroupDTO;
import ova.example.adminpanel.service.impl.GroupServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupServiceImpl groupService;

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroup(){
        return ResponseEntity.ok(groupService.getAllGroup());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroupById(long id){
        return ResponseEntity.ok(groupService.getGroupById(id));
    }
}
