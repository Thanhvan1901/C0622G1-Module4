package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducManagerService implements IProducManagerService {

    private static final Map<Integer,Product> products ;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1 ,"Iphone X", 10000000,"90% new" ,"Apple"));
        products.put(2,new Product(2 ,"Iphone X Max", 10000000,"99% new" ,"Apple"));
        products.put(3,new Product(3 ,"Iphone 12 Pro Max", 10000000,"95% new" ,"Apple"));
        products.put(4,new Product(4 ,"Iphone 13 Pro Max", 10000000,"96% new" ,"Apple"));
        products.put(5,new Product(5 ,"Iphone 14 Pro Max", 10000000,"New Line" ,"Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product produc) {
        products.put(produc.getId() , produc);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product produc) {
        products.put(produc.getId(),produc);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer,Product> item: products.entrySet()) {
            if(item.getValue().getName().contains(name)){
                productList.add(item.getValue());
            }
        }
        return productList ;
    }
    
}
