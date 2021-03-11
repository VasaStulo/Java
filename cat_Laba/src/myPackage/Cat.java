package myPackage;


import java.util.Date;

public class Cat {
    private String name;
    private int age;
    private String country;
    private Date happy_day;
    private String disease;

    public Cat(String name, int age, String country, Date happy_day, String disease) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.happy_day = happy_day;
        this.disease = disease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getHappy_day() {
        return happy_day;
    }

    public void setHappy_day(Date happy_day) {
        this.happy_day = happy_day;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return name +"," + age +","+ country +","+ happy_day+"," + disease+"\n";
    }



}