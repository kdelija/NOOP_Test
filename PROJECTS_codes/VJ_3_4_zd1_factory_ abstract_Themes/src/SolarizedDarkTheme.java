
public class SolarizedDarkTheme implements AbsFactoryTheme {

	@Override
	public ScrollBar createScrollBar() {
		// TODO Auto-generated method stub
		SolarizedDarkThemeScrollBar solarizedDarkThemeScrollBar = new SolarizedDarkThemeScrollBar();
		return solarizedDarkThemeScrollBar;
	}

	@Override
	public Toolbar createToolbar() {
		// TODO Auto-generated method stub
		SolarizedDarkThemeToolbar solarizedDarkThemeToolbar = new SolarizedDarkThemeToolbar();
		return solarizedDarkThemeToolbar;
	}

	@Override
	public Window createWindow() {
		// TODO Auto-generated method stub
		SolarizedDarkThemeWindow solarizedDarkThemeWindow = new SolarizedDarkThemeWindow();
		return solarizedDarkThemeWindow;
	}

	@Override
	public MenuBar createMenuBar() {
		// TODO Auto-generated method stub
		SolarizedDarkThemeMenuBar solarizedDarkThemeMenuBar = new SolarizedDarkThemeMenuBar();
		return solarizedDarkThemeMenuBar;
	}

	@Override
	public StatusBar createStatusBar() {
		// TODO Auto-generated method stub
		SolarizedDarkThemeStatusBar solarizedDarkThemeStatusBar = new SolarizedDarkThemeStatusBar();
		return solarizedDarkThemeStatusBar;
	}

}
