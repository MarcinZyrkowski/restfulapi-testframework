package org.example.model.service.restfulapi.item;

import java.util.List;
import lombok.Builder;

@Builder
public record ItemListWrapper(List<Item> itemList) {

}
