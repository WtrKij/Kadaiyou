public class TheDogTest1 {
    public static void main (String[] args){
        Dog pochi = new Dog();

        pochi.print();
        pochi.roudou();
        pochi.print();
        pochi.roudou();
        pochi.print();
        pochi.shokuji();
        pochi.print();
        pochi.shokuji();
        pochi.print();
        pochi.shokuji();
        pochi.print();
    }
}


class Dog{
    private DogState myState;

    public Dog(){
        myState = FunState.getInstance();
    }
    public void roudou(){
        myState.tire(this);
    }
    public void shokuji(){
        myState.eat(this);
    }
    public void changeState(DogState d){
        myState = d;
    }
    public void print(){
        System.out.println("現在、私は「"+myState.toString()+"」です");
    }
}

abstract class DogState{
    public abstract void tire(Dog yobimoto);
    public abstract void eat(Dog yobimoto);
    public abstract String toString();
}

class FunState extends DogState{
    private static FunState s = new FunState();
    private FunState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tire(Dog moto){
        moto.changeState(NormalState.getInstance());
    }
    public void eat(Dog moto){
        moto.changeState(SleepState.getInstance());
    }
    public String toString(){
        return "楽しい状態";
    }
}

class NormalState extends DogState{
    private static NormalState s = new NormalState();
    private NormalState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tire(Dog moto){
        moto.changeState(IrritationState.getInstance());
    }
    public void eat(Dog moto){
        moto.changeState(FunState.getInstance());
    }
    public String toString(){
        return "普通";
    }
}

class IrritationState extends DogState{
    private static IrritationState s = new IrritationState();
    private IrritationState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tire(Dog moto){
        
    }
    public void eat(Dog moto){
        moto.changeState(FunState.getInstance());
    }
    public String toString(){
        return "爆発寸前";
    }
}

class SleepState extends DogState{
    private static SleepState s = new SleepState();
    private SleepState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tire(Dog moto){
        moto.changeState(IrritationState.getInstance());
    }
    public void eat(Dog moto){
        moto.changeState(NormalState.getInstance());
    }
    public String toString(){
        return "睡眠状態";
    }
}