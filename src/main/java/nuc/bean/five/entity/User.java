package nuc.bean.five.entity;

import lombok.Data;

@Data
public class User {
    private String idcard;
    private String name;
    private String sex;
    private String phone;


    public User() {
    }

    public User(String idcard, String name, String sex, String phone) {
        this.idcard = idcard;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "idcard='" + idcard + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
