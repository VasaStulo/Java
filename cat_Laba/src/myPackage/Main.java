
package myPackage;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        try {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            ArrayList<Cat> catList = new ArrayList<>();
            Scanner scf = new Scanner(new File("kiteket.txt"));
            String text = "";
            String t[] = new String[0];
            Cat cat = null;
            while (scf.hasNext()) {
                text = scf.nextLine();
                t = text.split("[,]\\s*");
                String date = t[3];
                Date docDate = format.parse(date);
                cat = new Cat(t[0], Integer.parseInt(t[1]), t[2], docDate, t[4]);
                catList.add(cat);
            }

//            System.out.println("\n1)Удалить котика из коллекции\n2)Добавить котика в коллекцию(с клавиатуры)\n3)Проверить, есть ли котик с заданным с клавиатуры именем и возрастом\n4)Создать и вывести вторую коллекцию, основанную на первой, в которой возраст каждого котика будет возведен в квадрат\n5)Вывести полную информацию о котике по его имени и стране\n6)Отсортировать котиков по году рождения и вывести их имени с годом рождения");
//            System.out.print("Выберите пункт в меню> ");
            while (true) {
                System.out.println("\n1)Удалить котика из коллекции\n2)Добавить котика в коллекцию(с клавиатуры)\n3)Проверить, есть ли котик с заданным с клавиатуры именем и возрастом\n4)Создать и вывести вторую коллекцию, основанную на первой, в которой возраст каждого котика будет возведен в квадрат\n5)Вывести полную информацию о котике по его имени и стране\n6)Отсортировать котиков по году рождения и вывести их имени с годом рождения");
                System.out.print("Выберите пункт в меню> ");
                Scanner sc = new Scanner(System.in);
                int type = sc.nextInt();
                switch (type) {
                    case 1:
                        System.out.print("Введите имя котика, которого вы хотите удалить> ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        Iterator<Cat> catIterator = catList.iterator();//создаем итератор
                        while (catIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                            Cat nextCat = catIterator.next();//получаем следующий элемент
                            if (name.equalsIgnoreCase(nextCat.getName())) {
                                catIterator.remove();//удаляем кота с нужным именем
                            }
                        }
                        System.out.println(catList);
                        break;

                    case 2:
                        System.out.print("Введите данные котика,которого ходите видеть в коллекции\n");
                        System.out.println("Введите имя>");
                        String newName = sc.next();
                        System.out.println("Введите возраст (только число)>");
                        int newAge = sc.nextInt();
                        System.out.println("Введите страну проживания>");
                        String newCountry = sc.next();
                        System.out.println("Введите дату рождения (пример : 21.05.2001)>");
                        String newHappyDay = sc.next();
                        Date docDate = format.parse(newHappyDay);
                        System.out.println("Введите состояние котика (болен или здоров)>");
                        String newDisease = sc.next();
                        cat = new Cat(newName, newAge, newCountry, docDate, newDisease);
                        catList.add(cat);
                        for (Cat iterCat : catList) {
                            System.out.println(iterCat);
                        }
                        break;
                    case 3:
                        System.out.println("Введите имя котика для проверки>");
                        String nameCheck = sc.next();
                        Boolean flag = false;
                        for (Cat catIt : catList) {
                            if ((nameCheck.equalsIgnoreCase(catIt.getName()))) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            System.out.println("Такого котика нет");
                        } else
                            System.out.println("Котик с такими данными есть");
                        break;
                    case 4:
                        ArrayList<Cat> catTwoList = new ArrayList<>();
                        for (Cat cat1 : catList) {
                            catTwoList.add(cat1);
                        }
                        Iterator<Cat> cat1 = catTwoList.iterator();//создаем итератор
                        while (cat1.hasNext()) {//до тех пор, пока в списке есть элементы
                            Cat nextCat = cat1.next();
                            nextCat.setAge((int) Math.pow(nextCat.getAge(), 2));
                        }
                        System.out.println(catTwoList);

                        break;
                    case 5:
                        Boolean flager = false;
                        System.out.print("Введите имя котика>");
                        String nameCat = sc.next();
                        System.out.print("Введите страну проживания котика>");
                        String countryCat = sc.next();
                        Cat iteratorCat = null;
                        for (Cat iteratoCat : catList) {
                            if (nameCat.equalsIgnoreCase(iteratoCat.getName()) && (countryCat.equalsIgnoreCase(iteratoCat.getCountry()))) {
                                flager = true;
                                iteratorCat = iteratoCat;
                                break;
                            }

                        }
                        if (!flager)
                            System.out.println("Такого котика нет в наших данных");

                        else System.out.println(iteratorCat);

                        break;
                    case 6:
                        CatComparator catComparator = new CatComparator();
                        Collections.sort(catList, catComparator);

                        for (Cat catDay : catList) {


                            System.out.println(catDay.getName() + " " + catDay.getHappy_day());
                        }
                        break;

                }
            }
        } catch (ParseException e) {
            System.out.println("Ошибка парсинга даты");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода");
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка");
        }

    }
}

