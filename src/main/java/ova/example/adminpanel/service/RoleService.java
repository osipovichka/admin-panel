package ova.example.adminpanel.service;

public interface RoleService {
    /**
     * Добавить пользователю роль.
     *
     * @param userId roleId id пользователя, роли.
     */
    public void addUserRole(long userId, long roleId);

    /**
     * Удалять у пользователя роль.
     *
     * @param userId roleId пользователя, роли.
     */
    public void deleteUserRole(long userId, long roleId);
}
