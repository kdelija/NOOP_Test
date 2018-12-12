
public class LightVisualTheme implements AbsFactoryTheme {

	@Override
	public ScrollBar createScrollBar() {
		// TODO Auto-generated method stub
		LightVisualThemeScrollBar lightVisualThemeScrollBar = new LightVisualThemeScrollBar();
		return lightVisualThemeScrollBar;
	}

	@Override
	public Toolbar createToolbar() {
		// TODO Auto-generated method stub
		LightVisualThemeToolbar lightVisualThemeToolbar = new LightVisualThemeToolbar();
		return lightVisualThemeToolbar;
	}

	@Override
	public Window createWindow() {
		// TODO Auto-generated method stub
		LightVisualThemeWindow lightVisualThemeWindow = new LightVisualThemeWindow();
		return lightVisualThemeWindow;
	}

	@Override
	public MenuBar createMenuBar() {
		// TODO Auto-generated method stub
		LightVisualThemeMenuBar lightVisualThemeMenuBar = new LightVisualThemeMenuBar();
		return lightVisualThemeMenuBar;
	}

	@Override
	public StatusBar createStatusBar() {
		// TODO Auto-generated method stub
		LightVisualThemeStatusBar lightVisualThemeStatusBar = new LightVisualThemeStatusBar();
		return lightVisualThemeStatusBar;
	}

}
