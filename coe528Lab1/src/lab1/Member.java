
package lab1;

/**
 *
 * @author sajoshi
 */
public class Member extends Passenger{
    private int yearsOfMembership;
    
     public Member(String name, int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
      public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    @Override
    public double applyDiscount(double p){
        if(this.yearsOfMembership > 5){
            return p*0.5;
        }else if(p > 1){
            return p*0.9;
        }else{
            return p;
        }
    }
    
    @Override
    public String toString(){
        return String.format("Member --> Name:%s, Age:%d, Years of Membership:%d", this.name, this.age, this.yearsOfMembership);
    }
}
    

