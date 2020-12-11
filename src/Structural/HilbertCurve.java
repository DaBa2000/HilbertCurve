package Structural;

import java.util.ArrayList;
import java.util.List;

import GUI.PointListGui;

public class HilbertCurve {

	private List<Point> curve;

	public HilbertCurve() {
		curve = new ArrayList<Point>();
		curve.add(new Point(0, 0));
		curve.add(new Point(0, 1));
		curve.add(new Point(1, 1));
		curve.add(new Point(1, 0));
	}

	public List<Point> getCurve() {
		return curve;
	}	

	public void setCurve(List<Point> curve) {
		this.curve = curve;
	}

	public int getSideLength() {
		if (curve.size() < 4)
			return 1;
		if (curve.get(curve.size() - 1).getX() - curve.get(0).getX() == 0)
			return 1;
		return curve.get(curve.size() - 1).getX() - curve.get(0).getX();
	}

	public void step() {
		List<Point> newCurve = new ArrayList<Point>();
		int x = 0, y = 0;

		int length = curve.get(curve.size() - 1).getX() - curve.get(0).getX();
		for (int j = 0; j < curve.size(); j++) {
			Point p = curve.get(j);
			newCurve.add(new Point(x + p.getY(), y + p.getX()));
		}

		y += length + 1;

		for (int j = 0; j < curve.size(); j++) {
			Point p = curve.get(j);
			newCurve.add(new Point(x + p.getX(), y + p.getY()));
		}

		x += length + 1;

		for (int j = 0; j < curve.size(); j++) {
			Point p = curve.get(j);
			newCurve.add(new Point(x + p.getX(), y + p.getY()));
		}

		y -= length + 1;

		for (int j = 0; j < curve.size(); j++) {
			Point p = curve.get(j);
			newCurve.add(new Point(x + (length - p.getY()), y + (length - p.getX())));
		}

		curve = newCurve;
	}

	public void stepBack() {
		List<Point> newCurve = new ArrayList<Point>();

		if (curve.size() <= 4)
			return;

		for (int i = 0; i < curve.size() / 4; i++) {
			newCurve.add(new Point(curve.get(i).getY(), curve.get(i).getX()));
		}

		curve = newCurve;
	}
}
