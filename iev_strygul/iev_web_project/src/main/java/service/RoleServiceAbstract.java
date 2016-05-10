package service;

import domain.Role;

public class RoleServiceAbstract extends ServiceAbstract {

    public RoleServiceAbstract(Class type) { super(type); }

    public Role findRole (String roleName) {
        return (Role) dao.findByRestrictionEq("role", roleName);
    }
}
