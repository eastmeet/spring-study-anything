package anything.composition.practical;

public class SmartKitchenMain {

    public static void main(String[] args) {
        SmartKitchen smartKitchen = new SmartKitchen();
//
//        smartKitchen.getDishWasher().setHasWorkTodo(true);
//        smartKitchen.getBrewMaster().setHasWorkTodo(true);
//        smartKitchen.getIceBox().setHasWorkTodo(true);
//
//        smartKitchen.getDishWasher().doDished();
//        smartKitchen.getIceBox().orderFood();
//        smartKitchen.getBrewMaster().brewCoffee();
        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.doKitchenWork();
    }

}
