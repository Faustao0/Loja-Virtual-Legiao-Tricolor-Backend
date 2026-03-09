package com.legiaotricolor.BackLegiaoTricolor;

import com.legiaotricolor.BackLegiaoTricolor.domain.Category;
import com.legiaotricolor.BackLegiaoTricolor.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CategoryInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {

        createIfNotExists("Camisetas", "Produtos de camisetas");
        createIfNotExists("Calças", "Produtos de calças");
        createIfNotExists("Bonés", "Produtos de bonés");
        createIfNotExists("Acessórios", "Produtos acessórios");
    }

    private void createIfNotExists(String name, String description) {

        if (categoryRepository.findByNameIgnoreCase(name).isEmpty()) {

            Category category = Category.builder()
                    .name(name)
                    .description(description)
                    .build();

            categoryRepository.save(category);
        }
    }
}
