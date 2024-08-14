package org.example.model.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Colors {

    RED("RED"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    CYAN("CYAN"),
    MAGENTA("MAGENTA"),
    ORANGE("ORANGE"),
    PURPLE("PURPLE"),
    BLACK("BLACK"),
    WHITE("WHITE");

    private final String name;
}
