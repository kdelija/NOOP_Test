
public class DarkTheme implements AbsFactoryTheme {

	@Override
	public ScrollBar createScrollBar() {
		// TODO Auto-generated method stub
		DarkThemeScrollBar darkThemeScrollBar = new DarkThemeScrollBar();
		return darkThemeScrollBar;
	}

	@Override
	public Toolbar createToolbar() {
		// TODO Auto-generated method stub
		DarkThemeToolbar darkThemeToolbar = new DarkThemeToolbar();
		return darkThemeToolbar;
	}

	@Override
	public Window createWindow() {
		// TODO Auto-generated method stub
		DarkThemeWindow darkThemeWindow = new DarkThemeWindow();
		return darkThemeWindow;
	}

	@Override
	public MenuBar createMenuBar() {
		// TODO Auto-generated method stub
		DarkThemeMenuBar darkThemeMenuBar = new DarkThemeMenuBar();
		return darkThemeMenuBar;
	}

	@Override
	public StatusBar createStatusBar() {
		// TODO Auto-generated method stub
		DarkThemeStatusBar darkThemeStatusBar = new DarkThemeStatusBar();
		return darkThemeStatusBar;
	}

}
