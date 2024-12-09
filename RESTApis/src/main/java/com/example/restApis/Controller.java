package com.example.restApis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    private static Map<Integer, String> data = new HashMap<>();

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getData(@PathVariable int id) {
        if (data.containsKey(id)) {
            return ResponseEntity.ok("Data: " + data.get(id));
        } else {
            return ResponseEntity.status(404).body("Data not found with ID: " + id);
        }
    }

    // POST API to create data
    @PostMapping("/create")
    public ResponseEntity<String> createData(@RequestBody String value) {
        int id = data.size() + 1;
        data.put(id, value);
        return ResponseEntity.status(201).body("Data created with ID: " + id);
    }

    // PUT API to update data
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateData(@PathVariable int id, @RequestBody String value) {
        if (data.containsKey(id)) {
            data.put(id, value);
            return ResponseEntity.ok("Data updated with ID: " + id);
        } else {
            return ResponseEntity.status(404).body("Data not found with ID: " + id);
        }
    }

    // DELETE API to remove data
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable int id) {
        if (data.containsKey(id)) {
            data.remove(id);
            return ResponseEntity.ok("Data deleted with ID: " + id);
        } else {
            return ResponseEntity.status(404).body("Data not found with ID: " + id);
        }
    }
}
