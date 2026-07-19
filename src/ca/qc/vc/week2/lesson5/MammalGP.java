package ca.qc.vc.week2.lesson5;




interface Animal{}


interface Mammal extends Animal{}

interface Reptile extends Animal{}

class Dog implements Mammal{}
class Cat implements Mammal{}
class Mouse implements Mammal{}

class Frog implements Reptile{}
class Turtle implements Reptile{}
class Snake implements Reptile{}




public class MammalGP <? extends T> {



    public static void main(String[] args) {

        new MammalGP<Mammal>();
        new MammalGP<Dog>();
        new MammalGP<Cat>();

//        Number
//
//
//
//        new MammalGP<Frog>();
    }
}


