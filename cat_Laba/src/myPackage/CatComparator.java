package myPackage;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat> {
    public int compare(Cat a, Cat b){

        return a.getHappy_day().compareTo(b.getHappy_day());
    }

}
