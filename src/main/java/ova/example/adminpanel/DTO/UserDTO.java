package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.CourseProgramSkill;
import ova.example.adminpanel.models.Group;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date birthDate;
    private String email;
    private String phone;
    private Long cityId;

    private Set<Role> roles;

    @JsonProperty("studentGroup")
    private Set<Group> group;

    @JsonProperty("teacherGroup")
    private Set<Group> groups;

    private Set<CourseProgramSkill> skills;

    public static UserDTO fromModel(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPatronymic(user.getPatronymic());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setCityId(user.getCityId());

        Set<Role> roles = new HashSet<>();
        for (Role r: user.getRoles()) {
            roles.add(r);
            user.setRoles(roles);
        }

        return userDTO;
    }
}