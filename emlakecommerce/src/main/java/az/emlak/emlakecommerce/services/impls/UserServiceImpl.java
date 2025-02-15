package az.emlak.emlakecommerce.services.impls;

import az.emlak.emlakecommerce.dtos.auth.RegisterDto;
import az.emlak.emlakecommerce.dtos.user.UserCreateDto;
import az.emlak.emlakecommerce.dtos.user.UserDto;
import az.emlak.emlakecommerce.dtos.user.UserUpdateDto;
import az.emlak.emlakecommerce.model.Role;
import az.emlak.emlakecommerce.model.UserEntity;
import az.emlak.emlakecommerce.repositories.RoleRepository;
import az.emlak.emlakecommerce.repositories.UserRepository;
import az.emlak.emlakecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(RegisterDto registerDto) {
        UserEntity findUser =userRepository.findByEmail(registerDto.getEmail());
        if(findUser != null){
            return false;
        }
        UserEntity newUser = modelMapper.map(registerDto,UserEntity.class);
        String password = passwordEncoder.encode(registerDto.getPassword());
        newUser.setPassword(password);
        userRepository.save(newUser);
        return true;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserDto userDto = modelMapper.map(user, UserDto.class);
                    userDto.setRoles(user.getRoles()
                            .stream()
                            .map(Role::getName) // Rol isimlerini alıyoruz
                            .collect(Collectors.toSet()));
                    return userDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void createUser(UserCreateDto userCreateDto) {
        UserEntity user = modelMapper.map(userCreateDto, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));

        // Role eşleme
        Set<Role> roles = userCreateDto.getRoleIds()
                .stream()
                .map(roleId -> roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleId)))
                .collect(Collectors.toSet());
        user.setRoles(roles);

        userRepository.save(user);
    }

    @Override
    public UserUpdateDto getUserByIdForUpdate(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        UserUpdateDto userUpdateDto = modelMapper.map(user, UserUpdateDto.class);

        // Kullanıcının rollerini roleIds'e ekleyin
        Set<Long> roleIds = user.getRoles().stream()
                .map(Role::getId)
                .collect(Collectors.toSet());
        userUpdateDto.setRoleIds(roleIds);

        return userUpdateDto;
    }


    @Override
    public void updateUser(Long id, UserUpdateDto userUpdateDto) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        modelMapper.map(userUpdateDto, user);

        // Rolleri güncelleyin
        Set<Role> roles = userUpdateDto.getRoleIds().stream()
                .map(roleId -> roleRepository.findById(roleId).orElseThrow())
                .collect(Collectors.toSet());
        user.setRoles(roles);

        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void assignRoleToUser(Long userId, Long roleId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            UserEntity user = userOptional.get();
            Role role = roleOptional.get();
            user.getRoles().add(role);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User or Role not found.");
        }
    }

    @Override
    public void removeRoleFromUser(Long userId, Long roleId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            UserEntity user = userOptional.get();
            Role role = roleOptional.get();
            user.getRoles().remove(role);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User or Role not found.");
        }
    }

}
