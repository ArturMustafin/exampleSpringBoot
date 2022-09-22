package qa.spring.autotest.rest;

import org.springframework.web.bind.annotation.*;
import qa.spring.autotest.rest.Dto.Cat;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cat")
public class CatController {

    Map<Integer, Cat> data = new HashMap<>();

    @PostConstruct
    void initData() {
        data.put(1, new Cat(1, "Tom", "Proplan", 3));
        data.put(2, new Cat(1, "Bob", "Wiskas", 1));
    }

    @GetMapping("/{id}")
    public Cat get(@PathVariable int id) {
        return data.get(id);
    }

    @GetMapping("/all")
    public List<Cat> get() {
        return new ArrayList<>(data.values());
    }

    @PostMapping()
    public void save(@RequestBody Cat cat) {
        int id = data.size() + 1;
        cat.setId(id);
        data.put(id, cat);
    }

    @PutMapping("/{id}")
    public void change(@PathVariable int id, @RequestBody Cat catChanging) {
        Cat cat = data.get(id);
        cat.setAge(catChanging.getAge());
        cat.setEat(catChanging.getEat());
        cat.setName(catChanging.getName());
        data.put(id, cat);
    }

    @PatchMapping("/{id}")
    public void fix(@PathVariable int id, @RequestBody Cat catChanging) {
        Cat cat = data.get(id);

        if (catChanging.getName() != null) cat.setName(catChanging.getName());
        if (catChanging.getAge() != 0) cat.setAge(catChanging.getAge());
        if (catChanging.getEat() != null) cat.setEat(catChanging.getEat());

        data.put(id, cat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        data.remove(id);
    }
}
