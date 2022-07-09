public class A {
    int x,y;
    public A() {
        x*=x;
        y*=y;
    }
    {
        x+=10;
        y+=10;
    }
    public void exibe() {
        System.out.printf("x=%d y=%d",x,y);
    }
}