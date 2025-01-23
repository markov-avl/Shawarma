package ru.sccs.model.recipe;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sccs.command.Command;


@Data
@RequiredArgsConstructor
public class RecipeStep {

    private final Command command;

}
