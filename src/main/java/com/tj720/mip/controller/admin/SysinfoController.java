package com.tj720.mip.controller.admin;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarNotImplementedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.JsonResult;

@Controller("SysinfoController")
@RequestMapping("/sysinfo")
public class SysinfoController {

	public static void main(String[] args) throws Exception {
		SysinfoController s = new SysinfoController();
		System.out.println("CPU个数：" + s.getCpuCount());
		// s.getCpuTotal();
		s.testFileSystemInfo();
		s.testGetOSInfo();
	}

	@RequestMapping(value = "/goPage.do")
	public String goPage() throws SigarException {
		return "/WEB-INF/back/log/sysinfo.jsp";
	}

	/**
	 * 1.CPU资源信息
	 */

	/**
	 * a)CPU数量（单位：个）
	 * 
	 * @return
	 * @throws SigarException
	 */
	public int getCpuCount() throws SigarException {
		Sigar sigar = new Sigar();
		try {
			return sigar.getCpuInfoList().length;
		} finally {
			sigar.close();
		}
	}

	/**
	 * b)CPU的总量（单位：HZ）及CPU的相关信息
	 */
	@RequestMapping(value = "/getCpuTotal.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult getCpuTotal() {
		Sigar sigar = new Sigar();
		CpuInfo[] infos;
		Map<String, Object> data = new HashMap<>();
		try {
			infos = sigar.getCpuInfoList();
			data.put("cpusl", infos.length);
			for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
				CpuInfo info = infos[i];
				data.put("cpuzl", info.getMhz());
				data.put("cpumz", info.getVendor());
				data.put("cpuzl1", info.getModel());
				data.put("hcqsl", info.getCacheSize());
				/*
				 * System.out.println("CPU的总量:" + info.getMhz());// CPU的总量MHz
				 * System.out.println("获得CPU的卖主：" + info.getVendor());// 获得CPU的卖主，如：Intel
				 * System.out.println("CPU的类别：" + info.getModel());// 获得CPU的类别，如：Celeron
				 * System.out.println("缓冲存储器数量：" + info.getCacheSize());// 缓冲存储器数量
				 * System.out.println("**************");
				 */
				break;
			}

			// cpu使用率
			CpuPerc cpu = sigar.getCpuPerc();
			data.put("zdsyl", CpuPerc.format(cpu.getCombined()));// 总的使用率

			return new JsonResult(1, data);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return new JsonResult(0, "获取失败");
	}

	/**
	 * c)CPU的用户使用量、系统使用剩余量、总的剩余量、总的使用占用量等（单位：100%）
	 */
	private void printCpuPerc(CpuPerc cpu) {
		System.out.println("用户使用率:" + CpuPerc.format(cpu.getUser()));// 用户使用率
		System.out.println("系统使用率:" + CpuPerc.format(cpu.getSys()));// 系统使用率
		System.out.println("当前等待率:" + CpuPerc.format(cpu.getWait()));// 当前等待率
		System.out.println("Nice :" + CpuPerc.format(cpu.getNice()));//
		System.out.println("当前空闲率:" + CpuPerc.format(cpu.getIdle()));// 当前空闲率
		System.out.println("总的使用率:" + CpuPerc.format(cpu.getCombined()));// 总的使用率
		System.out.println("**************");
	}

