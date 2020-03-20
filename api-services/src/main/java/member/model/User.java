package member.model;

import lombok.Data;

/**
 * 用户
 *
 * @Author lixp23692
 * @Date 2019/8/30
 */
@Data
public class User {
    private int id;
    private String name;
    private Integer age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOtherDate() {
        return otherDate;
    }

    public void setOtherDate(String otherDate) {
        this.otherDate = otherDate;
    }
}
