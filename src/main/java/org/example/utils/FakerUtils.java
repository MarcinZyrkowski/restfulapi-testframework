package org.example.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FakerUtils {

    @Getter
    private static final Faker faker = new Faker();

    @Getter
    private static final FakeValuesService fakeValuesService = new FakeValuesService(Locale.getDefault(), new RandomService());

}
