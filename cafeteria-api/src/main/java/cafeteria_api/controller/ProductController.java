package cafeteria_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import cafeteria_api.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;
import cafeteria_api.service.ProductService;

@RestController
@Tag(
    name = "Produtos",
    description = "Operações relacionadas aos produtos da cafeteria"
)
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
        summary = "Lista todos os produtos",
        description = "Retorna todos os produtos disponíveis na cafeteria"
    )
    @GetMapping("/products")
    public List<Product> getProducts() {

        return productService.getAllProducts();
    }

    @Operation(
        summary = "Busca um produto pelo ID",
        description = "Retorna os dados de um produto específico"
    )
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(
            @Parameter(description = "ID do produto")
            @PathVariable Long id) {

        Product product = productService.getProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }
    @Operation(
        summary = "Cadastra um novo produto",
        description = "Cria um novo produto e adiciona à lista de produtos da cafeteria"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Produto criado com sucesso"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Dados inválidos"
        )
    })
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @Operation(
    summary = "Atualiza um produto",
    description = "Atualiza o nome e o preço de um produto existente"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Produto atualizado com sucesso"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Produto não encontrado"
        )
    })
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product updatedProduct =
            productService.updateProduct(id, product);

        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedProduct);
    }
    
    @Operation(
        summary = "Remove um produto",
        description = "Remove um produto existente pelo seu ID"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "Produto removido com sucesso"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Produto não encontrado"
        )
    })
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        boolean deleted = productService.deleteProduct(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}