package ds;
import javax.xml.rpc.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class dsclient extends Frame implements ActionListener
{
      Frame f,f1,f2,f3,f4,u,u1,u2,u3,m,m1,m2,m3;
      Button download,upload,cancel,downlod,exit,exit1,exit2,exit3,done,exit5,exit6,exit7,exit8,exit99,back,toup,login;
      TextField store,downfile,upfile,down,uname,pass;
      Dsint dsi;
      byte[] buffer=new byte[30*1024*1024];
   public static void main(String args[])throws Exception
   {
          dsclient dsc=new dsclient();
         
     }
    dsclient()
   {
               Stub stub=creatProxy();
              stub._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,"http://localhost:60888/kasi/Rajan?WSDL");
             dsi=(Dsint)stub;
              f=new Frame("welcome");
              f.setLayout(new FlowLayout());
              f.setVisible(true);
              download=new Button("download");
              upload=new Button("upload");
              cancel=new Button("cancel");
              f.add(download);
              f.add(upload);
              f.add(cancel);
              f.pack();
              download.addActionListener(this);
              upload.addActionListener(this);
              cancel.addActionListener(this);
              u1=new Frame("file not found with u");
                                           u1.setLayout(new FlowLayout());
                                           u1.setVisible(false);
                                           u2=new Frame("uploaded ");
                                           u2.setLayout(new FlowLayout());
                                           u2.setVisible(false);
                                           u3=new Frame("file already there in server ");
                                           u3.setLayout(new FlowLayout());
                                           u3.setVisible(false);
                                           exit6=new Button("exit1");
                                           exit7=new Button("exit2"); 
                                           exit8=new Button("exit3");
                                           exit6.addActionListener(this);
                                           exit7.addActionListener(this);
                                           exit8.addActionListener(this);
                                           u1.add(exit6);
                                           u2.add(exit7);
                                           u3.add(exit8);
                                            f2=new Frame("already exists error ");
                                           f2.setLayout(new FlowLayout());
                                           f2.setVisible(false);
                                           f3=new Frame("downloaded");
                                           f3.setLayout(new FlowLayout());
                                           f3.setVisible(false);
                                           f4=new Frame("not found in server");
                                           f4.setLayout(new FlowLayout());
                                           f4.setVisible(false);
                                           exit1=new Button("exit1");
                                           exit2=new Button("exit2"); 
                                           exit3=new Button("exit3");
                                           exit1.addActionListener(this);
                                           exit2.addActionListener(this);
                                           exit3.addActionListener(this);
                                           f2.add(exit1);
                                           f3.add(exit2);
                                           f4.add(exit3);
                                           
   }
   public void actionPerformed(ActionEvent ae)
  {
              String action=ae.getActionCommand();
                    System.out.println(action);
                 if(action.equals("download"))
                    {
                                       f.setVisible(false);
                                       f1=new Frame("download page");
                                       f1.setLayout(new FlowLayout());
                                       f1.setVisible(true);
                                       f1.pack();
                                       down=new TextField(20);
                                       store=new TextField(20); 
                                       downlod = new Button("downlod"); 
                                       exit=new Button("exit");
                                       f1.add(new Label("enter the file name "));
                                       f1.add(down);
                                       f1.add(new Label("enter the name to be stored in ur machine "));
                                       f1.add(store);
                                       f1.add(downlod);
                                       f1.add(exit);
                                       downlod.addActionListener(this);
                                       exit.addActionListener(this);
                                          
                    }
                 if(action.equals("exit"))
                  {
                          f1.setVisible(false);
                          f.setVisible(true);
                  }
                 if(action.equals("cancel"))
                  {
                          f.setVisible(false);
                  }
                if(action.equals("exit1"))
                  {
                          f2.setVisible(false);
                          f1.setVisible(true);
                  }
               if(action.equals("exit2"))
                  {
                          f3.setVisible(false);
                          f1.setVisible(true);
                  }
                if(action.equals("exit3"))
                  {
                          f4.setVisible(false);
                          f1.setVisible(true);
                  }
                  if(action.equals("downlod"))
                  {                     
                                           String fname=down.getText();
                                           String tname=store.getText();
					System.out.println(fname+" "+tname);
                                            try
                                            {
						System.out.println(buffer);
                                            buffer=dsi.getvideo(fname);
					    System.out.println(buffer);
                                            }
                                          catch(Exception e2)
                                            {
                                                System.out.println(e2);       
						 buffer=null;
                                            }    
                                          if(buffer!=null)
                                           {
                                                   try
                                                   {
                                                   FileInputStream fis=new FileInputStream(tname);
                                                   f1.setVisible(false);
                                                   f2.pack();
                                                   f2.setVisible(true);
                                                   f2.add(new Label("the file name is already found plz enter some other file name "));
                                                   }
                                             catch(Exception e)
                                         {                    
                                           try
                                          {                      
                                           File f=new File(tname);
                                           FileOutputStream fos=new FileOutputStream(f);
                                           DataOutputStream dos=new DataOutputStream(fos);
                                           dos.write(buffer);
                                           dos.close();
                                           f1.setVisible(true);
                                           f3.pack();
                                           f3.setVisible(true);
                                           f3.add(new Label("downloded"));
                                           Runtime rt=Runtime.getRuntime();
                                           Process p=rt.exec("cmd /c E:\\client\\VLC\\vlc "+tname);
                                             }
                                            catch(Exception e1)
                                                {
                                                            f1.setVisible(false);
                                                            f4.pack();
                                                            f4.setVisible(true);
                                                            f4.add(new Label("not downloaded"));
                                                }
                                         }
                                           }
                                           else
                                         f1.add(new Label("file requested is not found in the server "));
                  }
                            if(action.equals("upload"))
                            {
                                             uname=new TextField();
                                             pass=new TextField();
                                             m=new Frame("upload login");
                                             m.setLayout(new FlowLayout());
                                             m.setVisible(true);
                                             m.pack();
                                             m.add(new Label("enter the user name "));
                                             m.add(uname);
                                             m.add(new Label("enter the password "));
                                             m.add(pass);
                                              login=new Button("login");
                                             exit99=new Button("exit99");
                                             login.addActionListener(this);
                                             exit99.addActionListener(this);
                                             m.add(login);
                                             m.add(exit99);
                            }
                            if(action.equals("login"))
                           {
                                                boolean b=false;
                                                String un=uname.getText();
                                                String pw=pass.getText();
                                                System.out.println(un+pw);
                                                try
                                                 {
                                                //b=dsi.logincheck(un,pw);
                                                 }
                                                catch(Exception e)
                                                        { 
                                                                      System.out.println(e);
                                                                      System.out.println("inside catch");
                                                                      m3=new Frame("login fail");
                                                                      m3.setLayout(new FlowLayout());
                                                                      m3.setVisible(true);
                                                                      m3.pack();
                                                                      m3.add(new Label("login fail"));
                                                                      m.setVisible(false);
                                                                      back=new Button("back");
                                                                      m3.add(back);
                                                                      back.addActionListener(this);
                                                           }
                               System.out.println(b);
                                                 if(b)
                                                     {
                                                                      m1=new Frame("login success");
                                                                      m1.setLayout(new FlowLayout());
                                                                      m1.setVisible(true);
                                                                      m1.pack();
                                                                      m1.add(new Label("login success"));
                                                                      m.setVisible(false);
                                                                      toup=new Button("toup");
                                                                      m1.add(toup);
                                                                      toup.addActionListener(this);
                                                      }
                                                   else
                                                      {                                                                                                                      
                                                                      m2=new Frame("login fail");
                                                                      m2.setLayout(new FlowLayout());
                                                                      m2.setVisible(true);
                                                                      m2.pack();
                                                                      m2.add(new Label("login fail"));
                                                                      //m.setVisible(false);
                                                                      back=new Button("back");
                                                                      m2.add(back);
                                                                      back.addActionListener(this);
                                                        }
                                                     }
                             if(action.equals("toup"))
                              {
                                        u=new Frame("update");
                                        upfile=new TextField("                                                                      ");
                                        downfile=new TextField("                                                                      ");
                                        done=new Button("done");
                                        exit5=new Button("exit5");
                                        u.setLayout(new FlowLayout());
                                        u.pack();
                                        u.setVisible(true);
                                        f.setVisible(false);
                                        u.add(new Label("enter the file name to be uploded"));
                                        u.add(upfile);
                                        u.add(new Label("enter the file name to be saved in server"));
                                        u.add(downfile);
                                        u.add(done);
                                        u.add(exit5);
                                        done.addActionListener(this);
                                        upfile.addActionListener(this);
                              }
                           if(action.equals("done"))
                               { 
                                          boolean bool=false;
                                          byte[] bufer=null; 
                                    
                                          String fname=upfile.getText();
                                          String tname=downfile.getText();
                                         System.out.println(fname);
                                          try
                                                 {
                                                                  FileInputStream fis=new FileInputStream(fname);
                                                                  bufer=new byte[30*1024*1024];
                                                                  fis.read(bufer,0,bufer.length);
                                                                  System.out.println("after reading");
                                                                  fis.close(); 
                                                   }
                                           catch(Exception e)
                                                 {
                                                                      System.out.println("file input stream exception  1 ");
                                                                     u1.setVisible(true);
                                                                        System.out.println("file input stream exception");
                                                                       u1.add(new Label("sorry file to upload is not found with u :( "));
                                                                       u.setVisible(false);
                                                  } 
                                                   try
                                               {
                                            //bool=dsi.putvideo(bufer,tname);
                                            System.out.println("inside try");
                                              }
                                               catch(Exception e5)
                                            {
                                                                     System.out.println("file not found  1");
                                                                     u1.setVisible(true);
                                                                        System.out.println("file not found ");
                                                                       u1.add(new Label("sorry file to upload is not found with u :( "));
                                                                      u.setVisible(false);
                                            }
                                                      if(bool)
                                                                 {
                                                                            System.out.println("updated     1");
                                                                              u2.setVisible(true);
                                                                            System.out.println("updated");
                                                                              u2.add(new Label("uploaded "));
                                                                           u.setVisible(false);
                                                                 }
                                                       else
                                                                 {
                                                                                 System.out.println("updated errror 1");

                                                                                 u3.setVisible(true);
                                                                               System.out.println("update error");
                                                                                u3.add(new Label("file already found in server "));
                                                                                u.setVisible(false);
                                                                   }
                                    }
                               if(action.equals("exit6"))
                                              {
                                                             u1.setVisible(false);
                                                             f.setVisible(true);
                                              }
                             if(action.equals("exit7"))
                                              {
                                                             u2.setVisible(false);
                                                             f.setVisible(true);
                                              }
                            if(action.equals("exit8"))
                                              {
                                                             u3.setVisible(false);
                                                             f.setVisible(true);
                                              }
                             if(action.equals("exit99"))
                                              {
                                                             m.setVisible(false);
                                                             f.setVisible(true);
                                              }
                            if(action.equals("back"))
                                              {
                                                              m2.setVisible(false);
                                                             m.setVisible(true);
                                              }
}
    public static Stub creatProxy()
   {
       return (Stub)(new Dsservice_Impl().getDsintPort());
   }
}