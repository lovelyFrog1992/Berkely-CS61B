import java.io.*;

public class Nuke2{
	public static void main(String[] arg) throws Exception{
		BufferedReader rd;
		String str;
		try{
			rd=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Your input:");
			str=rd.readLine();
			if(str.length()<2){
				System.out.println("You should input string more than 1 characters");
			}else{
				String str2=str.substring(0,1)+str.substring(2);
				System.out.println(str2);
			}
		}catch(Exception e){
			System.out.println("Illegal String");
		}
	}
}