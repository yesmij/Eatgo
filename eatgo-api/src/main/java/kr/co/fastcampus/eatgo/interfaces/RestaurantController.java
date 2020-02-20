package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

//    private RestaurantRepository repository = new RestaurantRepository();
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//    @Autowired
//    private MenuItemRepository menuItemRespository;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
//        List<Restaurant> restaurants = new ArrayList<>();
//        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
//        restaurants.add(restaurant);

//        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> restaurants = restaurantService.getRestuarants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

        Restaurant restaurant = restaurantService.getRestaurant(id);

//        List<Restaurant> restaurants = new ArrayList<>();
//        restaurants.add(new Restaurant(id, "Bob zip", "Seoul"));
//        Restaurant restaurant = restaurantRepository.findById(id);
//
//        List<MenuItem> menuItems = menuItemRespository.findAllByRestaurantId(id);
//        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {

        String name = resource.getName();
        String address = resource.getAddress();

        Restaurant restaurant = new Restaurant( name, address);
        restaurantService.addRestaurant(restaurant);

        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Restaurant resource){

        String name = resource.getName();
        String address = resource.getAddress();
        restaurantService.updateRestaurant(id, name, address);
        return "{}";

    }
}
