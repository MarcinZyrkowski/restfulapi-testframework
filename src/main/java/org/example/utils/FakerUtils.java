package org.example.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FakerUtils {

  @Getter
  private static final Faker faker = new Faker();

  @Getter
  private static final FakeValuesService fakeValuesService =
      new FakeValuesService(Locale.getDefault(), new RandomService());
}
