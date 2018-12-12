
public class Client {
	
	private AbsFactoryTheme abs;
	private Window window;
	private StatusBar statusBar;
	private ScrollBar scrollBar;
	private MenuBar menuBar;
	private Toolbar toolbar;
	
	
	
	public Client(AbsFactoryTheme abs) {
		// TODO Auto-generated constructor stub
		this.abs = abs;
		createElements();
	}
	
	public void createElements() {
		
		window = abs.createWindow();
		toolbar = abs.createToolbar();
		scrollBar = abs.createScrollBar();
		statusBar = abs.createStatusBar();
		menuBar = abs.createMenuBar();
		
		renderElements();
		
	}
	
	public void renderElements() {
		
		window.rendering();
		toolbar.rendering();
		scrollBar.rendering();
		statusBar.rendering();
		menuBar.rendering();
	}

}
