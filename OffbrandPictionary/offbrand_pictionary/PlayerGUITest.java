package offbrand_pictionary;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class PlayerGUITest {

	private static PlayerGUI pGUI;
	private static Client client;
	
	private static WelcomePanel view1; 
	private static LoginPanel view2; 
	private static CreateAccountPanel view3; 
	private static GenLobbyPanel view4; 
    private static JoinLobbyPanel view5;
    private static WaitingRoomPanel view6;
    private static DrawerPanel view7;
    private static GuesserPanel view8;
    private static WinningPanel view9;
    
    private static WelcomeControl wc;
    private static LoginControl lc;
    private static CreateAccountControl cac;
    private static GenLobbyControl glc;
    private static JoinLobbyControl jlc;
    private static WaitingRoomControl wrc;
    private static DrawerControl dc;
    private static GuessControl gc;
    private static WinningControl winc;
	
	private JButton creActButton;
	private JButton submitButton;

	@BeforeClass
	public static void setUp()
	{
		pGUI = new PlayerGUI();
		
		client = new Client();
		client.setHost("localhost");
		client.setPort(8300);
		try {
			client.openConnection();
		} catch (IOException e) { e.printStackTrace(); }
		
		pGUI.setTitle("Offbrand Pictionary");
		pGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);
		PaintPanel canvas = new PaintPanel(418, 288);
		
		wc = new WelcomeControl(container);
		lc = new LoginControl(container, client);
		cac = new CreateAccountControl(container, client);
	    glc = new GenLobbyControl(container, client);
	    jlc = new JoinLobbyControl(container, client);
	    wrc = new WaitingRoomControl(container, client);
	    dc = new DrawerControl(container, client, canvas);
	    gc = new GuessControl(container, client);
	    winc = new WinningControl(container, client);
	    
	    canvas.setDrawControl(dc);
		client.setLoginControl(lc);
		client.setDrawerControl(dc);
		client.setGuessControl(gc);
		client.setCreateAccountControl(cac);
		client.setGenControl(glc);
		client.setJoinLobbyControl(jlc);
		client.setWaitControl(wrc);
		client.setWinningControl(winc);
		
		view1 = new WelcomePanel(wc);
		view2 = new LoginPanel(lc);
		view3 = new CreateAccountPanel(cac);
	    view4 = new GenLobbyPanel(glc);   
	    view5 = new JoinLobbyPanel(jlc);
	    view6 = new WaitingRoomPanel(wrc);
	    view7 = new DrawerPanel(dc, canvas);
	    view8 = new GuesserPanel(gc);
	    view9 = new WinningPanel(winc);

		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
	    container.add(view4, "4");
	    container.add(view5, "5");
	    container.add(view6, "6");
	    container.add(view7, "7");
	    container.add(view8, "8");
	    container.add(view9, "9");
		
		cardLayout.show(container, "1");
	
		pGUI.add(container, BorderLayout.CENTER);
		pGUI.setSize(650, 440);
		pGUI.setResizable(false);
		pGUI.setVisible(true);
	}
	
	@Before
	public void setupBeforeTest()throws Exception
	{
		creActButton = view1.getCreActButton();
		submitButton = view3.getSubmitButton();
		
	}
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(100);
		creActButton.doClick();
		Thread.sleep(500);
		view3.setUsername("test");
		Thread.sleep(200);
		view3.setPassword("testing123");
		Thread.sleep(200);
		view3.setReenteredPassword("testing123");
		Thread.sleep(200);
		submitButton.doClick();
		Thread.sleep(5000);
	}

}
