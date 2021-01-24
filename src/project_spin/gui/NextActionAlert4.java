package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

public class NextActionAlert4 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (GUI.c1.isSelected()) {
			Corona.setLocation(Location.ANATOLIKI_MAKEDONIA_KAI_THRAKI);
		} else if (GUI.c2.isSelected()) {
			Corona.setLocation(Location.KEDRIKH_MAKEDONIA);
		} else if (GUI.c3.isSelected()) {
			Corona.setLocation(Location.DYTIKH_MAKEDONIA);
		} else if (GUI.c4.isSelected()) {
			Corona.setLocation(Location.IPEIROS);
		} else if (GUI.c5.isSelected()) {
			Corona.setLocation(Location.THESSALIA);
		} else if (GUI.c6.isSelected()) {
			Corona.setLocation(Location.IONIOI_NHSOI);
		} else if (GUI.c7.isSelected()) {
			Corona.setLocation(Location.DYTIKH_ELLADA);
		} else if (GUI.c8.isSelected()) {
			Corona.setLocation(Location.STEREA_ELLADA);
		} else if (GUI.c9.isSelected()) {
			Corona.setLocation(Location.ATTIKH);
		} else if (GUI.c10.isSelected()) {
			Corona.setLocation(Location.PELOPONNHSOS);
		} else if (GUI.c11.isSelected()) {
			Corona.setLocation(Location.BOREIO_AIGAIO);
		} else if (GUI.c12.isSelected()) {
			Corona.setLocation(Location.NOTIO_AIGAIO);
		} else if (GUI.c13.isSelected()) {
			Corona.setLocation(Location.KRITI);
		} else {
			Corona.setLocation(null);
		}
		GUI.gui7();
	}

}
