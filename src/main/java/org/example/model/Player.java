package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {

    public String name;
    public int age;
    public int experience;
    public List<Integer> skills;
}
