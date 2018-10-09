package kitchen.goodboy.agentapp_goodboy.Items;


public class Hero {

    String name, number, address, status;

    public Hero(String name, String number, String address, String status) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }
}
