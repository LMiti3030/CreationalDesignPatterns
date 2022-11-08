package mititelu.laura;

public class LaunchOrder {

    public static class Builder{
        //same fields as in LauncOrder class
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        //we can add parameteres to enforce that some fields are mandatory
        public Builder(){}

        public LaunchOrder build(){
            return new LaunchOrder(this);
        }

        public Builder bread(String bread){
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments){
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing){
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat){
            this.meat = meat;
            return this;
        }



    }


    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    public LaunchOrder(Builder builder){
            this.bread = builder.bread;
            this.condiments = builder.condiments;
            this.dressing = builder.dressing;
            this.meat = builder.meat;
    }



    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}
