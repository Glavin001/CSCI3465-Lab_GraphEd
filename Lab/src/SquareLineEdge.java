import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * 
 */

/**
 * @author glavin
 *
 */
public class SquareLineEdge extends LineEdge {

	public void draw(Graphics2D g2)
	{
		Line2D cp = getConnectionPoints();
		
		GeneralPath polyline = 
		        new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);

		Point2D topPt = cp.getP1().getY() > cp.getP2().getY() ?  cp.getP1() :  cp.getP2();
		Point2D bottomPt = cp.getP1().getY() > cp.getP2().getY() ?  cp.getP2() :  cp.getP1();
		
		// Start
		polyline.moveTo ((int) topPt.getX(), (int) topPt.getY());

		// Draw Long line
		double hDist = (topPt.getX() - bottomPt.getX());
		double vDist = (topPt.getY() - bottomPt.getY());
		
		// Shorter 
		if (Math.abs(vDist) > Math.abs(hDist)) {
			// Vertical is shorter
			polyline.lineTo((int) topPt.getX() - hDist/2, (int) topPt.getY());
			polyline.lineTo((int) bottomPt.getX() + hDist/2, (int) bottomPt.getY());
		}
		else
		{
			// Horizontal is shorter
			polyline.lineTo((int) topPt.getX(), (int) topPt.getY() - vDist/2);
			polyline.lineTo((int) bottomPt.getX(), (int) bottomPt.getY() + vDist/2);	
		}
		
		// End
        polyline.lineTo((int) bottomPt.getX(), (int) bottomPt.getY());
		
		g2.draw(polyline);
		
	}

}
