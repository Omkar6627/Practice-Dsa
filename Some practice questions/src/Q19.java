public class Q19 {


//            1. Abstraction:
//
//    What is it? Abstraction is the process of simplifying complex systems by modeling classes based on their essential attributes and behaviors while hiding unnecessary details.
//            Why do we need it? Abstraction allows us to focus on what an object does rather than how it does it, making code more manageable and understandable.
//            Example:
//
//    java
//    Copy code
//    abstract class Shape {
//        abstract double calculateArea();
//    }
//
//    class Circle extends Shape {
//        private double radius;
//
//        Circle(double radius) {
//            this.radius = radius;
//        }
//
//        @Override
//        double calculateArea() {
//            return Math.PI * radius * radius;
//        }
//    }
//    In this example, we abstract the concept of a "Shape" with an "abstract" class, and the concrete "Circle" class inherits from it.
//
//            2. Encapsulation:
//
//    What is it? Encapsulation is the bundling of data and methods that operate on that data into a single unit (a class). It restricts access to some of the object's components, providing data security and reducing unintended interference.
//    Why do we need it? Encapsulation helps maintain data integrity and flexibility in changing the internal implementation without affecting other parts of the code.
//            Example:
//
//    java
//    Copy code
//    public class Student {
//        private String name;
//        private int age;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            if (age >= 0) {
//                this.age = age;
//            }
//        }
//    }
//    In this example, the "Student" class encapsulates data (name and age) and provides controlled access to them using getter and setter methods.
//
//3. Inheritance:
//
//    What is it? Inheritance is a mechanism that allows one class (subclass or derived class) to inherit properties and behaviors from another class (superclass or base class). It supports the concept of "is-a" relationship.
//            Why do we need it? Inheritance promotes code reusability and the creation of hierarchies of classes that share common attributes and behaviors.
//            Example:
//
//    java
//    Copy code
//    class Animal {
//        void eat() {
//            System.out.println("Animal is eating.");
//        }
//    }
//
//    class Dog extends Animal {
//        void bark() {
//            System.out.println("Dog is barking.");
//        }
//    }
//    In this example, "Dog" is a subclass of "Animal" and inherits the "eat" method.
//
//4. Polymorphism:
//
//    What is it? Polymorphism allows objects of different classes to be treated as objects of a common superclass. It enables a single interface to represent different data types and their behaviors.
//    Why do we need it? Polymorphism simplifies code by enabling flexibility in method implementations, making it easier to add new classes that conform to existing interfaces.
//    Example:
//
//    java
//    Copy code
//    class Bird {
//        void makeSound() {
//            System.out.println("Bird is making a sound.");
//        }
//    }
//
//    class Duck extends Bird {
//        @Override
//        void makeSound() {
//            System.out.println("Duck is quacking.");
//        }
//    }
//
//    class Sparrow extends Bird {
//        @Override
//        void makeSound() {
//            System.out.println("Sparrow is chirping.");
//        }
//    }
//    In this example, both "Duck" and "Sparrow" are subclasses of "Bird" and provide their own implementations of the "makeSound" method, demonstrating polymorphism.
//
//    These OOP concepts are fundamental in Java and are widely used to design and structure code in a modular and organized way.
}
