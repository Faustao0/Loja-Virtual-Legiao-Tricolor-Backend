package com.legiaotricolor.BackLegiaoTricolor;

import com.legiaotricolor.BackLegiaoTricolor.domain.Category;
import com.legiaotricolor.BackLegiaoTricolor.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public CategoryInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {

        createIfNotExists("Camisetas", "Produtos de camisetas");
        createIfNotExists("Calças", "Produtos de calças");
        createIfNotExists("Bonés", "Produtos de bonés");
        createIfNotExists("Acessórios", "Produtos acessórios");
    }

    private void createIfNotExists(String name, String description) {

        if (categoryRepository.findByNameIgnoreCase(name).isEmpty()) {

            Category category = new Category();
            category.setName(name);
            category.setDescription(description);

            categoryRepository.save(category);
        }
    }
}
