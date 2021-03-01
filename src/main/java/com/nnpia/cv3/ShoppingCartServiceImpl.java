package com.nnpia.cv3;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    int totalCost = 0;
    int itemsCount = 0;

    @Override
    public void add(Item item) {
        switch (item.getItemType()) {
            case Pizza:
                totalCost += 120;
                break;
            case Beer:
                totalCost += 30;
                break;
            case Cola:
                totalCost += 25;
                break;
            case IceCream:
                totalCost += 45;
                break;
        }
        itemsCount++;
    }

    @Override
    public int getTotalCost() {
        return totalCost;
    }

    @Override
    public int getItemsCount() {
        return itemsCount;
    }
}
