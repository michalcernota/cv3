package com.nnpia.cv3;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StatsServiceImpl implements StatsService {
    private int ordersCount = 0;

    @Override
    public void increaseOrderCount() {
        ordersCount++;
    }

    @Override
    public int getOrdersCount() {
        return ordersCount;
    }
}
