package shapes;

public class Circle extends Shape{

    private int radius;

    public Circle(int x, int y, int radius, String fill) {
        super(x, y, fill);
        this.radius = radius;
    }

    public Circle(String svg) {
//        Extract indexes
        int xIndex = svg.indexOf("cx=\"") + 4;
        int yIndex = svg.indexOf("cy=\"") + 4;
        int radiusIndex = svg.indexOf("r=\"") + 3;
        int fillIndex = svg.indexOf("fill=\"") + 6;
//        Constructor part
        int x = Integer.parseInt(svg.substring(xIndex, svg.indexOf("\"", xIndex)));
        int y = Integer.parseInt(svg.substring(yIndex, svg.indexOf("\"", yIndex)));
        String fill = svg.substring(fillIndex, svg.indexOf("\"", fillIndex));

        super(x, y, fill);
        this.radius = Integer.parseInt(svg.substring(radiusIndex, svg.indexOf("\"", radiusIndex)));
    }

    @Override
    public String toString() {
        return String.format("    <circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\" />",
                x, y, radius, fill);
    }

    @Override
    public String toPrint() {
        return String.format("circle %d %d %d %s",
                x, y, radius, fill);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
