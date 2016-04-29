package service;

import domain.Role;

public class RoleServiceImpl extends ServiceImpl {

    public RoleServiceImpl(Class type) { super(type); }

    public Role findRole (String roleName) {
        return (Role) dao.findAllByRestrictionEq("role", roleName);
    }
}
