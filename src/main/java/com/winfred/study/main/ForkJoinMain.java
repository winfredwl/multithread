package com.winfred.study.main;

import com.winfred.study.entity.Product;
import com.winfred.study.entity.ProductListGenerator;
import com.winfred.study.recursiveaction.Task;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class ForkJoinMain {
    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(10000);
        Task task = new Task(products, 0, products.size(), 0.20);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do {
            System.out.printf("Main: 运行的线程数量: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: 线程偷取: %d\n", pool.getStealCount());
            System.out.printf("Main: 并行数: %d\n", pool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());
        pool.shutdown();

        if (task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally.\n");
        }

        products.stream().forEach(product -> {
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
            }
        });
        System.out.println("Main: End of the program.\n");
    }

}
