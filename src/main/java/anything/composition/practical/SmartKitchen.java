package anything.composition.practical;

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
