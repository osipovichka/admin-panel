package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @PostMapping
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO groupDTO){
        return ResponseEntity.ok(groupService.createGroup(groupDTO));
    }

    @PutMapping
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDetails){
        if(groupDetails.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(groupService.updateGroup(groupDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGroup(@PathVariable long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        groupService.deleteGroup(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
