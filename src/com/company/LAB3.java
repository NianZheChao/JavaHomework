package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LAB3 {
    public static void LAB3_1(int n) {  //getPentagonalNumber(int n)
        for (int i = 1; i < n + 1; i++) {
            System.out.print(i * (3 * i - 1) / 2 + "  ");
            if (i % 10 == 0) System.out.print("\n");
        }
    }

    public static void LAB3_2(long n) {  //sumDigits(long n)
        long m = 0, sum = 0;
        while (n > 0) {
            m = n % 10;
            sum += m;
            n /= 10;
        }
        System.out.println(sum);
    }

    public static class footMeterTrans {
        public static double footToMeters(double foot) {
            double meter;
            meter = foot * 0.305;
            return meter;
        }

        public static double meterToFoot(double meter) {
            double foot;
            foot = meter * 3.279;
            return foot;
        }

        public static void table() {
            System.out.println("inch\tmeter\t\tmeter\tinch");
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "\t\t" + footToMeters(i) + "\t\t\t" + i + "\t\t" + meterToFoot(i));
            }
        }
    }

    public static void LAB3_4(char ch1, char ch2, int numberPerLine) {  //printfChars
        int i = 0;
        while (ch2 >= ch1) {
            System.out.print(ch1 + " ");
            ch1++;
            i++;
            if (i % 10 == 0) System.out.print("\n");
        }
    }

    public static void LAB3_5(double i) {
        System.out.println("i\tm(i)");
        for (double j = 1; j < i + 1; j++) {
            double sum = 0, temp = j;
            while (temp >= 1) {
                sum += temp / (temp + 1);
                temp--;
            }
            System.out.printf("%.0f\t%.4f\n", j, sum);
        }
    }

    public static void LAB3_6(int n) { //printMatrix(int n)
        Random r = new Random(1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int rand = r.nextInt(2);
                System.out.print(rand + " ");
            }
            System.out.print("\n");
        }
    }

    public static void LAB3_7(String n) {
        int num = 0;
        if (n.length() < 8) {
            System.out.println("Invalid Password");
            return;
        }
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i)) && !Character.isLetter(n.charAt(i))) {
                System.out.println("Invalid Password");
                return;
            }
            if (!Character.isDigit(n.charAt(i))) num++;
        }
        if (num > 1)
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");
        return;
    }

    public static double LAB3_8(long n) {  //double sqrt(long n)
        double tem = 1, nextGuess = 1, lastGuess = 1;
        while (tem > 0.00001) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
            tem = Math.abs(lastGuess - nextGuess);
        }
        return nextGuess;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void LAB3_9(int p) {
        System.out.println("p\t\t2^p-1");
        for (int i = 2; i <= p; i++) {
            if (isPrime(i))
                System.out.println(i + "\t" + (Math.pow(2, i) - 1));
        }
    }

    public static void LAB3_10(int n) {
        for (int i = 4; i < n + 1; i++) {
            if (isPrime(i) && isPrime(i - 2))
                System.out.println("(" + (i - 2) + "," + i + ")");
        }
    }

    public static void LAB3_11() {
        Random r = new Random(5);
        int a = r.nextInt(7), b = r.nextInt(7), c = 0, d = 0;
        System.out.println("first toss:" + a + " and " + b);
        if (a + b == 2 || a + b == 3 || a + b == 12) {
            System.out.println("lose with " + a + " and " + b);
        } else if (a + b == 7 || a + b == 11)
            System.out.println("win with " + a + " and " + b);
        else {
            while (c + d != a + b || c + d != 7) {
                c = r.nextInt(7);
                d = r.nextInt(7);
                if (c + d == a + b) {
                    System.out.println("win with another toss:" + c + " and " + d);
                    return;
                } else if (c + d == 7) {
                    System.out.println("lose with another toss:" + c + " and " + d);
                    return;
                }
            }
        }
    }

    public static class LAB3_12 {
        public static boolean isValid(long number) {
            if (prefixMatched(number)) if (sumOfDoubleEvenPlace(number) % 10 == 0) return true;
            return true;
        }

        public static int sumOfDoubleEvenPlace(long number) {
            int sum = 0;
            int sumGetdigit = 0;
            long temp = 0;
            int numberSize = getSize(number);
            for (int i = 2; i <= numberSize; i += 2) {
                temp = getPrefix(number, i);
                sumGetdigit += getDigit((int) temp * 2);
            }
            sum = sumGetdigit + sumOfOddPlace(number);
            return sum;
        }

        public static int getDigit(int number) {
            int numGetDigit = 0;
            if (number % 10 >= 0) {
                numGetDigit = number % 10;
                number /= 10;
                numGetDigit += number;
                return numGetDigit;
            }
            return number;
        }

        public static int sumOfOddPlace(long number) {
            int sum = 0, i = 0;
            int Size = getSize(number);
            for (i = 1; i <= Size; i += 2) {
                sum += getPrefix(number, i);
            }
            return sum;
        }

        public static boolean prefixMatched(long number) {
            int numberSize = getSize(number);
            if (numberSize >= 13 && numberSize <= 16) {
                switch ((int) getPrefix(number, numberSize)) {
                    case 4:
                    case 6:
                    case 5:
                        return true;
                    case 3:
                        if ((int) getPrefix(number, numberSize - 1) == 7)
                            return true;
                }
            }
            return false;
        }

        public static int getSize(long d) {
            long i = 0;
            while (d > 0) {
                i += 1;
                d /= 10;
            }
            return (int) i;
        }

        public static long getPrefix(long number, int k) {
            int i = 0;
            long temp = 0;
            while (i < k) {
                i++;
                temp = number % 10;
                number /= 10;
            }
            return temp;
        }
    }

    public static String format(int number, int width) {
        String format = "";
        int numberLenth = (number + "").length();
        if (numberLenth < width) {
            for (int i = 1; i <= width - numberLenth; i++)
                format = format + "0";
            return format + number;
        } else return "" + number;
    }

    public static void LAB3_14() {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        int[] numbers = new int[10];
        System.out.print("enter ten numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = input.nextInt();
            for (int j = 0; j < i; j++) {
                if (numbers[i] != array[j])
                    array[j] = numbers[i];
            }
        }
    }

    public static void LAB3_15() {
        int[] array = new int[100];
        int[] counts = new int[10];
        for (int i = 0; i < 100; i++)
            array[i] = (int) (Math.random() * 10);
        for (int i = 0; i < 100; i++)
            counts[array[i]]++;
        for (int i = 0; i < 10; i++)
            System.out.println(i + " has appeares " + counts[i] + " times");
    }

    public static int LAB3_16(double[] array) {
        double min = array[0];
        int n = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                n = i;
            }
        }
        return n;
    }

    public static void LAB3_17() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = (int) (Math.random() * 100);
        getRandom(1, 10, 45, 30, 65, 75);
        getRandom(array);
    }

    private static void getRandom(int... numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] > 1 && numbers[i] < 54)
                System.out.println(numbers[i]);
    }

    public static int[] LAB3_18(int[] array) {               //elimminateDuplicates(int[] array)
        int[] b = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 0; i < 10; i++)
            for (int j = 9; j > i; j--)
                if (array[i] == array[j])
                    b[j] = -1;
        System.out.println("the distinct numbers are:");
        for (int i = 0; i < array.length; i++) {
            if (b[i] == 1)
                System.out.print(array[i] + " ");
        }
        return array;
    }

    public static void LAB3_19() {
        Scanner input = new Scanner(System.in);
        int[] list = new int[10];
        System.out.print("enter list,the first one is the length: ");
        for (int i = 0; i < 10; i++)
            list[i] = input.nextInt();
        isSorted(list);
    }

    private static boolean isSorted(int[] list) {
        int[] list2 = new int[10];
        for (int i = 1; i < list[0]; i++)
            list2[i - 1] = list[i];
        java.util.Arrays.parallelSort(list2);
        for (int i = 1; i < list[0]; i++)
            if (list2[i - 1] != list[i]) {
                System.out.println("the list is not sorted ");
                break;
            } else
                System.out.println("the list is already sorted ");
        return false;
    }

    public static void LAB3_20() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the numbers of balls to drop:");
        int balls = input.nextInt();
        System.out.print("Enter the numbers of slots in the bean machine:");
        int slots = input.nextInt();
        System.out.println();
        int[] holes = new int[slots];
        for (int i = 0; i < balls; i++) {
            int sum = 0;
            for (int j = 0; j < slots - 1; j++) {
                double direction = Math.random() * 2 - 1; //随机生成-1到1之间的数字，当x<0时左移，x>0时右移
                if (direction < 0)
                    System.out.print("L");
                else {
                    System.out.print("R");
                    sum++;
                }
            }
            System.out.println();
            holes[sum] += 1; //有多少个R就进哪个洞,从0开始编号
        }
        int maxhole = 0;
        for (int i = 0; i < holes.length; i++) {   //找出所有洞中进球数的最大值
            if (holes[i] > maxhole)
                maxhole = holes[i];
        }
        System.out.println();
        for (int i = 0; i < maxhole; i++) { //以进球数最大值为行数
            for (int j = 0; j < slots - 1; j++) {   //以洞数为列数
                if (holes[j] == maxhole - i) {
                    System.out.print('0');
                    holes[j]--;
                } else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void LAB3_21() {
        boolean[] L = new boolean[100];
        for (int i = 0; i < L.length; i++) {
            L[i] = false;
        }
        //S1
        for (int i = 0; i < L.length; i++) {
            L[i] = true;
        }
        //S2
        for (int i = 1; i < L.length; i += 2) {
            L[i] = false;
        }
        //S3--S100
        for (int i = 2; i < 100; i++) {
            for (int j = i; j < L.length; j += (i + 1)) {
                if (L[i] == false)
                    L[i] = true;
                else L[i] = false;
            }
        }

        for (int i = 0; i < L.length; i++) {
            int count = 1;
            if (L[i] == true) {
                System.out.print(i + 1 + " ");
                count++;
            }
            if (count % 5 == 0) {
                System.out.println();
            }
        }
    }

    static boolean equals(int[] list1, int[] list2) {
        if (Arrays.equals(list1, list2))
            return true;
        else
            return false;
    }

    public static void LAB3_22() {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int arr1[] = null;
        int arr2[] = null;
        for (int i = 0; i < n1; i++)
            arr1[i] = input.nextInt();
        for (int j = 0; j < n2; j++)
            arr2[j] = input.nextInt();
        if (equals(arr1, arr2))
            System.out.println("true");
    }

    public static boolean isConsecutiveFour(int[] values) {
        int count = 0;
        int temp = values[0];
        for (int i = 1; i < values.length; i++) {
            if (temp == values[i]) {
                count++;
                if (count >= 4) {
                    return true;
                }
            } else {
                count = 0;
                temp = values[i];
            }
        }
        return false;
    }

    public static void LAB3_25() {
        Scanner in = new Scanner(System.in);
        String[] words = {"write", "that", "what"};
        int r = (int) (Math.random() * words.length);
        char[] w = words[r].toCharArray();
        char[] e = new char[words[r].length()];
        int k = 0, i = 0;
        boolean flag = false;
        int count = 0;
        int miss = 0;
        while (true) {

            System.out.print("(Guess) Enter a letter in word ");
            count = 0;
            for (i = 0; i < w.length; i++) {
                flag = false;
                for (int j = 0; j < k; j++) {
                    if (w[i] == e[j]) {
                        count++;
                        flag = true;
                        break;
                    }
                }
                if (count == w.length)
                    break;
                if (flag)
                    System.out.print(w[i]);
                else
                    System.out.print("*");
            }
            if (count == w.length)
                break;
            System.out.print(" > ");
            String s = in.next();
            e[k] = s.charAt(0);

            for (i = 0; i < w.length; i++)
                if (w[i] == e[k])
                    break;
            if (i == w.length)
                System.out.println(e[k] + " is not in the word");

            flag = false;
            for (i = 0; i < k; i++)
                if (e[k] == e[i]) {
                    flag = true;
                    break;
                }
            if (flag)
                System.out.println(e[k] + " is already in the word");
            else
                k++;
        }
        System.out.print("The word is" + words[r] + ". You misse " + miss + " time.");
    }

    public static void LAB3_26() {
        int[][] work = {
                {2, 4, 3, 4, 5, 8, 8},
                {7, 3, 4, 3, 3, 4, 4},
                {3, 3, 4, 3, 3, 2, 2},
                {9, 3, 4, 7, 3, 4, 1},
                {3, 5, 4, 3, 6, 3, 8},
                {3, 4, 4, 6, 3, 4, 4},
                {3, 7, 4, 8, 3, 8, 4},
                {6, 3, 5, 9, 2, 7, 9},
        };
        int[][] time = new int[8][1];
        for (int i = 0; i < work.length; i++)
            for (int j = 0; j < work[i].length; j++) {
                time[i][0] += work[i][j];
            }
        int temp = 0;
        for (int i = 0; i < work.length - 1; i++)
            for (int j = 0; j < i; j++) {
                if (work[i][0] < work[i + 1][0])
                    temp = work[i + 1][0];
                work[i + 1][0] = work[i][0];
                work[i][0] = temp;
            }

        for (int i = 0; i < 8; i++)
            System.out.println(time[i][0]);
    }

    public static void LAB3_27() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter matrix1:");
        double[][] matrix1 = new double[3][3];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = input.nextDouble();
            }
        }

        System.out.print("\nEnter matrix2:");
        double[][] matrix2 = new double[3][3];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = input.nextDouble();
            }
        }

        System.out.println("The matrices are added as follows");
        double[][] matrix = addMatrix(matrix1, matrix2);
        System.out.println(matrix1[0][0] + " " + matrix1[0][1] + " " + matrix1[0][2] + "    "
                + matrix2[0][0] + " " + matrix2[0][1] + " " + matrix2[0][2] + "    "
                + matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2]);
        System.out.println(matrix1[1][0] + " " + matrix1[1][1] + " " + matrix1[1][2] + " +  "
                + matrix2[1][0] + " " + matrix2[1][1] + " " + matrix2[1][2] + " =  "
                + matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2]);
        System.out.println(matrix1[2][0] + " " + matrix1[2][1] + " " + matrix1[2][2] + "    "
                + matrix2[2][0] + " " + matrix2[2][1] + " " + matrix2[2][2] + "    "
                + matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2]);
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] matrix = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = a[i][j] + b[i][j];
            }
        }
        return matrix;
    }

    public static void LAB3_29() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size for the matrix:");
        int size = scanner.nextInt();
        //2.
        int[][] matrix = new int[size][size];

        //3.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random() > 0.5 ? 1 : 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //4.
        for (int i = 0; i < matrix.length; i++) {
            boolean flag = true;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] != matrix[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("All " + matrix[i][0] + " on row " + i);
            }
        }
        //5.
        for (int j = 0; j < matrix.length; j++) {
            boolean flag = true;
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[0][j] != matrix[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("All " + matrix[0][j] + " on col " + j);
            }
        }
        //6.
        boolean flag = true;
        for (int x = 1; x < matrix.length; x++) {
            if (matrix[0][0] != matrix[x][x]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("All " + matrix[0][0] + " on major diagonal ");
        }
        //7.
        flag = true;
        for (int i = matrix.length - 2, j = 1; i >= 0 && j < matrix.length; i--, j++) {
            if (matrix[matrix.length - 1][0] != matrix[i][j]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("All " + matrix[matrix.length - 1][0] + " on sub diagonal ");
        }
    }

    public static class JavaGame {
        int row, column;                       //行列
        char Graph[][];                       //二维棋盘
        int top[];                              //模拟栈尾指针
        String C[] = {"red", "yellow"};          //棋子颜色
        int empty;                            //棋盘剩余空格

        public JavaGame(int r, int c) {                  //初始化棋盘数据
            empty = r * c;
            row = r;
            column = c;
            Graph = new char[r][c];
            top = new int[c];
            for (int i = 0; i < c; i++)                       //初始化数组栈
                top[i] = -1;
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    Graph[i][j] = ' ';
        }

        public void show() {                            //展示棋盘
            for (int i = row - 1; i >= 0; i--) {
                System.out.print("|");
                for (int j = 0; j < column; j++)
                    System.out.print(Graph[i][j] + "|");
                System.out.println();
            }
        }

        public int Input(int y, int key) {              //下棋
            if (y >= column || y < 0 || top[y] == row - 1) {
                System.out.println("out of range");
                return 1;
            }
            Graph[++top[y]][y] = C[key % 2].toUpperCase().charAt(0);
            empty--;
            return 0;
        }

        public int judge(int x, int y) {                //判断是否有人胜出
            if (search(Graph[x][y], x, y, 1, 0) + search(Graph[x][y], x, y, -1, 0) >= 3 || //水平探测
                    search(Graph[x][y], x, y, 1, 1) + search(Graph[x][y], x, y, -1, -1) >= 3 || //对角探测
                    search(Graph[x][y], x, y, 0, 1) + search(Graph[x][y], x, y, 0, -1) >= 3 || //垂直探测
                    search(Graph[x][y], x, y, 1, -1) + search(Graph[x][y], x, y, -1, 1) >= 3)  //对角探测
                return 1;
            return 0;                          //未有人获胜
        }

        public int search(char k, int a, int b, int z, int f) {    //单向探测函数
            a += z;
            b += f;
            if (b >= column || a >= row || a < 0 || b < 0 || Graph[a][b] != k)
                return 0;
            return search(k, a, b, z, f) + 1;
        }

        public static void LAB3_31(String[] args) {
            JavaGame My = new JavaGame(6, 7);
            Scanner input = new Scanner(System.in);
            int tmp, key;
            My.show();
            for (int i = 0; ; ) {
                System.out.print("Drop a " + My.C[i % 2] + " disk at column(0-6) : ");
                tmp = input.nextInt();
                if (My.Input(tmp, i) != 0)      //出错后 执行下一循环（i没有++）
                    continue;
                My.show();
                if (My.judge(My.top[tmp], tmp) == 1) {    //判断是否有人胜出
                    System.out.println("The " + My.C[i % 2] + " player won");
                    break;
                }
                if (My.empty == 0) {                    //平局
                    System.out.println("Chess draw");
                    break;
                }
                i++;
            }
        }
    }

    public static void LAB3_32() {
        Scanner input = new Scanner(System.in);
        double[][] list1 = new double[3][3];
        System.out.println("enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                list1[i][j] = input.nextDouble();
        if (isMarkovMatrix(list1))
            System.out.println("it is a Markov Matrix.");
        else
            System.out.println("it is not a Markov Matrix.");

    }

    private static boolean isMarkovMatrix(double[][] list1) {
        for (int i = 0; i < 3; i++) {
            double sum = 0;
            for (int j = 0; j < 3; j++) {
                if (list1[i][j] < 0)
                    return false;
                sum += list1[j][i];
            }
            if (sum != 1.0)
                return false;
        }
        return true;
    }

    public static void LAB3_33() {
        Scanner input = new Scanner(System.in);
        int[][] list1 = new int[3][3];
        int[][] list2 = new int[3][3];
        System.out.print("enter list1: ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                list1[i][j] = input.nextInt();
        System.out.print("enter list2: ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                list2[i][j] = input.nextInt();
        if (equals(list1, list2))
            System.out.println("the two arrays are strictly identical.");
    }

    private static boolean equals(int[][] list1, int[][] list2) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (list1[i][j] != list2[i][j]) {
                    System.out.println("the two arrays are not strictly identical.");
                    return false;
                }
        return true;
    }

    public static void LAB3_34() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter list1:");
        int[][] list1 = new int[3][3];
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list1[i].length; j++) {
                list1[i][j] = input.nextInt();
            }
        }

        System.out.print("\nEnter list2:");
        int[][] list2 = new int[3][3];
        for (int i = 0; i < list2.length; i++) {
            for (int j = 0; j < list2[i].length; j++) {
                list2[i][j] = input.nextInt();
            }
        }

        if (equals(list1, list2))
            System.out.println("The two arrays are identical");
        else System.out.println("The two arrays are not identical");
    }

    public static boolean equals_2(int[][] m1, int[][] m2) {
        int[] list1 = new int[m1.length * m1[0].length];
        int[] list2 = new int[m2.length * m2[0].length];

        int k = 0;
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                list1[k] = m1[i][j];
                k++;
            }
        }
        k = 0;
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                list2[k] = m2[i][j];
                k++;
            }
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i])
                return false;
        }

        return true;
    }

    public static class maxjuzhen {

        static int n;

        public void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int[][] zz = new int[100][100];
            int[] ans = new int[3];
            n = scan.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    zz[i][j] = scan.nextInt();
                }
            }
            ans = findLargestBlock(zz);
            System.out.print("最大矩阵位置：(" + ans[1] + "," + ans[2] + ")  ");
            System.out.println("矩阵长度：" + ans[0]);
        }

        public int[] findLargestBlock(int[][] m) {
            int maxn = 1, x = 0, y = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (m[i][j] == 1) {
                        int mmin = Math.min(m[i - 1][j], m[i][j - 1]);
                        mmin = Math.min(m[i - 1][j - 1], mmin);//求出上 ，左，上左最小值
                        m[i][j] = mmin + 1;
                        if (maxn < m[i][j]) {
                            maxn = m[i][j];
                            x = i;
                            y = j;//记录方阵右下位置
                        }
                    }
                }
            }
            int[] ans = {maxn, x - maxn + 1, y - maxn + 1};//结果放在数组中
            return ans;
        }
    }

    public static void LAB3_36() {
        System.out.print("Enter number n:");
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        char[][] matrix = new char[n][n];
        System.out.println("Enter " + n + " rows of letters separated by spaces:");
        String temp = null;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                temp = cin.next();
                matrix[i][j] = temp.charAt(0);
                if (matrix[i][j] > ('A' + n) || matrix[i][j] < 'A')
                    count++;
            }
            if (count != 0) {
                System.out.println("Wrong input: the letters must be from A to C");
                return;
            }
        }
        int[] record = new int[n];
        Arrays.fill(record, 0);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ++record[(int) (matrix[i][j] - 'A')];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ++record[(int) (matrix[j][i] - 'A')];
            }
        }
        boolean flag = true;
        for (int i = 0; i < n; ++i) {
            if (record[i] != 2 * n) {
                flag = false;
            }
        }

        if (flag)
            System.out.println("The input array is Latin squre");
    }

    public static void main(String[] args) {
        //LAB3_1(100);
        //LAB3_2(234);
        //footMeterTrans.table();
        //LAB3_4('l','z',10);
        //LAB3_5(20);
        //LAB3_6(3);
        //LAB3_7("test1235");
        //System.out.println(LAB3_8(10));
        //LAB3_9(31);
        //LAB3_10(1000);
        //LAB3_11();
        System.out.println(format(34,5));

    }
}
