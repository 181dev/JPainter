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
package imagez.brush;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * Paints with solid shapes of colour.
 * @author notzed
 */
public class SolidPainter extends BrushPainter {
	private final Paint paint;
	private final Shape shape;

	public SolidPainter(Paint paint, Shape shape) {
		this.paint = paint;
		this.shape = shape;
	}

	@Override
	public void begin(Graphics2D gg, double x, double y) {
		super.begin(gg, x, y);

		this.gg.setPaint(paint);
	}
	
	@Override
	public void paint(double px, double py, double length) {
		gg.translate(px, py);
		gg.fill(shape);
		gg.translate(-px, -py);
		
		Rectangle damaged = shape.getBounds();

		damaged.x += px - 4;
		damaged.y += py - 4;
		damaged.width += 8;
		damaged.height += 8;

		fireBrushDamaged(damaged);
	}
	
}
