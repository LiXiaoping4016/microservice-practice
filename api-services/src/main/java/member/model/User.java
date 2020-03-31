package member.model;

import java.io.Serializable;

/**
 * 用户
 *
 * @Author lixp23692
 * @Date 2019/8/30
 */
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String otherDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOtherDate() {
        return otherDate;
    }

    public void setOtherDate(String otherDate) {
        this.otherDate = otherDate;
    }
}
