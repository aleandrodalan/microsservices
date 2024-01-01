package br.com.aleandro.java.back.end.controllers;

import br.com.aleandro.java.back.end.dtos.UserDTO;
import br.com.aleandro.java.back.end.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.noContent().build();
    }
    @PostMapping("/")
    public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO userDTO) {
        UserDTO userSaved = userService.save(userDTO);
        return userSaved != null ? ResponseEntity.ok(userSaved) : ResponseEntity.noContent().build();
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
        UserDTO userDTO = userService.findByCpf(cpf);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> queryByName(@RequestParam(name="nome", required = true) String nome) {
        List<UserDTO> users = userService.queryByName(nome);
        return !users.isEmpty() ? ResponseEntity.ok(userService.queryByName(nome)) : ResponseEntity.noContent().build();
    }
}
