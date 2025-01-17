package ru.sccs.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDish {

    // Название блюда
    private String name;

    // Состав блюда
    private List<MenuIngredient> composition;
}
