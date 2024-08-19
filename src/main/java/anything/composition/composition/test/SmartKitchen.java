package anything.composition.composition.test;

import lombok.Getter;

@Getter
public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen() {
        brewMaster = new CoffeeMaker();
        dishWasher = new DishWasher();
        iceBox = new Refrigerator();
    }

    public void addWater() {
        brewMaster.setHasWorkTodo(true);
        brewMaster.brewCoffee();
    }

    public void pourMilk() {
        iceBox.setHasWorkTodo(true);
        iceBox.orderFood();
    }

    public void loadDishwasher() {
        dishWasher.doDished();
    }

    public void setKitchenState(boolean coffeeFlag, boolean fridgeFlag, boolean dishWasherFlag) {
        this.brewMaster.setHasWorkTodo(coffeeFlag);
        this.iceBox.setHasWorkTodo(fridgeFlag);
        this.dishWasher.setHasWorkTodo(dishWasherFlag);
    }

    public void doKitchenWork() {
        this.brewMaster.brewCoffee();
        this.iceBox.orderFood();
        this.dishWasher.doDished();
    }

}
