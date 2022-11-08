package mititelu.laura;

public class LaunchOrderDemo {

    public static void main(String[] args) {
        LaunchOrderBean launchOrderBean = new LaunchOrderBean();

        launchOrderBean.setBread("Wheat");
        launchOrderBean.setCondiments("Lettuce");
        launchOrderBean.setDressing("Mustard");
        launchOrderBean.setMeat("Ham");

        System.out.println(launchOrderBean.getBread());
        System.out.println(launchOrderBean.getCondiments());
        System.out.println(launchOrderBean.getDressing());
        System.out.println(launchOrderBean.getMeat());
    }

}
