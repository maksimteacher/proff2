package service;

import dao.GenericDaoImpl;
import domain.Theme;

public class ThemeServiceImpl extends ServiceImpl {
    GenericDaoImpl<Theme, Integer> dao = new GenericDaoImpl<>(Theme.class);

    public ThemeServiceImpl(Class type) {
        super(type);
    }


    public Theme findTheme(String themeName) {
        return dao.findByRestrictionEq("theme", themeName);
    }
}