	/**
	 * 2.内存资源信息
	 */
	@RequestMapping(value = "/getPhysicalMemory.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult getPhysicalMemory() {
		// a)物理内存信息
		DecimalFormat df = new DecimalFormat("#0.0");
		Sigar sigar = new Sigar();
		Mem mem;
		Map<String, Object> data = new HashMap<>();
		try {
			mem = sigar.getMem();
			float total = (float) mem.getTotal() / 1024 / 1024 / 1024;
			float use = (float) mem.getUsed() / 1024 / 1024 / 1024;
			data.put("nczl", df.format(total) + "G");		//内存总量
			data.put("ncsy", df.format(use) + "G");			//当前内存使用量
			data.put("ncsybfb", df.format(use*100/total) + "%");		//已使用百分比
			
			return new JsonResult(1, data);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return new JsonResult(0, "获取失败");
	}

	/**
	 * a)取到当前操作系统的名称：
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getPlatformName.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getPlatformName() {
		String hostname = "";
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (Exception exc) {
			Sigar sigar = new Sigar();
			try {
				hostname = sigar.getNetInfo().getHostName();
			} catch (SigarException e) {
				hostname = "localhost.unknown";
			} finally {
				sigar.close();
			}
		}
		return hostname;
	}

	/**
	 * b)取当前操作系统的信息
	 */
	@RequestMapping(value = "/testGetOSInfo.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void testGetOSInfo() {
		OperatingSystem OS = OperatingSystem.getInstance();
		// 操作系统内核类型如： 386、486、586等x86
		System.out.println("OS.getArch() = " + OS.getArch());
		System.out.println("OS.getCpuEndian() = " + OS.getCpuEndian());//
		System.out.println("OS.getDataModel() = " + OS.getDataModel());//
		// 系统描述
		System.out.println("OS.getDescription() = " + OS.getDescription());
		System.out.println("OS.getMachine() = " + OS.getMachine());//
		// 操作系统类型
		System.out.println("OS.getName() = " + OS.getName());
		System.out.println("OS.getPatchLevel() = " + OS.getPatchLevel());//
		// 操作系统的卖主
		System.out.println("OS.getVendor() = " + OS.getVendor());
		// 卖主名称
		System.out.println("OS.getVendorCodeName() = " + OS.getVendorCodeName());
		// 操作系统名称
		System.out.println("OS.getVendorName() = " + OS.getVendorName());
		// 操作系统卖主类型
		System.out.println("OS.getVendorVersion() = " + OS.getVendorVersion());
		// 操作系统的版本号
		System.out.println("OS.getVersion() = " + OS.getVersion());
	}

	/**
	 * 4.资源信息（主要是硬盘）
	 * a)取硬盘已有的分区及其详细信息（通过sigar.getFileSystemList()来获得FileSystem列表对象，然后对其进行编历）：
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/testFileSystemInfo.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult testFileSystemInfo() throws Exception {
		Sigar sigar = new Sigar();
		FileSystem fslist[] = sigar.getFileSystemList();
		DecimalFormat df = new DecimalFormat("#0.00");
		List<Map<String, Object>> data = new ArrayList<>();
		// String dir = System.getProperty("user.home");// 当前用户文件夹路径
		for (int i = 0; i < fslist.length; i++) {
			Map<String, Object> current = new HashMap<>();
			FileSystem fs = fslist[i];
			// 分区的盘符名称
			current.put("panName", fs.getDevName());
			FileSystemUsage usage = null;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
			} catch (SigarException e) {
				if (fs.getType() == 2)
					throw e;
				continue;
			}
			switch (fs.getType()) {
			case 0: // TYPE_UNKNOWN ：未知
				break;
			case 1: // TYPE_NONE
				break;
			case 2: // TYPE_LOCAL_DISK : 本地硬盘
				// 文件系统总大小
				current.put("panTotal", df.format((float) usage.getTotal() / 1024 / 1024) + "G");
				current.put("panFree", df.format((float)usage.getFree()/1024/1024) + "G");
				// 文件系统剩余大小
				double usePercent = usage.getUsePercent() * 100D;
				current.put("panUsage", df.format(usePercent) + "%");
				break;
			case 3:// TYPE_NETWORK ：网络
				break;
			case 4:// TYPE_RAM_DISK ：闪存
				break;
			case 5:// TYPE_CDROM ：光驱
				break;
			case 6:// TYPE_SWAP ：页面交换
				break;
			}
			data.add(current);
		}
		return new JsonResult(1, data);
	}

	/**
	 * 5.网络信息 a)当前机器的正式域名
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getFQDN.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getFQDN() {
		Sigar sigar = null;
		try {
			return InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			try {
				sigar = new Sigar();
				return sigar.getFQDN();
			} catch (SigarException ex) {
				return null;
			} finally {
				sigar.close();
			}
		}
	}

	/**
	 * b)取到当前机器的IP地址
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getDefaultIpAddress.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getDefaultIpAddress() {
		String address = null;
		try {
			address = InetAddress.getLocalHost().getHostAddress();
			// 没有出现异常而正常当取到的IP时，如果取到的不是网卡循回地址时就返回
			// 否则再通过Sigar工具包中的方法来获取
			if (!NetFlags.LOOPBACK_ADDRESS.equals(address)) {
				return address;
			}
		} catch (UnknownHostException e) {
			// hostname not in DNS or /etc/hosts
		}
		Sigar sigar = new Sigar();
		try {
			address = sigar.getNetInterfaceConfig().getAddress();
		} catch (SigarException e) {
			address = NetFlags.LOOPBACK_ADDRESS;
		} finally {
			sigar.close();
		}
		return address;
	}

	/**
	 * c)取到当前机器的MAC地址
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getMAC.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getMAC() {
		Sigar sigar = null;
		try {
			sigar = new Sigar();
			String[] ifaces = sigar.getNetInterfaceList();
			String hwaddr = null;
			for (int i = 0; i < ifaces.length; i++) {
				NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
				if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
						|| NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
					continue;
				}
				/*
				 * 如果存在多张网卡包括虚拟机的网卡，默认只取第一张网卡的MAC地址，如果要返回所有的网卡（包括物理的和虚拟的）
				 * 则可以修改方法的返回类型为数组或Collection ，通过在for循环里取到的多个MAC地址。
				 */
				hwaddr = cfg.getHwaddr();
				break;
			}
			return hwaddr != null ? hwaddr : null;
		} catch (Exception e) {
			return null;
		} finally {
			if (sigar != null)
				sigar.close();
		}
	}

	/**
	 * d)获取网络流量等信息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/testNetIfList.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void testNetIfList() throws Exception {
		Sigar sigar = new Sigar();
		String ifNames[] = sigar.getNetInterfaceList();
		for (int i = 0; i < ifNames.length; i++) {
			String name = ifNames[i];
			NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
			print("\nname = " + name);// 网络设备名
			print("Address = " + ifconfig.getAddress());// IP地址
			print("Netmask = " + ifconfig.getNetmask());// 子网掩码
			if ((ifconfig.getFlags() & 1L) <= 0L) {
				print("!IFF_UP...skipping getNetInterfaceStat");
				continue;
			}
			try {
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
				print("RxPackets = " + ifstat.getRxPackets());// 接收的总包裹数
				print("TxPackets = " + ifstat.getTxPackets());// 发送的总包裹数
				print("RxBytes = " + ifstat.getRxBytes());// 接收到的总字节数
				print("TxBytes = " + ifstat.getTxBytes());// 发送的总字节数
				print("RxErrors = " + ifstat.getRxErrors());// 接收到的错误包数
				print("TxErrors = " + ifstat.getTxErrors());// 发送数据包时的错误数
				print("RxDropped = " + ifstat.getRxDropped());// 接收时丢弃的包数
				print("TxDropped = " + ifstat.getTxDropped());// 发送时丢弃的包数
			} catch (SigarNotImplementedException e) {
			} catch (SigarException e) {
				print(e.getMessage());
			}
		}
	}

	void print(String msg) {
		System.out.println(msg);
	}

	/**
	 * e)一些其他的信息
	 */
	@RequestMapping(value = "/getEthernetInfo.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void getEthernetInfo() {
		Sigar sigar = null;
		try {
			sigar = new Sigar();
			String[] ifaces = sigar.getNetInterfaceList();
			for (int i = 0; i < ifaces.length; i++) {
				NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
				if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
						|| NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
					continue;
				}
				System.out.println("cfg.getAddress() = " + cfg.getAddress());// IP地址
				System.out.println("cfg.getBroadcast() = " + cfg.getBroadcast());// 网关广播地址
				System.out.println("cfg.getHwaddr() = " + cfg.getHwaddr());// 网卡MAC地址
				System.out.println("cfg.getNetmask() = " + cfg.getNetmask());// 子网掩码
				System.out.println("cfg.getDescription() = " + cfg.getDescription());// 网卡描述信息
				System.out.println("cfg.getType() = " + cfg.getType());//
				System.out.println("cfg.getDestination() = " + cfg.getDestination());
				System.out.println("cfg.getFlags() = " + cfg.getFlags());//
				System.out.println("cfg.getMetric() = " + cfg.getMetric());
				System.out.println("cfg.getMtu() = " + cfg.getMtu());
				System.out.println("cfg.getName() = " + cfg.getName());
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error while creating GUID" + e);
		} finally {
			if (sigar != null)
				sigar.close();
		}
	}

}