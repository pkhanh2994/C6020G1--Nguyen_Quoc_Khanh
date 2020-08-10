package OOP.bai_tap;

public class Shape {
        protected String color;
        protected boolean filled;
        public Shape(){
            this.color="green";
            this.filled=true;
        }
        public Shape(String color,boolean filled){
            this.color=color;
            this.filled=filled;
        }

        public String getColor() {
            return color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public String toString() {
            return "A Shape with color of "
                    + getColor()
                    + " and "
                    + (isFilled() ? "filled" : "not filled");
        }
}
