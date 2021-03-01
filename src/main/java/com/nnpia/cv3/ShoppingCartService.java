package com.nnpia.cv3;

public interface ShoppingCartService {
    void add(Item item);

    int getTotalCost();

    int getItemsCount();
}
