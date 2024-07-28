package bg.softuni.clothing_store.clothing_store_orders.model.dto;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangeStatusDto {
    private StatusType status;
}
