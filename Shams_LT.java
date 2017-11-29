
package shamsulti;
import java.io.*;
import java.util.*;

public class Shams_LT {
 public static Scanner input =new Scanner (System.in);
    public static class record {
       String  lexam,type;
     record(String L,String t ){
       this.lexam=L; this.type=t;
    }}
   public static record[] lut =new record [100];
     public static int lutn=0; 
    
   //
 public static void insert_lut(String token){
           
     if(Is_RW(token)){
              lut[lutn]=new record(token,"rw");
                 lutn++;
                }
        else if(Is_DIG(token)){
            lut[lutn]=new record(token,"dig");
            lutn++;
            }
            else if(Is_ID(token)){
            lut[lutn]=new record(token,"id");
               lutn++;
            }
            else System.out.println("erorr");
            
          }
    public static void insert_ch(char ch){
          if(Is_SP(ch)){
              lut[lutn]=new record(String.valueOf(ch),"sp");
               lutn++;
          }
          else if(Is_OP(ch)){
          lut[lutn]=new record(String.valueOf(ch),"op");
               lutn++;
          }
          else  System.out.println("erorr");
            
    }
    
  public static boolean Is_SP(char ch){
    if((ch==',')|| (ch==';') || (ch=='(') || (ch==')') || (ch=='}') ||(ch=='{'))
    {
        return true ;
    }
    else 
        return false; 
    }
    //
    public static boolean Is_OP (char ch){
    if((ch=='+') || (ch=='-') || 
         (ch=='/') || (ch=='*') || 
            (ch=='='))
    {
        return true ;
    }
    else 
        return false ;
    }
    //
    public static boolean Is_RW(String st )
    {
    if((st.equals("DEF")) || (st.equals("BODY")) || 
       (st.equals("Int")) || (st.equals("Byte")) 
       || (st.equals("print")))
    {    
    return true ;
    }
    else 
    return false ;
    }       
    //
    public static boolean Is_DIG(String st)
    { 
    for (int i=0;i<st.length();i++)
    {
    if(st.charAt(i)>='0'&& st.charAt(i)<='9' )
    {
        continue ;
    }
    else 
     return false ;
    }
    return true ;
    }
    //
    public static boolean Is_ID(String st)
    {
    
       if((st.charAt(0)>='A'&& st.charAt(0)<='Z')||
                   (st.charAt(0)>='a'&&st.charAt(0)<='z'))
    {
                 for(int i=1 ;i<st.length();i++)
    {
                        if((st.charAt(0)>='A'&& st.charAt(0)<='Z')||
                            (st.charAt(0)>='a'&&st.charAt(0)<='z')
                             &&(st.charAt(i)>='0'&& st.charAt(i)<='9')) 
                                        continue;
    
                    else 
                                        return false ;
   }
        
   }
                    else 
                    return false;
       
                    return true; 
    }
    
    public static void main(String[] args) {
        try
        {
       
         Scanner sc = new Scanner(new File("F:/lab1.txt"));
            char ch; 
            String tokn,line,com;
     
       while(sc.hasNext())
        {  
            line=sc.nextLine();
            tokn="";
         for(int i=0;i<line.length();i++)
            {
                    ch=line.charAt(i);
           if((ch!=' '))
                   if((Is_SP(ch)||Is_OP(ch)))
                     {
                               if((!tokn.equals("")))
                               {
                                   insert_lut(tokn);
                                   tokn="";
                               }
                               
                     insert_ch(ch);
                     }
                             
                   else          
                                   tokn+=ch;        
                  
                    else if(!tokn.equals(""))
                              {
                             insert_lut(tokn);  
                             tokn="";
                              }
                     if(!tokn.equals(""))
                     {       insert_lut(tokn);  
                             tokn="";
                       }
                 } 
            sc.close();
            for(int j=0;j<lutn-1;j++){
                System.out.println(lut[j].lexam+" "+lut[j].type); 
            }
        }
        }
     catch( FileNotFoundException e )
      {
            System.out.print("not found ");
      }
     }

}
