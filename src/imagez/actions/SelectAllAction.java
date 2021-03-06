/*
 *  Copyright (c) 2011 Michael Zucchi
 *
 *  This file is part of ImageZ, a bitmap image editing appliction.
 *
 *  ImageZ is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ImageZ is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with ImageZ.  If not, see <http://www.gnu.org/licenses/>.
 */
package imagez.actions;

import imagez.image.ZSelectionModel;
import imagez.ui.ImageWindow;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

/**
 *
 * @author notzed
 */
public class SelectAllAction extends AbstractWindowAction {

	public SelectAllAction() {
		super("Select All", null);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl A"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageWindow win = getWindow(e);
		ZSelectionModel sm = win.getImageView().getCurrentSelection();

		//sm.setAntiAliasingEnabled(false);
		//sm.setFeatherEnabled(false);
		sm.updateSelection(sm.MODE_REPLACE, new Rectangle(win.getImageView().getImage().getDimension()), false);
	}
}
