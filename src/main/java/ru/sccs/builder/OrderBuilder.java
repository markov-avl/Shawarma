package ru.sccs.builder;

import ru.sccs.model.Order;
import ru.sccs.model.OrderPosition;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    private final List<OrderPosition> positions = new ArrayList<>();

    public OrderBuilder addPosition(OrderPosition position) {
        positions.add(position);
        return this;
    }

    public OrderBuilder removePosition(int position) {
        positions.remove(position);
        return this;
    }

    public Order build() {
        return new Order(positions);
    }

}
