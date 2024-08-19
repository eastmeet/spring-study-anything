package anything.composition.composition.test;

public class DishWasher {

    private boolean hasWorkTodo;

    public void setHasWorkTodo(boolean hasWorkTodo) {
        this.hasWorkTodo = hasWorkTodo;
    }

    public void doDished() {
        if (this.hasWorkTodo) {
            System.out.println("Washing Dishes");
            this.hasWorkTodo = false;
        }
    }

}
