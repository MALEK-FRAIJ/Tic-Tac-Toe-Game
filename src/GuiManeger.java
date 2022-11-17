import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class GuiManeger {

	public GuiManeger() {
		
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
