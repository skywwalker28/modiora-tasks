package skyww.modiora.block4;

public class Task2 {
    /// №1
    public static class Book {
        private final String title;
        private final String author;
        private final int year;
        private final int countPages;
        private final double cost;

        public Book(String title, String author) {
            this(title, author, 0);
        }

        public Book(String title, String author, int year) {
            this(title, author, year, 0);
        }

        public Book(String title, String author, int year, int countPage) {
            this(title, author, year, countPage, 0.0);
        }

        public Book(String title, String author, int year, int countPage, double cost) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.countPages = countPage;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println("Название: " + title
            + "\nАвтор: " + author);
            if (year > 0) {
                System.out.println("Год издания: " + year);
            }

            if (countPages > 0) {
                System.out.println("Кол-во страниц: " + countPages);
            }

            if (cost > 0) {
                System.out.println("Цена: " + cost);
            }

            System.out.println();
        }

        public boolean isClassic() {
            return year > 0 && year <= 1950;
        }

        public static void main(String[] args) {
            Book book1 = new Book("Преступление и наказание", "Федор Михайлович Достоевский");
            Book book2 = new Book("Преступление и наказание", "Федор Михайлович Достоевский", 1866);
            Book book3 = new Book("Преступление и наказание", "Федор Михайлович Достоевский", 1866, 672);
            Book book4 = new Book("Преступление и наказание", "Федор Михайлович Достоевский", 1866, 672);
            Book book5 = new Book("Преступление и наказание", "Федор Михайлович Достоевский", 1866, 672, 8000);

            book1.printInfo();
            book2.printInfo();
            book3.printInfo();
            book4.printInfo();
            book5.printInfo();

            System.out.println("book5 является классикой? - " + book5.isClassic());
            /*
            Вывод:
            Название: Преступление и наказание
            Автор: Федор Михайлович Достоевский

            Название: Преступление и наказание
            Автор: Федор Михайлович Достоевский
            Год издания: 1866

            Название: Преступление и наказание
            Автор: Федор Михайлович Достоевский
            Год издания: 1866
            Кол-во страниц: 672

            Название: Преступление и наказание
            Автор: Федор Михайлович Достоевский
            Год издания: 1866
            Кол-во страниц: 672

            Название: Преступление и наказание
            Автор: Федор Михайлович Достоевский
            Год издания: 1866
            Кол-во страниц: 672
            Цена: 8000.0

            book5 является классикой? - true
            */
        }
    }

    /// №2
    public static class Circle {
        private final double radius;
        private final double centerX;
        private final double centerY;

        public Circle() {
            this(1.0, 0.0, 0.0);
        }

        public Circle(double radius) {
            this(radius, 0.0, 0.0);
        }

        public Circle(double radius, double centerX, double centerY) {
            this.radius = radius;
            this.centerX = centerX;
            this.centerY = centerY;
        }

        public Circle(Circle other) {
            this(other.radius, other.centerX, other.centerY);
        }


        public double area() {
            return Math.PI * radius * radius;
        }

        public double perimeter() {
            return 2 * Math.PI * radius;
        }

        public boolean contains(double x, double y) {
            double dx = x - centerX, dy = y - centerY;
            return Math.sqrt(dx * dx + dy * dy) <= radius;
        }

        public boolean intersects(Circle other) {
            double x = centerX - other.centerX, y = centerY - other.centerY;
            return Math.sqrt(x*x + y*y) < (radius + other.radius);
        }

        public static void main(String[] args) {
            Circle circle1 = new Circle(3, 5, 5);
            Circle circle2 = new Circle(5, 0, 0);
            Circle copyCircle2 = new Circle(circle2);

            System.out.println("Периметр circle1: " + circle1.perimeter());
            System.out.println("Периметр circle2: " + circle2.perimeter());
            System.out.println("Периметр copyCircle2: " + copyCircle2.perimeter());
            System.out.println();

            System.out.println("Площадь circle1: " + circle1.area());
            System.out.println("Площадь circle2: " + circle2.area());
            System.out.println("Площадь copyCircle2: " + copyCircle2.area());
            System.out.println();

            System.out.println("Точка (3;4) внутри circle2: " + circle2.contains(3, 4));
            System.out.println("Точка (0;0) внутри circle2: " + circle2.contains(0, 0));
            System.out.println("Точка (6;0) внутри circle2: " + circle2.contains(6, 0));
            System.out.println();

            System.out.println("circle1 пересекается с (3,0,0): " + circle1.intersects(new Circle(3, 0, 0)));
            System.out.println("circle1 пересекается с (3,10,0): " + circle1.intersects(new Circle(3, 10, 0)));
            System.out.println("circle1 пересекается с (1,0,0): " + circle1.intersects(new Circle(1, 0, 0)));
            /*
            Вывод:
            Периметр circle1: 18.84955592153876
            Периметр circle2: 31.41592653589793
            Периметр copyCircle2: 31.41592653589793

            Площадь circle1: 28.274333882308138
            Площадь circle2: 78.53981633974483
            Площадь copyCircle2: 78.53981633974483

            Точка (3;4) внутри circle2: true
            Точка (0;0) внутри circle2: true
            Точка (6;0) внутри circle2: false

            circle1 пересекается с (3,0,0): false
            circle1 пересекается с (3,10,0): false
            circle1 пересекается с (1,0,0): false
            */
        }
    }

    /// №3
    public static class Matrix {
        private final int rows;
        private final int cols;
        private final int[][] data;

        public Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            data = new int[rows][cols];
        }

        public Matrix(int[][] data) {
            rows = data.length;
            cols = data[0].length;
            this.data = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    this.data[r][c] = data[r][c];
                }
            }
        }

        public Matrix(Matrix other) {
            rows = other.rows;
            cols = other.cols;
            data = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    this.data[r][c] = other.data[r][c];
                }
            }
        }

        public int get(int i, int j) {
            return data[i][j];
        }

        public void set(int i, int j, int value) {
            data[i][j] = value;
        }

        public Matrix add(Matrix other) {
            if (other.rows != this.rows || other.cols != this.cols) {
                System.out.println("Матрицы должны быть одинакового размера");
                return null;
            }

            Matrix result = new Matrix(rows, cols);
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    result.data[r][c] = data[r][c] + other.data[r][c];
                }
            }

            return result;
        }

        public Matrix multiply(Matrix other) {
            if (cols != other.rows) {
                System.out.println("Число столбцов в первой матрице должно быть равно числу строк второй");
                return null;
            }

            Matrix result = new Matrix(this.rows, other.cols);
            for (int i = 0; i < result.data.length; i++) {
                for (int j = 0; j < result.data[0].length; j++) {
                    for (int k = 0; k < cols; k++) {
                        result.data[i][j] += this.data[i][k] * other.data[k][j];
                    }
                }
            }

            return result;
        }

        public void printMatrix() {
            System.out.println("Matrix: ");
            for (int r = 0; r <  rows; r++) {
                System.out.print("{");
                for (int c = 0; c < cols; c++) {
                    if (c != cols-1) {
                        System.out.print(data[r][c] + ", ");
                    } else {
                        System.out.println(data[r][c] + "}");
                    }
                }
            }

            System.out.println();
        }

        public static void main(String[] args) {
            int[][] m1 = {{1,1}, {1,1}};
            int[][] m2 = {{1,1}, {1,1}};
            int[][] m3 = {{1,1}, {1,1}, {1,1}};
            int[][] m4 = {{4,3,2}, {5,2,8}};

            Matrix matrix1 = new Matrix(m1);
            Matrix matrix2 = new Matrix(m2);
            Matrix matrix3 = new Matrix(m3);
            Matrix matrix4 = new Matrix(m4);


            matrix1.add(matrix2).printMatrix();
            matrix3.multiply(matrix4).printMatrix();

            System.out.println("Элемент в matrix1, индексы 0,1 = " + matrix1.get(0,1) + "\n");

            Matrix orig = new Matrix(2,2);
            Matrix copy = new Matrix(orig);

            copy.set(0,0, 10);
            System.out.println("Проверка копирующего конструктора:");
            orig.printMatrix();
            copy.printMatrix();

            /*
            Вывод:
            Matrix:
            {2, 2}
            {2, 2}

            Matrix:
            {9, 5, 10}
            {9, 5, 10}
            {9, 5, 10}

            Элемент в matrix1, индексы 0,1 = 1

            Проверка копирующего конструктора:
            Matrix:
            {0, 0}
            {0, 0}

            Matrix:
            {10, 0}
            {0, 0}
            */
        }
    }

    /// №4
    public static class Config {
        private static int instanceCount;
        private String host;
        private int port;
        private int maxConnections;
        private int timeout;
        private boolean debug;

        {
            host = "localhost";
            port = 8080;
            maxConnections = 100;
            timeout = 30;
            debug = false;
        }

        public Config() {
            instanceCount++;
        }

        public Config(String host, int port) {
            this.host = host;
            this.port = port;
            instanceCount++;
        }

        public Config(String host, int port, int maxConnections, int timeout, boolean debug) {
            this.host = host;
            this.port = port;
            this.maxConnections = maxConnections;
            this.timeout = timeout;
            this.debug = debug;
            instanceCount++;
        }

        public void printConfig() {
            System.out.println(
                    "Хост: " + host
                    + "\nПорт: " + port
                    + "\nМакс. Подключений: " + maxConnections
                    + "\nЗадержка: " + timeout
                    + "\nДебаг: " + debug
            );

            System.out.println();
        }

        public int getInstanceCount() {
            return instanceCount;
        }


        public static void main(String[] args) {
            Config config1 = new Config();
            Config config2 = new Config("test_localhost1", 8081);
            Config config3 = new Config("test_localhost2", 8082, 90, 35, true);

            config1.printConfig();
            config2.printConfig();
            config3.printConfig();
            System.out.println("Кол-во созданных конфигураций: " + config1.getInstanceCount());
        }

        /*
        Вывод:
        Хост: localhost
        Порт: 8080
        Макс. Подключений: 100
        Задержка: 30
        Дебаг: false

        Хост: test_localhost1
        Порт: 8081
        Макс. Подключений: 100
        Задержка: 30
        Дебаг: false

        Хост: test_localhost2
        Порт: 8082
        Макс. Подключений: 90
        Задержка: 35
        Дебаг: true

        Кол-во созданных конфигураций: 3
        */
    }
}
