package br.com.aleandro.java.back.end.services;

import br.com.aleandro.java.back.end.dtos.UserDTO;
import br.com.aleandro.java.back.end.models.User;
import br.com.aleandro.java.back.end.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserDTO::convert).orElse(null);
    }

    public UserDTO save(UserDTO userDTO) {
        User userSaved = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(userSaved);
    }

    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }
    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
}
