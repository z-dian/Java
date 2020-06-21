package API2.Polymorphism.Demo04;

public class laptop {
    //笔记本开机
    public void openLaptop() {
        System.out.println("笔记本开机");
    }

    //笔记本关机
    public void closeLaptop() {
        System.out.println("笔记本关机");
    }

    //使用USB
    public void useUsb(USB usb) {

        //判断是否有USB
        if(usb!=null){
            usb.open();
            if(usb instanceof mouse){
                mouse m = (mouse)usb;
                m.click();
            }else if(usb instanceof keyBoard){
                keyBoard k = (keyBoard)usb;
                k.knock();
            }
            usb.close();
        }
    }

}
