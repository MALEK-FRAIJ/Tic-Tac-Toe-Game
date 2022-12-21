import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class GuiManager {

	public GuiManager() {
		
		try {

            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {

                    UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        } catch (Exception e) {
        }
	}
}
