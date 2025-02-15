package az.emlak.emlakecommerce.services;

import az.emlak.emlakecommerce.dtos.auth.RegisterDto;
import az.emlak.emlakecommerce.dtos.user.UserCreateDto;
import az.emlak.emlakecommerce.dtos.user.UserDto;
import az.emlak.emlakecommerce.dtos.user.UserUpdateDto;

import java.util.List;

public interface UserService {
    boolean register(RegisterDto registerDto);


    boolean authenticate(String username, String password);

    List<UserDto> getAllUsers();

    void createUser(UserCreateDto userCreateDto);

    UserUpdateDto getUserByIdForUpdate(Long id);

    void updateUser(Long id, UserUpdateDto userUpdateDto);

    void deleteUserById(Long id);

    void assignRoleToUser(Long userId, Long roleId);

    void removeRoleFromUser(Long userId, Long roleId);
}
