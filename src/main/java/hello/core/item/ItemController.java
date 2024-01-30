package hello.core.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index () {
        return "OK";
    }

    @PostMapping("/item/save")
    public String save(@RequestBody ItemSaveRequest itemSaveRequest) {
        System.out.println(itemSaveRequest.getName());
        service.save(itemSaveRequest);
        return "OK";
    }
}
