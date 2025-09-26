package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET todos los usuarios
    @GetMapping
public List<Object> getAllUsers() {
    return userRepository.findAll().stream().map(user -> new Object() {
        public final Object name = new Object() {
            public final String title = user.getName_title() != null ? user.getName_title() : "";
            public final String first = user.getFirst_name() != null ? user.getFirst_name() : "";
            public final String last = user.getLast_name() != null ? user.getLast_name() : "";
        };
        public final String gender = user.getGender();
        public final String email = user.getEmail();
        public final String phone = user.getPhone();
        public final Object location = new Object() {
            public final String state = user.getState() != null ? user.getState() : "";
            public final String city = user.getCity() != null ? user.getCity() : "";
            public final int postcode = user.getPostcode() != null ? user.getPostcode() : 0;
        };
        public final Object picture = new Object() {
            public final String large = user.getPicture_large() != null ? user.getPicture_large() : "https://via.placeholder.com/150";
        };
        public final Object login = new Object() {
            public final String uuid = user.getId() != null ? user.getId().toString() : "";
        };
    }).collect(Collectors.toList());
}



    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

   @DeleteMapping("/{id}")
public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
    try {
        userRepository.deleteById(id); // borra solo ese registro
        return ResponseEntity.ok(Map.of("estatus", 200, "message", "Usuario eliminado"));
    } catch (Exception e) {
        return ResponseEntity.status(500).body(Map.of("estatus", 500, "message", "Error al eliminar"));
    }
}



}
