package guijo.la.chupa.spring.service;

import guijo.la.chupa.spring.dto.UserDTO;
import guijo.la.chupa.spring.model.User;
import guijo.la.chupa.spring.repos.UserRepository;
import guijo.la.chupa.spring.util.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> findAll() {
        final List<User> users = userRepository.findAll(Sort.by("dni"));
        return users.stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .toList();
    }

    public UserDTO get(final Long dni) {
        return userRepository.findById(dni)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getDni();
    }

    public void update(final Long dni, final UserDTO userDTO) {
        final User user = userRepository.findById(dni)
                .orElseThrow(NotFoundException::new);
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long dni) {
        userRepository.deleteById(dni);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setDni(user.getDni());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        return user;
    }

}
