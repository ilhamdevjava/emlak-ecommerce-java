package az.emlak.emlakecommerce.services.impls;

import az.emlak.emlakecommerce.model.Role;
import az.emlak.emlakecommerce.repositories.RoleRepository;
import az.emlak.emlakecommerce.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + id));
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role updateRole(Role role) {
        Optional<Role> existingRole = roleRepository.findById(role.getId());
        if (existingRole.isEmpty()) {
            throw new IllegalArgumentException("Role not found with id: " + role.getId());
        }
        return roleRepository.save(role);
    }
}
