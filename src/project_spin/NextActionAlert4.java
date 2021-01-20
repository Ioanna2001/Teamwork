package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlert4 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (GUI.c1.isSelected()) {
			Corona.location = Location.ANATOLIKI_MAKEDONIA_KAI_THRAKI;
		} else if (GUI.c2.isSelected()) {
			Corona.location = Location.KEDRIKH_MAKEDONIA;
		} else if (GUI.c3.isSelected()) {
			Corona.location = Location.DYTIKH_MAKEDONIA;
		} else if (GUI.c4.isSelected()) {
			Corona.location = Location.HPEIROS;
		} else if (GUI.c5.isSelected()) {
			Corona.location = Location.UESSALIA;
		} else if (GUI.c6.isSelected()) {
			Corona.location = Location.IONIOI_NHSOI;
		} else if (GUI.c7.isSelected()) {
			Corona.location = Location.DYTIKH_ELLADA;
		} else if (GUI.c8.isSelected()) {
			Corona.location = Location.STEREA_ELLADA;
		} else if (GUI.c9.isSelected()) {
			Corona.location = Location.ATTIKH;
		} else if (GUI.c10.isSelected()) {
			Corona.location = Location.PELOPONNHSOS;
		} else if (GUI.c11.isSelected()) {
			Corona.location = Location.BOREIO_AIGAIO;
		} else if (GUI.c12.isSelected()) {
			Corona.location = Location.NOTIO_AIGAIO;
		} else if (GUI.c13.isSelected()) {
			Corona.location = Location.KRHTH;
		} else {
			Corona.location = null;
		}
		GUI.gui7();
	}

}
