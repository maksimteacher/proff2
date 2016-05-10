package start;

import domain.Theme;
import service.ThemeServiceAbstract;

public class Runner {
    public static void main(String[] args) {
        Theme theme = new Theme();
        theme.setTheme("First Theme");
        Theme theme2 = new Theme();
        theme2.setTheme("Second Theme");
        Theme theme3 = new Theme();
        theme3.setTheme("Third Theme");

        ThemeServiceAbstract themeService = new ThemeServiceAbstract(Theme.class);
        themeService.add(theme);
        themeService.add(theme2);
        themeService.add(theme3);

    }
}

