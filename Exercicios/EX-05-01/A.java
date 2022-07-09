public class A {
    protected int x=10,y=20;
    public void ma1(int z) {
        x+=y*z;
    }
    public void ma2() {
        y=x*y;
    }
    public void ma3(int w) {
        ma1(w);
        ma2();
    }
    public void exibe() {
        System.out.printf("x=%d y=%d",x,y);
    }
}