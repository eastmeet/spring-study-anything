package anything.composition.composition.test;

public class CoffeeMaker {

    private boolean hasWorkTodo;

    public void setHasWorkTodo(boolean hasWorkTodo) {
        this.hasWorkTodo = hasWorkTodo;
    }

    public void brewCoffee() {
        if (this.hasWorkTodo) {
            System.out.println("brew Coffee is done");
            hasWorkTodo = false;
        }

    }

}
