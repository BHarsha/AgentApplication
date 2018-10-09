package kitchen.goodboy.agentapp_goodboy.others;

/**
 * Created by ellipsoid on 21-10-2017.
 */

public class User {


    private String id, mobile, email, name, profession, refcode;

    public User(String id, String mobile, String email, String name, String profession, String refcode) {
        this.id = id;
        this.mobile = mobile;
        this.email = email;
        this.name = name;
        this.profession = profession;
        this.refcode = refcode;
    }

    public String getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getRefcode() {
        return refcode;
    }
}
