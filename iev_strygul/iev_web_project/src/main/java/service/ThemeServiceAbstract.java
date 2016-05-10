package service;

import dao.GenericDaoImpl;
import domain.Theme;

public class ThemeServiceAbstract extends ServiceAbstract {
    GenericDaoImpl<Theme, Integer> dao = new GenericDaoImpl<>(Theme.class);

    public ThemeServiceAbstract(Class type) {
        super(type);
    }

}
