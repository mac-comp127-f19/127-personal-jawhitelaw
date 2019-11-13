package maps;


import java.util.HashMap;
import java.util.Map;

public class RestaurantExplorer {
    public static void main(String [] args) {
        // Step 1. Create a new empty HashMap.
        // The keys should be the names of the restaurant.
        // The values should be the restaurant objects.

        Map<String, Restaurant> restaurantMap = new HashMap<>();

        // Step 2. Add five restaurants to the map (hint: use put()).

        restaurantMap.put("McDonalds", new Restaurant("McDonalds", "fast", 2));
        restaurantMap.put("Wendy's", new Restaurant("Wendy's", "fast", 2));
        restaurantMap.put("Dunn Bros", new Restaurant("Dunn Bros", "coffee", 3));
        restaurantMap.put("French Meadow", new Restaurant("French Meadow", "semi-formal", 5));
        restaurantMap.put("Cafe Mac", new Restaurant("Cafe Mac", "dining hall", 1));

        // Step 3. Print the names of each restaurant (hint: use keySet()).

        System.out.println(restaurantMap.keySet());

        // Step 4. Remove one of the restaurants by name. Check to make sure
        // it no longer exists and print out the result (hint: use containsKey()).

        restaurantMap.remove("McDonalds");
        System.out.println(restaurantMap.keySet());

        // Step 5. Print the restaurant objects (hint: use values())

        System.out.println(restaurantMap.values());

        // Step 6. Print the restaurant names and objects (hint: use entrySet()).

        System.out.println(restaurantMap.entrySet());

    }
}
