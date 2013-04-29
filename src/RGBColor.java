
public class RGBColor {
	private int rColor;
	private int gColor;
	private int bColor;
	
	RGBColor(int redColor, int greenColor, int blueColor){
		rColor = redColor;
		gColor = greenColor;
		bColor = blueColor;
	}
	
	public void setColor(int redColor, int greenColor, int blueColor){
		rColor = redColor;
		gColor = greenColor;
		bColor = blueColor;
	}
	
	public int getRedColor(){
		return rColor;
	}
	
	public int getGreenColor(){
		return gColor;
	}
	
	public int getBlueColor(){
		return bColor;
	}
}
