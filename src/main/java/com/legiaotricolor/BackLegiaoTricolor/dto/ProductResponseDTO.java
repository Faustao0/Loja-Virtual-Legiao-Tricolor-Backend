package com.legiaotricolor.BackLegiaoTricolor.dto;

import com.legiaotricolor.BackLegiaoTricolor.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ProductResponseDTO {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private Boolean active;
    private String categoryName;
    private String imageUrl;
    List<ProductImageDTO> images;

    public ProductResponseDTO(Product product) {
    }
}
