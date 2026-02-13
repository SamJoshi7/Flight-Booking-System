
package lab1;

/**
 *
 * @author sajoshi
 */
public abstract class Passenger {
    String name;
    int age;
    
     public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }
public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public abstract double applyDiscount(double p);
    
    @Override
    public abstract String toString();
    
}
