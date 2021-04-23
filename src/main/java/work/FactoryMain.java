package work;

public class FactoryMain {

    public static void main(String[] args) {
        // 工厂，库存为10
        Factory factory = new Factory(10);
        // 商店1，库存为1
        Store store1 = new Store("小米", 1, factory);
        // 商店2，库存为2
        Store store2 = new Store("华为", 2, factory);

        // 工厂开工
        factory.start();

        // 8秒后商店开始运营
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 商店1开始运营
        store1.start();
        // 商店2开始运营
        store2.start();
    }
}

class Factory {
    volatile int bicycleInFactory = 0;

    // inventory 工厂初始库存
    public Factory(int inventory) {
        bicycleInFactory = inventory;
    }

    // 生产自行车
    synchronized
    public void produce() {
        System.out.println("工厂 当前有自行车 " + bicycleInFactory + ", 生产" + 1 + "辆自行车");

        bicycleInFactory++;
    }

    // 发货
    synchronized
    public int delivery(String store) {
        int delivery = 5;

        if (bicycleInFactory > 5) {
            System.out.println("工厂 当前有自行车 " + bicycleInFactory + ", 向" + store + "发货5辆自行车");

            bicycleInFactory -= 5;
        } else {
            delivery = bicycleInFactory;

            System.out.println("工厂 当前有自行车 " + bicycleInFactory + ", 向" + store + "发货" + delivery + "辆自行车");

            bicycleInFactory = 0;
        }
        return delivery;
    }

    public void start() {
        // 生产自行车
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    // 生产一辆自行车
                    produce();

                    // 2秒生产一辆
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

class Store {
    private String storeName;

    volatile int bicycleInStore = 0;

    private Factory bicycleFactory;

    // name 商店名称，
    // inventory 初始库存，
    // factory 货源工厂
    public Store(String name, int inventory, Factory factory) {
        storeName = name;
        bicycleInStore = inventory;
        bicycleFactory = factory;
    }

    // 申请五辆自行车或者清空工厂库存
    synchronized
    public void request(int request) {
        System.out.println(storeName + " 当前有自行车 " + bicycleInStore + ", 向工厂申请得到" + request + "辆自行车");

        bicycleInStore += request;
    }

    // 销售一辆自行车或者没有自行车不销售
    synchronized
    public void sale() {
        if (bicycleInStore > 0) {
            System.out.println(storeName + " 当前有自行车 " + bicycleInStore + ", 销售" + 1);
            bicycleInStore--;
        } else {
            System.out.println(storeName + " 当前有自行车 " + bicycleInStore + "，无法销售");
        }
    }

    public void start() {
        // 进货
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    // 申请五辆自行车或者清空工厂库存
                    request(bicycleFactory.delivery(storeName));

                    // 每隔10秒申请发货
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        // 销售
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    // 销售一辆自行车或者没有自行车不销售
                    sale();

                    // 每隔1到10秒卖出一辆
                    try {
                        Thread.sleep(1000L * (int) (Math.random() * 9 + 1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
