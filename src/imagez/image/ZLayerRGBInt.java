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
package imagez.image;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;

/**
 * Backed by fast 32 bit rgb layer.
 * @author notzed
 */
public class ZLayerRGBInt extends ZLayerRGB {

	int[] data;
	SinglePixelPackedSampleModel psm;

	public ZLayerRGBInt(ZImage zimage, Rectangle bounds) {
		super(zimage, bounds);

		this.bimage = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_RGB);
		this.psm = (SinglePixelPackedSampleModel) bimage.getSampleModel();
		WritableRaster raster = bimage.getRaster();
		this.data = ((DataBufferInt) raster.getDataBuffer()).getData();
	}

	public ZLayerRGBInt(ZImage zimage, BufferedImage image) {
		super(zimage, image.getRaster().getBounds());

		this.bimage = image;
		this.psm = (SinglePixelPackedSampleModel) image.getSampleModel();
		WritableRaster raster = image.getRaster();
		this.data = ((DataBufferInt) raster.getDataBuffer()).getData();

		assert psm.getNumDataElements() == 4;
	}


	@Override
	public int getStride() {
		return bounds.width;
	}

	@Override
	public void clear(Rectangle rect) {
		int doff = psm.getOffset(rect.x - bounds.x, rect.y - bounds.y);
		int width = rect.width;
		int height = rect.height;
		int dmod = psm.getScanlineStride() - width;

		for (int y=0;y<height;y++) {
			for (int x =0;x<width;x++) {
				data[doff++] = 0;
			}
			doff += dmod;
		}
	}

	@Override
	public void getLineRGBA(float[] dst, int doff, int x, int y, int width) {
		int soff = psm.getOffset(x - bounds.x, y - bounds.y);
		float scale = 1.0f / 255.0f;

		for (int i = 0; i < width; i++) {
			int v = data[soff++];

			dst[doff + 3] = 1;
			dst[doff + 0] = ((v >> 16) & 0xff) * scale;
			dst[doff + 1] = ((v >> 8) & 0xff) * scale;
			dst[doff + 2] = ((v >> 0) & 0xff) * scale;
			doff += 4;
		}
	}

	@Override
	public void setLineRGBA(float[] src, int soff, int x, int y, int width) {
		int doff = psm.getOffset(x - bounds.x, y - bounds.y);
		float scale = 255.0f;
		float br = bgRed;
		float bg = bgGreen;
		float bb = bgBlue;;

		for (int i = 0; i < width; i++) {
			float A = src[soff+3];
			float a1 = 1-A;
			int R = (int) ((br * a1 + src[soff+0]) * scale + 0.5f);
			int G = (int) ((bg * a1 + src[soff+1]) * scale + 0.5f);
			int B = (int) ((bb * a1 + src[soff+2]) * scale + 0.5f);

			soff += 4;

			R = Math.max(R, 0);
			G = Math.max(G, 0);
			B = Math.max(B, 0);
			//A = Math.max(A, 0);
			R = Math.min(R, 255);
			G = Math.min(G, 255);
			B = Math.min(B, 255);
			//A = Math.min(A, 255);

			data[doff++] = (R<<16) | (G<<8) | B;
		}
	}

	@Override
	public int getChannelCount() {
		return 3;
	}

	@Override
	public void getLine(float[][] dst, int doff, int x, int y, int width) {
		int soff = psm.getOffset(x - bounds.x, y - bounds.y);
		float scale = 1.0f / 255.0f;

		for (int i = 0; i < width; i++) {
			int v = data[soff++];

			dst[0][doff] = ((v >> 16) & 0xff) * scale;
			dst[1][doff] = ((v >> 8) & 0xff) * scale;
			dst[2][doff] = ((v >> 0) & 0xff) * scale;
			doff ++;
		}
	}

	@Override
	public void setLine(float[][] src, int soff, int x, int y, int width) {
		int doff = psm.getOffset(x - bounds.x, y - bounds.y);
		float scale = 255.0f;

		for (int i = 0; i < width; i++) {
			int R = (int) (src[0][soff] * scale + 0.5f);
			int G = (int) (src[1][soff] * scale + 0.5f);
			int B = (int) (src[2][soff] * scale + 0.5f);

			soff += 1;

			R = Math.max(R, 0);
			G = Math.max(G, 0);
			B = Math.max(B, 0);

			R = Math.min(R, 255);
			G = Math.min(G, 255);
			B = Math.min(B, 255);

			data[doff++] = (R<<16) | (G<<8) | B;
		}
	}
}
