package ova.example.adminpanel.utils;

import lombok.Getter;

@Getter
public enum RolesEnum {
    USER(1l),
    ADMIN(2l),
    TEACHER(3l),
    STUDENT(4l);

    private final long value;

    RolesEnum(long value) {
        this.value = value;
    }
}
