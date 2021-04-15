package ova.example.adminpanel.utils;

import lombok.Getter;

@Getter
public enum RolesEnum {
    USER(1l),
    ADMIN(2l),
    TEACHER(3l),
    STUDENT(4l);

    private final Long value;

    RolesEnum(Long value) {
        this.value = value;
    }
}
