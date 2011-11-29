 
//package demo;
//
///**
// * Created by IntelliJ IDEA.
// * User: Administrator
// * Date: 11-8-4
// * Time: 下午11:35
// * To change this template use File | Settings | File Templates.
// */
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import sun.management.ManagementFactory;
//import com.sun.management.OperatingSystemMXBean;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.net.InetAddress;
//import org.hyperic.sigar.FileSystem;
//import org.hyperic.sigar.FileSystemUsage;
//import org.hyperic.sigar.CpuInfo;
//import org.hyperic.sigar.NetInterfaceConfig;
//import org.hyperic.sigar.OperatingSystem;
//import org.hyperic.sigar.Sigar;
//import org.hyperic.sigar.SigarException;
//
//
//public class baseinfo {
//
//    /**
//     * Edit by Sky 20101029
//     */
//    private String memsize="";//记录物理内存的大小
//    private int kb = 1024*1024;//计算单位
//    private String osinfo="";//记录系统版本等类别信息
//
//
//
//
//    private String mem(){
//        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
//        long totalMemorySize = osmxb.getTotalPhysicalMemorySize() / kb;
//        memsize="mem_="+totalMemorySize+"M";
//        return memsize;
//    }
//
//    private String cpu(){
//          Sigar sigar = new Sigar();
//          String cpuinfo="";
//          CpuInfo[] infos;
//          try {
//               infos = sigar.getCpuInfoList();
//               cpuinfo+=infos[0].getModel();
//               int cpunum=infos.length/2;
//               if(cpunum>0){
//                  cpuinfo+=" ,"+cpunum+"CPU";
//               }else{
//                   cpuinfo+=" ,1CPU";
//               }
//          } catch (SigarException e) {
//           e.printStackTrace();
//          }
//               cpuinfo+=","+Runtime.getRuntime().availableProcessors()+"CORE";
//        return "cpu_="+cpuinfo;
//    }
//
//    private String disk(){
//        String osName = System.getProperty("os.name");
//        //System.out.println(osName);
//        String diskinfo="";
//        long total=0;
//        try{
//
//          Sigar disk = new Sigar();
//          FileSystem fslist[]=disk.getFileSystemList();
//          if(osName.startsWith("Win") || osName.startsWith("win")){
//            for (int i = 0; i < fslist.length; i++) {
//                FileSystem fs = fslist[i];    // 分区的盘符名称
//                 if (fs.getType() == 2) {
//                //System.out.println("\n~~~~~~~~~~" + i + "~~~~~~~~~~");
//                //System.out.println("fs.getDevName() = " + fs.getDevName());
//                FileSystemUsage usage = disk.getFileSystemUsage(fs.getDirName());
//                total=total+usage.getTotal()/kb;
//                //System.out.println(" Total = " + usage.getTotal()/kb + "G");
//               }
//             }
//            diskinfo+="disk_="+total+"G";
//          }else if(osName.startsWith("Lin") || osName.startsWith("lin")){
//                long count=0;
//                HashMap<String, diskinfoclass> hm=new HashMap<String,diskinfoclass>();
//
//              for (int i = 0; i < fslist.length; i++) {
//                    FileSystem fs = fslist[i];    // 分区的盘符名称
//                     if (fs.getType() == 2) {
//                         count=0;
//                         String devName = fs.getDevName();
//                         String subdevName = devName.substring(0, devName.length()-1);
//                         if(hm.containsKey(subdevName)){
//                             int myvalue=Integer.parseInt(hm.get("subdevName").toString());
//                             FileSystemUsage usage = disk.getFileSystemUsage(fs.getDirName());
//                             count=count+usage.getTotal()/kb;
//                             count=count+myvalue;
//                             hm.remove(subdevName);
//                             diskinfoclass di=new diskinfoclass(subdevName,count);
//                             hm.put(subdevName, di);
//                         }else{
//                             FileSystemUsage usage = disk.getFileSystemUsage(fs.getDirName());
//                             count=count+usage.getTotal()/kb;
//                             diskinfoclass di=new diskinfoclass(subdevName,count);
//                             hm.put(subdevName, di);
//                         }
//                   }
//                     Collection<diskinfoclass> collection = hm.values();
//                     Iterator<diskinfoclass> iter = collection.iterator();
//                     diskinfo+="disk_";
//                     String tmpstring="";
//                     while(iter.hasNext()){
//                         diskinfoclass te=iter.next();
//                         tmpstring+=te.getName()+":"+te.getSize()+" ";
//                     }
//                     diskinfo+=tmpstring;
//                     System.out.println("diskinfo:"+diskinfo);
//                 }
//          }
//
//        } catch(SigarException e) {
//            e.printStackTrace();
//            }
//
//        return diskinfo;
//    }
//
//    private String controller(){
//        String controllerinfo="";
//        String scsictlinfo="";
//          Sigar sigar = null;
//          String ethernet_controller="";
//          try {
//              sigar = new Sigar();
//              String[] ifaces = sigar.getNetInterfaceList();
//              for (int i = 0; i < ifaces.length; i++) {
//                  NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
//                  String str=new String(cfg.getDescription().getBytes(),"UTF-8");
//                  str=str.replace("?", "");
//                  ethernet_controller+=cfg.getType()+" controller:"+str;
//
//              }
//          }catch(Exception e){
//              e.printStackTrace();
//          }
//        //////////////scsictlinfo///////////////////////
//
//            try {
//                String[] vbsCmd   = new String[]{"wscript", "my.vbs"};
//                Process process = Runtime.getRuntime().exec(vbsCmd);
//                List<Process> processes = new LinkedList<Process>();
//                processes.add(process);
//                 for (Process p : processes)
//                 {
//                        try {
//                            p.waitFor();
//                        } catch (InterruptedException e) {
//
//                            e.printStackTrace();
//                        }
//                 }
//                File filedisk = new File("disktype.txt");
//                if(filedisk.exists()){
//                InputStream is = new FileInputStream("disktype.txt");
//                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//                String line = reader.readLine();
//                while (line != null) {
//                    line=line.substring(line.indexOf("\\")+1,line.indexOf("______________________________"));
//                    scsictlinfo+=line;
//                    line = reader.readLine();
//                }
//                is.close();
//                reader.close();}else{
//                    scsictlinfo+="unkown disk drive type";
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        ////////////////////////////////////////////////
//        return controllerinfo+="scsictl_="+scsictlinfo+"\nethctl_="+ethernet_controller;
//    }
//
//    private String nic(){
//        String nicinfo="";
//          Sigar sigar = null;
//          try {
//              sigar = new Sigar();
//              String[] ifaces = sigar.getNetInterfaceList();
//              for (int i = 0; i < ifaces.length; i++) {
//                  NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
//                if(cfg.getName().indexOf("lo0")<0){
//                  nicinfo+= cfg.getName()+"("+cfg.getHwaddr()+"|"+cfg.getAddress()+")";
//                }
//              }
//          }catch(Exception e){
//              e.printStackTrace();
//          }
//        return nicinfo;
//    }
//
//    private String osinfo(){
//        String osName = System.getProperty("os.name");
//        String kernel = osName +" "+ System.getProperty("os.version");
//        String issue = "";
//        String hostname="";
//        String bit="";
//        String uptime="";
//          try {
//           hostname = InetAddress.getLocalHost().getHostName();
//          } catch (Exception exc) {
//           Sigar sigar = new Sigar();
//           try {
//            hostname = sigar.getNetInfo().getHostName();
//           } catch (SigarException e) {
//            hostname = "localhost.unknown";
//           } finally {
//            sigar.close();
//           }
//          }
//       OperatingSystem OS = OperatingSystem.getInstance();
//       issue=OS.getDescription()+"  ("+OS.getVendorCodeName()+")";
//       bit=OS.getArch();
//       if(osName.startsWith("Win") || osName.startsWith("win") ){
//         try{
//             Process readresult = Runtime.getRuntime().exec("uptime.exe");
//             BufferedReader in = new BufferedReader(new InputStreamReader(readresult.getInputStream()));
//             String line="";
//             line = in.readLine();
//             if(line.indexOf("day")>0)
//               uptime=(line.substring(line.indexOf("for:")+4,line.indexOf("day")));
//             else
//               uptime=(line.substring(line.indexOf("for:")+4,line.indexOf(",")));
//             in.close();
//             in=null;
//         }catch(Exception e){
//           e.printStackTrace();
//              }
//         }else{
//             try{
//             Process readresult = Runtime.getRuntime().exec("/usr/bin/uptime");
//             BufferedReader in = new BufferedReader(new InputStreamReader(readresult.getInputStream()));
//             String line="";
//             line = in.readLine();
//             uptime=(line.substring(line.indexOf("up")+2,line.indexOf("day")));
//             in.close();
//             in=null;
//             }catch(Exception e){
//                 e.printStackTrace();
//             }
//         }
//       if(bit.startsWith("x86")|| bit.startsWith("X86")){
//           bit="64bit";
//       }else{ bit = "32bit";}
//
//        osinfo = "os_="+osName+"\nkernel_="+kernel+"\nissue_="+issue+"\nbit_="+bit+"\nhostname_="+hostname+"\nrundays_="+uptime;
//        return osinfo;
//
//    }
//
//    public String getInfo(){
//        String output="";
//        agent myagent= new agent();
//        output+=this.cpu()+"\n"+this.mem()+"\n"+this.disk()+"\n"+this.controller()+"\n"+this.nic()+"\n"+this.osinfo()+"\n"+myagent.getVersion();
//        return output;
//    }
//
//    public static void main(String[] args) {
//        //System.out.println(System.getProperty("java.library.path"));
//        baseinfo test = new baseinfo();
//        //System.out.println(test.mem());
//        //System.out.println(test.osinfo());
//        //test.getCpuTotal();
//        //System.out.println(test.disk());
//        //System.out.println(test.cpu());
//        //System.out.println(test.nic());
//        //System.out.println(test.controller());
//        System.out.println(test.getInfo());
//
//    }
//
//}
//
 
