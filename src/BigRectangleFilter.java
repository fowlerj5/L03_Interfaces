import java.awt.Rectangle;

public class BigRectangleFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        Rectangle r = (Rectangle) x;
        return ((2*r.height)+(2*r.width))>10;
    }
}
