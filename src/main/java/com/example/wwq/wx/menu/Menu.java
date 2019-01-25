package com.example.wwq.wx.menu;

public class Menu {


    //一级菜单
    private Button[] button;


    public Button[] getButton() {
        return button;
    }


    public void setButton(Button[] button) {
        this.button = button;
    }

    //创建新增菜单的方法
    public static Menu initMenu() {
        Menu menu = new Menu();
//        ClickButton button11 = new ClickButton();
//        button11.setName("click菜单");
//        button11.setType("click");
//        button11.setKey("11");

        ViewButton button21 = new ViewButton();
        button21.setName("万物商城");
        button21.setType("view");
        button21.setUrl("http://www.wanwuquanhn.com");//我这里测试使用百度网站
//
//        ClickButton button31 = new ClickButton();
//        button31.setName("扫码事件");
//        button31.setType("scancode_push");
//        button31.setKey("31");
//
//        ClickButton button32 = new ClickButton();
//        button32.setName("地理位置");
//        button32.setType("location_select");
//        button32.setKey("32");
//
//        Button button = new Button();
//        button.setName("菜单");
//        button.setSub_button(new Button[]{button31,button32});

        menu.setButton(new Button[]{button21});
        return menu;
    }
}
