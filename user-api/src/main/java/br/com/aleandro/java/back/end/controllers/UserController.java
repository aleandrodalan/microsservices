package br.com.aleandro.java.back.end.controllers;

import br.com.aleandro.java.back.end.dtos.UserDTO;
import br.com.aleandro.java.back.end.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }
    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }
    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    @GetMapping("/user/search")
    public List<UserDTO> queryByName(
            @RequestParam(name="nome", required = true)
            String nome) {
        return userService.queryByName(nome);
    }
}
