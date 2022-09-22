package qa.spring.autotest.rest.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {

    int id;
    String name;
    String eat;
    int age;
}
