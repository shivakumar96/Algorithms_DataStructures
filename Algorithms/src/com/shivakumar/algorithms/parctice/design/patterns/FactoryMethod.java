package com.shivakumar.algorithms.parctice.design.patterns;

class Burger{
}

class ChickenBurger extends Burger{

}

class VegBurger extends Burger{

}

class BurgerFactory{
    public Burger CreateBurger(String request){
        Burger burger= null;

        if("CHICKEN".equals(request))
            burger =  new ChickenBurger();
        else if("VEG".equals(request))
            burger =  new VegBurger();
        return  burger;
    }
}

class Restaurant{
    public Burger orderBurger(String request){
        BurgerFactory burgerFactory = new BurgerFactory();
        Burger burger = burgerFactory.CreateBurger(request);
        return burger;
    }
}
// Above is the Simple Factory Implementation


//Loose coupling


//Below has Loose coupling

interface BurgerFood {
    public void prepare();
}

class VegBurgerFood implements BurgerFood{

    @Override
    public void prepare() {
        //TODO:
    }
}

class ChickenBurgerFood implements BurgerFood{

    @Override
    public void prepare() {
        //TODO:
    }
}

abstract class RestaurantFact {
    public BurgerFood orderburger() {
        BurgerFood burger = createBurger();
        burger.prepare();
        return burger;
    }
    public abstract BurgerFood createBurger();
}

class ChickenRestaurant extends RestaurantFact{

    @Override
    public BurgerFood createBurger() {
        return new ChickenBurgerFood();
    }
}

class VegRestaurant extends RestaurantFact{

    @Override
    public BurgerFood createBurger() {
        return new ChickenBurgerFood();
    }
}


public class FactoryMethod {

}
