import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String args[]){
        BigRectangleFilter brf = new BigRectangleFilter();
        ArrayList<Object> rects = new ArrayList<>();

        rects.add(new Rectangle(1,1));
        rects.add(new Rectangle(1,2));
        rects.add(new Rectangle(1,3));
        rects.add(new Rectangle(2,2));
        rects.add(new Rectangle(2,3));
        rects.add(new Rectangle(2,4));
        rects.add(new Rectangle(3,3));
        rects.add(new Rectangle(3,4));
        rects.add(new Rectangle(4,4));
        rects.add(new Rectangle(10,20));

        System.out.print("All rect perimeters: ");
        for (Object x : rects) {
            Rectangle r = (Rectangle) x;
            System.out.print((2*r.height)+(2*r.width) + " ");
        }

        System.out.println();
        System.out.print("Big rect perimeters: ");
        for (Object x : rects) {
            if (brf.accept(x)) {
                Rectangle r = (Rectangle) x;
                System.out.print((2*r.height)+(2*r.width) + " ");
            }
        }
    }
}
