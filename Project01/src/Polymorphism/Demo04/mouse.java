package Polymorphism.Demo04;

public class mouse implements USB{

    @Override
    public void open() {
        System.out.println("鼠标连接");
    }

    @Override
    public void close() {
        System.out.println("鼠标断开");
    }

    public void click(){
        System.out.println("鼠标点击...");
    }
}
