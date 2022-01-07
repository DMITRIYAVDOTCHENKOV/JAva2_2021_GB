package geekbrainJava2.Lesson5DZ;


import java.util.Arrays;

public class Multithreading {


        public static final int size = 10000000;
        public static final int h = size / 2;


        public static void main(String[] args) throws InterruptedException {
            nonThrOneЕhread();
            divisionIntoTwoStreams();

        }


        public static void nonThrOneЕhread() {
            System.out.println("---Запускаем 1-ый метод---");
            float[] arr = new float[size];
            Arrays.fill(arr, 1f);
            long executionTime = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
            }
            System.out.println("Время работы 1-го метода: " + (System.currentTimeMillis() - executionTime) + " мс");
            System.out.println("---Метод завершился---");
            System.out.println();
        }


        public static void divisionIntoTwoStreams() {
            System.out.println("---Запускаем 2-ой метод---");

            int[] initialArray = new int[size];
            Arrays.fill(initialArray, 1);
//        System.out.println(Arrays.toString(initialArray));
            long executionTime = System.currentTimeMillis();

            int[] leftHalf = new int[h];
            int[] rightHalf = new int[h];

            System.arraycopy(initialArray, 0, leftHalf, 0, h);
            System.arraycopy(initialArray, h, rightHalf, 0, h);


            Runnable stream1 = () -> {
                for (int i = 0; i < leftHalf.length; i++) {
                    leftHalf[i] =
                            (int) (leftHalf[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
                }
            };

            Runnable stream2 = () -> {
                for (int i = 0; i < rightHalf.length; i++) {
                    rightHalf[i] =
                            (int) (rightHalf[i] * Math.sin(0.2f + (i + h) / 5f) * Math.cos(0.2f + (i + h) / 5f) * Math.cos(0.4f + (i + h) / 2f));
                }
            };

            Thread thread1 = new Thread(stream1);
            thread1.start();
            Thread thread2 = new Thread(stream2);
            thread2.start();


            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int [] mergedArray = new int[size];
            System.arraycopy(leftHalf, 0, initialArray, 0, h);
            System.arraycopy(rightHalf, 0, initialArray, h, h);
//        System.out.println(Arrays.toString(mergedArray));

            System.out.println("Время работы 2-го метода: " + (System.currentTimeMillis() - executionTime) + " мс");
            System.out.println("---Метод 2 завершился---");

        }
    }



