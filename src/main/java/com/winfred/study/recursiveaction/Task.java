package com.winfred.study.recursiveaction;

import com.winfred.study.entity.Product;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @author Winfred
 * @since 2017/3/16
 * work-stealing算法只用于ForkJoinTask对象，RecursiveAction继承自ForkJoinTask，RecursiveAction不返回结果
 */
public class Task extends RecursiveAction {
    private static final long serialVersionUID = 1L;
    private List<Product> products;

    private int first;
    private int last;
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks:%s\n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle + 1, increment);
            Task t2 = new Task(products, middle + 1, last, increment);
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + increment));
        }
    }
}
