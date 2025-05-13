package learn.junit.anas.javaunittest;

public class Calculator {
    public Integer add(Integer first, Integer second){
        return first + second;
    }
    public Integer minus(Integer first, Integer second){
        return first - second;
    }
    public Integer times(Integer first, Integer second){
        return first * second;
    }
    public Integer divided(Integer first, Integer second){
        if(second == 0){
            throw new IllegalArgumentException("cannot devide by zero");
        } else{
            return first / second;
        }
    }
}
