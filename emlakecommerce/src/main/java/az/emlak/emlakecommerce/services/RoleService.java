package az.emlak.emlakecommerce.services;

import az.emlak.emlakecommerce.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role saveRole(Role role);
    void deleteRole(Long id);
    Role updateRole(Role role);

}
