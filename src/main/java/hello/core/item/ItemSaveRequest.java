package hello.core.item;

import lombok.Data;

@Data
public class ItemSaveRequest {
    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String imagePath;
}
