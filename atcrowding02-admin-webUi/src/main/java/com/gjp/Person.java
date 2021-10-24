package com.gjp;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component(value = "person")
@Data
public class Person {
    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
