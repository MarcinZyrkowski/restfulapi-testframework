package org.example.generator;

import org.example.model.service.Item;
import org.example.model.utils.*;
import org.example.utils.EnumUtils;
import org.example.utils.FakerUtils;

import java.time.LocalDate;
import java.util.Random;

public class ItemGenerator {

    private static final Random RANDOM = new Random();

    public static Item generateRandomItem() {
        int minPrice = 1;
        int maxPrice = 10_000;
        int minYear = 2010;

        Device device = RANDOM.nextBoolean() ? Device.PHONE : Device.LAPTOP;

        Item item = Item.builder()
                .name(device == Device.PHONE
                        ? EnumUtils.getRandom(Phone.class).getName()
                        : EnumUtils.getRandom(Laptop.class).getName())
                .data(Item.Data.builder()
                        .year(RANDOM.nextInt(minYear, LocalDate.now().getYear()))
                        .color(EnumUtils.getRandom(Colors.class).getName())
                        .price((double) FakerUtils.getFaker().number().numberBetween(minPrice, maxPrice))
                        .cpuModel(EnumUtils.getRandom(CpuModel.class).getModelName())
                        .build())
                .build();

        if (device == Device.PHONE) {
            item = item.toBuilder()
                    .data(item.data().toBuilder()
                            .capacity(EnumUtils.getRandom(Capacity.class).getSize())
                            .build())
                    .build();
        }

        if (device == Device.LAPTOP) {
            item = item.toBuilder()
                    .data(item.data().toBuilder()
                            .hardDiskSize(EnumUtils.getRandom(HardDiskSize.class).getSize())
                            .build())
                    .build();
        }

        return item;
    }

    private enum Device {
        PHONE, LAPTOP
    }

}
