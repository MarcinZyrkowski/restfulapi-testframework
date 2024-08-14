package org.example.model.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Capacity {

    C128GB(128),
    C256GB(256),
    C512GB(512),
    C1TB(1024),
    C2TB(2048);

    private final int size;

}
