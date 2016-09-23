
public class pixelStore{
    private int[] pixel;
	private short[] RGBval;
	public pixelStore(int x, int y,short r,short g,short b){
		pixel=new int[2];
		RGBval=new short[3];
		pixel[0]=x;
		pixel[1]=y;		
		RGBval[0]=r;
		RGBval[1]=g;
		RGBval[2]=b;
	}
	public int[] getPixel(){
		return pixel;
	}
	public short[] getRGB(){
		return RGBval;
	}
	public short[] sumRGB(pixelStore st){
		short[] otherRGB=st.getRGB();
		short[] result=new short[otherRGB.length];
		for(int i=0;i<otherRGB.length;i++){
			result[i]=(short)(otherRGB[i]+this.RGBval[i]);
		}
		return result;
	}
	public int[] sumPixel(pixelStore st){
		int[] otherPixel=st.getPixel();
		int[] result=new int[otherPixel.length];
		for(int i=0;i<otherPixel.length;i++){
			result[i]=otherPixel[i]+this.pixel[i];
		}
		return result;
	}
	public void avePixel(int r){
		for(int i=0;i<RGBval.length;i++){
			RGBval[i]=(short)(RGBval[i]/((short)r));
		}
		for(int i=0;i<pixel.length;i++){
			pixel[i]=pixel[i]/r;
		}
	}
}