package model.employee;

public class Position {
    private String position_id;
    private String position_name;

    public Position(String position_id, String position_name) {
        this.position_id = position_id;
        this.position_name = position_name;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }
}
