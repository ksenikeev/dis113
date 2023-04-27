package ru.itis.lab2_10.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class GroupDto {
    private Long id;
    private String groupp;

    @Override
    public String toString() {
        return "GroupDto{" +
                "id=" + id +
                ", groupp='" + groupp + '\'' +
                '}';
    }
}
