package src.bai7_abstraction.exercise.colorable;

import src.bai7_abstraction.exercise.resizable.Rectangle;
import src.bai7_abstraction.exercise.resizable.Shape;

public class Test  {
    public static void main(String[] args) {
        Shape[] shape = new Shape[1];
        shape[0] = new Rectangle(5, 10);
        for (Shape x: shape) {
            System.out.println(x);
            if (x instanceof Colorable){
                Rectangle rectangle = (Rectangle) x;
                System.out.println(rectangle.getArea());
                rectangle.howToColor();
            }
        }
    }
}
