package Polymorphism.Demo04;

public class Demo01Test {
    public static void main(String[] args) {
        //创建笔记本实体对象
        laptop l = new laptop();
        //笔记本开机
        l.openLaptop();

        //创建鼠标实体对象
        USB usb = new mouse();

        //笔记本使用鼠标
        l.useUsb(usb);

        //创建键盘实体对象
        USB usb1 = new keyBoard();
        //笔记本使用键盘
        l.useUsb(usb1);

        //笔记本关机
        l.closeLaptop();
    }
}
