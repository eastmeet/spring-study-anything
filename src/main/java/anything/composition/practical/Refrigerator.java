package anything.composition.practical;

public class Refrigerator {

    private boolean hasWorkTodo;

    public void setHasWorkTodo(boolean hasWorkTodo) {
        this.hasWorkTodo = hasWorkTodo;
    }

    public void orderFood() {
        if (this.hasWorkTodo) {
            System.out.println("Ordering Food");
            hasWorkTodo = false;
        }
    }

}
