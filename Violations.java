package ChallenNew;
import java.util.*;
import java.io.*;


public class Violations {

              String vno;

              String vcat;

              String dtime;

              String loc;

              float amt;                     

                          

              public static void main(String[] args) throws IOException {

                           int max=1;

                           HashMap<String,ArrayList<String>> viols =new HashMap<>();

                           BufferedReader reader;

                           BufferedWriter writer;

                           try {
                           reader=new BufferedReader(new FileReader("D:\\Challan.txt"));

                           writer=new BufferedWriter(new FileWriter("D:\\totalchallan.txt"));

                           String line=reader.readLine();

                           while(line!=null)

                           {

                                         String[] sd=line.split(",");

                                         String vno=(sd[0]);

                                         String loc=(sd[1]);

                                         String dtime=(sd[2]);

                                         String vcat=(sd[3]);

                                         float amt=Float.parseFloat(sd[4]);

                                         ArrayList<String> list=new ArrayList<String>(); 

//                                          System.out.println(line);                      

                                         ArrayList<String> vs = viols.get(vno);
                                         
                        
                                         if(vs==null) {

                                                       vs=new ArrayList<>();

                                                       vs.add(line);

                                         }

                                         else

                                         {

                                                       vs.add(line);

                                                      

                                         }
                                         viols.put(vno, vs);

                                         if(vs.size()>max) {

                                                       max=vs.size();
                                         }
                                         line=reader.readLine();
                                         
                           }
                                   
                                                
                           for(int i=1;i<max+1;i++)

                                         {

                                                       System.out.println(i+"violation are listed below");
                                                       writer.write(i+"violation are listed below");
                                                       writer.newLine();
                                                       Set<String> keySet= viols.keySet();
                                                      
                                         
                                                       for(String key:keySet)

                           

                                                  	{

                                                       ArrayList<String> viols1=viols.get(key);
                                                       
                                                       
                                                        if((viols1!=null)&&(viols1.size()==i))

                                                       {

                                                    	   for(String s:viols1)
                                                    	   {
                                                    		   System.out.println(s);
                                                    		   writer.write(s);
                                                    		   writer.newLine();
                                                    	   }

                                                       }

                                       

                                         }

                                  }
                                         
                                        reader.close();
                             			writer.close();
                
                           }catch(IOException e) {
      			e.printStackTrace();
                           }
              }
}
      		      

                                                

           



