package com.peterbochs;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.peterbochs.architecture.IA32PageDirectory;
import com.peterbochs.elf.ElfUtil;
import com.peterbochs.helprequest.HelpRequestDialog;
import com.peterbochs.instrument.Data;
import com.peterbochs.instrument.InstrumentPanel;
import com.peterbochs.instrument.InterruptSocketServerController;
import com.peterbochs.instrument.JmpSocketServerController;
import com.peterbochs.instrument.MemorySocketServerController;
import com.peterbochs.logpanel.LogPanel;
import com.peterbochs.osdebuginformation.JOSDebugInformationPanel;
import com.peterbochs.osdebuginformation.OSDebugInfoHelper;
import com.peterbochs.sourceleveldebugger.DwarfLine;
import com.peterbochs.sourceleveldebugger.MapStructure;
import com.peterbochs.sourceleveldebugger.SourceLevelDebugger2;
import com.peterbochs.sourceleveldebugger.Symbol;
import com.peterbochs.webservice.WebServiceUtil;
import com.peterswing.CommonLib;
import com.peterswing.advancedswing.diskpanel.DiskPanel;
import com.peterswing.advancedswing.enhancedtextarea.EnhancedTextArea;
import com.peterswing.advancedswing.jdropdownbutton.JDropDownButton;
import com.peterswing.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane;
import com.peterswing.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane_BasePanel;
import com.peterswing.advancedswing.jprogressbardialog.JProgressBarDialog;
import com.peterswing.advancedswing.jvmdialog.JVMInfoDialog;
import com.peterswing.advancedswing.searchtextfield.JSearchTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
@SuppressWarnings("serial")
public class Application extends javax.swing.JFrame {
	private JMenuItem aboutUsMenuItem;
	private JPanel jPanel8;
	private JDropDownButton jStepBochsButton;
	private JMenu jMenu5;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JMaximizableTabbedPane jTabbedPane1;
	private JHexTable jHexTable1;
	private JEditorPane jBochsEditorPane;

	public static CommandReceiver commandReceiver;

	private JSplitPane jSplitPane1;
	private RegisterPanel jRegisterPanel1;
	private JMenuItem runBochsMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem stopBochsMenuItem;
	private JMenuItem startBochsMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	public JDropDownButton jRunBochsButton;
	private JButton jStopBochsButton;
	private JButton jStartBochsButton;
	private JToolBar jToolBar1;
	private JPanel jPanel7;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private JMaximizableTabbedPane jTabbedPane3;
	private JMenuItem pauseBochsMenuItem;
	private JPanel jPanel3;
	public JMaximizableTabbedPane jTabbedPane2;
	private JButton jBochsCommandButton;
	private JTextField jBochsCommandTextField;
	private JPanel jPanel2;
	private JPanel jPanel1;
	public static JTable jInstructionTable;
	private JScrollPane jScrollPane5;
	private JScrollPane jScrollPane4;
	public JComboBox jMemoryAddressComboBox;
	private JButton jDeleteBreakpointButton;
	private JPanel jPanel12;
	private JTable jBreakpointTable;
	private JButton jDisableBreakpointButton;
	private JButton jEnableBreakpointButton;
	private JButton jSaveBreakpointButton;
	private JButton jAddBreakpointButton;
	private JButton jRefreshBreakpointButton;
	private JScrollPane jScrollPane9;
	private JPanel jPanel4;
	private JScrollPane jScrollPane6;
	private JLabel jLabel3;
	private JScrollPane jScrollPane8;
	private JScrollPane jScrollPane7;
	private JTable jPageTableTable;
	private JTable jPageDirectoryTable;
	private JPanel jPanel11;
	private JTable jGDTTable;
	private JScrollPane jScrollPane3;
	private JMenuItem jUpdateBochsStatusMenuItem;
	private JButton jGOMemoryButton;
	private JPanel jPanel9;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private static BufferedWriter commandOutputStream;
	private Process p;
	private JSplitPane jSplitPane2;
	private JProgressBar jStatusProgressBar;
	private JPanel jStatusPanel;
	private JButton jUpdateBochsButton;
	private JLabel jStatusLabel;
	private JButton jDisassembleCurrentIPButton;
	private JComboBox jInstructionComboBox;
	private JPanel jInstructionControlPanel;
	private JPanel jPanel10;
	private JDropDownButton jLoadBreakpointButton;
	private int commandHistoryIndex;
	private JScrollPane jScrollPane10;
	private ButtonGroup buttonGroup1;
	private JRadioButton jHexRadioButton;
	private JRadioButton jDecRadioButton;
	private JRadioButton jOctRadioButton1;
	private JRadioButton jBinaryRadioButton;
	private JTable jLDTTable;
	private JScrollPane jScrollPane11;
	private JTable jIDTTable;
	private JTable jAddressTranslateTable;
	private JTable jAddressTranslateTable2;
	private JPanel jPanel22;
	private JPanel jPanel24;
	private JToolBar jPanel26;
	private JMenuItem jStepOverNTimesMenuItem;
	private JMenuItem jStepOver100MenuItem;
	private JMenuItem jStepOver10MenuItem;
	private JDropDownButton jStepOverDropDownButton;
	private JMenuItem jRunCustomCommandMenuItem;
	private JButton jButton4;
	private EnhancedTextArea bochsoutTextArea;
	private JPanel jPanel31;
	private JMenuItem jShortcutHelpMenuItem;
	private JDropDownButton jSBAButton;
	private JDropDownButton jSBButton;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JSpinner jShowAfterwardSpinner;
	private JMenuItem jRunBochsAndSkipBreakpointMenuItem;
	private JSearchTextField jFilterHistoryTableTextField;
	private JLabel jLabel2;
	private JLabel jHistoryTableRepeatedLabel;
	private JButton jClearRunningTextAreaButton;
	private JButton jClearHistoryTableButton;
	private ButtonGroup buttonGroup4;
	public JMenuItem jWhereIsHereMenuItem;
	private JMenuItem jLoadSystemMapMenuItem;
	private JMenu jSystemMenu;
	private JToggleButton jSourceLevelDebuggerButton;
	private SourceLevelDebugger2 sourceLevelDebugger;
	public JMenuItem jShowInSourceCodeMenuItem;
	private JSeparator jSeparator3;
	private JRadioButton jMMXRadioButton;
	private JRadioButton jFPURadioButton;
	private JButton jPreviousMemoryButton;
	private JButton jNextMemoryPageButton;
	private JComboBox jMaxRowComboBox;
	private JLabel jLabel1;
	private JCheckBox jSaveToRunDotTxtCheckBox;
	private JCheckBox jAutoUpdateEvery20LinesCheckBox;
	private JCheckBox jDisableAutoUpdateCheckBox;
	private JLabel jStepCountLabel;
	private JButton jButton16;
	private EnhancedTextArea jTextArea1;
	private JLabel jRunningLabel2;
	private JPanel jRunningPanel;
	private JMenuItem jStepUntilIPBigChangeMenuItem;
	private JMenuItem jJVMMenuItem;
	private JMenuItem jStepUntilMovMenuItem;
	private JMenuItem jStepUntilIRetMenuItem;
	private JMenuItem jStepUntilRetMenuItem;
	private JMenuItem jStepUntilCallOrJumpMenuItem;
	private JMenuItem jStepNMenuItem;
	private JMenuItem jStep100MenuItem;
	private JMenuItem jStep10MenuItem;
	private JPanel jPanel30;
	private JMenuItem jHelpRequestMenuItem;
	private EnhancedTextArea osLogPanel1;
	private JToggleButton jOSLogToggleButton;
	private JToggleButton jRegisterToggleButton;
	private LogPanel logPanel1;
	private JToggleButton jLogToggleButton;
	private JToggleButton jProfilerToggleButton;
	private InstrumentPanel jInstrumentPanel;
	private JOSDebugInformationPanel jOSDebugInformationPanel1;
	private JLabel jOSDebugInfoErrorLabel;
	private JTabbedPane jTabbedPane5;
	private JPanel jOSDebugStandardPanel;
	private JButton jSettingButton;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JPopupMenu jELFTablePopupMenu;
	public JButton jFastStepBochsButton;
	private JMenuItem jJPMenuItem;
	private JMenuItem jKRMenuItem;
	private JButton jInstructionUpTenButton;
	private JButton jInstructionDownButton;
	private JButton jInstructionUpButton;
	private JMenuItem jMenuItem9;
	private JMenuItem jMenuItem8;
	private JPopupMenu jSearchMemoryTablePopupMenu;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem6;
	private JPopupMenu jBreakpointPopupMenu;
	private JMenuItem jSetLinearBreakpointMenuItem;
	private JMenuItem jSetPhysicalBreakpointMenuItem;
	private JPopupMenu jInstructionPanelPopupMenu;
	private JCheckBox jHideIfAddressIsZeroCheckBox;
	private JMaximizableTabbedPane_BasePanel jMaximizableTabbedPane_BasePanel1;
	private DiskPanel diskPanel;
	private JButton jGoLinearButton;
	private JButton jClearBochsButton;
	public JTextField jDumpPageDirectoryAddressTextField;
	private JButton jDumpPageTableAtAddressButton;
	private JButton jButton20;
	private JButton jButton19;
	private JTable jProgramHeaderTable;
	private JScrollPane jScrollPane16;
	private JTable jELFSectionTable;
	private JScrollPane jScrollPane15;
	private JTable jELFHeaderTable;
	private JScrollPane jELFHeaderScrollPane;
	private JMaximizableTabbedPane jTabbedPane4;
	private JButton jOpenELFDumpButton;
	private JComboBox jELFComboBox;
	private JPanel jELFDumpPanel;
	private JLabel jLatestVersionLabel;
	private JLabel jBochsVersionLabel;
	private JCheckBox jShowELFByteCheckBox;
	private JLabel jCPUModeLabel;
	private JPanel jPanel25;
	private JButton jLoadELFBreakpointButton;
	private JButton jSaveELFBreakpointButton;
	private JButton jDisableELFBreakpointButton;
	private JButton jEnableELFBreakpointButton;
	private JButton jRefreshELFBreakpointButton;
	private JTable jELFTable;
	private JScrollPane jScrollPane14;
	private JComboBox jELFFileComboBox;
	private JButton jOpenELFButton;
	private JPanel jPanel23;
	private JPanel jELFBreakpointPanel;
	private JMenuItem jDisassemble32MenuItem;
	private JMenuItem jPTEMenuItem;
	private JMenuItem jPDEMenuItem;
	private JMenuItem jIDTDescriptorMenuItem;
	private JMenuItem jIDTMenuItem;
	private JMenuItem jGDTDescriptorMenuItem;
	private JMenuItem jGDTMenuItem;
	private JPopupMenu jHexTablePopupMenu;
	private JTextField jAddressTextField;
	private JPanel jPanel21;
	private ButtonGroup buttonGroup3;
	private JButton jButton18;
	private JButton jButton17;
	private JToolBar jToolBar3;
	private JScrollPane jScrollPane13;
	private JButton jRefreshAddressTranslateButton;
	private JPanel jPanel20;
	private JRadioButton jSearchAddressRadioButton3;
	private JRadioButton jSearchAddressRadioButton2;
	private JRadioButton jSearchAddressRadioButton1;
	private JPanel jAddressTranslatePanel;
	private JButton jRefreshPageTableGraphButton;
	private JCheckBox jAutoRefreshPageTableGraphCheckBox;
	private JToolBar jToolBar2;
	private JPanel jPageTableGraphPanel;
	private JButton jPagingGraphButton;
	private JToolBar jPanel19;
	private JButton jGDTGraphButton;
	private JLabel jRunningLabel;
	private JPanel jMainPanel;
	private JButton jButton15;
	private JButton jButton11;
	private JButton jButton10;
	private JButton jButton9;
	private JButton jButton8;
	private JPanel jPanel16;
	private JPanel jPanel15;
	private JButton jButton7;
	private JButton jButton6;
	private JPanel jPanel14;
	private JRadioButton jTblRadioButton;
	private JToolBar jPanel13;
	private JRadioButton jRegRadioButton;
	private JTable jHistoryTable;
	private JMenuItem jDialogMenuItem;
	private JMenuItem jArialMenuItem;
	private JMenu jMenu2;
	private JMenu jMenu1;
	private JScrollPane jTableTranslateScrollPane;
	// Vector<HashMap> bochsCommandLength =
	// XMLHelper.xmltoVector(getClass().getClassLoader().getResourceAsStream("peter/bochsCommandLength.xml"),
	// "/bochsCommandLength");
	private static String[] arguments;
	private JMenuItem jFont14MenuItem;
	private JMenuItem jFont12MenuItem;
	private JMenuItem jFont10MenuItem;
	private JMenuItem jFont8MenuItem;
	private JMenu jFontMenu;
	private JMenuItem jSCMenuItem;
	private JMenuItem jHKMenuItem;
	private JMenuItem jEnglishMenuItem;
	private JMenu jMenu6;
	private JSplitPane jSplitPane3;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jExportHistoryToExcelButton;
	private JButton jButton5;
	private JButton jButton12;
	private JButton jButton13;
	private JPanel jPanel17;
	private JTable jSearchMemoryTable;
	private JScrollPane jScrollPane12;
	private JPanel jPanel18;
	private JButton jSearchMemoryButton;
	private JComboBox jSearchMemoryToComboBox;
	private JLabel jLabel6;
	private JComboBox jSearchMemoryFromComboBox;
	private JLabel jLabel5;
	private JTextField jSearchMemoryTextField;
	private JLabel jLabel4;
	private JButton jDisassembleButton;
	public static ResourceBundle language;
	private JButton jRefreshAddressTranslateTableButton;

	private long currentMemoryWindowsAddress;
	public static boolean isLinux;
	public static String version = "";
	private JButton jButton21;
	public static String bochsrc;
	static boolean preventSetVisibleHang = true;

	boolean breakpointLoadedOnce = false;
	boolean systemMapLoadedOnce = false;
	private JScrollPane jScrollPane17;
	private JEditorPane jEditorPane1;
	private JButton jSearchObjdumpButton;
	private JTextField jTextField1;
	private JToolBar jPanel27;
	private JPanel objdumpPanel;
	private JButton jSearchRelPltButton;
	private JTextField jSearchRelPltTextField;
	private JToolBar jToolBar4;
	private JEditorPane jSearchRelPltEditorPane;
	private JScrollPane jScrollPane18;
	private JPanel jPanel28;

	private JEditorPane jSearchDynamicEditorPane;
	private JScrollPane jScrollPane19;
	private JButton jSearchDynamicButton;
	private JTextField jSearchDynamicTextField;
	private JToolBar jToolBar5;
	private JPanel jPanel29;

	private String currentPanel = "jMaximizableTabbedPane_BasePanel1";

	private ButtonGroup buttonGroup2 = new ButtonGroup();
	private JMenuItem loadSystemsMapMenuItem = new JMenuItem("Load system.map");
	private String latestVersionURL;
	private boolean saveToRunDotTxt;
	private boolean processPauseBoch;
	private int skipBreakpointTime;
	private boolean isUpdateBochsStatusEnd;
	Vector<CustomCommand> customCommandQueue = new Vector<CustomCommand>();
	URL url = getClass().getClassLoader().getResource("com/peterbochs/images/ajax-loader.gif");
	public static Application instance;

	TableModel jBreakpointTableModel = new DefaultTableModel(new String[][] {}, new String[] { MyLanguage.getString("No"), MyLanguage.getString("Address_type"),
			"Disp Enb Address", MyLanguage.getString("Hit") }) {
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		WebServiceUtil.log("peter-bochs", "start", null, null, null);
		try {
			UIManager.setLookAndFeel("com.peterswing.white.PeterSwingWhiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (args.length == 0) {
			String errorMessage = "Wrong number of argument\n\n";
			errorMessage += "\nIn Linux/Mac : java -jar peter-bochs-debugger.jar bochs -f bochxrc.bxrc";
			errorMessage += "\nIn windows : java -jar peter-bochs-debugger.jar c:\\program files\\bochs2.4.3\\bochsdbg.exe -q -f bochxrc.bxrc";
			errorMessage += "\n!!! if using peter-bochs in windows, you need to pass the full path of bochs exe and -q to the parameter. (!!! relative path of bochs exe will not work)";
			errorMessage += "\n!!! to use \"experimental feature\", please add \"-debug\" to the parameter list";
			System.out.println(errorMessage);
			JOptionPane.showMessageDialog(null, errorMessage);
			return;
		} else {
			if (args[0].equals("-version") || args[0].equals("-v")) {
				System.out.println(Global.version);
				return;
			}
		}

		for (String str : args) {
			if (str.contains("bochsrc") || str.contains(".bxrc")) {
				bochsrc = str;
			}
		}

		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.indexOf("windows") > -1) {
			isLinux = false;
		} else {
			isLinux = true;
		}
		if (System.getProperty("mrj.version") != null) {
			com.apple.eawt.Application macApp = com.apple.eawt.Application.getApplication();
			//
			// System.setProperty("dock:name", "Your Application Name");
			macApp.setDockIconImage(new ImageIcon(Application.class.getClassLoader().getResource("com/peterbochs/icons/peter.png")).getImage());
			// java.awt.PopupMenu menu = new java.awt.PopupMenu();
			// menu.add(new MenuItem("test"));
			// macApp.setDockMenu(menu);

			macApp.addApplicationListener(new MacAboutBoxHandler());
		}

		if (ArrayUtils.contains(args, "-debug")) {
			Global.debug = true;
			args = (String[]) ArrayUtils.removeElement(args, "-debug");
		} else {
			Global.debug = false;
		}

		try {
			if (Application.class.getProtectionDomain().getCodeSource().getLocation().getFile().endsWith(".jar")) {
				JarFile jarFile = new JarFile(Application.class.getProtectionDomain().getCodeSource().getLocation().getFile());
				if (System.getProperty("os.name").toLowerCase().startsWith("linux")) {
					if (System.getProperty("os.arch").contains("64")) {
						if (Global.debug) {
							System.out.println("Loading linux 64 bits jogl");
						}
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_amd64/libgluegen-rt.so")), new File("libgluegen-rt.so"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_amd64/libjogl_awt.so")), new File("libjogl_awt.so"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_amd64/libjogl_cg.so")), new File("libjogl_cg.so"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_amd64/libjogl.so")), new File("libjogl.so"));
					} else {
						if (Global.debug) {
							System.out.println("Loading linux 32 bits jogl");
						}
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_i586/libgluegen-rt.so")), new File("libgluegen-rt.so"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_i586/libjogl_awt.so")), new File("libjogl_awt.so"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_i586/libjogl_cg.so")), new File("libjogl_cg.so"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/linux_i586/libjogl.so")), new File("libjogl.so"));
					}
					try {
						File f = new File(".");
						Runtime.getRuntime().load(f.getAbsolutePath() + File.separator + "libjogl.so");
						System.out.println("Loading " + f.getAbsolutePath() + File.separator + "libjogl.so");
						Runtime.getRuntime().load(f.getAbsolutePath() + File.separator + "libjogl_awt.so");
						Runtime.getRuntime().load(f.getAbsolutePath() + File.separator + "libjogl_cg.so");
						Runtime.getRuntime().load(f.getAbsolutePath() + File.separator + "libgluegen-rt.so");
					} catch (UnsatisfiedLinkError e) {
						e.printStackTrace();
						System.err.println("Native code library failed to load.\n" + e);
						System.err.println("Solution : Please add \"-Djava.library.path=.\" to start peter-bochs\n" + e);
					}
				} else if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
					CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/exe/PauseBochs.exe")), new File("PauseBochs.exe"));
					CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/exe/StopBochs.exe")), new File("StopBochs.exe"));
					CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/exe/ndisasm.exe")), new File("ndisasm.exe"));

					if (System.getProperty("os.arch").contains("64")) {
						if (Global.debug) {
							System.out.println("Loading windows 64 bits jogl");
						}
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_amd64/jogl.dll")), new File("jogl.dll"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_amd64/jogl_awt.dll")), new File("jogl_awt.dll"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_amd64/jogl_cg.dll")), new File("jogl_cg.dll"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_amd64/gluegen-rt.dll")), new File("gluegen-rt.dll"));
					} else {
						if (Global.debug) {
							System.out.println("Loading windows 32 bits jogl");
						}
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_i586/jogl.dll")), new File("jogl.dll"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_i586/jogl_awt.dll")), new File("jogl_awt.dll"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_i586/jogl_cg.dll")), new File("jogl_cg.dll"));
						CommonLib.writeFile(jarFile.getInputStream(new JarEntry("com/peterbochs/jogl_dll/windows_i586/gluegen-rt.dll")), new File("gluegen-rt.dll"));
					}
					try {
						File f = new File(".");
						System.load(f.getAbsolutePath() + File.separator + "jogl.dll");
						System.load(f.getAbsolutePath() + File.separator + "jogl_awt.dll");
						System.load(f.getAbsolutePath() + File.separator + "jogl_cg.dll");
						System.load(f.getAbsolutePath() + File.separator + "gluegen-rt.dll");
					} catch (UnsatisfiedLinkError e) {
						e.printStackTrace();
						System.err.println("Native code library failed to load.\n" + e);
						System.err.println("Solution : Please add \"-Djava.library.path=.\" to start peter-bochs\n" + e);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (ArrayUtils.contains(args, "-loadBreakpoint")) {
			Setting.getInstance().setLoadBreakpointAtStartup(true);
			args = (String[]) ArrayUtils.removeElement(args, "-loadBreakpoint");
		} else if (ArrayUtils.contains(args, "-loadbreakpoint")) {
			Setting.getInstance().setLoadBreakpointAtStartup(true);
			args = (String[]) ArrayUtils.removeElement(args, "-loadbreakpoint");
		}

		for (int x = 0; x < args.length; x++) {
			if (args[x].toLowerCase().startsWith("-osdebug")) {
				Global.osDebug = CommonLib.convertFilesize(args[x].replaceAll("-.*=", ""));
				args = (String[]) ArrayUtils.removeElement(args, args[x]);
				x = -1;
			} else if (args[x].toLowerCase().startsWith("-profilingmemoryport")) {
				Global.profilingMemoryPort = (int) CommonLib.convertFilesize(args[x].replaceAll("-.*=", ""));
				args = (String[]) ArrayUtils.removeElement(args, args[x]);
				x = -1;
			} else if (args[x].toLowerCase().startsWith("-profilingjmpport")) {
				Global.profilingJmpPort = (int) CommonLib.convertFilesize(args[x].replaceAll("-.*=", ""));
				args = (String[]) ArrayUtils.removeElement(args, args[x]);
				x = -1;
			} else if (args[x].toLowerCase().startsWith("-loadmap")) {
				Global.mapFilePath = args[x].replaceAll("-.*=", "");
				Setting.getInstance().setLoadSystemMapAtStartup(true);
				args = (String[]) ArrayUtils.removeElement(args, args[x]);
				x = -1;
			}
		}

		arguments = args;

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Application inst = new Application();
				Application.instance = inst;

				new Thread("preventSetVisibleHang thread") {
					public void run() {
						try {
							Thread.currentThread();
							Thread.sleep(5000);
							if (preventSetVisibleHang) {
								System.out.println("setVisible(true) cause system hang, this probably a swing bug, so force exit, please restart");
								System.exit(-1);
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}.start();

				if (Global.debug) {
					System.out.println("setVisible(true)");
				}
				inst.setVisible(true);
				preventSetVisibleHang = false;
				if (Global.debug) {
					System.out.println("end setVisible(true)");
				}
			}
		});
	}

	public Application() {
		super();

		if (Global.debug) {
			System.out.println(new Date());
		}

		if (Global.debug) {
			System.out.println("initGUI()");
		}
		initGUI();
		if (Global.debug) {
			System.out.println("end initGUI()");
		}

		if (Global.debug) {
			System.out.println("startBochs()");
		}
		startBochs();
		if (Global.debug) {
			System.out.println("end startBochs()");
		}
		initChineseFont();
		new Thread("checkLatestVersion thread") {
			public void run() {
				HashMap<String, String> map = PeterBochsCommonLib.checkLatestVersion();
				if (Global.debug) {
					System.out.println("finished checkLatestVersion()");
					System.out.println("checkLatestVersion()=" + map.get("latestVersion"));
				}
				if (map != null) {
					if (map.get("latestVersion") != null && map.get("latestVersion").compareTo(Global.version) > 0) {
						jLatestVersionLabel.setText(MyLanguage.getString("Latest_version_available") + " : " + map.get("latestVersion"));
						latestVersionURL = map.get("downloadURL");
					} else {
						jLatestVersionLabel.setText("");
					}
				} else {
					jLatestVersionLabel.setText("");
				}
			}
		}.start();

		if (Global.debug) {
			System.out.println(new Date());
		}
	}

	private void startBochs() {
		try {
			this.enableAllButtons(true, false);
			jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/resultset_next.png")));

			if (p != null) {
				p.destroy();
			}
			ProcessBuilder pb;
			if (arguments.length == 0) {
				pb = new ProcessBuilder("bochs", "-q");
			} else {
				pb = new ProcessBuilder(arguments);
			}

			pb.redirectErrorStream(true);
			p = pb.start();
			InputStream is = p.getInputStream();
			commandReceiver = new CommandReceiver(is, this);
			new Thread(commandReceiver, "commandReceiver thread").start();
			commandOutputStream = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

			if (isLinux) {
				sendCommand("6");
			}

			Date date1 = new Date();
			while (commandReceiver.getLinesLength() < 9) {
				Thread.currentThread();
				Thread.sleep(100);
				if (new Date().getTime() - date1.getTime() > 4000) {
					break;
				}
			}
			String versionLines[] = commandReceiver.getCommandResultUntilEnd().split("\n");
			for (String line : versionLines) {
				if (line.contains("Bochs x86 Emulator")) {
					version = line.trim();
					jBochsVersionLabel.setText(version + "     ");
				}
				if (line.contains("Peter-bochs instrument")) {
					if (Setting.getInstance().isMemoryProfiling()) {
						if (Global.debug) {
							System.out.println("Memory profiling port " + Global.profilingMemoryPort);
						}
						MemorySocketServerController.start(Global.profilingMemoryPort, null);
					}
					if (Setting.getInstance().isJmpProfiling()) {
						if (Global.debug) {
							System.out.println("Jump profiling port " + Global.profilingJmpPort);
						}
						JmpSocketServerController.start(Global.profilingJmpPort, jInstrumentPanel.getJmpTableModel());
					}
					if (Setting.getInstance().isInterruptProfiling()) {
						if (Global.debug) {
							System.out.println("Interrupt profiling port " + Global.profilingInterruptPort);
						}
						InterruptSocketServerController.start(Global.profilingInterruptPort);
					}
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, MyLanguage.getString("Unable_to_start_bochs") + "\n" + MyLanguage.getString("Tips_you_specified_a_wrong_path_of_bochs"));
			ex.printStackTrace();
		}
	}

	private void stopBochs() {
		WebServiceUtil.log("peter-bochs", "stop", null, null, null);
		try {
			this.enableAllButtons(false, false);
			jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/resultset_next.png")));

			if (currentPanel.equals("jMaximizableTabbedPane_BasePanel1")) {
				CardLayout cl = (CardLayout) (jMainPanel.getLayout());
				cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
				currentPanel = "jMaximizableTabbedPane_BasePanel1";
			}

			if (isLinux) {
				ProcessBuilder pb = new ProcessBuilder("killall", "-9", "bochs");
				pb.start();
			} else {
				ProcessBuilder pb = new ProcessBuilder("StopBochs.exe");
				pb.start();
			}

			MemorySocketServerController.stop();
			JmpSocketServerController.stop();
			InterruptSocketServerController.stop();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private synchronized void pauseBochs(boolean pauseBochsManually, boolean resumeMainPanel) {
		if (!processPauseBoch) {
			processPauseBoch = true;
			try {
				if (jRunBochsButton.getText().equals(MyLanguage.getString("Pause_bochs"))) {
					WebServiceUtil.log("peter-bochs", "pause", null, null, null);

					commandReceiver.clearBuffer();
					commandReceiver.waitUntilNoInput();

					if (pauseBochsManually) {
						if (isLinux) {
							ProcessBuilder pb = new ProcessBuilder("killall", "-2", "bochs");
							pb.start();
						} else {
							ProcessBuilder pb = new ProcessBuilder("PauseBochs.exe");
							pb.start();
						}
					}

					updateBochsStatus(true);

					if (resumeMainPanel) {
						SwingUtilities.invokeLater(new Runnable() {
							// this invokeLater prevent openJDK hang my program,
							// I
							// am using FC15
							public void run() {
								CardLayout cl = (CardLayout) (jMainPanel.getLayout());
								cl.show(jMainPanel, currentPanel);
							}
						});
					}
					if (skipBreakpointTime <= 0 && customCommandQueue.size() <= 0) {
						jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
						jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/resultset_next.png")));
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			processPauseBoch = false;
		}
	}

	private void runBochs() {
		WebServiceUtil.log("peter-bochs", "run", null, null, null);
		try {
			enableAllButtons(false, true);
			if (currentPanel.equals("jMaximizableTabbedPane_BasePanel1") || currentPanel.equals("sourceLevelDebugger")) {
				CardLayout cl = (CardLayout) (jMainPanel.getLayout());
				cl.show(jMainPanel, "Running Label");
			}

			if (skipBreakpointTime > 0) {
				jRunningLabel.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\"" + url + "\" /><br><br>" + skipBreakpointTime
						+ "</center></html>");
				jRunningLabel.getParent().getParent().getParent().repaint();
				jRunningLabel.getParent().getParent().repaint();
				jRunningLabel.getParent().repaint();
				jRunningLabel.repaint();
			} else if (customCommandQueue.size() > 0) {
				String nextCommands = "";
				for (int x = 0; x < customCommandQueue.size() && x < 10; x++) {
					nextCommands += customCommandQueue.get(x);
				}
				jRunningLabel.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\"" + url + "\" /><br><br>"
						+ customCommandQueue.size() + "</center></html>");
				jRunningLabel.getParent().repaint();
			}

			Data.memoryProfilingZone.needToTellBochsToUpdateZone = true;
			commandReceiver.clearBuffer();
			sendCommand("c");

			jRunBochsButton.setText(MyLanguage.getString("Pause_bochs"));
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/pause.png")));

			new Thread("runBochs() update thread") {
				public void run() {
					while (commandReceiver.getLinesLength() == 0) {
						try {
							Thread.currentThread();
							Thread.sleep(200);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					skipBreakpointTime--;
					if (skipBreakpointTime > 0) {
						pauseBochs(false, false); // update register, not really
													// want to pause because it
													// already paused
						waitUpdateFinish();

						runBochs();
					} else if (customCommandQueue.size() > 0) {
						pauseBochs(false, false); // update register, not really
													// want to pause because it
													// already paused
						waitUpdateFinish();

						while (customCommandQueue.size() > 0) {
							String command = customCommandQueue.get(0).command;
							customCommandQueue.remove(0);

							commandReceiver.clearBuffer();
							System.out.println("command=" + command);
							if (command.equals("s")) {
								sendCommand("s");
								updateBochsStatus(true);
								waitUpdateFinish();
							} else if (command.equals("c")) {
								runBochs();
								return;
							}
						}
						// pauseBochs(false, true);
						// waitUpdateFinish();
					} else {
						pauseBochs(false, true);
						waitUpdateFinish();
					}
				}
			}.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void waitUpdateFinish() {
		while (!isUpdateBochsStatusEnd) {
			try {
				Thread.currentThread();
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void initGUI() {
		try {
			language = Utf8ResourceBundle.getBundle("language_" + Setting.getInstance().getCurrentLanguage());

			if (!isLinux) {
				if (!new File("PauseBochs.exe").exists() || !new File("StopBochs.exe").exists()) {
					JOptionPane.showMessageDialog(null, MyLanguage.getString("PauseBochsExe"), MyLanguage.getString("Error"), JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!new File("ndisasm.exe").exists()) {
					JOptionPane.showMessageDialog(null, MyLanguage.getString("NdisasmExe"), MyLanguage.getString("Error"), JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			{
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				if (Global.isBeta) {
					this.setTitle(MyLanguage.getString("Title") + " " + Global.version + " , This is beta version, if you found a bug, please try older official release");
				} else {
					this.setTitle(MyLanguage.getString("Title") + " " + Global.version);
				}

				this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/peter.png")).getImage());
				this.addWindowListener(new WindowAdapter() {
					public void windowOpened(WindowEvent evt) {
						thisWindowOpened(evt);
					}

					public void windowActivated(WindowEvent evt) {
						thisWindowActivated(evt);
					}

					public void windowClosing(WindowEvent evt) {
						thisWindowClosing(evt);
					}
				});
			}
			{
				jToolBar1 = new JToolBar();
				getContentPane().add(jToolBar1, BorderLayout.NORTH);
				{
					jStartBochsButton = new JButton();
					jToolBar1.add(jStartBochsButton);
					jStartBochsButton.setText(MyLanguage.getString("Start_bochs"));
					jStartBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/accept.png")));
					jStartBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jStartBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jStopBochsButton = new JButton();
					jToolBar1.add(jStopBochsButton);
					jStopBochsButton.setText(MyLanguage.getString("Stop_bochs"));
					jStopBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/stop.png")));
					jStopBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jStopBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jRunBochsButton = new JDropDownButton();
					jToolBar1.add(jRunBochsButton);
					jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
					jRunBochsButton.setMaximumSize(new java.awt.Dimension(125, 26));
					jRunBochsButton.add(getJRunBochsAndSkipBreakpointMenuItem());
					jRunBochsButton.add(getJRunCustomCommandMenuItem());
					jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/resultset_next.png")));
					jRunBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRunBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jStepBochsButton = new JDropDownButton();
					jToolBar1.add(jStepBochsButton);
					jToolBar1.add(getJStepOverDropDownButton());
					jToolBar1.add(getJFastStepBochsButton());
					jStepBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/step.png")));
					jStepBochsButton.setText(MyLanguage.getString("Step"));
					jStepBochsButton.setMaximumSize(new java.awt.Dimension(85, 26));
					jStepBochsButton.add(getJStep10MenuItem());
					jStepBochsButton.add(getJStep100MenuItem());
					jStepBochsButton.add(getJStepNMenuItem());
					jStepBochsButton.add(getJStepUntilCallOrJumpMenuItem());
					jStepBochsButton.add(getJStepUntilRetMenuItem());
					jStepBochsButton.add(getJStepUntilIRetMenuItem());
					jStepBochsButton.add(getJStepUntilMovMenuItem());
					jStepBochsButton.add(getJStepUntilIPBigChangeMenuItem());
					jStepBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jStepBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jUpdateBochsButton = new JButton();
					jToolBar1.add(jUpdateBochsButton);
					jToolBar1.add(getJExportToExcelButton());
					jToolBar1.add(getJSettingButton());
					jToolBar1.add(getJRegisterToggleButton());
					jToolBar1.add(getJSourceLevelDebuggerButton());
					jToolBar1.add(getJProfilerToggleButton());
					jToolBar1.add(getJLogToggleButton());
					jToolBar1.add(getJOSLogToggleButton());
					jUpdateBochsButton.setEnabled(true);
					jUpdateBochsButton.setText(MyLanguage.getString("Update"));
					jUpdateBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_refresh.png")));
					jUpdateBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jUpdateBochsButtonActionPerformed(evt);
						}
					});
				}
			}
			{
				jStatusPanel = new JPanel();
				BorderLayout jStatusPanelLayout = new BorderLayout();
				jStatusPanel.setLayout(jStatusPanelLayout);
				getContentPane().add(jStatusPanel, BorderLayout.SOUTH);
				getContentPane().add(getJMainPanel());
				{
					jStatusProgressBar = new JProgressBar();
					jStatusPanel.add(jStatusProgressBar, BorderLayout.WEST);
					jStatusPanel.add(getJPanel25(), BorderLayout.CENTER);
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText(MyLanguage.getString("File"));
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText(MyLanguage.getString("Exit"));
						exitMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								exitMenuItemActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenuBar1.add(getJFontMenu());
					jMenuBar1.add(getJMenu6());
					jMenuBar1.add(getJSystemMenu());
					jMenu4.setText(MyLanguage.getString("Bochs"));
					{
						startBochsMenuItem = new JMenuItem();
						jMenu4.add(startBochsMenuItem);
						startBochsMenuItem.setText(MyLanguage.getString("Start_bochs"));
						startBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								startBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						stopBochsMenuItem = new JMenuItem();
						jMenu4.add(stopBochsMenuItem);
						stopBochsMenuItem.setText(MyLanguage.getString("Stop_bochs"));
						stopBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								stopBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						runBochsMenuItem = new JMenuItem();
						jMenu4.add(runBochsMenuItem);
						runBochsMenuItem.setText(MyLanguage.getString("Run_bochs"));
						runBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								runBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						pauseBochsMenuItem = new JMenuItem();
						jMenu4.add(pauseBochsMenuItem);
						pauseBochsMenuItem.setText(MyLanguage.getString("Pause_bochs"));
						pauseBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								pauseBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						jUpdateBochsStatusMenuItem = new JMenuItem();
						jMenu4.add(jUpdateBochsStatusMenuItem);
						jUpdateBochsStatusMenuItem.setText(MyLanguage.getString("Update_bochs_status"));
						jUpdateBochsStatusMenuItem.setBounds(83, 86, 79, 20);
						jUpdateBochsStatusMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jUpdateBochsStatusMenuItemActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText(MyLanguage.getString("Help"));
					{
						aboutUsMenuItem = new JMenuItem();
						jMenu5.add(aboutUsMenuItem);
						jMenu5.add(getJHelpRequestMenuItem());
						jMenu5.add(getJJVMMenuItem());
						jMenu5.add(getJShortcutHelpMenuItem());
						aboutUsMenuItem.setText(MyLanguage.getString("About_us"));
						aboutUsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								aboutUsMenuItemActionPerformed(evt);
							}
						});
					}
				}
			}
			if (Setting.getInstance().getWidth() == 0 || Setting.getInstance().getHeight() == 0) {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				setSize(screenSize.width * 2 / 3, screenSize.height * 4 / 5);
			} else {
				setSize(Setting.getInstance().getWidth(), Setting.getInstance().getHeight());
			}
			int x = Setting.getInstance().getX();
			int y = Setting.getInstance().getY();
			if (x <= 0 || y <= 0) {
				this.setLocationRelativeTo(null);
			} else {
				setLocation(x, y);
			}

			jSplitPane1.setDividerLocation(Setting.getInstance().getDivX());
			jSplitPane2.setDividerLocation(Setting.getInstance().getDivY());

			jOSDebugInformationPanel1.getjMainSplitPane().setDividerLocation(Setting.getInstance().getOsDebugSplitPane_DividerLocation());
			// pack();
			initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
			jInstrumentPanel.setThing(jStatusProgressBar, jStatusLabel);

			// prevent null jmenuitem
			getJInstructionPanelPopupMenu();
			// end prevent null jmenuitem

			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				public boolean dispatchKeyEvent(KeyEvent e) {
					if (e.getID() == KeyEvent.KEY_RELEASED) {
						int keycode = e.getKeyCode();
						if (keycode == 112) {
							jTabbedPane3.setSelectedIndex(0);
						} else if (keycode == 113) {
							jTabbedPane3.setSelectedIndex(1);
						} else if (keycode == 114) {
							jTabbedPane3.setSelectedIndex(2);
						} else if (keycode == 115) {
							jTabbedPane3.setSelectedIndex(3);
						} else if (keycode == 116) {
							if (jStartBochsButton.isEnabled()) {
								jStartBochsButtonActionPerformed(null);
							}
						} else if (keycode == 117) {
							if (jStopBochsButton.isEnabled()) {
								jStopBochsButtonActionPerformed(null);
							}
						} else if (keycode == 118) {
							if (jRunBochsButton.isEnabled()) {
								jRunBochsButtonActionPerformed(null);
							}
						} else if (keycode == 119) {
							if (jStepBochsButton.isEnabled()) {
								jStepBochsButtonActionPerformed(null);
							}
						} else if (keycode == 120) {
							if (jFastStepBochsButton.isEnabled()) {
								jFastStepButtonActionPerformed(null);
							}
						}
					}

					// If the key should not be dispatched to the
					// focused component, set discardEvent to true
					boolean discardEvent = false;
					return discardEvent;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(ERROR);
		}
	}

	private void initChineseFont() {
		new Thread("initChineseFont thread") {
			public void run() {
				Font[] allfonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
				String chinesesample = "\u4e00";
				for (int j = 0; j < allfonts.length; j++) {
					if (allfonts[j].canDisplayUpTo(chinesesample) == -1) {
						// System.out.println(allfonts[j].getFontName());
						JMenuItem jMenuItem = new JMenuItem(allfonts[j].getFontName());
						jMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								Setting.getInstance().setFontFamily(((JMenuItem) evt.getSource()).getText());
							}
						});
						jMenu2.add(jMenuItem);
					}
				}

				for (int j = 0; j < allfonts.length; j++) {
					if (allfonts[j].canDisplayUpTo(chinesesample) != -1) {
						// System.out.println(allfonts[j].getFontName());
						JMenuItem jMenuItem = new JMenuItem(allfonts[j].getFontName());
						jMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								Setting.getInstance().setFontFamily(((JMenuItem) evt.getSource()).getText());
							}
						});
						jMenu2.add(jMenuItem);
					}
				}
			}
		}.start();
	}

	private void jBochsCommandButtonActionPerformed(ActionEvent evt) {
		try {
			if (jBochsCommandTextField.getText().trim().equals("clear")) {
				this.jBochsEditorPane.setText("");
			} else if (jBochsCommandTextField.getText().trim().equals("c")) {
				commandReceiver.shouldShow = false;
				runBochs();
			} else if (jBochsCommandTextField.getText().trim().equals("q")) {
				stopBochs();
			} else {
				try {
					Setting.getInstance().getBochsCommandHistory().add(jBochsCommandTextField.getText());
					Setting.getInstance().save();
				} catch (Exception ex2) {
				}

				commandReceiver.shouldShow = true;

				sendCommand(this.jBochsCommandTextField.getText());
				if (Setting.getInstance().isUpdateAfterBochsCommand()) {
					updateBochsStatusForBochsCommand(true);
				}
				commandHistoryIndex = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jBochsCommandTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jBochsCommandButtonActionPerformed(null);
			jBochsCommandTextField.setText("");
		}
	}

	private void startBochsMenuItemActionPerformed(ActionEvent evt) {
		startBochs();
	}

	private void stopBochsMenuItemActionPerformed(ActionEvent evt) {
		stopBochs();
	}

	private void runBochsMenuItemActionPerformed(ActionEvent evt) {
		runBochs();
	}

	private void pauseBochsMenuItemActionPerformed(ActionEvent evt) {
		skipBreakpointTime = 0;
		pauseBochs(true, true);
	}

	private void jStartBochsButtonActionPerformed(ActionEvent evt) {
		startBochs();
	}

	private void jStopBochsButtonActionPerformed(ActionEvent evt) {
		stopBochsMenuItemActionPerformed(null);
	}

	private void jRunBochsButtonActionPerformed(ActionEvent evt) {
		if (jRunBochsButton.getEventSource() != null) {
			if (jRunBochsButton.getEventSource() == jRunBochsAndSkipBreakpointMenuItem) {
				customCommandQueue.clear();
				commandReceiver.shouldShow = false;
				String s = JOptionPane.showInputDialog(this, "How many time of breakpoint you want to skip?");
				if (s == null) {
					return;
				}
				skipBreakpointTime = Integer.parseInt(s);
				runBochsMenuItemActionPerformed(null);
			} else if (jRunBochsButton.getEventSource() == jRunCustomCommandMenuItem) {
				CustomCommandDialog d = new CustomCommandDialog(this);
				d.setVisible(true);
				customCommandQueue.clear();
				if (d.ok) {
					for (int z = 0; z < (Integer) d.jRepeatSpinner.getValue(); z++) {
						if (!d.jComboBox1.getSelectedItem().toString().equals("")) {
							for (int x = 0; x < (Integer) d.jSpinner1.getValue(); x++) {
								customCommandQueue.add(new CustomCommand(d.jComboBox1.getSelectedItem().toString()));
							}
						}
						if (!d.jComboBox2.getSelectedItem().toString().equals("")) {
							for (int x = 0; x < (Integer) d.jSpinner2.getValue(); x++) {
								customCommandQueue.add(new CustomCommand(d.jComboBox2.getSelectedItem().toString()));
							}
						}
						if (!d.jComboBox3.getSelectedItem().toString().equals("")) {
							for (int x = 0; x < (Integer) d.jSpinner3.getValue(); x++) {
								customCommandQueue.add(new CustomCommand(d.jComboBox3.getSelectedItem().toString()));
							}
						}
						if (!d.jComboBox4.getSelectedItem().toString().equals("")) {
							for (int x = 0; x < (Integer) d.jSpinner4.getValue(); x++) {
								customCommandQueue.add(new CustomCommand(d.jComboBox4.getSelectedItem().toString()));
							}
						}
						if (!d.jComboBox5.getSelectedItem().toString().equals("")) {
							for (int x = 0; x < (Integer) d.jSpinner5.getValue(); x++) {
								customCommandQueue.add(new CustomCommand(d.jComboBox5.getSelectedItem().toString()));
							}
						}
						if (!d.jComboBox6.getSelectedItem().toString().equals("")) {
							for (int x = 0; x < (Integer) d.jSpinner6.getValue(); x++) {
								customCommandQueue.add(new CustomCommand(d.jComboBox6.getSelectedItem().toString()));
							}
						}
					}

					skipBreakpointTime = 0;
					commandReceiver.shouldShow = false;
					runBochsMenuItemActionPerformed(null);
				}
			}
		} else {
			customCommandQueue.clear();
			commandReceiver.shouldShow = false;
			if (jRunBochsButton.getText().equals(MyLanguage.getString("Run_bochs"))) {
				runBochsMenuItemActionPerformed(null);
			} else {
				pauseBochsMenuItemActionPerformed(null);
			}
		}
	}

	public static void sendCommand(String command) {
		try {
			command = command.toLowerCase().trim();

			commandReceiver.clearBuffer();
			commandOutputStream.write(command + "\n");
			commandOutputStream.flush();
			if (!command.equals("6") && !command.equals("c") && !command.startsWith("pb") && !command.startsWith("vb") && !command.startsWith("lb") && !command.startsWith("bpd")
					&& !command.startsWith("bpe") && !command.startsWith("del") && !command.startsWith("set")) {
				commandReceiver.waitUntilHaveInput();
				return;
			}
		} catch (IOException e) {
		}
	}

	public void sendCommand2(String command) {
		try {
			p.getOutputStream().write(3);
			// commandOutputStream.write(3);
			// commandOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void aboutUsMenuItemActionPerformed(ActionEvent evt) {
		new JAboutUsDialog(this).setVisible(true);
	}

	MyThread untilThread;

	private void jStepBochsButtonActionPerformed(ActionEvent evt) {
		if (jStepBochsButton.getEventSource() != null) {
			untilThread = new MyThread(jStepBochsButton.getEventSource());
			if (jStepBochsButton.getEventSource() == jStepNMenuItem) {
				String s = JOptionPane.showInputDialog(this, "Please input the instruction count?");
				if (s == null) {
					return;
				}
				untilThread.instructionCount = Integer.parseInt(s);
			} else if (jStepBochsButton.getEventSource() == jStepUntilIPBigChangeMenuItem) {
				String s = JOptionPane.showInputDialog("Please input the instruction count?");
				if (s == null) {
					return;
				}
				untilThread.ipDelta = CommonLib.convertFilesize(s);
			}

			// if (currentPanel.equals("jMaximizableTabbedPane_BasePanel1")) {
			CardLayout cl = (CardLayout) (jMainPanel.getLayout());
			cl.show(jMainPanel, "Running Label 2");
			// }
			new Thread(untilThread, "Step until thread").start();
		} else {
			sendCommand("s");
			WebServiceUtil.log("peter-bochs", "step", null, null, null);
			updateBochsStatus(true);
			// updateHistoryTable(re);
		}
	}

	class MyThread implements Runnable {
		Object eventSource;
		public boolean shouldStop;
		public int instructionCount;
		public long ipDelta;
		int noOfLine = 1;

		public MyThread(Object eventSource) {
			this.eventSource = eventSource;
		}

		private String update(String result, DataOutputStream out) {
			String re = commandReceiver.getCommandResult("(").toLowerCase();
			if (saveToRunDotTxt || !jDisableAutoUpdateCheckBox.isSelected()) {
				if (re.endsWith("\n")) {
					re = re.substring(0, re.length() - 1);
				}
				if (jAutoUpdateEvery20LinesCheckBox.isSelected()) {
					result += re + "\n";
				} else {
					result = re;
				}
			}
			updatePTime();
			updateRegister();
			updateHistoryTable(re);
			if (saveToRunDotTxt) {
				try {
					out.writeBytes(result + "\n");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!jDisableAutoUpdateCheckBox.isSelected()) {
				if (jMaxRowComboBox.getSelectedItem().equals("infinite")) {
					jTextArea1.setMaxRow(-1);
				} else {
					jTextArea1.setMaxRow(Integer.parseInt(jMaxRowComboBox.getSelectedItem().toString()));
				}
				if (jAutoUpdateEvery20LinesCheckBox.isSelected()) {
					if (noOfLine >= 20) {
						jBochsEditorPane.setText(jBochsEditorPane.getText() + result);
						jTextArea1.newLogFileLine(result);
						result = "";
						noOfLine = 1;
					} else {
						noOfLine++;
					}
				} else {
					jBochsEditorPane.setText(jBochsEditorPane.getText() + result);
					jTextArea1.newLogFileLine(result);
					result = "";
				}
			}
			return result;
		}

		public void run() {
			DataOutputStream out = null;
			try {
				enableAllButtons(false, false);
				jStepCountLabel.setVisible(false);
				out = new DataOutputStream(new FileOutputStream("run.txt", true));

				if (eventSource != null) {
					if (eventSource == jStep10MenuItem) {
						String result = "";
						for (int x = 1; x <= 10 && !shouldStop; x++) {
							jStatusLabel.setText("Step " + x + " / 10");
							sendCommand("s");
							result = update(result, out);
						}
						updateBochsStatus(false);
					} else if (eventSource == jStep100MenuItem) {
						String result = "";
						for (int x = 1; x <= 100 && !shouldStop; x++) {
							jStatusLabel.setText("Step " + x + " / 100");
							sendCommand("s");
							result = update(result, out);
						}
						updateBochsStatus(false);
					} else if (eventSource == jStepOver10MenuItem) {
						String result = "";
						for (int x = 1; x <= 10 && !shouldStop; x++) {
							jStatusLabel.setText("Step over " + x + " / 10");
							sendCommand("next");
							result = update(result, out);
						}
						updateBochsStatus(false);
					} else if (eventSource == jStepOver100MenuItem) {
						String result = "";
						for (int x = 1; x <= 100 && !shouldStop; x++) {
							jStatusLabel.setText("Step over " + x + " / 10");
							sendCommand("next");
							result = update(result, out);
						}
						updateBochsStatus(false);
					} else if (eventSource == jStepNMenuItem) {
						String result = "";
						jStepCountLabel.setVisible(true);
						for (int x = 1; x <= instructionCount && !shouldStop; x++) {
							jStatusLabel.setText("Step " + x + " / " + instructionCount);
							jStepCountLabel.setText("Step " + x + " / " + instructionCount);
							sendCommand("s");
							result = update(result, out);
							jBochsEditorPane.setText("");
						}
						updateBochsStatus(false);
					} else if (eventSource == jStepOverNTimesMenuItem) {
						String result = "";
						jStepCountLabel.setVisible(true);
						for (int x = 1; x <= instructionCount && !shouldStop; x++) {
							jStatusLabel.setText("Step over " + x + " / " + instructionCount);
							jStepCountLabel.setText("Step over " + x + " / " + instructionCount);
							sendCommand("next");
							result = update(result, out);
							jBochsEditorPane.setText("");
						}
						updateBochsStatus(false);
					} else if (eventSource == jStepUntilCallOrJumpMenuItem) {
						boolean notMatch = true;
						do {
							sendCommand("s");
							String result = commandReceiver.getCommandResult("(").toLowerCase();
							if (result.contains("jmp") || result.contains("je") || result.contains("jne") || result.contains("jg") || result.contains("jge")
									|| result.contains("ja") || result.contains("jae") || result.contains("jl") || result.contains("jle") || result.contains("jb")
									|| result.contains("jbe") || result.contains("jo") || result.contains("jno") || result.contains("jz") || result.contains("jnz")
									|| result.contains("loop") || result.contains("call")) {
								notMatch = false;
							}
						} while (notMatch && !shouldStop);
						updateBochsStatus(true);
					} else if (eventSource == jStepUntilRetMenuItem) {
						boolean notMatch = true;
						do {
							sendCommand("s");
							String result = commandReceiver.getCommandResult("(").toLowerCase();
							if (result.contains("ret")) {
								notMatch = false;
							}
						} while (notMatch && !shouldStop);
						updateBochsStatus(true);
					} else if (eventSource == jStepUntilIRetMenuItem) {
						boolean notMatch = true;
						do {
							sendCommand("s");
							String result = commandReceiver.getCommandResult("(").toLowerCase();
							if (result.contains("iret")) {
								notMatch = false;
							}
						} while (notMatch && !shouldStop);
						updateBochsStatus(true);
					} else if (eventSource == jStepUntilMovMenuItem) {
						boolean notMatch = true;
						do {
							sendCommand("s");
							String result = commandReceiver.getCommandResult("(").toLowerCase();
							if (result.contains("mov")) {
								notMatch = false;
							}
						} while (notMatch && !shouldStop);
						updateBochsStatus(true);
					} else if (eventSource == jStepUntilIPBigChangeMenuItem) {
						boolean notMatch = true;
						long lastIP = -1;
						int count = 1;
						Date lastTime = new Date();
						jStepCountLabel.setVisible(true);

						int noOfLine = 1;
						String result = "";

						do {
							double secondDiff = 0;
							sendCommand("s");

							String re = commandReceiver.getCommandResult("(").toLowerCase();
							long ip = CommonLib.convertFilesize(re.replaceAll("\\].*$", "").replaceAll("^.*\\[", ""));

							if (saveToRunDotTxt || !jDisableAutoUpdateCheckBox.isSelected()) {
								if (re.endsWith("\n")) {
									re = re.substring(0, re.length() - 1);
								}
								if (jAutoUpdateEvery20LinesCheckBox.isSelected()) {
									result += re + "\n";
								} else {
									result = re;
								}
							}
							updateRegister();
							updateHistoryTable(re);

							if (saveToRunDotTxt) {
								out.writeBytes(result + "\n");
								out.flush();
							}
							if (!jDisableAutoUpdateCheckBox.isSelected()) {
								if (jMaxRowComboBox.getSelectedItem().equals("infinite")) {
									jTextArea1.setMaxRow(-1);
								} else {
									jTextArea1.setMaxRow(Integer.parseInt(jMaxRowComboBox.getSelectedItem().toString()));
								}
								if (jAutoUpdateEvery20LinesCheckBox.isSelected()) {
									if (noOfLine >= 20) {
										jBochsEditorPane.setText(jBochsEditorPane.getText() + result);
										jTextArea1.newLogFileLine(result);
										result = "";
										noOfLine = 1;

										secondDiff = (Double.parseDouble(String.valueOf(new Date().getTime())) - lastTime.getTime()) / 1000;
										lastTime = new Date();
									} else {
										noOfLine++;
									}
								} else {
									jBochsEditorPane.setText(jBochsEditorPane.getText() + result);
									jTextArea1.newLogFileLine(result);
									result = "";

									secondDiff = (Double.parseDouble(String.valueOf(new Date().getTime())) - lastTime.getTime()) / 1000;
									lastTime = new Date();
								}
							} else {
								secondDiff = (Double.parseDouble(String.valueOf(new Date().getTime())) - lastTime.getTime()) / 1000;
								lastTime = new Date();
							}

							if (lastIP != -1 && Math.abs(ip - lastIP) >= ipDelta) {
								notMatch = false;
							}
							lastIP = ip;

							if (secondDiff > 0) {
								if (!jDisableAutoUpdateCheckBox.isSelected()) {
									if (jAutoUpdateEvery20LinesCheckBox.isSelected()) {
										jStepCountLabel.setText(String.valueOf(count) + " instructions executed, current EIP=0x" + Long.toHexString(ip) + ", "
												+ Math.round(20 / secondDiff) + " instructions executed per second");
										count += 20;
									} else {
										jStepCountLabel.setText(String.valueOf(count++) + " instructions executed, current EIP=0x" + Long.toHexString(ip) + ", "
												+ Math.round(1 / secondDiff) + " instructions executed per second");
									}
								} else {
									jStepCountLabel.setText(String.valueOf(count++) + " instructions executed, current EIP=0x" + Long.toHexString(ip) + ", "
											+ Math.round(1 / secondDiff) + " instructions executed per second");
								}
							}
							updateRegister();
						} while (notMatch && !shouldStop);
						updateBochsStatus(true);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (currentPanel.equals("jMaximizableTabbedPane_BasePanel1") || currentPanel.equals("sourceLevelDebugger")) {
					CardLayout cl = (CardLayout) (jMainPanel.getLayout());
					cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
					currentPanel = "jMaximizableTabbedPane_BasePanel1";
				}

				enableAllButtons(true, false);
			}

			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void jGOMemoryButtonActionPerformed(ActionEvent evt) {
		try {
			updateMemory(true);

			addMemoryAddressComboBox(jMemoryAddressComboBox.getSelectedItem().toString());

			Setting.getInstance().getMemoryCombo().add(jMemoryAddressComboBox.getSelectedItem().toString());
			Setting.getInstance().save();
		} catch (Exception ex) {
			if (Global.debug) {
				ex.printStackTrace();
			}
		}
	}

	private void addMemoryAddressComboBox(String str) {
		for (int x = 0; x < jMemoryAddressComboBox.getItemCount(); x++) {
			if (jMemoryAddressComboBox.getItemAt(x).toString().trim().equals(str.trim())) {
				return;
			}
		}
		jMemoryAddressComboBox.addItem(str.trim());
	}

	private void addInstructionComboBox(String str) {
		for (int x = 0; x < jInstructionComboBox.getItemCount(); x++) {
			if (this.jInstructionComboBox.getItemAt(x).toString().trim().equals(str.trim())) {
				return;
			}
		}

		jInstructionComboBox.addItem(str.trim());
	}

	private void jUpdateBochsStatusMenuItemActionPerformed(ActionEvent evt) {
		updateBochsStatus(true);
	}

	public void updateBochsStatus(final boolean updateHistoryTable) {
		isUpdateBochsStatusEnd = false;
		WebServiceUtil.log("peter-bochs", "updateBochsStatus", null, null, null);
		final JProgressBarDialog d = new JProgressBarDialog(this, true);
		Thread updateThread = new Thread("updateBochsStatus thread") {
			public void run() {
				if (Global.debug) {
					System.out.println("updateBochsStatus thread start");
				}
				enableAllButtons(false, skipBreakpointTime > 0);

				d.jProgressBar.setString("update ptime");
				if (Global.debug) {
					System.out.println("update ptime");
				}
				updatePTime();

				d.jProgressBar.setString("updateRegister");
				if (Global.debug) {
					System.out.println("updateRegister");
				}
				updateRegister();

				d.jProgressBar.setString("updateEFlag");
				if (Global.debug) {
					System.out.println("updateEFlag");
				}
				updateEFlag();

				d.jProgressBar.setString("updateMemory");
				if (Global.debug) {
					System.out.println("updateMemory");
				}
				updateMemory(true);

				d.jProgressBar.setString("updateInstruction");
				if (Global.debug) {
					System.out.println("updateInstruction");
				}
				updateInstruction(null);

				d.jProgressBar.setString("updateGDT");
				if (Global.debug) {
					System.out.println("updateGDT");
				}
				updateGDT();

				d.jProgressBar.setString("updateIDT");
				if (Global.debug) {
					System.out.println("updateIDT");
				}
				updateIDT();

				d.jProgressBar.setString("updateLDT");
				if (Global.debug) {
					System.out.println("updateLDT");
				}
				updateLDT();

				d.jProgressBar.setString("updatePageTable");
				if (Global.debug) {
					System.out.println("updatePageTable");
				}
				updatePageTable(CommonLib.convertFilesize(jRegisterPanel1.jCR3TextField.getText()));

				d.jProgressBar.setString("updateStack");
				if (Global.debug) {
					System.out.println("updateStack");
				}
				updateStack();

				d.jProgressBar.setString("updateAddressTranslate");
				if (Global.debug) {
					System.out.println("updateAddressTranslate");
				}
				updateAddressTranslate();

				d.jProgressBar.setString("updateBreakpoint");
				if (Global.debug) {
					System.out.println("updateBreakpoint");
				}
				updateBreakpoint();

				d.jProgressBar.setString("updateBreakpointTableColor");
				if (Global.debug) {
					System.out.println("updateBreakpointTableColor");
				}
				updateBreakpointTableColor();

				if (Global.osDebug != -1) {
					d.jProgressBar.setString("update OS debug informations");
					if (Global.debug) {
						System.out.println("update OS debug informations");
					}
					updateOSDebugInfo();
				}

				d.jProgressBar.setString("jInstrumentPanel.updateChart");
				if (Global.debug) {
					System.out.println("jInstrumentPanel.updateChart");
				}
				jInstrumentPanel.updateChart();

				d.jProgressBar.setString("update call graph");
				if (Global.debug) {
					System.out.println("update call graph");
				}
				jInstrumentPanel.updateCallGraph();

				if (updateHistoryTable) {
					d.jProgressBar.setString("updateHistoryTable");
					if (Global.debug) {
						System.out.println("updateHistoryTable");
					}
					sendCommand("disasm");
					String result = commandReceiver.getCommandResultUntilEnd();
					updateHistoryTable(result);
				}

				jStatusLabel.setText("");

				if (breakpointLoadedOnce == false && Setting.getInstance().loadBreakpointAtStartup) {
					jLoadBreakpointButtonActionPerformed(null);
					breakpointLoadedOnce = true; // since we only have to load
													// once
				}
				if (systemMapLoadedOnce == false && Setting.getInstance().loadSystemMapAtStartup) {
					if (Global.mapFilePath != null) {
						sourceLevelDebugger.loadSystemMap(new File(Global.mapFilePath));
						systemMapLoadedOnce = true; // since we only have to
													// load once
					}
				}
				d.jProgressBar.setString("updateBochsStatus end");
				d.setVisible(false);

				enableAllButtons(true, skipBreakpointTime > 0 || customCommandQueue.size() > 0);
				isUpdateBochsStatusEnd = true;
				if (Global.debug) {
					System.out.println("updateBochsStatus thread end");
				}
			}
		};

		// d.thread = updateThread;
		// updateThread.setDaemon(true);
		// d.setTitle("Updating peter-bochs status");
		// d.jProgressBar.setIndeterminate(true);
		// d.jCancelButton.setVisible(false);
		// d.setVisible(true);
		updateThread.start();

		if (Global.debug) {
			System.out.println("updateBochsStatus() end");
		}
	}

	protected void updatePTime() {
		try {
			jStatusLabel.setText("Updating general registers");
			commandReceiver.shouldShow = false;
			sendCommand("ptime");
			String result = commandReceiver.getCommandResultUntilEnd();
			if (result.contains(":") && result.contains("ptime")) {
				jRegisterPanel1.jPTimeTextField.setText(result.split(":")[1].trim());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void updateOSDebugInfo() {
		long size = 0;
		try {
			String magicByte = getMemoryStr(Global.osDebug, 8, true);
			CardLayout cl = (CardLayout) (jOSDebugStandardPanel.getLayout());
			if (magicByte.equals("PETER---")) {
				size = CommonLib.getInt(getMemory(Global.osDebug + 8, 4, true), 0);
				String xml = getMemoryStr(Global.osDebug + 12, (int) size, true).trim();
				// xml = CommonLib.readFile("test.xml");
				OSDebugInfoHelper.jOSDebugInformationPanel = jOSDebugInformationPanel1;

				OSDebugInfoHelper.addData(magicByte, size, xml);
				this.jOSDebugInformationPanel1.jXMLEditorPane.setText(xml);
				cl.show(jOSDebugStandardPanel, "jOSDebugInformationPanel1");
			} else {
				cl.show(jOSDebugStandardPanel, "OS debug error label");
			}
		} catch (OutOfMemoryError ex) {
			System.gc();
			System.out.println("Size probably too large? size=" + size);
			ex.printStackTrace();
		}
	}

	public void updateBochsStatusForBochsCommand(boolean shouldWait) {
		Thread updateThread = new Thread("updateBochsStatusForBochsCommand thread") {
			public void run() {
				enableAllButtons(false, false);

				if (Setting.getInstance().isUpdateAfterBochsCommand_register()) {
					if (Global.debug) {
						System.out.println("updateRegister");
					}
					updateRegister();
					if (Global.debug) {
						System.out.println("updateEFlag");
					}
					updateEFlag();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_memory()) {
					if (Global.debug) {
						System.out.println("updateMemory");
					}
					updateMemory(true);
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_instruction()) {
					if (Global.debug) {
						System.out.println("updateInstruction");
					}
					updateInstruction(null);
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_gdt()) {
					if (Global.debug) {
						System.out.println("updateGDT");
					}
					updateGDT();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_idt()) {
					if (Global.debug) {
						System.out.println("updateIDT");
					}
					updateIDT();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_ldt()) {
					if (Global.debug) {
						System.out.println("updateLDT");
					}
					updateLDT();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_pageTable()) {
					if (Global.debug) {
						System.out.println("updatePageTable");
					}
					updatePageTable(CommonLib.convertFilesize(jRegisterPanel1.jCR3TextField.getText()));
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_stack()) {
					if (Global.debug) {
						System.out.println("updateStack");
					}
					updateStack();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_addressTranslate()) {
					if (Global.debug) {
						System.out.println("updateAddressTranslate");
					}
					updateAddressTranslate();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_history()) {
					if (Global.debug) {
						System.out.println("updateHistoryTable");
					}
					updateHistoryTable();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_breakpoint()) {
					if (Global.debug) {
						System.out.println("updateBreakpointTableColor");
					}
					updateBreakpoint();
					updateBreakpointTableColor();
				}

				jStatusLabel.setText("");

				enableAllButtons(true, false);

				if (breakpointLoadedOnce == false && Setting.getInstance().loadBreakpointAtStartup) {
					jLoadBreakpointButtonActionPerformed(null);
					breakpointLoadedOnce = true; // since we only have to load
													// once
				}
			}
		};
		updateThread.start();
		if (shouldWait) {
			try {
				updateThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateBreakpointTableColor() {
		for (int x = 0; x < jBreakpointTable.getRowCount(); x++) {
			String value = jBreakpointTable.getValueAt(x, 0).toString();
			JInstructionTableModel model = (JInstructionTableModel) jInstructionTable.getModel();
			if (CommonLib.convertFilesize(model.getMemoryAddress(0)) == CommonLib.convertFilesize(jBreakpointTable.getValueAt(x, 2).toString())) {
				int hit = Integer.parseInt(jBreakpointTable.getValueAt(x, 3).toString());
				jBreakpointTable.setValueAt("-" + value, x, 0);
				jBreakpointTable.setValueAt(hit + 1, x, 3);
			} else {
				if (value.startsWith("-")) {
					jBreakpointTable.setValueAt(value.substring(1), x, 0);
				}
			}
		}
	}

	private void updateHistoryTable() {
		updateHistoryTable("");
	}

	private void updateHistoryTable(String instruction) {
		try {
			AllRegisters.time.add(new Date());
			AllRegisters.ptime.add(jRegisterPanel1.jPTimeTextField.getText());
			AllRegisters.eax.add(CommonLib.string2decimal(jRegisterPanel1.jEAXTextField.getText()));
			AllRegisters.ebx.add(CommonLib.string2decimal(jRegisterPanel1.jEBXTextField.getText()));
			AllRegisters.ecx.add(CommonLib.string2decimal(jRegisterPanel1.jECXTextField.getText()));
			AllRegisters.edx.add(CommonLib.string2decimal(jRegisterPanel1.jEDXTextField.getText()));
			AllRegisters.esi.add(CommonLib.string2decimal(jRegisterPanel1.jESITextField.getText()));
			AllRegisters.edi.add(CommonLib.string2decimal(jRegisterPanel1.jEDITextField.getText()));
			AllRegisters.ebp.add(CommonLib.string2decimal(jRegisterPanel1.jEBPTextField.getText()));
			AllRegisters.esp.add(CommonLib.string2decimal(jRegisterPanel1.jESPTextField.getText()));

			AllRegisters.cs.add(CommonLib.string2decimal(jRegisterPanel1.jCSTextField.getText()));
			AllRegisters.eip.add(CommonLib.string2decimal(jRegisterPanel1.jEIPTextField.getText()));
			AllRegisters.ds.add(CommonLib.string2decimal(jRegisterPanel1.jDSTextField.getText()));
			AllRegisters.es.add(CommonLib.string2decimal(jRegisterPanel1.jESTextField.getText()));
			AllRegisters.fs.add(CommonLib.string2decimal(jRegisterPanel1.jFSTextField.getText()));
			AllRegisters.gs.add(CommonLib.string2decimal(jRegisterPanel1.jGSTextField.getText()));
			AllRegisters.ss.add(CommonLib.string2decimal(jRegisterPanel1.jSSTextField.getText()));
			AllRegisters.eflags.add(jRegisterPanel1.jEFlagLabel.getText().trim() + jRegisterPanel1.jEFlagLabel2.getText().trim());

			AllRegisters.cr0.add(CommonLib.string2decimal(jRegisterPanel1.jCR0TextField.getText()));
			AllRegisters.cr2.add(CommonLib.string2decimal(jRegisterPanel1.jCR2TextField.getText()));
			AllRegisters.cr3.add(CommonLib.string2decimal(jRegisterPanel1.jCR3TextField.getText()));
			AllRegisters.cr4.add(CommonLib.string2decimal(jRegisterPanel1.jCR4TextField.getText()));

			AllRegisters.gdtr.add(CommonLib.string2decimal(jRegisterPanel1.jGDTRTextField.getText()));
			AllRegisters.idtr.add(CommonLib.string2decimal(jRegisterPanel1.jIDTRTextField.getText()));
			AllRegisters.ldtr.add(CommonLib.string2decimal(jRegisterPanel1.jLDTRTextField.getText()));

			AllRegisters.tr.add(CommonLib.string2decimal(jRegisterPanel1.jTRTextField.getText()));

			AllRegisters.instructions.add(instruction.trim());
			AllRegisters.cCode.add(getCCodeStr(CommonLib.string2decimal(jRegisterPanel1.jEIPTextField.getText())));

			Vector<Long> stack = new Vector<Long>();
			for (int x = 0; x < jRegisterPanel1.jStackList.getModel().getSize(); x++) {
				stack.add(CommonLib.string2decimal(jRegisterPanel1.jStackList.getModel().getElementAt(x).toString()));
			}
			AllRegisters.stack.add(stack);

			AllRegisters.st0.add(jRegisterPanel1.jST0TextField.getText());
			AllRegisters.st1.add(jRegisterPanel1.jST1TextField.getText());
			AllRegisters.st2.add(jRegisterPanel1.jST2TextField.getText());
			AllRegisters.st3.add(jRegisterPanel1.jST3TextField.getText());
			AllRegisters.st4.add(jRegisterPanel1.jST4TextField.getText());
			AllRegisters.st5.add(jRegisterPanel1.jST5TextField.getText());
			AllRegisters.st6.add(jRegisterPanel1.jST6TextField.getText());
			AllRegisters.st7.add(jRegisterPanel1.jST7TextField.getText());
			AllRegisters.fpu_status.add(jRegisterPanel1.jFPUStatusTextField.getText());
			AllRegisters.fpu_control.add(jRegisterPanel1.jFPUControlTextField.getText());
			AllRegisters.fpu_tag.add(jRegisterPanel1.jFPUTagTextField.getText());
			AllRegisters.fpu_operand.add(jRegisterPanel1.jFPUOperandTextField.getText());
			AllRegisters.fip.add(jRegisterPanel1.jFIPTextField.getText());
			AllRegisters.fcs.add(jRegisterPanel1.jFCSTextField.getText());
			AllRegisters.fdp.add(jRegisterPanel1.jFDPTextField.getText());
			AllRegisters.fds.add(jRegisterPanel1.jFDSTextField.getText());

			AllRegisters.mm0.add(jRegisterPanel1.jMMX0TextField.getText());
			AllRegisters.mm1.add(jRegisterPanel1.jMMX1TextField.getText());
			AllRegisters.mm2.add(jRegisterPanel1.jMMX2TextField.getText());
			AllRegisters.mm3.add(jRegisterPanel1.jMMX3TextField.getText());
			AllRegisters.mm4.add(jRegisterPanel1.jMMX4TextField.getText());
			AllRegisters.mm5.add(jRegisterPanel1.jMMX5TextField.getText());
			AllRegisters.mm6.add(jRegisterPanel1.jMMX6TextField.getText());
			AllRegisters.mm7.add(jRegisterPanel1.jMMX7TextField.getText());

			((HistoryTableModel) this.jHistoryTable.getModel()).fireTableDataChanged();
			jHistoryTable.scrollRectToVisible(jHistoryTable.getCellRect(jHistoryTable.getRowCount() - 1, 0, true));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateEFlag() {
		try {
			jStatusLabel.setText("Updating EFlags");
			// commandReceiver.setCommandNoOfLine(-1);
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			sendCommand("info eflags");
			String result = commandReceiver.getCommandResultUntilEnd();
			String arr[] = result.replaceAll("<.*> ", "").split(" ");

			jRegisterPanel1.jEFlagLabel.setText("");
			jRegisterPanel1.jEFlagLabel2.setText("");
			for (int x = 0; x < 7; x++) {
				jRegisterPanel1.jEFlagLabel.setText(jRegisterPanel1.jEFlagLabel.getText() + arr[x] + " ");
			}
			for (int x = 7; x < arr.length; x++) {
				jRegisterPanel1.jEFlagLabel2.setText(jRegisterPanel1.jEFlagLabel2.getText() + arr[x] + " ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void updateAddressTranslate() {
		try {
			jStatusLabel.setText("Updating Address translate");
			// commandReceiver.setCommandNoOfLine(-1);
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			sendCommand("info tab");
			Thread.currentThread();
			Thread.sleep(100);
			String result = commandReceiver.getCommandResultUntilEnd();
			String[] lines = result.split("\n");
			DefaultTableModel model = (DefaultTableModel) jAddressTranslateTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int x = 1; x < lines.length; x++) {
				Vector<String> strs = new Vector<String>(Arrays.asList(lines[x].trim().split("->")));
				model.addRow(strs);
			}
			((DefaultTableModel) jAddressTranslateTable.getModel()).fireTableDataChanged();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enableAllButtons(boolean b, boolean exceptRunButton) {
		if (!exceptRunButton) {
			jRunBochsButton.setEnabled(b);
		}
		jStepBochsButton.setEnabled(b);
		jStepOverDropDownButton.setEnabled(b);
		jFastStepBochsButton.setEnabled(b);
		jUpdateBochsButton.setEnabled(b);
		jButton13.setEnabled(b);
		jSettingButton.setEnabled(b);
		jRegisterToggleButton.setEnabled(b);
		jSourceLevelDebuggerButton.setEnabled(b);
		jProfilerToggleButton.setEnabled(b);

		jPageDirectoryTable.setEnabled(b);
		jPageTableTable.setEnabled(b);

		pauseBochsMenuItem.setEnabled(b);
		runBochsMenuItem.setEnabled(b);
		jUpdateBochsStatusMenuItem.setEnabled(b);
		jRunBochsAndSkipBreakpointMenuItem.setEnabled(b);
		jRunCustomCommandMenuItem.setEnabled(b);
	}

	public void updatePageTable(long pageDirectoryBaseAddress) {
		Vector<IA32PageDirectory> ia32_pageDirectories = new Vector<IA32PageDirectory>();
		try {
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			jStatusLabel.setText("Updating page table");
			// commandReceiver.setCommandNoOfLine(512);
			sendCommand("xp /4096bx " + pageDirectoryBaseAddress);
			float totalByte2 = 4096 - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			long realStartAddress = pageDirectoryBaseAddress;
			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);
			String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			if (result != null) {
				String[] lines = result.split("\n");
				DefaultTableModel model = (DefaultTableModel) jPageDirectoryTable.getModel();
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				jStatusProgressBar.setMaximum(lines.length - 1);

				for (int y = 0; y < lines.length; y++) {
					jStatusProgressBar.setValue(y);
					String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

					for (int z = 0; z < 2; z++) {
						try {
							int bytes[] = new int[4];
							for (int x = 0; x < 4; x++) {
								bytes[x] = CommonLib.string2decimal(b[x + z * 4].substring(2).trim()).intValue();
							}
							long value = CommonLib.getInt(bytes, 0);
							// "No.", "PT base", "AVL", "G",
							// "D", "A", "PCD", "PWT",
							// "U/S", "W/R", "P"

							long baseL = value & 0xfffff000;
							// if (baseL != 0) {
							String base = "0x" + Long.toHexString(baseL);
							String avl = String.valueOf((value >> 9) & 3);
							String g = String.valueOf((value >> 8) & 1);
							String d = String.valueOf((value >> 6) & 1);
							String a = String.valueOf((value >> 5) & 1);
							String pcd = String.valueOf((value >> 4) & 1);
							String pwt = String.valueOf((value >> 3) & 1);
							String us = String.valueOf((value >> 2) & 1);
							String wr = String.valueOf((value >> 1) & 1);
							String p = String.valueOf((value >> 0) & 1);

							ia32_pageDirectories.add(new IA32PageDirectory(base, avl, g, d, a, pcd, pwt, us, wr, p));

							model.addRow(new String[] { String.valueOf(y * 2 + z), base, avl, g, d, a, pcd, pwt, us, wr, p });
							// }
						} catch (Exception ex) {
						}
					}
					jStatusLabel.setText("Updating page table " + (y + 1) + "/" + lines.length);
				}
				jPageDirectoryTable.setModel(model);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/*
		 * if (false && Global.debug &&
		 * jAutoRefreshPageTableGraphCheckBox.isSelected()) {
		 * System.out.println("aa"); GraphModel model = new DefaultGraphModel();
		 * GraphLayoutCache view = new GraphLayoutCache(model, new
		 * DefaultCellViewFactory() { public CellView createView(GraphModel
		 * model, Object cell) { CellView view = null; if (model.isPort(cell)) {
		 * view = new PortView(cell); } else if (model.isEdge(cell)) { view =
		 * new EdgeView(cell); } else { if (cell instanceof IA32PageDirectory) {
		 * view = new PageDirectoryView(cell); } else if (cell instanceof
		 * IA32PageTable) { view = new JButtonView(cell, 1); } else { view = new
		 * VertexView(cell); } } return view; } }); JGraph graph = new
		 * JGraph(model, view);
		 * 
		 * // add cells
		 * 
		 * // DefaultGraphCell[] cells = new //
		 * DefaultGraphCell[ia32_pageDirectories.size() + 1];
		 * Vector<DefaultGraphCell> cells = new Vector<DefaultGraphCell>();
		 * DefaultGraphCell root = new DefaultGraphCell("cr3 " +
		 * jRegisterPanel1.jCR3TextField.getText());
		 * GraphConstants.setGradientColor(root.getAttributes(), Color.red);
		 * GraphConstants.setOpaque(root.getAttributes(), true);
		 * GraphConstants.setBounds(root.getAttributes(), new
		 * Rectangle2D.Double(0, 0, 140, 20)); root.add(new DefaultPort());
		 * cells.add(root);
		 * 
		 * Vector<IA32PageDirectory> pageDirectoryCells = new
		 * Vector<IA32PageDirectory>(); for (int x = 0; x <
		 * ia32_pageDirectories.size(); x++) { IA32PageDirectory cell =
		 * ia32_pageDirectories.get(x);
		 * GraphConstants.setGradientColor(cell.getAttributes(), Color.orange);
		 * GraphConstants.setOpaque(cell.getAttributes(), true);
		 * GraphConstants.setBounds(cell.getAttributes(), new
		 * Rectangle2D.Double(0, x * 20, 140, 20)); cell.add(new DefaultPort());
		 * pageDirectoryCells.add(cell);
		 * 
		 * // page table String pageTableAddress =
		 * ia32_pageDirectories.get(x).base; sendCommand("xp /4096bx " +
		 * pageTableAddress);
		 * 
		 * float totalByte2 = 4096 - 1; totalByte2 = totalByte2 / 8; int
		 * totalByte3 = (int) Math.floor(totalByte2); String realEndAddressStr;
		 * String realStartAddressStr; String baseAddress = pageTableAddress;
		 * long realStartAddress = CommonLib.string2decimal(baseAddress);
		 * 
		 * realStartAddressStr = String.format("%08x", realStartAddress); long
		 * realEndAddress = realStartAddress + totalByte3 * 8; realEndAddressStr
		 * = String.format("%08x", realEndAddress);
		 * 
		 * String result = commandReceiver.getCommandResult(realStartAddressStr,
		 * realEndAddressStr); String[] lines = result.split("\n");
		 * 
		 * Vector<DefaultGraphCell> pageTables = new Vector<DefaultGraphCell>();
		 * for (int y = 1; y < 4; y++) { String[] b =
		 * lines[y].replaceFirst("			cell.add(new DefaultPort());^.*:",
		 * "").trim().split("\t");
		 * 
		 * for (int z = 0; z < 2; z++) { try { int bytes[] = new int[4]; for
		 * (int x2 = 0; x2 < 4; x2++) { bytes[x2] =
		 * CommonLib.string2decimal(b[x2 + z *
		 * 4].substring(2).trim()).intValue(); } long value =
		 * CommonLib.getInt(bytes, 0);
		 * 
		 * String base = Long.toHexString(value & 0xfffff000); String avl =
		 * String.valueOf((value >> 9) & 3); String g = String.valueOf((value >>
		 * 8) & 1); String d = String.valueOf((value >> 6) & 1); String a =
		 * String.valueOf((value >> 5) & 1); String pcd = String.valueOf((value
		 * >> 4) & 1); String pwt = String.valueOf((value >> 3) & 1); String us
		 * = String.valueOf((value >> 2) & 1); String wr = String.valueOf((value
		 * >> 1) & 1); String p = String.valueOf((value >> 0) & 1);
		 * IA32PageTable pageTableCell = new IA32PageTable(base, avl, g, d, a,
		 * pcd, pwt, us, wr, p);
		 * GraphConstants.setGradientColor(pageTableCell.getAttributes(),
		 * Color.orange);
		 * GraphConstants.setOpaque(pageTableCell.getAttributes(), true);
		 * GraphConstants.setBounds(pageTableCell.getAttributes(), new
		 * Rectangle2D.Double(0, (z + y) * 20, 140, 20)); pageTableCell.add(new
		 * DefaultPort()); pageTables.add(pageTableCell); } catch (Exception ex)
		 * { } } }
		 * 
		 * // group it and link it DefaultGraphCell pt[] =
		 * pageTables.toArray(new DefaultGraphCell[] {}); DefaultGraphCell
		 * vertex1 = new DefaultGraphCell(new String("page table" + x), null,
		 * pt); vertex1.add(new DefaultPort()); cells.add(vertex1);
		 * 
		 * DefaultEdge edge = new DefaultEdge();
		 * edge.setSource(cell.getChildAt(0));
		 * edge.setTarget(vertex1.getLastChild());
		 * 
		 * GraphConstants.setLineStyle(edge.getAttributes(),
		 * GraphConstants.STYLE_ORTHOGONAL);
		 * GraphConstants.setRouting(edge.getAttributes(),
		 * GraphConstants.ROUTING_DEFAULT); int arrow =
		 * GraphConstants.ARROW_CLASSIC;
		 * GraphConstants.setLineEnd(edge.getAttributes(), arrow);
		 * GraphConstants.setEndFill(edge.getAttributes(), true);
		 * 
		 * cells.add(edge); }
		 * 
		 * if (pageDirectoryCells.toArray().length > 0) { IA32PageDirectory pt[]
		 * = pageDirectoryCells.toArray(new IA32PageDirectory[] {});
		 * DefaultGraphCell vertex1 = new DefaultGraphCell(new
		 * String("Vertex1"), null, pt); vertex1.add(new DefaultPort());
		 * cells.add(vertex1);
		 * 
		 * DefaultEdge edge = new DefaultEdge();
		 * edge.setSource(root.getChildAt(0));
		 * edge.setTarget(vertex1.getLastChild()); int arrow =
		 * GraphConstants.ARROW_CLASSIC;
		 * GraphConstants.setLineEnd(edge.getAttributes(), arrow);
		 * GraphConstants.setEndFill(edge.getAttributes(), true);
		 * 
		 * // lastObj = cells[index]; cells.add(edge); }
		 * 
		 * graph.getGraphLayoutCache().insert(cells.toArray());
		 * graph.setDisconnectable(false);
		 * 
		 * JGraphFacade facade = new JGraphFacade(graph); JGraphLayout layout =
		 * new JGraphTreeLayout(); ((JGraphTreeLayout)
		 * layout).setOrientation(SwingConstants.WEST); //
		 * ((JGraphHierarchicalLayout) layout).setNodeDistance(100);
		 * layout.run(facade); Map nested = facade.createNestedMap(true, true);
		 * graph.getGraphLayoutCache().edit(nested);
		 * 
		 * // JGraphFacade facade = new JGraphFacade(graph); // JGraphLayout
		 * layout = new JGraphFastOrganicLayout(); // layout.run(facade); // Map
		 * nested = facade.createNestedMap(true, true); //
		 * graph.getGraphLayoutCache().edit(nested);
		 * 
		 * jPageTableGraphPanel.removeAll(); jPageTableGraphPanel.add(new
		 * JScrollPane(graph), BorderLayout.CENTER); }
		 */

	}

	private void updateStack() {
		try {
			jStatusLabel.setText("Updating stack");
			// commandReceiver.setCommandNoOfLine(512);

			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			sendCommand("print-stack 40");
			String result = commandReceiver.getCommandResultUntilHaveLines(40);
			String[] lines = result.split("\n");
			jRegisterPanel1.jStackList.removeAll();
			jStatusProgressBar.setMaximum(lines.length - 1);
			DefaultListModel model = new DefaultListModel();
			for (int y = 1; y < lines.length; y++) {
				try {
					jStatusProgressBar.setValue(y);
					String[] b = lines[y].split("[\\[\\]]");
					model.addElement(b[1]);
					jStatusLabel.setText("Updating stack " + y + "/" + (lines.length - 1));
				} catch (Exception ex2) {
				}
			}
			jRegisterPanel1.jStackList.setModel(model);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateInstruction(Long address) {
		updateInstructionUsingBochs(address);

		if (!jRegisterPanel1.jEIPTextField.getText().equals("")) {
			((JSourceCodeTableModel) jELFTable.getModel()).updateBreakpoint(getRealEIP());
			((JInstructionTableModel) jInstructionTable.getModel()).updateBreakpoint(getRealEIP());
		}
	}

	@SuppressWarnings("unused")
	private void updateInstructionUsingNasm(Long address) {
		try {
			if (address == null) {
				address = new Long(0);
			}
			jStatusLabel.setText("Updating instruction");
			String result = Disassemble.disassemble(address, 32);
			String lines[] = result.split("\n");
			if (lines.length > 0) {
				DefaultTableModel model = (DefaultTableModel) jInstructionTable.getModel();
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				jStatusProgressBar.setMaximum(lines.length - 1);
				for (int x = 0; x < lines.length; x++) {
					jStatusProgressBar.setValue(x);
					try {
						model.addRow(new String[] { lines[x].substring(0, 10).trim(), lines[x].substring(20).trim(), lines[x].substring(10, 20).trim() });
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateInstructionUsingBochs(Long address) {
		try {
			final int maximumLine = 40;
			String command;
			jStatusLabel.setText("Updating instruction");
			if (address == null) {
				Long cs = CommonLib.string2decimal(this.jRegisterPanel1.jCSTextField.getText());
				Long eip = CommonLib.string2decimal(this.jRegisterPanel1.jEIPTextField.getText());

				for (int x = 1; x < 200; x++) {
					DwarfLine l = MapStructure.findDwarfLineByAddress(eip - x);
					if (l != null) {
						eip = eip - x;
						break;
					}
				}

				command = "disasm cs:" + eip + " 0x" + Long.toHexString(cs) + ":0x" + Long.toHexString(eip + 200);
			} else {
				command = "disasm " + address + " " + (address + 200);
			}
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			sendCommand(command);
			//			 Thread.sleep(200);
			// commandReceiver.waitUntilHaveLine(40);
			commandReceiver.waitUntilHaveLine(30);
			// commandReceiver.setCommandNoOfLine(15);
			String result = commandReceiver.getCommandResultUntilEnd();
			String lines[] = result.split("\n");
			if (lines.length > 0) {
				JInstructionTableModel model = (JInstructionTableModel) jInstructionTable.getModel();
				model.clearData();
				int eIPRow = 0;
				int rowNo = 0;
				jStatusProgressBar.setMaximum(lines.length - 1);
				for (int x = 0; x < lines.length && x < maximumLine; x++) {
					jStatusProgressBar.setValue(x);
					try {
						lines[x] = lines[x].replaceFirst("\\<.*\\>", "");
						String strs[] = lines[x].split(":");
						int secondColon = lines[x].indexOf(":", lines[x].indexOf(":") + 1);

						// load cCode
						String pcStr = strs[0].trim();
						long pc = Long.parseLong(pcStr, 16);
						String s[] = getCCode(pc);
						String lineNo[] = getCCodeLineNo(pc);
						if (s != null && lineNo != null) {
							for (int index = 0; index < s.length; index++) {
								model.addRow(new String[] { "", "cCode:" + lineNo[index], s[index], "" });
								rowNo++;
							}
						}
						// end load cCode

						// model.addRow(new String[] { "", strs[0].trim() + " "
						// + strs[1].trim().replaceAll("\\( *\\)", ""),
						// lines[x].substring(secondColon +
						// 1).trim().split(";")[0].trim(),
						// lines[x].split(";")[1] });
						Symbol symbol = MapStructure.findSymbolByMemoryOffset(pc);
						if (symbol != null) {
							pcStr += ":" + symbol.archiveMember;
						}

						if (pc == getRealEIP()) {
							eIPRow = rowNo;
						}
						model.addRow(new String[] { "", pcStr, lines[x].substring(secondColon + 1).trim().split(";")[0].trim(), lines[x].split(";")[1] });
						rowNo++;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				model.fireTableDataChanged();
				jInstructionTable.scrollRectToVisible(jInstructionTable.getCellRect(eIPRow + 10, 1, true));
				sourceLevelDebugger.jAssemblyTable.scrollRectToVisible(jInstructionTable.getCellRect(eIPRow + 10, 1, true));
				jInstructionTable.scrollRectToVisible(jInstructionTable.getCellRect(eIPRow, 1, true));
				sourceLevelDebugger.jAssemblyTable.scrollRectToVisible(jInstructionTable.getCellRect(eIPRow, 1, true));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String[] getCCode(long pc) {
		try {
			DwarfLine line = MapStructure.findDwarfLineByAddress(pc);
			if (line != null) {
				DwarfLine lastLine = MapStructure.findLastDwarfLineByAddress(pc);
				int startLineNo = (lastLine == null) ? 0 : lastLine.lineNo;
				List<String> sourceLines = CacheStructure.fileCaches.get(line.file);
				if (sourceLines == null) {
					sourceLines = FileUtils.readLines(line.file);
					CacheStructure.fileCaches.put(line.file, sourceLines);
				}
				if (line.lineNo - startLineNo > 0) {
					String s[] = new String[line.lineNo - startLineNo];
					for (int z = startLineNo, index = 0; z < line.lineNo; z++, index++) {
						String cCode = sourceLines.get(z);
						s[index] = cCode;
					}
					return s;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private String[] getCCodeLineNo(long pc) {
		try {
			DwarfLine line = MapStructure.findDwarfLineByAddress(pc);
			if (line != null) {
				DwarfLine lastLine = MapStructure.findLastDwarfLineByAddress(pc);
				int startLineNo = (lastLine == null) ? 0 : lastLine.lineNo;
				List<String> sourceLines = CacheStructure.fileCaches.get(line.file);
				if (sourceLines == null) {
					sourceLines = FileUtils.readLines(line.file);
					CacheStructure.fileCaches.put(line.file, sourceLines);
				}
				if (line.lineNo - startLineNo > 0) {
					String s[] = new String[line.lineNo - startLineNo];
					for (int z = startLineNo, index = 0; z < line.lineNo; z++, index++) {
						s[index] = line.file.getName() + ":" + z;
					}
					return s;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private String getCCodeStr(long pc) {
		String s[] = getCCode(pc);
		if (s == null) {
			return "";
		} else {
			String r = "";
			for (String c : s) {
				r += c + "\n";
			}
			return r;
		}
	}

	private void updateGDT() {
		try {
			jStatusLabel.setText("Updating GDT");
			// commandReceiver.setCommandNoOfLine(20);

			int limit = Integer.parseInt(this.jRegisterPanel1.jGDTRLimitTextField.getText().substring(2), 16);
			limit = (limit + 1) / 8 - 1;
			if (limit > 100) {
				limit = 100;
			}
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			sendCommand("info gdt 0 " + limit);
			String limitStr = String.format("0x%02x", limit);

			String result = commandReceiver.getCommandResult("GDT[0x00]", "GDT[" + limitStr + "]");
			if (result != null) {
				String lines[] = result.split("\n");
				JGDTTableModel model = (JGDTTableModel) jGDTTable.getModel();
				model.clear();
				// jStatusProgressBar.setMaximum(lines.length - 1);
				for (int x = 1; x < lines.length; x++) {
					jStatusLabel.setText("Updating GDT " + x);
					// System.out.println(">++>>" + lines[x]);
					jStatusProgressBar.setValue(x);
					try {
						Vector<String> v = new Vector<String>();
						v.add(lines[x].replaceFirst("^.*\\[", "").replaceFirst("].*$", ""));
						v.add(lines[x].replaceFirst("^.*]=", ""));
						model.addValue(v);
					} catch (Exception ex) {
					}
				}

				((JGDTTableModel) jGDTTable.getModel()).fireTableDataChanged();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateIDT() {
		try {
			jStatusLabel.setText("Updating IDT");

			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			int limit = Integer.parseInt(this.jRegisterPanel1.jIDTRLimitTextField.getText().substring(2), 16);
			limit = (limit + 1) / 8 - 1;
			if (limit > 200) {
				limit = 200;
			}
			sendCommand("info idt 0 " + limit);

			String limitStr = String.format("0x%02x", limit);

			String result = commandReceiver.getCommandResult("IDT[0x00]", "IDT[" + limitStr + "]");
			String lines[] = result.split("\n");
			JIDTTableModel model = (JIDTTableModel) jIDTTable.getModel();
			model.clear();
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int x = 0; x < lines.length; x++) {
				jStatusLabel.setText("Updating IDT " + x);
				jStatusProgressBar.setValue(x);
				try {
					Vector<String> v = new Vector<String>();
					v.add(lines[x].replaceFirst("^.*\\[", "").replaceFirst("].*$", ""));
					v.add(lines[x].replaceFirst("^.*]=", ""));
					model.addValue(v);
				} catch (Exception ex) {
				}
			}
			((JIDTTableModel) jIDTTable.getModel()).fireTableDataChanged();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateLDT() {
		try {
			jStatusLabel.setText("Updating LDT");
			// commandReceiver.setCommandNoOfLine(20);

			int limit = (int) CommonLib.convertFilesize(this.jRegisterPanel1.jLDTRTextField.getText()) & 0xffff;
			limit = (limit + 1) / 8 - 1;
			if (limit > 200) {
				limit = 200;
			}
			sendCommand("info ldt 0 " + limit);
			String limitStr = String.format("0x%02x", limit);
			String result = commandReceiver.getCommandResult("LDT[0x00]", "LDT[" + limitStr + "]");
			String lines[] = result.split("\n");
			JLDTTableModel model = (JLDTTableModel) jLDTTable.getModel();
			model.clear();
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int x = 1; x < lines.length; x++) {
				jStatusProgressBar.setValue(x);
				try {
					Vector<String> v = new Vector<String>();
					v.add(lines[x].replaceFirst("^.*\\[", "").replaceFirst("].*$", ""));
					v.add(lines[x].replaceFirst("^.*]=", ""));
					model.addValue(v);
				} catch (Exception ex) {
				}
			}
			model.fireTableDataChanged();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void changeText(JTextField jTextField, String value) {
		Long l = CommonLib.convertFilesize(value);
		String newValue = "0x" + Long.toHexString(l);
		if (jTextField.getText().equals(newValue)) {
			jTextField.setForeground(Color.black);
		} else {
			jTextField.setForeground(Color.red);
		}
		jTextField.setText(newValue);
	}

	private void changeTextStr(JTextField jTextField, String value) {
		if (jTextField.getText().equals(value)) {
			jTextField.setForeground(Color.black);
		} else {
			jTextField.setForeground(Color.red);
		}
		jTextField.setText(value);
	}

	private void updateRegister() {
		try {
			jStatusLabel.setText("Updating general registers");
			commandReceiver.shouldShow = false;
			sendCommand("r");
			String result = commandReceiver.getCommandResult("ax:", "eflags");
			String lines[] = result.split("\n");
			jStatusProgressBar.setMaximum(lines.length - 1);
			int x = 0;
			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				if (line.matches(".*.ax:.*")) {
					changeText(this.jRegisterPanel1.jEAXTextField, line.replaceAll(":", "").replaceAll("^.*ax", "").split(" ")[1]);
				}
				if (line.matches(".*.bx:.*")) {
					changeText(this.jRegisterPanel1.jEBXTextField, line.replaceAll(":", "").replaceAll("^.*bx", "").split(" ")[1]);
				}
				if (line.matches(".*.cx:.*")) {
					changeText(this.jRegisterPanel1.jECXTextField, line.replaceAll(":", "").replaceAll("^.*cx", "").split(" ")[1]);
				}
				if (line.matches(".*.dx:.*")) {
					changeText(this.jRegisterPanel1.jEDXTextField, line.replaceAll(":", "").replaceAll("^.*dx", "").split(" ")[1]);
				}
				if (line.matches(".*.si:.*")) {
					changeText(this.jRegisterPanel1.jESITextField, line.replaceAll(":", "").replaceAll("^.*si", "").split(" ")[1]);
				}
				if (line.matches(".*.di:.*")) {
					changeText(this.jRegisterPanel1.jEDITextField, line.replaceAll(":", "").replaceAll("^.*di", "").split(" ")[1]);
				}
				if (line.matches(".*.bp:.*")) {
					changeText(this.jRegisterPanel1.jEBPTextField, line.replaceAll(":", "").replaceAll("^.*bp", "").split(" ")[1]);
				}
				if (line.matches(".*.sp:.*")) {
					changeText(this.jRegisterPanel1.jESPTextField, line.replaceAll(":", "").replaceAll("^.*sp", "").split(" ")[1]);
				}
				if (line.matches(".*.ip:.*")) {
					changeText(this.jRegisterPanel1.jEIPTextField, line.replaceAll(":", "").replaceAll("^.*ip", "").split(" ")[1]);
				}
				if (line.matches(".*eflags .*")) {
					changeText(this.jRegisterPanel1.jEFLAGSTextField, line.replaceAll(":", "").replaceAll("^.*eflags", "").split(" ")[1]);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (version.contains("2.4.1")) {
			try {
				// sregs
				jStatusLabel.setText("Updating segment registers");
				// System.out.println("want sreg");
				commandReceiver.clearBuffer();
				sendCommand("sreg");
				String result = commandReceiver.getCommandResult("s:", "idtr:");
				// System.out.println(result);
				String[] lines = result.split("\n");

				int x = 0;
				jStatusProgressBar.setMaximum(lines.length - 1);

				for (String line : lines) {
					line = line.replaceFirst("<.*>", "");
					jStatusProgressBar.setValue(x++);
					String str[] = line.split(" ");

					if (line.matches(".*cs:.*")) {
						changeText(this.jRegisterPanel1.jCSTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*ds:.*")) {
						changeText(this.jRegisterPanel1.jDSTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*es:.*")) {
						changeText(this.jRegisterPanel1.jESTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*fs:.*")) {
						changeText(this.jRegisterPanel1.jFSTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*gs:.*")) {
						changeText(this.jRegisterPanel1.jGSTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*ss:.*")) {
						changeText(this.jRegisterPanel1.jSSTextField, line.split("=")[1].split(",")[0]);
					} else

					if (line.matches(".*gdtr:.*")) {
						changeText(this.jRegisterPanel1.jGDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jGDTRLimitTextField, str[1].split("=")[1]);
					} else if (line.matches(".*ldtr.*")) {
						changeText(this.jRegisterPanel1.jLDTRTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*idtr:.*")) {
						changeText(this.jRegisterPanel1.jIDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jIDTRLimitTextField, str[1].split("=")[1]);
					} else if (line.matches(".*tr:.*")) {
						changeText(this.jRegisterPanel1.jTRTextField, line.split("=")[1].split(",")[0]);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			try {
				// sregs
				jStatusLabel.setText("Updating segment registers");
				// System.out.println("want sreg");
				commandReceiver.clearBuffer();
				sendCommand("sreg");
				String result = commandReceiver.getCommandResult("s:", "idtr:");
				// System.out.println(result);
				String[] lines = result.split("\n");

				int x = 0;
				jStatusProgressBar.setMaximum(lines.length - 1);

				for (String line : lines) {
					line = line.replaceFirst("<.*>", "");
					jStatusProgressBar.setValue(x++);
					String str[] = line.split(" ");

					if (line.matches(".*cs:.*")) {
						changeText(this.jRegisterPanel1.jCSTextField, line.split(":")[1].split(",")[0]);
					} else if (line.matches(".*ds:.*")) {
						changeText(this.jRegisterPanel1.jDSTextField, line.split(":")[1].split(",")[0]);
					} else if (line.matches(".*es:.*")) {
						changeText(this.jRegisterPanel1.jESTextField, line.split(":")[1].split(",")[0]);
					} else if (line.matches(".*fs:.*")) {
						changeText(this.jRegisterPanel1.jFSTextField, line.split(":")[1].split(",")[0]);
					} else if (line.matches(".*gs:.*")) {
						changeText(this.jRegisterPanel1.jGSTextField, line.split(":")[1].split(",")[0]);
					} else if (line.matches(".*ss:.*")) {
						changeText(this.jRegisterPanel1.jSSTextField, line.split(":")[1].split(",")[0]);
					}

					if (line.matches(".*gdtr:.*")) {
						changeText(this.jRegisterPanel1.jGDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jGDTRLimitTextField, str[1].split("=")[1]);
					} else if (line.matches(".*ldtr.*")) {
						changeText(this.jRegisterPanel1.jLDTRTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*idtr:.*")) {
						changeText(this.jRegisterPanel1.jIDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jIDTRLimitTextField, str[1].split("=")[1]);
					} else if (line.matches(".*tr:.*")) {
						changeText(this.jRegisterPanel1.jTRTextField, line.split(":")[1].split(",")[0]);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		try {
			// cregs
			jStatusLabel.setText("Updating control registers");
			// commandReceiver.setCommandNoOfLine(Integer.parseInt(bochsCommandLength.get(0).get("cregs").toString()));
			commandReceiver.clearBuffer();
			sendCommand("creg");
			String result = commandReceiver.getCommandResult("CR0", "CR4");
			String[] lines = result.split("\n");

			int x = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				if (line.matches(".*CR0=.*")) {
					line = line.replaceFirst("^.*CR0", "CR0");
					changeText(this.jRegisterPanel1.jCR0TextField, line.split(" ")[0].split("=")[1].replace(":", ""));

					if (CommonLib.getBit(CommonLib.convertFilesize(jRegisterPanel1.jCR0TextField.getText()), 0) == 1) {
						jCPUModeLabel.setText(MyLanguage.getString("Protected_mode") + "     ");
					} else {
						jCPUModeLabel.setText(MyLanguage.getString("Real_mode") + "     ");
					}
					String arr[] = line.split(":")[1].split(" ");

					jRegisterPanel1.jCR0DetailLabel.setText("");
					jRegisterPanel1.jCR0DetailLabel2.setText(" ");
					for (int z = 0; z < 7; z++) {
						jRegisterPanel1.jCR0DetailLabel.setText(jRegisterPanel1.jCR0DetailLabel.getText() + arr[z] + " ");
					}
					for (int z = 7; z < arr.length; z++) {
						jRegisterPanel1.jCR0DetailLabel2.setText(jRegisterPanel1.jCR0DetailLabel2.getText() + arr[z] + " ");
					}
				} else if (line.matches(".*CR2=.*")) {
					changeText(this.jRegisterPanel1.jCR2TextField, line.split(" ")[2].split("=")[1]);
				} else if (line.matches(".*CR3=.*")) {
					changeText(this.jRegisterPanel1.jCR3TextField, line.split(" ")[0].split("=")[1]);
				} else if (line.matches(".*CR4=.*")) {
					changeText(this.jRegisterPanel1.jCR4TextField, line.split(" ")[0].split("=")[1].replace(":", ""));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			if (version.contains("2.4.1")) {
			} else {
				// dregs
				jStatusLabel.setText("Updating debug registers");
				// commandReceiver.setCommandNoOfLine(Integer.parseInt(bochsCommandLength.get(0).get("cregs").toString()));
				sendCommand("dreg");
				String result = commandReceiver.getCommandResult("DR0", "DR7");
				String[] lines = result.split("\n");

				int x = 0;
				jStatusProgressBar.setMaximum(lines.length - 1);

				for (String line : lines) {
					jStatusProgressBar.setValue(x++);
					if (line.matches(".*DR0=0x.*")) {
						changeText(this.jRegisterPanel1.jDR0TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR1=0x.*")) {
						changeText(this.jRegisterPanel1.jDR1TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR2=0x.*")) {
						changeText(this.jRegisterPanel1.jDR2TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR3=0x.*")) {
						changeText(this.jRegisterPanel1.jDR3TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR6=0x.*")) {
						changeText(this.jRegisterPanel1.jDR6TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR7=0x.*")) {
						changeText(this.jRegisterPanel1.jDR7TextField, line.split("=")[1].split(":")[0]);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			// fpu
			jStatusLabel.setText("Updating FPU registers");
			commandReceiver.clearBuffer();
			sendCommand("fpu");
			String result = commandReceiver.getCommandResult("status", "FP7");
			String[] lines = result.split("\n");

			int x = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				String ss[] = line.split(":");
				if (line.matches(".*ST0.*")) {
					changeTextStr(this.jRegisterPanel1.jST0TextField, line.split(" ")[10]);
				} else if (line.matches(".*ST1.*")) {
					changeTextStr(this.jRegisterPanel1.jST1TextField, line.split(" ")[12]);
				} else if (line.matches(".*ST2.*")) {
					changeTextStr(this.jRegisterPanel1.jST2TextField, line.split(" ")[12]);
				} else if (line.matches(".*ST3.*")) {
					changeTextStr(this.jRegisterPanel1.jST3TextField, line.split(" ")[12]);
				} else if (line.matches(".*ST4.*")) {
					changeTextStr(this.jRegisterPanel1.jST4TextField, line.split(" ")[12]);
				} else if (line.matches(".*ST5.*")) {
					changeTextStr(this.jRegisterPanel1.jST5TextField, line.split(" ")[12]);
				} else if (line.matches(".*ST6.*")) {
					changeTextStr(this.jRegisterPanel1.jST6TextField, line.split(" ")[12]);
				} else if (line.matches(".*ST7.*")) {
					changeTextStr(this.jRegisterPanel1.jST7TextField, line.split(" ")[12]);
				} else if (line.matches(".*status.*")) {
					changeTextStr(this.jRegisterPanel1.jFPUStatusTextField, line.substring(line.indexOf(":")));
				} else if (line.matches(".*control.*")) {
					changeTextStr(this.jRegisterPanel1.jFPUControlTextField, ss[ss.length - 2].trim() + " " + ss[ss.length - 1].trim());
				} else if (line.matches(".*tag.*")) {
					changeTextStr(this.jRegisterPanel1.jFPUTagTextField, ss[ss.length - 1].trim());
				} else if (line.matches(".*operand.*")) {
					changeTextStr(this.jRegisterPanel1.jFPUOperandTextField, ss[ss.length - 1].trim());
				} else if (line.matches("fip.*")) {
					changeTextStr(this.jRegisterPanel1.jFIPTextField, line.split(":")[1].trim());
				} else if (line.matches("fcs.*")) {
					changeTextStr(this.jRegisterPanel1.jFCSTextField, line.split(":")[1].trim());
				} else if (line.matches("fdp.*")) {
					changeTextStr(this.jRegisterPanel1.jFDPTextField, line.split(":")[1].trim());
				} else if (line.matches("fds.*")) {
					changeTextStr(this.jRegisterPanel1.jFDSTextField, line.split(":")[1].trim());
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			// mmx
			jStatusLabel.setText("Updating MMX registers");
			commandReceiver.clearBuffer();
			sendCommand("mmx");
			String result = commandReceiver.getCommandResult("MM[0]", "MM[7]");
			String[] lines = result.split("\n");

			int x = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				String ss[] = line.split(":");
				if (line.matches(".*MM\\[0\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX0TextField, ss[1].trim());
				} else if (line.matches(".*MM\\[1\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX1TextField, ss[1].trim());
				} else if (line.matches(".*MM\\[2\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX2TextField, ss[1].trim());
				} else if (line.matches(".*MM\\[3\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX3TextField, ss[1].trim());
				} else if (line.matches(".*MM\\[4\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX4TextField, ss[1].trim());
				} else if (line.matches(".*MM\\[5\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX5TextField, ss[1].trim());
				} else if (line.matches(".*MM\\[6\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX6TextField, ss[1].trim());
				} else if (line.matches(".*MM\\[7\\].*")) {
					changeTextStr(this.jRegisterPanel1.jMMX7TextField, ss[1].trim());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateMemory(boolean isPhysicalAddress) {
		try {
			if (this.jMemoryAddressComboBox.getSelectedItem() != null) {
				commandReceiver.shouldShow = false;
				currentMemoryWindowsAddress = CommonLib.convertFilesize(this.jMemoryAddressComboBox.getSelectedItem().toString());
				jStatusLabel.setText("Updating memory");
				int totalByte = 200;
				int bytes[] = getMemory(CommonLib.convertFilesize(this.jMemoryAddressComboBox.getSelectedItem().toString()), totalByte, isPhysicalAddress);
				jStatusLabel.setText("");
				jHexTable1.getModel().setCurrentAddress(CommonLib.convertFilesize(this.jMemoryAddressComboBox.getSelectedItem().toString()));
				jHexTable1.getModel().set(bytes);
				jHexTable1.getModel().fireTableDataChanged();
			}
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void exitMenuItemActionPerformed(ActionEvent evt) {
		thisWindowClosing(null);
		System.exit(0);
	}

	private void thisWindowClosing(WindowEvent evt) {
		if (p != null) {
			p.destroy();
		}

		Setting.getInstance().setWidth(this.getWidth());
		Setting.getInstance().setHeight(this.getHeight());
		Setting.getInstance().setX(this.getLocation().x);
		Setting.getInstance().setY(this.getLocation().y);
		Setting.getInstance().setDivX(jSplitPane1.getDividerLocation());
		Setting.getInstance().setDivY(jSplitPane2.getDividerLocation());
		Setting.getInstance().setOsDebugSplitPane_DividerLocation(this.jOSDebugInformationPanel1.getjMainSplitPane().getDividerLocation());
		Setting.getInstance().save();
	}

	private void jGDTTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			for (int x = 0; x < jTabbedPane2.getTabCount(); x++) {
				if (jTabbedPane2.getTitleAt(x).equals(("GDT " + String.format("0x%02x", jGDTTable.getSelectedRow() + 1)))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			jTabbedPane2.addTabWithCloseButton("GDT " + String.format("0x%02x", jGDTTable.getSelectedRow() + 1), null,
					new GDTLDTPanel(this, 0, CommonLib.string2decimal(this.jRegisterPanel1.jGDTRTextField.getText()), jGDTTable.getSelectedRow() + 1), null);
			jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
		}
	}

	private void jLDTTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			for (int x = 0; x < jTabbedPane2.getTabCount(); x++) {
				if (jTabbedPane2.getTitleAt(x).equals(("LDT " + jLDTTable.getSelectedRow() + 1))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			JScrollPane temp = new JScrollPane();
			temp.setViewportView(new GDTLDTPanel(this, 1, CommonLib.string2decimal(this.jRegisterPanel1.jLDTRTextField.getText()), jLDTTable.getSelectedRow() + 1));
			jTabbedPane2.addTabWithCloseButton("LDT " + jLDTTable.getSelectedRow(), null, temp, null);
			jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
		}
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!file.getName().toLowerCase().endsWith(".png")) {
				file = new File(file.getAbsolutePath() + ".png");
			}
			if (!PeterBochsCommonLib.saveImage(jHexTable1, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jUpdateBochsButtonActionPerformed(ActionEvent evt) {
		updateBochsStatus(true);
	}

	private void jPageDirectoryTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			jStatusProgressBar.setValue(0);
			String pageTableAddress = jPageDirectoryTable.getValueAt(jPageDirectoryTable.getSelectedRow(), 1).toString();
			if (!CommonLib.isNumber(pageTableAddress)) {
				return;
			}

			// commandReceiver.setCommandNoOfLine(512);
			sendCommand("xp /4096bx " + pageTableAddress);

			float totalByte2 = 4096 - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			String baseAddress = pageTableAddress;
			long realStartAddress = CommonLib.string2decimal(baseAddress);

			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);

			String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			String[] lines = result.split("\n");
			PageTableTableModel model = (PageTableTableModel) jPageTableTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int y = 0; y < lines.length; y++) {
				jStatusProgressBar.setValue(y);
				String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

				for (int z = 0; z < 2; z++) {
					try {
						int bytes[] = new int[4];
						for (int x = 0; x < 4; x++) {
							bytes[x] = CommonLib.string2decimal(b[x + z * 4].substring(2).trim()).intValue();
						}
						long value = CommonLib.getInt(bytes, 0);
						// "No.", "PT base", "AVL", "G",
						// "D", "A", "PCD", "PWT",
						// "U/S", "W/R", "P"

						String base = "0x" + Long.toHexString(CommonLib.getValue(value, 12, 31) << 12);
						String avl = String.valueOf((value >> 9) & 3);
						String g = String.valueOf((value >> 8) & 1);
						String pat = String.valueOf((value >> 7) & 1);
						String d = String.valueOf((value >> 6) & 1);
						String a = String.valueOf((value >> 5) & 1);
						String pcd = String.valueOf((value >> 4) & 1);
						String pwt = String.valueOf((value >> 3) & 1);
						String us = String.valueOf((value >> 2) & 1);
						String wr = String.valueOf((value >> 1) & 1);
						String p = String.valueOf((value >> 0) & 1);
						boolean tempB = model.isShowZeroAddress();
						model.setShowZeroAddress(true);
						model.addRow(new String[] { String.valueOf(y * 2 + z), base, avl, g, pat, d, a, pcd, pwt, us, wr, p });
						model.setShowZeroAddress(tempB);
					} catch (Exception ex) {
					}
				}

				jPageTableTable.setModel(model);
			}
		}
	}

	private void jPageTableTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			String pageAddress = jPageTableTable.getValueAt(jPageTableTable.getSelectedRow(), 1).toString();
			this.jMemoryAddressComboBox.setSelectedItem(pageAddress);
			this.jGOMemoryButtonActionPerformed(null);
		}
	}

	private void jRefreshBreakpointButtonActionPerformed(ActionEvent evt) {
		jRefreshBreakpointButton.setEnabled(false);
		updateBreakpoint();
		jRefreshBreakpointButton.setEnabled(true);
	}

	private void updateBreakpoint() {
		try {
			jStatusLabel.setText("Updating breakpoint");
			// commandReceiver.setCommandNoOfLine(-1);
			commandReceiver.clearBuffer();
			sendCommand("info break");
			Thread.currentThread();
			Thread.sleep(100);
			String result = commandReceiver.getCommandResultUntilEnd();
			String[] lines = result.split("\n");
			DefaultTableModel model = (DefaultTableModel) jBreakpointTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}

			for (int x = 1; x < lines.length; x++) {
				if (lines[x].contains("breakpoint")) {
					Vector<String> strs = new Vector<String>(Arrays.asList(lines[x].trim().split(" \\s")));
					strs.add("0"); // hit count
					if (strs.size() > 1) {
						strs.remove(1);
						model.addRow(strs);
					}
				}
			}

			this.jRefreshELFBreakpointButtonActionPerformed(null);
			jStatusLabel.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jDisassembleCurrentIPButtonActionPerformed(ActionEvent evt) {
		jDisassembleCurrentIPButton.setEnabled(false);
		this.updateInstruction(null);
		updateBreakpointTableColor();
		jDisassembleCurrentIPButton.setEnabled(true);
	}

	private void jAddBreakpointButtonActionPerformed(ActionEvent evt) {
		jAddBreakpointButton.setEnabled(false);
		String type = (String) JOptionPane.showInputDialog(this, null, "Add breakpoint", JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { MyLanguage.getString("Physical_address"), MyLanguage.getString("Linear_address"), MyLanguage.getString("Virtual_address") },
				MyLanguage.getString("Physical_address"));
		if (type != null) {
			String address = JOptionPane.showInputDialog(this, "Please input breakpoint address", "Add breakpoint", JOptionPane.QUESTION_MESSAGE);
			if (address != null) {
				if (type.equals(MyLanguage.getString("Physical_address"))) {
					sendCommand("pb " + address);
				} else if (type.equals(MyLanguage.getString("Linear_address"))) {
					sendCommand("lb " + address);
				} else {
					sendCommand("vb " + address);
				}
				updateBreakpoint();
				updateBreakpointTableColor();
			}
		}
		jAddBreakpointButton.setEnabled(true);
	}

	private void jSaveBreakpointButtonActionPerformed(ActionEvent evt) {
		jSaveBreakpointButton.setEnabled(false);
		LinkedList<Breakpoint> v = Setting.getInstance().getBreakpoint();
		v.clear();

		for (int x = 0; x < this.jBreakpointTable.getRowCount(); x++) {
			Breakpoint h = new Breakpoint();
			h.setNo(x);
			h.setType(this.jBreakpointTable.getValueAt(x, 0).toString());
			h.setEnable(this.jBreakpointTable.getValueAt(x, 1).toString());
			h.setAddress(this.jBreakpointTable.getValueAt(x, 2).toString());
			h.setHit(Integer.parseInt(this.jBreakpointTable.getValueAt(x, 3).toString()));
			v.add(h);
		}
		Setting.getInstance().save();
		jSaveBreakpointButton.setEnabled(true);
	}

	private void jLoadBreakpointButtonActionPerformed(ActionEvent evt) {
		if (jLoadBreakpointButton.getEventSource() == loadSystemsMapMenuItem) {
			JFileChooser fc = new JFileChooser(new File("."));
			int returnVal = fc.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				new SystemMapDialog(this, file).setVisible(true);
			}
		} else {
			jLoadBreakpointButton.setEnabled(false);
			LinkedList<Breakpoint> vector = Setting.getInstance().getBreakpoint();
			try {
				for (int x = 0; x < vector.size(); x++) {
					boolean match = false;
					for (int y = 0; y < this.jBreakpointTable.getRowCount(); y++) {
						if (vector.get(x).getAddress().trim().equals(jBreakpointTable.getValueAt(y, 2).toString().trim())) {
							match = true;
							break;
						}
					}
					if (!match) {
						if (vector.get(x).getType().contains("pbreakpoint")) {
							sendCommand("pb " + vector.get(x).getAddress());
						} else {
							sendCommand("lb " + vector.get(x).getAddress());
						}
						if (vector.get(x).getEnable().trim().equals("keep n")) {
							sendCommand("bpd " + (x + 1));
						}
					}
				}
			} catch (Exception e) {
				if (Global.debug) {
					e.printStackTrace();
				}
			}
			updateBreakpoint();
			updateBreakpointTableColor();
			jLoadBreakpointButton.setEnabled(true);
		}
	}

	private void jDeleteBreakpointButtonActionPerformed(ActionEvent evt) {
		jDeleteBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("del " + jBreakpointTable.getValueAt(rows[x], 0).toString().replaceAll("^-*", "").trim().split(" ")[0]);
		}
		updateBreakpoint();
		updateBreakpointTableColor();
		jDeleteBreakpointButton.setEnabled(true);
	}

	private void jDisableBreakpointButtonActionPerformed(ActionEvent evt) {
		jDisableBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpd " + jBreakpointTable.getValueAt(rows[x], 0).toString().replaceAll("^-*", "").trim().split(" ")[0]);
		}
		updateBreakpoint();
		updateBreakpointTableColor();
		jDisableBreakpointButton.setEnabled(true);
		this.updateInstruction(null);
	}

	private void jEnableBreakpointButtonActionPerformed(ActionEvent evt) {
		jEnableBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpe " + jBreakpointTable.getValueAt(rows[x], 0).toString().replaceAll("^-*", "").trim().split(" ")[0]);
		}
		updateBreakpoint();
		updateBreakpointTableColor();
		jEnableBreakpointButton.setEnabled(true);
		this.updateInstruction(null);
	}

	private void jBochsCommandTextFieldKeyPressed(KeyEvent evt) {
		if (jBochsCommandTextField.getText().equals("")) {
			commandHistoryIndex = 0;
		}
		HashSet<String> vector = Setting.getInstance().getBochsCommandHistory();
		if (evt.getKeyCode() == 38) {
			if (commandHistoryIndex < vector.size()) {
				commandHistoryIndex++;
				this.jBochsCommandTextField.setText(vector.toArray()[vector.size() - commandHistoryIndex].toString());
			}
		} else if (evt.getKeyCode() == 40) {
			if (commandHistoryIndex > 1) {
				commandHistoryIndex--;
				this.jBochsCommandTextField.setText(vector.toArray()[vector.size() - commandHistoryIndex].toString());
			}
		}
	}

	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private void jBinaryRadioButtonStateChanged(ChangeEvent evt) {

	}

	private void jOctRadioButton1StateChanged(ChangeEvent evt) {

	}

	private void jDecRadioButtonStateChanged(ChangeEvent evt) {

	}

	private void jHexRadioButtonStateChanged(ChangeEvent evt) {

	}

	private void jBinaryRadioButtonItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(2);
		jHexTable1.getModel().fireTableDataChanged();
	}

	private void jOctRadioButton1ItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(8);
		jHexTable1.getModel().fireTableDataChanged();
	}

	private void jDecRadioButtonItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(10);
		jHexTable1.getModel().fireTableDataChanged();
	}

	private void jHexRadioButtonItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(16);
		jHexTable1.getModel().fireTableDataChanged();
	}

	private JScrollPane getJTableTranslateScrollPane() {
		if (jTableTranslateScrollPane == null) {
			jTableTranslateScrollPane = new JScrollPane();
			jTableTranslateScrollPane.setViewportView(getJPanel30());
		}
		return jTableTranslateScrollPane;
	}

	private JTable getJAddressTranslateTable() {
		if (jAddressTranslateTable == null) {
			TableModel jAddressTranslateTableModel = new DefaultTableModel(new String[][] {}, new String[] { MyLanguage.getString("From"), MyLanguage.getString("To") });
			jAddressTranslateTable = new JTable();
			jAddressTranslateTable.setModel(jAddressTranslateTableModel);
		}
		return jAddressTranslateTable;
	}

	private JMenu getJFontMenu() {
		if (jFontMenu == null) {
			jFontMenu = new JMenu();
			jFontMenu.setText(MyLanguage.getString("Font"));
			jFontMenu.add(getJMenu1());
			jFontMenu.add(getJMenu2());
		}
		return jFontMenu;
	}

	private JMenuItem getJFont8MenuItem() {
		if (jFont8MenuItem == null) {
			jFont8MenuItem = new JMenuItem();
			jFont8MenuItem.setText("8");
			jFont8MenuItem.setBounds(0, -110, 80, 22);
			jFont8MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont8MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont8MenuItem;
	}

	private JMenuItem getJFont10MenuItem() {
		if (jFont10MenuItem == null) {
			jFont10MenuItem = new JMenuItem();
			jFont10MenuItem.setText("10");
			jFont10MenuItem.setBounds(0, -88, 80, 22);
			jFont10MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont10MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont10MenuItem;
	}

	private JMenuItem getJFont12MenuItem() {
		if (jFont12MenuItem == null) {
			jFont12MenuItem = new JMenuItem();
			jFont12MenuItem.setText("12");
			jFont12MenuItem.setBounds(0, -66, 80, 22);
			jFont12MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont12MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont12MenuItem;
	}

	private JMenuItem getJFont14MenuItem() {
		if (jFont14MenuItem == null) {
			jFont14MenuItem = new JMenuItem();
			jFont14MenuItem.setText("14");
			jFont14MenuItem.setBounds(0, -44, 80, 22);
			jFont14MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont14MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont14MenuItem;
	}

	private void jFont14MenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontsize(14);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
	}

	private void jFont12MenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontsize(12);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
	}

	private void jFont10MenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontsize(10);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
	}

	private void jFont8MenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontsize(8);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
	}

	public void initGlobalFontSetting(Font fnt) {
		FontUIResource fontRes = new FontUIResource(fnt);
		for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText(MyLanguage.getString("Size"));
			jMenu1.add(getJFont8MenuItem());
			jMenu1.add(getJFont10MenuItem());
			jMenu1.add(getJFont12MenuItem());
			jMenu1.add(getJFont14MenuItem());
		}
		return jMenu1;
	}

	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText(MyLanguage.getString("Font"));
			jMenu2.add(getJArialMenuItem());
			jMenu2.add(getJDialogMenuItem());
		}
		return jMenu2;
	}

	private JMenuItem getJArialMenuItem() {
		if (jArialMenuItem == null) {
			jArialMenuItem = new JMenuItem();
			jArialMenuItem.setText("Arial");
			jArialMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jArialMenuItemActionPerformed(evt);
				}
			});
		}
		return jArialMenuItem;
	}

	private JMenuItem getJDialogMenuItem() {
		if (jDialogMenuItem == null) {
			jDialogMenuItem = new JMenuItem();
			jDialogMenuItem.setText("Dialog");
			jDialogMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDialogMenuItemActionPerformed(evt);
				}
			});
		}
		return jDialogMenuItem;
	}

	private void jArialMenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontFamily("Arial");
	}

	private void jDialogMenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontFamily("Dialog");
	}

	private JMenu getJMenu6() {
		if (jMenu6 == null) {
			jMenu6 = new JMenu();
			jMenu6.setText(MyLanguage.getString("Language"));
			jMenu6.add(getJMenuItem1());
			jMenu6.add(getJMenuItem2());
			jMenu6.add(getJMenuItem3());
			jMenu6.add(getJKRMenuItem());
			jMenu6.add(getJJPMenuItem());
		}
		return jMenu6;
	}

	private JMenuItem getJMenuItem1() {
		if (jEnglishMenuItem == null) {
			jEnglishMenuItem = new JMenuItem();
			jEnglishMenuItem.setText(MyLanguage.getString("English"));
			jEnglishMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem1ActionPerformed(evt);
				}
			});
		}
		return jEnglishMenuItem;
	}

	private JMenuItem getJMenuItem2() {
		if (jHKMenuItem == null) {
			jHKMenuItem = new JMenuItem();
			jHKMenuItem.setText(MyLanguage.getString("Traditional_chinese"));
			jHKMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem2ActionPerformed(evt);
				}
			});
		}
		return jHKMenuItem;
	}

	private JMenuItem getJMenuItem3() {
		if (jSCMenuItem == null) {
			jSCMenuItem = new JMenuItem();
			jSCMenuItem.setText(MyLanguage.getString("Simplified_chinese"));
			jSCMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem3ActionPerformed(evt);
				}
			});
		}
		return jSCMenuItem;
	}

	private void jMenuItem2ActionPerformed(ActionEvent evt) {
		changeLanguage("zh_TW");
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {
		changeLanguage("en_US");
	}

	private void jMenuItem3ActionPerformed(ActionEvent evt) {
		changeLanguage("zh_CN");
	}

	private void changeLanguage(String language) {
		JOptionPane.showMessageDialog(this, "Please restart");

		Setting.getInstance().setCurrentLanguage(language);
		Setting.getInstance().save();
	}

	private JTable getJHistoryTable() {
		if (jHistoryTable == null) {
			jHistoryTable = new JTable();
			HistoryTableModel model = new HistoryTableModel();
			jHistoryTable.setModel(model);
			final MyTableRowSorter<TableModel> sorter = new MyTableRowSorter<TableModel>(model);
			jHistoryTable.setRowSorter(sorter);
			jHistoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			for (int x = 1; x <= 15; x++) {
				jHistoryTable.getColumnModel().getColumn(x).setPreferredWidth(120);
			}
			jHistoryTable.getColumnModel().getColumn(5).setPreferredWidth(800);
		}
		jHistoryTable.setDefaultRenderer(String.class, new HistoryTableCellRenderer());
		jHistoryTable.setIntercellSpacing(new Dimension(0, 0));
		jHistoryTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jHistoryTableMouseClicked(evt);
			}
		});
		return jHistoryTable;
	}

	private JRadioButton getJRadioButton1() {
		if (jRegRadioButton == null) {
			jRegRadioButton = new JRadioButton();
			jRegRadioButton.setText("reg");
			getButtonGroup2().add(jRegRadioButton);
			jRegRadioButton.setSelected(true);
			jRegRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRegRadioButtonActionPerformed(evt);
				}
			});
		}
		return jRegRadioButton;
	}

	private JToolBar getJPanel13() {
		if (jPanel13 == null) {
			jPanel13 = new JToolBar();
			FlowLayout jPanel13Layout = new FlowLayout();
			jPanel13Layout.setAlignment(FlowLayout.LEFT);
			{
				jLabel3 = new JLabel();
				jPanel13.add(jLabel3);
				jLabel3.setText(MyLanguage.getString("Pause_history"));
			}
			jPanel13.add(getJRadioButton1());
			jPanel13.add(getJRadioButton2());
			jPanel13.add(getJFPURadioButton());
			jPanel13.add(getJMMXRadioButton());
			jPanel13.add(getJButton1());
			jPanel13.add(getJExportHistoryToExcelButton());
			jPanel13.add(getJClearHistoryTableButton());
			jPanel13.add(getJLabel2());
			jPanel13.add(getJHistoryTableRepeatedLabel());
			jPanel13.add(getJFilterHistoryTableTextField());
			jPanel13.add(getJLabel9());
			jPanel13.add(getJLabel8());
			jPanel13.add(getJLabel7());
			jPanel13.add(getJShowAfterwardSpinner());
		}
		return jPanel13;
	}

	private JRadioButton getJRadioButton2() {
		if (jTblRadioButton == null) {
			jTblRadioButton = new JRadioButton();
			jTblRadioButton.setText("tbl. desc.");
			getButtonGroup2().add(jTblRadioButton);
			jTblRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jTblRadioButtonActionPerformed(evt);
				}
			});
		}
		return jTblRadioButton;
	}

	private ButtonGroup getButtonGroup2() {
		if (buttonGroup2 == null) {
			buttonGroup2 = new ButtonGroup();
		}
		return buttonGroup2;
	}

	private void jRegRadioButtonActionPerformed(ActionEvent evt) {
		HistoryTableModel model = (HistoryTableModel) this.jHistoryTable.getModel();
		model.setView("reg");
		for (int x = 1; x <= 15; x++) {
			jHistoryTable.getColumnModel().getColumn(x).setPreferredWidth(120);
		}
		jHistoryTable.getColumnModel().getColumn(5).setPreferredWidth(800);
	}

	private void jTblRadioButtonActionPerformed(ActionEvent evt) {
		HistoryTableModel model = (HistoryTableModel) this.jHistoryTable.getModel();
		model.setView("tbl");
		for (int x = 1; x < model.getColumnCount(); x++) {
			jHistoryTable.getColumnModel().getColumn(x).setPreferredWidth(120);
		}
		jHistoryTable.getColumnModel().getColumn(6).setPreferredWidth(300);
	}

	private JSplitPane getJSplitPane3() {
		if (jSplitPane3 == null) {
			jSplitPane3 = new JSplitPane();
			jSplitPane3.setDividerLocation(400);
			{
				jScrollPane7 = new JScrollPane();
				jSplitPane3.add(jScrollPane7, JSplitPane.RIGHT);
				{
					jPageTableTable = new JTable();
					jScrollPane7.setViewportView(jPageTableTable);
					jPageTableTable.setModel(new PageTableTableModel());
					jPageTableTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					jPageTableTable.getColumnModel().getColumn(0).setPreferredWidth(40);
					for (int x = 2; x <= 11; x++) {
						jPageTableTable.getColumnModel().getColumn(x).setPreferredWidth(40);
					}
					jPageTableTable.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jPageTableTableMouseClicked(evt);
						}
					});
				}
			}
			{
				jScrollPane8 = new JScrollPane();
				jSplitPane3.add(jScrollPane8, JSplitPane.LEFT);
				{
					// TableModel jPageDirectoryTableModel = new
					// DefaultTableModel(new String[][] {}, new String[] {
					// "No.", "PT base", "AVL", "G", "D", "A", "PCD", "PWT",
					// "U/S",
					// "W/R", "P" }) {
					// public boolean isCellEditable(int row, int column) {
					// return false;
					// }
					// };
					jPageDirectoryTable = new JTable();
					jScrollPane8.setViewportView(jPageDirectoryTable);
					jPageDirectoryTable.setModel(new PageDirectoryTableModel());
					jPageDirectoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					jPageDirectoryTable.getColumnModel().getColumn(0).setPreferredWidth(40);
					for (int x = 2; x < 11; x++) {
						jPageDirectoryTable.getColumnModel().getColumn(x).setPreferredWidth(40);
					}
					jPageDirectoryTable.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jPageDirectoryTableMouseClicked(evt);
						}
					});
				}
			}
		}
		return jSplitPane3;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
		}
		return jButton1;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});
		}
		return jButton2;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton3ActionPerformed(evt);
				}
			});
		}
		return jButton3;
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(jInstructionTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JButton getJExportHistoryToExcelButton() {
		if (jExportHistoryToExcelButton == null) {
			jExportHistoryToExcelButton = new JButton();
			jExportHistoryToExcelButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jExportHistoryToExcelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jExportHistoryToExcelButtonActionPerformed(evt);
				}
			});
		}
		return jExportHistoryToExcelButton;
	}

	private void jExportHistoryToExcelButtonActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!file.getName().endsWith(".xls")) {
				file = new File(file.getParent() + File.separator + file.getName() + ".xls");
			}
			if (file.exists()) {
				int r = JOptionPane.showConfirmDialog(this, "Overwrite " + file.getName() + "?", "Warning", JOptionPane.YES_NO_OPTION);
				if (r == 1) {
					return;
				}
			}
			final JProgressBarDialog d = new JProgressBarDialog(this, "Exporting to XLS", true);
			d.jProgressBar.setIndeterminate(true);
			d.jProgressBar.setStringPainted(true);

			class MyThread extends Thread {
				File file;

				public MyThread(File file) {
					this.file = file;
				}

				public void run() {
					PeterBochsCommonLib.exportRegisterHistory(file, d);
				}
			}
			d.thread = new MyThread(file);
			d.setVisible(true);
		}
	}

	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton5ActionPerformed(evt);
				}
			});
		}
		return jButton5;
	}

	private void jButton5ActionPerformed(ActionEvent evt) {
		SaveMemoryToXLSDialog d = new SaveMemoryToXLSDialog(this);
		long currentMemoryAddress = CommonLib.convertFilesize(jMemoryAddressComboBox.getSelectedItem().toString());
		d.jFromTextField.setText("0x" + Long.toHexString(currentMemoryAddress));
		d.jToTextField.setText("0x" + Long.toHexString(currentMemoryAddress + 64 * 1024));
		d.setVisible(true);
		if (d.ok) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				if (!file.getName().toLowerCase().endsWith(".xls")) {
					file = new File(file.getAbsolutePath() + ".xls");
				}
				PeterBochsCommonLib.exportTableModelToExcel(file, jHexTable1.getModel(), jMemoryAddressComboBox.getSelectedItem().toString());
			}
		}
	}

	private JPanel getJPanel14() {
		if (jPanel14 == null) {
			jPanel14 = new JPanel();
			jPanel14.add(getJButton6());
			jPanel14.add(getJButton7());
			jPanel14.add(getJGDTGraphButton());
		}
		return jPanel14;
	}

	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jButton6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton6ActionPerformed(evt);
				}
			});
		}
		return jButton6;
	}

	private void jButton6ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(this.jGDTTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton7ActionPerformed(evt);
				}
			});
		}
		return jButton7;
	}

	private void jButton7ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, this.jGDTTable.getModel(), "GDT");
		}
	}

	private JPanel getJPanel15() {
		if (jPanel15 == null) {
			jPanel15 = new JPanel();
			jPanel15.add(getJButton9());
			jPanel15.add(getJButton8());
		}
		return jPanel15;
	}

	private JPanel getJPanel16() {
		if (jPanel16 == null) {
			jPanel16 = new JPanel();
			jPanel16.add(getJButton11());
			jPanel16.add(getJButton10());
		}
		return jPanel16;
	}

	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton8ActionPerformed(evt);
				}
			});
		}
		return jButton8;
	}

	private void jButton8ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, this.jIDTTable.getModel(), "IDT");
		}
	}

	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jButton9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton9ActionPerformed(evt);
				}
			});
		}
		return jButton9;
	}

	private void jButton9ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(this.jIDTTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JButton getJButton10() {
		if (jButton10 == null) {
			jButton10 = new JButton();
			jButton10.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton10ActionPerformed(evt);
				}
			});
		}
		return jButton10;
	}

	private void jButton10ActionPerformed(ActionEvent evt) {
		System.out.println("jButton10.actionPerformed, event=" + evt);
	}

	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jButton11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton11ActionPerformed(evt);
				}
			});
		}
		return jButton11;
	}

	private void jButton11ActionPerformed(ActionEvent evt) {
		System.out.println("jButton11.actionPerformed, event=" + evt);
	}

	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton12ActionPerformed(evt);
				}
			});
		}
		return jButton12;
	}

	private void jButton12ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, Application.jInstructionTable.getModel(), "instruction 0x" + this.jInstructionComboBox.getSelectedItem().toString());
		}
	}

	private JButton getJExportToExcelButton() {
		if (jButton13 == null) {
			jButton13 = new JButton();
			jButton13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton13.setText("Excel");
			jButton13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton13ActionPerformed(evt);
				}
			});
		}
		return jButton13;
	}

	private void jButton13ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			final JProgressBarDialog d = new JProgressBarDialog(this, "Exporting to XLS", true);
			d.jProgressBar.setIndeterminate(true);
			d.jProgressBar.setStringPainted(true);

			class MyThread extends Thread {
				File file;
				Application application;

				public MyThread(Application application, File file) {
					this.application = application;
					this.file = file;
				}

				public void run() {
					Workbook wb = new HSSFWorkbook();// Write the output to a
														// file
					PeterBochsCommonLib.exportRegisterHistory(wb, d);
					PeterBochsCommonLib.exportTableModelToExcel(file, application.jGDTTable.getModel(), "GDT", wb);
					PeterBochsCommonLib.exportTableModelToExcel(file, application.jIDTTable.getModel(), "IDT", wb);
					PeterBochsCommonLib.exportTableModelToExcel(file, Application.jInstructionTable.getModel(), "instruction 0x"
							+ application.jInstructionComboBox.getSelectedItem().toString(), wb);
					PeterBochsCommonLib.exportTableModelToExcel(file, application.jHexTable1.getModel(), jMemoryAddressComboBox.getSelectedItem().toString(), wb);
					FileOutputStream fileOut;
					try {
						fileOut = new FileOutputStream(file);
						wb.write(fileOut);
						fileOut.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			d.thread = new MyThread(this, file);
			d.setVisible(true);
		}
	}

	private JPanel getJPanel17() {
		if (jPanel17 == null) {
			jPanel17 = new JPanel();
			BorderLayout jPanel17Layout = new BorderLayout();
			jPanel17.setLayout(jPanel17Layout);
			jPanel17.add(getJPanel18(), BorderLayout.NORTH);
			jPanel17.add(getJScrollPane12(), BorderLayout.CENTER);
		}
		return jPanel17;
	}

	private JPanel getJPanel18() {
		if (jPanel18 == null) {
			jPanel18 = new JPanel();
			jPanel18.add(getJLabel4());
			jPanel18.add(getJTextField1());
			jPanel18.add(getJLabel5());
			jPanel18.add(getJSearchMemoryFromComboBox());
			jPanel18.add(getJLabel6());
			jPanel18.add(getJSearchMemoryToComboBox());
			jPanel18.add(getJSearchMemoryButton());
			jPanel18.add(getJButton15());
		}
		return jPanel18;
	}

	private JScrollPane getJScrollPane12() {
		if (jScrollPane12 == null) {
			jScrollPane12 = new JScrollPane();
			jScrollPane12.setViewportView(getJSearchMemoryTable());
		}
		return jScrollPane12;
	}

	private JTable getJSearchMemoryTable() {
		if (jSearchMemoryTable == null) {
			jSearchMemoryTable = new JTable();
			getJSearchMemoryTable().getTableHeader().setReorderingAllowed(false);
			jSearchMemoryTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jSearchMemoryTableMouseClicked(evt);
				}
			});
			jSearchMemoryTable.setModel(new SearchTableModel());
		}
		return jSearchMemoryTable;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("hex/dec/string");
		}
		return jLabel4;
	}

	private JTextField getJTextField1() {
		if (jSearchMemoryTextField == null) {
			jSearchMemoryTextField = new JTextField();
			jSearchMemoryTextField.setPreferredSize(new java.awt.Dimension(84, 18));
		}
		return jSearchMemoryTextField;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("from");
		}
		return jLabel5;
	}

	private JComboBox getJSearchMemoryFromComboBox() {
		if (jSearchMemoryFromComboBox == null) {
			ComboBoxModel jSearchMemoryFromComboBoxModel = new DefaultComboBoxModel(new String[] {});
			jSearchMemoryFromComboBox = new JComboBox();
			jSearchMemoryFromComboBox.setModel(jSearchMemoryFromComboBoxModel);
			jSearchMemoryFromComboBox.setEditable(true);
			jSearchMemoryFromComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
		}
		return jSearchMemoryFromComboBox;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("to");
		}
		return jLabel6;
	}

	private JComboBox getJSearchMemoryToComboBox() {
		if (jSearchMemoryToComboBox == null) {
			ComboBoxModel jSearchMemoryToComboBoxModel = new DefaultComboBoxModel(new String[] {});
			jSearchMemoryToComboBox = new JComboBox();
			jSearchMemoryToComboBox.setModel(jSearchMemoryToComboBoxModel);
			jSearchMemoryToComboBox.setEditable(true);
			jSearchMemoryToComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
		}
		return jSearchMemoryToComboBox;
	}

	private JButton getJSearchMemoryButton() {
		if (jSearchMemoryButton == null) {
			jSearchMemoryButton = new JButton();
			jSearchMemoryButton.setText("Search");
			jSearchMemoryButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchMemoryButtonActionPerformed(evt);
				}
			});
		}
		return jSearchMemoryButton;
	}

	private void jSearchMemoryButtonActionPerformed(ActionEvent evt) {
		try {
			if (this.jSearchMemoryToComboBox.getSelectedItem().toString().trim().startsWith("+")) {
				this.jSearchMemoryToComboBox.setSelectedItem("0x"
						+ Long.toHexString(CommonLib.convertFilesize(this.jSearchMemoryFromComboBox.getSelectedItem().toString())
								+ CommonLib.convertFilesize(this.jSearchMemoryToComboBox.getSelectedItem().toString().substring(1))));
			}
			new SearchMemoryDialog(this, this.jSearchMemoryTable, this.jSearchMemoryTextField.getText(), CommonLib.convertFilesize(this.jSearchMemoryFromComboBox.getSelectedItem()
					.toString()), CommonLib.convertFilesize(this.jSearchMemoryToComboBox.getSelectedItem().toString())).setVisible(true);
		} catch (Exception ex) {

		}
	}

	private JButton getJDisassembleButton() {
		if (jDisassembleButton == null) {
			jDisassembleButton = new JButton();
			jDisassembleButton.setText(MyLanguage.getString("Disassemble"));
			jDisassembleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDisassembleButtonActionPerformed(evt);
				}
			});
		}
		return jDisassembleButton;
	}

	private void jDisassembleButtonActionPerformed(ActionEvent evt) {
		this.addInstructionComboBox(this.jInstructionComboBox.getSelectedItem().toString());
		jDisassembleCurrentIPButton.setEnabled(false);
		try {
			updateInstruction(CommonLib.convertFilesize(this.jInstructionComboBox.getSelectedItem().toString()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		updateBreakpointTableColor();
		jDisassembleCurrentIPButton.setEnabled(true);
	}

	private JButton getJButton15() {
		if (jButton15 == null) {
			jButton15 = new JButton();
			jButton15.setText(MyLanguage.getString("Clear"));
			jButton15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton15ActionPerformed(evt);
				}
			});
		}
		return jButton15;
	}

	private void jButton15ActionPerformed(ActionEvent evt) {
		((SearchTableModel) this.jSearchMemoryTable.getModel()).removeAll();
	}

	private JPanel getJMainPanel() {
		if (jMainPanel == null) {
			jMainPanel = new JPanel();
			CardLayout jMainPanelLayout = new CardLayout();
			jMainPanel.setLayout(jMainPanelLayout);
			{
				jMainPanel.add(getJMaximizableTabbedPane_BasePanel1(), "jMaximizableTabbedPane_BasePanel1");
				jMainPanel.add(getJInstrumentPanel(), "jInstrumentPanel");
				jMainPanel.add(getJRunningLabel(), "Running Label");
				jMainPanel.add(getLogPanel1(), "logPanel1");
				jMainPanel.add(getOsLogPanel1(), "oSLogPanel1");
				jMainPanel.add(getJRunningPanel(), "Running Label 2");
				jMainPanel.add(getSourceLevelDebugger(), "sourceLevelDebugger");
			}
		}
		return jMainPanel;
	}

	private JSplitPane getJSplitPane2() {
		jSplitPane2 = new JSplitPane();

		jSplitPane2.setPreferredSize(new java.awt.Dimension(1009, 781));
		jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		{
			jSplitPane1 = new JSplitPane();
			jSplitPane2.add(jSplitPane1, JSplitPane.TOP);
			jSplitPane1.setDividerLocation(400);
			{
				jTabbedPane1 = new JMaximizableTabbedPane();
				jSplitPane1.add(jTabbedPane1, JSplitPane.RIGHT);
				jTabbedPane1.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						jTabbedPane1StateChanged(evt);
					}
				});
				{
					jPanel10 = new JPanel();
					BorderLayout jPanel10Layout = new BorderLayout();
					jPanel10.setLayout(jPanel10Layout);
					jTabbedPane1.addTab(MyLanguage.getString("Instruction"),
							new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/text_padding_top.png")), jPanel10, null);
					jPanel10.setPreferredSize(new java.awt.Dimension(604, 452));
					{
						jInstructionControlPanel = new JPanel();
						jPanel10.add(jInstructionControlPanel, BorderLayout.NORTH);
						{
							ComboBoxModel jInstructionComboBoxModel = new DefaultComboBoxModel(new String[] {});
							jInstructionComboBox = new JComboBox();
							jInstructionControlPanel.add(jInstructionComboBox);
							jInstructionControlPanel.add(getJDisassembleButton());
							jInstructionComboBox.setModel(jInstructionComboBoxModel);
							jInstructionComboBox.setEditable(true);
							jInstructionComboBox.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jInstructionComboBoxActionPerformed(evt);
								}
							});
						}
						{
							jDisassembleCurrentIPButton = new JButton();
							jInstructionControlPanel.add(jDisassembleCurrentIPButton);
							jInstructionControlPanel.add(getJInstructionUpTenButton());
							jInstructionControlPanel.add(getJInstructionUpButton());
							jInstructionControlPanel.add(getJButton22());
							jInstructionControlPanel.add(getJButton3());
							jInstructionControlPanel.add(getJButton12());
							jDisassembleCurrentIPButton.setText(MyLanguage.getString("Disassemble") + " cs:eip");
							jDisassembleCurrentIPButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jDisassembleCurrentIPButtonActionPerformed(evt);
								}
							});
						}
					}
					{
						jScrollPane5 = new JScrollPane();
						jPanel10.add(jScrollPane5, BorderLayout.CENTER);
						{
							jInstructionTable = new JTable();
							jScrollPane5.setViewportView(jInstructionTable);
							jInstructionTable.setModel(new JInstructionTableModel());
							jInstructionTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							jInstructionTable.getTableHeader().setReorderingAllowed(false);
							jInstructionTable.getColumnModel().getColumn(0).setMaxWidth(20);
							jInstructionTable.getColumnModel().getColumn(1).setPreferredWidth(40);
							jInstructionTable.getColumnModel().getColumn(2).setPreferredWidth(200);
							jInstructionTable.getColumnModel().getColumn(3).setPreferredWidth(40);
							jInstructionTable.setDefaultRenderer(String.class, new JInstructionTableCellRenderer());
							jInstructionTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jInstructionTableMouseClicked(evt);
								}
							});
						}
					}
				}
				{
					jPanel4 = new JPanel();
					jTabbedPane1.addTab(MyLanguage.getString("Breakpoint"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/cancel.png")),
							jPanel4, null);
					BorderLayout jPanel4Layout = new BorderLayout();
					jPanel4.setLayout(jPanel4Layout);
					{
						jScrollPane9 = new JScrollPane();
						jPanel4.add(jScrollPane9, BorderLayout.CENTER);
						{
							jBreakpointTable = new JTable();
							jBreakpointTable.getTableHeader().setReorderingAllowed(false);
							jScrollPane9.setViewportView(jBreakpointTable);
							jBreakpointTable.setModel(jBreakpointTableModel);
							jBreakpointTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							jBreakpointTable.getColumnModel().getColumn(0).setCellRenderer(new JBreakpointTableCellRenderer());
							jBreakpointTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jBreakpointTableMouseClicked(evt);
								}
							});
							jBreakpointTable.getColumnModel().getColumn(2).setPreferredWidth(100);
							jBreakpointTable.getColumnModel().getColumn(3).setPreferredWidth(20);
						}
					}
					{
						jPanel12 = new JPanel();
						jPanel4.add(jPanel12, BorderLayout.SOUTH);
						{
							jAddBreakpointButton = new JButton();
							jPanel12.add(jAddBreakpointButton);
							jAddBreakpointButton.setText(MyLanguage.getString("Add"));
							jAddBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jAddBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jDeleteBreakpointButton = new JButton();
							jPanel12.add(jDeleteBreakpointButton);
							jDeleteBreakpointButton.setText(MyLanguage.getString("Del"));
							jDeleteBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jDeleteBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jRefreshBreakpointButton = new JButton();
							jPanel12.add(jRefreshBreakpointButton);
							jRefreshBreakpointButton.setText(MyLanguage.getString("Refresh"));
							jRefreshBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jRefreshBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jEnableBreakpointButton = new JButton();
							jPanel12.add(jEnableBreakpointButton);
							jEnableBreakpointButton.setText(MyLanguage.getString("Enable"));
							jEnableBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jEnableBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jDisableBreakpointButton = new JButton();
							jPanel12.add(jDisableBreakpointButton);
							jDisableBreakpointButton.setText(MyLanguage.getString("Disable"));
							jDisableBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jDisableBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jSaveBreakpointButton = new JButton();
							jPanel12.add(jSaveBreakpointButton);
							jSaveBreakpointButton.setText(MyLanguage.getString("Save"));
							jSaveBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jSaveBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jLoadBreakpointButton = new JDropDownButton();
							jPanel12.add(jLoadBreakpointButton);
							jPanel12.add(getJSBButton());
							jPanel12.add(getJSBAButton());
							jLoadBreakpointButton.setText(MyLanguage.getString("Load"));
							jLoadBreakpointButton.add(loadSystemsMapMenuItem);
							jLoadBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jLoadBreakpointButtonActionPerformed(evt);
								}
							});
						}
					}
				}
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab(MyLanguage.getString("Bochs"),
							new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/application_xp_terminal.png")), jPanel1, null);
					jTabbedPane1.addTab("ELF", new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/linux.png")), getJELFBreakpointPanel(),
							null);
					DiskPanel diskPanel = getDiskPanel();
					if (diskPanel.getFile() != null) {
						jTabbedPane1.addTab(diskPanel.getFile().getName(), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/package.png")),
								diskPanel, null);
					}
					BorderLayout jPanel1Layout = new BorderLayout();
					jPanel1.setLayout(jPanel1Layout);
					{
						jScrollPane4 = new JScrollPane();
						jPanel1.add(jScrollPane4, BorderLayout.CENTER);
						{
							jBochsEditorPane = new JEditorPane();
							jScrollPane4.setViewportView(jBochsEditorPane);
						}
					}
					{
						jPanel2 = new JPanel();
						TableLayout jPanel2Layout = new TableLayout(new double[][] { { TableLayout.FILL, 411.0, TableLayout.MINIMUM, TableLayout.MINIMUM }, { TableLayout.FILL } });
						jPanel2Layout.setHGap(5);
						jPanel2Layout.setVGap(5);
						jPanel2.setLayout(jPanel2Layout);
						jPanel1.add(jPanel2, BorderLayout.SOUTH);
						{
							jBochsCommandTextField = new JTextField();
							jPanel2.add(jBochsCommandTextField, "0, 0, 1, 0");
							jBochsCommandTextField.addKeyListener(new KeyAdapter() {
								public void keyPressed(KeyEvent evt) {
									jBochsCommandTextFieldKeyPressed(evt);
								}

								public void keyTyped(KeyEvent evt) {
									jBochsCommandTextFieldKeyTyped(evt);
								}
							});
						}
						{
							jBochsCommandButton = new JButton();
							jPanel2.add(jBochsCommandButton, "2, 0");
							jPanel2.add(getJClearBochsButton(), "3, 0");
							jBochsCommandButton.setText("Run");
							jBochsCommandButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jBochsCommandButtonActionPerformed(evt);
								}
							});
						}
					}
				}
			}
			{
				jTabbedPane3 = new JMaximizableTabbedPane();
				jSplitPane1.add(jTabbedPane3, JSplitPane.LEFT);
				{
					jPanel8 = new JPanel();
					BorderLayout jPanel8Layout = new BorderLayout();
					jPanel8.setLayout(jPanel8Layout);
					jTabbedPane3.addTab(MyLanguage.getString("Memory"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/memory.png")),
							jPanel8, null);
					{
						jScrollPane2 = new JScrollPane();
						jPanel8.add(jScrollPane2, BorderLayout.CENTER);
						{
							jHexTable1 = new JHexTable();
							jHexTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
							for (int x = 1; x < 9; x++) {
								jHexTable1.getColumnModel().getColumn(x).setPreferredWidth(10);
							}
							jScrollPane2.setViewportView(jHexTable1);
							jHexTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							jHexTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							jHexTable1.setCellSelectionEnabled(true);
							jHexTable1.getTableHeader().setReorderingAllowed(false);
							jHexTable1.setDefaultRenderer(String.class, new JMemoryTableCellRenderer());
							jHexTable1.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jHexTable1MouseClicked(evt);
								}
							});
						}
					}
					{
						jPanel9 = new JPanel();
						FlowLayout jPanel9Layout = new FlowLayout();
						jPanel9.setLayout(jPanel9Layout);
						jPanel8.add(jPanel9, BorderLayout.NORTH);
						{
							jMemoryAddressComboBox = new JComboBox();
							jPanel9.add(jMemoryAddressComboBox);
							jMemoryAddressComboBox.setSelectedItem("0x00000000");
							jMemoryAddressComboBox.setEditable(true);
							jMemoryAddressComboBox.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jMemoryAddressComboBoxActionPerformed(evt);
								}
							});
							new Thread("addMemoryAddressComboBox thread") {
								public void run() {
									TreeSet<String> vector = Setting.getInstance().getMemoryCombo();

									Iterator<String> iterator = vector.iterator();
									while (iterator.hasNext()) {
										addMemoryAddressComboBox(iterator.next());
									}
								}
							}.start();
							jMemoryAddressComboBox.setSelectedItem("0x00000000");
						}
						{
							jGOMemoryButton = new JButton();
							jPanel9.add(jGOMemoryButton);
							jPanel9.add(getJGoLinearButton());
							jPanel9.add(getJPreviousMemoryButton());
							jPanel9.add(getJNextMemoryPageButton());
							jPanel9.add(getJButton2());
							jPanel9.add(getJButton5());
							jGOMemoryButton.setText(MyLanguage.getString("Go"));
							jGOMemoryButton.setToolTipText(MyLanguage.getString("Physical_address"));
							jGOMemoryButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jGOMemoryButtonActionPerformed(evt);
								}
							});
						}
						{
							jBinaryRadioButton = new JRadioButton();
							jPanel9.add(jBinaryRadioButton);
							jBinaryRadioButton.setText("2");
							jBinaryRadioButton.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									jBinaryRadioButtonItemStateChanged(evt);
								}
							});
							jBinaryRadioButton.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									jBinaryRadioButtonStateChanged(evt);
								}
							});
							getButtonGroup1().add(jBinaryRadioButton);
						}
						{
							jOctRadioButton1 = new JRadioButton();
							jPanel9.add(jOctRadioButton1);
							jOctRadioButton1.setText("8");
							jOctRadioButton1.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									jOctRadioButton1ItemStateChanged(evt);
								}
							});
							jOctRadioButton1.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									jOctRadioButton1StateChanged(evt);
								}
							});
							getButtonGroup1().add(jOctRadioButton1);
						}
						{
							jDecRadioButton = new JRadioButton();
							jPanel9.add(jDecRadioButton);
							jDecRadioButton.setText("10");
							jDecRadioButton.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									jDecRadioButtonItemStateChanged(evt);
								}
							});
							jDecRadioButton.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									jDecRadioButtonStateChanged(evt);
								}
							});
							getButtonGroup1().add(jDecRadioButton);
						}
						{
							jHexRadioButton = new JRadioButton();
							jPanel9.add(jHexRadioButton);
							jHexRadioButton.setText("16");
							jHexRadioButton.setSelected(true);
							jHexRadioButton.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									jHexRadioButtonItemStateChanged(evt);
								}
							});
							jHexRadioButton.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent evt) {
									jHexRadioButtonStateChanged(evt);
								}
							});
							getButtonGroup1().add(jHexRadioButton);
						}
					}
				}
				{
					jPanel5 = new JPanel();
					jTabbedPane3.addTab(MyLanguage.getString("GDT"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/gdt.png")), jPanel5,
							null);
					BorderLayout jPanel5Layout = new BorderLayout();
					jPanel5.setLayout(jPanel5Layout);
					{
						jScrollPane3 = new JScrollPane();
						jPanel5.add(jScrollPane3, BorderLayout.CENTER);
						jPanel5.add(getJPanel14(), BorderLayout.NORTH);
						{
							JGDTTableModel jGDTTableModel = new JGDTTableModel();
							jGDTTable = new JTable();
							jGDTTable.setModel(jGDTTableModel);
							jScrollPane3.setViewportView(jGDTTable);
							jGDTTable.getColumnModel().getColumn(0).setMaxWidth(40);
							jGDTTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							jGDTTable.getTableHeader().setReorderingAllowed(false);
							jGDTTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jGDTTableMouseClicked(evt);
								}
							});

						}
					}
				}
				{
					jPanel6 = new JPanel();
					BorderLayout jPanel6Layout = new BorderLayout();
					jPanel6.setLayout(jPanel6Layout);
					jTabbedPane3.addTab(MyLanguage.getString("IDT"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/idt.png")), jPanel6,
							null);
					{
						jScrollPane10 = new JScrollPane();
						jPanel6.add(jScrollPane10, BorderLayout.CENTER);
						jPanel6.add(getJPanel15(), BorderLayout.NORTH);
						{
							JIDTTableModel jIDTTableModel = new JIDTTableModel();
							jIDTTable = new JTable();
							jIDTTable.setModel(jIDTTableModel);
							jScrollPane10.setViewportView(jIDTTable);
							jIDTTable.getColumnModel().getColumn(0).setMaxWidth(40);
							jIDTTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							jIDTTable.getTableHeader().setReorderingAllowed(false);
							jIDTTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jIDTTableMouseClicked(evt);
								}
							});
						}
					}
				}
				{
					jPanel7 = new JPanel();
					BorderLayout jPanel7Layout = new BorderLayout();
					jPanel7.setLayout(jPanel7Layout);
					jTabbedPane3.addTab(MyLanguage.getString("LDT"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/ldt.png")), jPanel7,
							null);
					jTabbedPane3.addTab(MyLanguage.getString("Search_memory"), new ImageIcon(getClass().getClassLoader()
							.getResource("com/peterbochs/icons/famfam_icons/memory.png")), getJPanel17(), null);
					jTabbedPane3
							.addTab("bochsout.txt", new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/script.png")), getJPanel31(), null);
					{
						jScrollPane11 = new JScrollPane();
						jPanel7.add(jScrollPane11, BorderLayout.CENTER);
						jPanel7.add(getJPanel16(), BorderLayout.NORTH);
						{
							JLDTTableModel jLDTTableModel = new JLDTTableModel();
							jLDTTable = new JTable();
							jLDTTable.setModel(jLDTTableModel);
							jScrollPane11.setViewportView(jLDTTable);
							jLDTTable.getColumnModel().getColumn(0).setMaxWidth(40);
							jLDTTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							jLDTTable.getTableHeader().setReorderingAllowed(false);
							jLDTTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jLDTTableMouseClicked(evt);
								}
							});
						}
					}
				}
			}
		}
		{
			jTabbedPane2 = new JMaximizableTabbedPane();
			// jTabbedPane2.setCloseIcon(true);
			// jTabbedPane2.setMaxIcon(true);
			//
			// jTabbedPane2.addCloseListener(new CloseListener() {
			// public void closeOperation(MouseEvent e) {
			// jTabbedPane2.remove(jTabbedPane2.getOverTabIndex());
			// }
			// });
			//
			// jTabbedPane2.addMaxListener(new MaxListener() {
			// public void maxOperation(MouseEvent e) {
			// jTabbedPane2.detachTab(jTabbedPane2.getOverTabIndex());
			// }
			// });

			jSplitPane2.add(jTabbedPane2, JSplitPane.BOTTOM);
			{
				jScrollPane1 = new JScrollPane();
				jTabbedPane2.addTab(MyLanguage.getString("Register"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/text_kerning.png")),
						jScrollPane1, null);
				{
					jRegisterPanel1 = new RegisterPanel(this);
					jScrollPane1.setViewportView(jRegisterPanel1);
				}
			}
			{
				jPanel3 = new JPanel();
				jTabbedPane2.addTab(MyLanguage.getString("History"),
						new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/book_addresses.png")), jPanel3, null);
				BorderLayout jPanel3Layout = new BorderLayout();
				jPanel3.setLayout(jPanel3Layout);
				{
					jScrollPane6 = new JScrollPane();
					jPanel3.add(jScrollPane6, BorderLayout.CENTER);
					jPanel3.add(getJPanel13(), BorderLayout.NORTH);
					jScrollPane6.setViewportView(getJHistoryTable());
				}
			}
			{
				jPanel11 = new JPanel();
				jTabbedPane2.addTab(MyLanguage.getString("Paging"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/page_copy.png")),
						jPanel11, null);
				jTabbedPane2.addTab(MyLanguage.getString("Address_translate"),
						new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/page_go.png")), getJAddressTranslatePanel(), null);
				jTabbedPane2.addTab("Page table graph (experimental)", new ImageIcon(getClass().getClassLoader()
						.getResource("com/peterbochs/icons/famfam_icons/page_lightning.png")), getJPageTableGraphPanel(), null);
				if (!Global.debug) {
					jTabbedPane2.removeTabAt(jTabbedPane2.getTabCount() - 1);
				}
				jTabbedPane2.addTab(MyLanguage.getString("Table_translate"),
						new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/page_refresh.png")), getJTableTranslateScrollPane(), null);
				jTabbedPane2.addTab(MyLanguage.getString("ELF_dump"), new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/linux.png")),
						getJELFDumpScrollPane(), null);
				jTabbedPane2.addTab("OS debug informations", new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/bug.png")),
						getJOSDebugStandardPanel(), null);
				BorderLayout jPanel11Layout = new BorderLayout();
				jPanel11.setLayout(jPanel11Layout);
				jPanel11.add(getJSplitPane3(), BorderLayout.CENTER);
				jPanel11.add(getJPanel19(), BorderLayout.NORTH);
			}
		}
		return jSplitPane2;
	}

	private JLabel getJRunningLabel() {
		if (jRunningLabel == null) {
			jRunningLabel = new JLabel();

			new Thread("JRunningLabel thread") {
				public void run() {
					if (Setting.getInstance().getCurrentLanguage().equals("zh_TW")) {
						jRunningLabel
								.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\""
										+ url
										+ "\" /><br><br><a style=\"color: #ffffff;  text-decoration:none\" href=\"http://www.kingofcoders.com\">編程王 www.kingofcoders.com</a></center></html>");
					} else if (Setting.getInstance().getCurrentLanguage().equals("zh_CN")) {
						jRunningLabel
								.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\""
										+ url
										+ "\" /><br><br><img src=\"http://www.kingofcoders.com/images/KOC_logo2.jpg\" /><br><a style=\"color: #ffffff;  text-decoration:none\" href=\"http://www.kingofcoders.com\">编程王 www.kingofcoders.com</a></center></html>");
					} else {
						jRunningLabel.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\"" + url + "\" /></center></html>");
					}
				}
			}.start();
			jRunningLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jRunningLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			jRunningLabel.setFont(new java.awt.Font("Arial", 0, 20));
			jRunningLabel.setForeground(Color.white);
			jRunningLabel.setBackground(new Color(0, 0, 0, 180));
			jRunningLabel.setOpaque(true);
		}
		return jRunningLabel;
	}

	private JButton getJGDTGraphButton() {
		if (jGDTGraphButton == null) {
			jGDTGraphButton = new JButton();
			jGDTGraphButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/map.png")));
			jGDTGraphButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGDTGraphButtonActionPerformed(evt);
				}
			});
		}
		return jGDTGraphButton;
	}

	private void jGDTGraphButtonActionPerformed(ActionEvent evt) {

	}

	private JToolBar getJPanel19() {
		if (jPanel19 == null) {
			jPanel19 = new JToolBar();
			FlowLayout jPanel19Layout = new FlowLayout();
			jPanel19Layout.setAlignment(FlowLayout.LEFT);
			jPanel19.add(getJPagingGraphButton());
			jPanel19.add(getJButton21x());
			jPanel19.add(getJButton20());
			jPanel19.add(getJDumpPageDirectoryAddressTextField());
			jPanel19.add(getJButton21());
			jPanel19.add(getJHideIfAddressIsZeroCheckBox());
		}
		return jPanel19;
	}

	private JButton getJPagingGraphButton() {
		if (jPagingGraphButton == null) {
			jPagingGraphButton = new JButton();
			jPagingGraphButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jPagingGraphButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPagingGraphButtonActionPerformed(evt);
				}
			});
		}
		return jPagingGraphButton;
	}

	private void jPagingGraphButtonActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(jSplitPane3, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JPanel getJPageTableGraphPanel() {
		if (jPageTableGraphPanel == null) {
			jPageTableGraphPanel = new JPanel();
			BorderLayout jPageTableGraphPanelLayout = new BorderLayout();
			jPageTableGraphPanel.setLayout(jPageTableGraphPanelLayout);
			jPageTableGraphPanel.add(getJToolBar2(), BorderLayout.NORTH);
		}
		return jPageTableGraphPanel;
	}

	private JToolBar getJToolBar2() {
		if (jToolBar2 == null) {
			jToolBar2 = new JToolBar();
			jToolBar2.add(getJAutoRefreshPageTableGraphCheckBox());
			jToolBar2.add(getJRefreshPageTableGraphButton());
		}
		return jToolBar2;
	}

	private JCheckBox getJAutoRefreshPageTableGraphCheckBox() {
		if (jAutoRefreshPageTableGraphCheckBox == null) {
			jAutoRefreshPageTableGraphCheckBox = new JCheckBox();
			jAutoRefreshPageTableGraphCheckBox.setText("Auto refresh");
		}
		return jAutoRefreshPageTableGraphCheckBox;
	}

	private JButton getJRefreshPageTableGraphButton() {
		if (jRefreshPageTableGraphButton == null) {
			jRefreshPageTableGraphButton = new JButton();
			jRefreshPageTableGraphButton.setText("Refresh");
		}
		return jRefreshPageTableGraphButton;
	}

	private JPanel getJAddressTranslatePanel() {
		if (jAddressTranslatePanel == null) {
			jAddressTranslatePanel = new JPanel();
			BorderLayout jAddressTranslatePanelLayout = new BorderLayout();
			jAddressTranslatePanel.setLayout(jAddressTranslatePanelLayout);
			jAddressTranslatePanel.add(getJPanel20(), BorderLayout.WEST);
			jAddressTranslatePanel.add(getJPanel22(), BorderLayout.CENTER);
			jAddressTranslatePanel.add(getJToolBar3(), BorderLayout.NORTH);
		}
		return jAddressTranslatePanel;
	}

	private JPanel getJPanel20() {
		if (jPanel20 == null) {
			jPanel20 = new JPanel();
			TableLayout jPanel20Layout = new TableLayout(new double[][] { { 8.0, 156.0, 13.0 }, { 25.0, 25.0, 25.0, 22.0, 37.0, TableLayout.FILL } });
			jPanel20Layout.setHGap(5);
			jPanel20Layout.setVGap(5);
			jPanel20.setLayout(jPanel20Layout);
			jPanel20.setPreferredSize(new java.awt.Dimension(189, 629));
			jPanel20.add(getJRadioButton3(), "1, 0, 2, 0");
			jPanel20.add(getJRadioButton4(), "1, 1, 2, 1");
			jPanel20.add(getJRadioButton5(), "1, 2, 2, 2");
			jPanel20.add(getJPanel21(), "1, 4");
			jPanel20.add(getJAddressTextField(), "1, 3");
		}
		return jPanel20;
	}

	private JRadioButton getJRadioButton3() {
		if (jSearchAddressRadioButton1 == null) {
			jSearchAddressRadioButton1 = new JRadioButton();
			jSearchAddressRadioButton1.setText(MyLanguage.getString("Virtual_address"));
			jSearchAddressRadioButton1.setSelected(true);
			getButtonGroup3().add(jSearchAddressRadioButton1);
		}
		return jSearchAddressRadioButton1;
	}

	private JRadioButton getJRadioButton4() {
		if (jSearchAddressRadioButton2 == null) {
			jSearchAddressRadioButton2 = new JRadioButton();
			jSearchAddressRadioButton2.setText(MyLanguage.getString("Linear_address"));
			getButtonGroup3().add(jSearchAddressRadioButton2);
		}

		return jSearchAddressRadioButton2;
	}

	private JRadioButton getJRadioButton5() {
		if (jSearchAddressRadioButton3 == null) {
			jSearchAddressRadioButton3 = new JRadioButton();
			jSearchAddressRadioButton3.setVisible(false);
			jSearchAddressRadioButton3.setText(MyLanguage.getString("Physical_address"));
			getButtonGroup3().add(jSearchAddressRadioButton3);
		}

		return jSearchAddressRadioButton3;
	}

	private JButton getJButton16() {
		if (jRefreshAddressTranslateButton == null) {
			jRefreshAddressTranslateButton = new JButton();
			jRefreshAddressTranslateButton.setText(MyLanguage.getString("Convert"));
			jRefreshAddressTranslateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshAddressTranslateButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshAddressTranslateButton;
	}

	private JPanel getJPanel22() {
		if (jPanel22 == null) {
			jPanel22 = new JPanel();
			BorderLayout jPanel22Layout = new BorderLayout();
			jPanel22.setLayout(jPanel22Layout);
			jPanel22.add(getJScrollPane13(), BorderLayout.CENTER);
		}
		return jPanel22;
	}

	private JTable getJTable1() {
		if (jAddressTranslateTable2 == null) {
			jAddressTranslateTable2 = new JTable();
			AddressTranslateTableModel addressTranslateTableModel = new AddressTranslateTableModel();
			jAddressTranslateTable2.setModel(addressTranslateTableModel);
			jAddressTranslateTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			for (int x = 0; x < jAddressTranslateTable2.getColumnCount(); x++) {
				jAddressTranslateTable2.getColumnModel().getColumn(x).setPreferredWidth(100);
			}
		}
		return jAddressTranslateTable2;
	}

	private JScrollPane getJScrollPane13() {
		if (jScrollPane13 == null) {
			jScrollPane13 = new JScrollPane();
			jScrollPane13.setPreferredSize(new java.awt.Dimension(150, 32));
			jScrollPane13.setViewportView(getJTable1());
		}
		return jScrollPane13;
	}

	private JToolBar getJToolBar3() {
		if (jToolBar3 == null) {
			jToolBar3 = new JToolBar();
			jToolBar3.add(getJButton17());
			jToolBar3.add(getJButton18());
			jToolBar3.add(getJRefreshAddressTranslateTableButton());
			jToolBar3.add(getJButton19());
		}
		return jToolBar3;
	}

	private JButton getJButton17() {
		if (jButton17 == null) {
			jButton17 = new JButton();
			jButton17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
			jButton17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton17ActionPerformed(evt);
				}
			});
		}
		return jButton17;
	}

	private JButton getJButton18() {
		if (jButton18 == null) {
			jButton18 = new JButton();
			jButton18.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton18ActionPerformed(evt);
				}
			});
		}
		return jButton18;
	}

	private ButtonGroup getButtonGroup3() {
		if (buttonGroup3 == null) {
			buttonGroup3 = new ButtonGroup();
		}
		return buttonGroup3;
	}

	private JPanel getJPanel21() {
		if (jPanel21 == null) {
			jPanel21 = new JPanel();
			jPanel21.add(getJButton16());
		}
		return jPanel21;
	}

	private JTextField getJAddressTextField() {
		if (jAddressTextField == null) {
			jAddressTextField = new JTextField();
			jAddressTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jAddressTextFieldKeyTyped(evt);
				}
			});
		}
		return jAddressTextField;
	}

	private void jRefreshAddressTranslateButtonActionPerformed(ActionEvent evt) {
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();

		if (jSearchAddressRadioButton1.isSelected()) {
			if (!this.jAddressTextField.getText().contains(":") || this.jAddressTextField.getText().replaceAll("[^:]", "").length() != 1) {
				JOptionPane.showMessageDialog(this, "Error, please input <segment selector>:<offset>\n\ne.g. : 0x10:0x12345678", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Long segSelector = CommonLib.convertFilesize(this.jAddressTextField.getText().split(":")[0]);
			Long address = CommonLib.convertFilesize(this.jAddressTextField.getText().split(":")[1]);

			// for (int x = 0; x < model.getRowCount(); x++) {
			// if (model.searchType.get(x).equals(1) &&
			// model.searchSegSelector.get(x).equals(segSelector) &&
			// model.searchAddress.get(x).equals(address)) {
			// return;
			// }
			// }

			model.searchType.add(1);
			model.searchSegSelector.add(segSelector);
			model.searchAddress.add(address);

			model.virtualAddress.add(address);
			long segNo = segSelector >> 3;
			model.segNo.add(segNo);

			// read GDT descriptor
			int descriptor[] = PeterBochsCommonLib.getMemoryFromBochs(CommonLib.convertFilesize(this.jRegisterPanel1.jGDTRTextField.getText()) + (segNo * 8), 8);
			long baseAddress = CommonLib.getLong(descriptor[2], descriptor[3], descriptor[4], descriptor[7], 0, 0, 0, 0);
			long linearAddress = baseAddress + address;
			model.baseAddress.add(baseAddress);
			model.linearAddress.add(linearAddress);

			long pdNo = CommonLib.getValue(linearAddress, 31, 22);
			model.pdNo.add(pdNo);
			int pdeBytes[] = PeterBochsCommonLib.getMemoryFromBochs(CommonLib.convertFilesize(this.jRegisterPanel1.jCR3TextField.getText()) + (pdNo * 4), 4);
			long pde = CommonLib.getInt(pdeBytes, 0);
			model.pde.add(pde);

			long ptNo = CommonLib.getValue(linearAddress, 21, 12);
			model.ptNo.add(ptNo);
			long pageTableBaseAddress = pde & 0xfffff000;
			int pteBytes[] = PeterBochsCommonLib.getMemoryFromBochs(pageTableBaseAddress + (ptNo * 4), 4);
			long pte = CommonLib.getInt(pteBytes, 0);
			long pagePhysicalAddress = pte & 0xfffff000;
			model.pte.add(pte);

			long physicalAddress = pagePhysicalAddress + CommonLib.getValue(linearAddress, 11, 0);
			model.physicalAddress.add(physicalAddress);
			int bytesAtPhysicalAddress[] = PeterBochsCommonLib.getMemoryFromBochs(physicalAddress, 8);
			model.bytes.add(PeterBochsCommonLib.convertToString(bytesAtPhysicalAddress));

			model.fireTableDataChanged();
		} else if (jSearchAddressRadioButton2.isSelected()) {
			// for (int x = 0; x < model.getRowCount(); x++) {
			// if (model.searchType.get(x).equals(2) &&
			// model.searchAddress.get(x).equals(CommonLib.convertFilesize(this.jAddressTextField.getText())))
			// {
			// return;
			// }
			// }
			Long address = CommonLib.convertFilesize(this.jAddressTextField.getText());

			model.searchType.add(2);
			model.searchAddress.add(address);

			long baseAddress = 0;
			long linearAddress = baseAddress + address;
			model.baseAddress.add(baseAddress);
			model.linearAddress.add(linearAddress);

			long pdNo = CommonLib.getValue(linearAddress, 31, 22);
			model.pdNo.add(pdNo);
			int pdeBytes[] = PeterBochsCommonLib.getMemoryFromBochs(CommonLib.convertFilesize(this.jRegisterPanel1.jCR3TextField.getText()) + (pdNo * 4), 4);
			long pde = CommonLib.getInt(pdeBytes, 0);
			model.pde.add(pde);

			long ptNo = CommonLib.getValue(linearAddress, 21, 12);
			model.ptNo.add(ptNo);
			long pageTableBaseAddress = pde & 0xfffff000;
			int pteBytes[] = PeterBochsCommonLib.getMemoryFromBochs(pageTableBaseAddress + (ptNo * 4), 4);
			long pte = CommonLib.getInt(pteBytes, 0);
			long pagePhysicalAddress = pte & 0xfffff000;
			model.pte.add(pte);

			long physicalAddress = pagePhysicalAddress + CommonLib.getValue(linearAddress, 11, 0);
			model.physicalAddress.add(physicalAddress);
			int bytesAtPhysicalAddress[] = PeterBochsCommonLib.getMemoryFromBochs(physicalAddress, 8);
			model.bytes.add(PeterBochsCommonLib.convertToString(bytesAtPhysicalAddress));

			model.fireTableDataChanged();
		} else if (jSearchAddressRadioButton3.isSelected()) {
			for (int x = 0; x < model.getRowCount(); x++) {
				if (model.searchType.get(x).equals(3) && model.searchAddress.get(x).equals(CommonLib.convertFilesize(this.jAddressTextField.getText()))) {
					return;
				}
			}
			Long addr = CommonLib.convertFilesize(this.jAddressTextField.getText());
			model.searchType.add(3);
			model.searchSegSelector.add(0L);
			model.searchAddress.add(addr);

			model.virtualAddress.add(0L);
			model.segNo.add(0L);
			model.linearAddress.add(0L);
			model.pdNo.add(0L);
			model.ptNo.add(0L);
			model.physicalAddress.add(0L);
			model.bytes.add("");

			model.fireTableDataChanged();
		}
	}

	private JButton getJRefreshAddressTranslateTableButton() {
		if (jRefreshAddressTranslateTableButton == null) {
			jRefreshAddressTranslateTableButton = new JButton();
			jRefreshAddressTranslateTableButton.setText(MyLanguage.getString("Refresh"));
			jRefreshAddressTranslateTableButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_refresh.png")));
			jRefreshAddressTranslateTableButton.setText("Refresh");
			jRefreshAddressTranslateTableButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshAddressTranslateTableButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshAddressTranslateTableButton;
	}

	private void jRefreshAddressTranslateTableButtonActionPerformed(ActionEvent evt) {
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();
		for (int x = 0; x < model.getRowCount(); x++) {
			if (model.searchType.get(x).equals(1)) {
				model.segNo.set(x, model.searchSegSelector.get(x) >> 3);
				model.virtualAddress.set(x, model.searchAddress.get(x));

				long gdtBase = PeterBochsCommonLib.getPhysicalAddress(CommonLib.convertFilesize(this.jRegisterPanel1.jCR3TextField.getText()),
						CommonLib.convertFilesize(this.jRegisterPanel1.jGDTRTextField.getText()));
				System.out.println("gdtBase=" + Long.toHexString(gdtBase));
				commandReceiver.clearBuffer();
				gdtBase += model.segNo.get(x) * 8;
				sendCommand("xp /8bx " + gdtBase);
				String result = commandReceiver.getCommandResult(String.format("%08x", gdtBase));

				int bytes[] = new int[8];
				String[] b = result.replaceFirst("^.*:", "").split("\t");
				for (int y = 1; y <= 8; y++) {
					bytes[y - 1] = (int) CommonLib.convertFilesize(b[y]);
				}

				Long gdtDescriptor = CommonLib.getLong(bytes, 0);
				System.out.println(Long.toHexString(gdtDescriptor));
				long base = CommonLib.getLong(bytes[2], bytes[3], bytes[4], bytes[7], 0, 0, 0, 0);
				System.out.println(Long.toHexString(base));

				model.linearAddress.set(x, base + model.searchAddress.get(x));
			}
		}
		model.fireTableDataChanged();
	}

	private void jHexTable1MouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jHexTable1.rowAtPoint(p);
			int columnNumber = jHexTable1.columnAtPoint(p);
			ListSelectionModel model = jHexTable1.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jHexTable1.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJHexTablePopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPopupMenu getJHexTablePopupMenu() {
		if (jHexTablePopupMenu == null) {
			jHexTablePopupMenu = new JPopupMenu();
			jHexTablePopupMenu.add(getJMenu7());
			jHexTablePopupMenu.add(getJMenu8());
			jHexTablePopupMenu.add(getJMenuItem4());
			jHexTablePopupMenu.add(getJMenuItem5());
			jHexTablePopupMenu.add(getJMenuItem6());
			jHexTablePopupMenu.add(getJMenuItem7());
			jHexTablePopupMenu.add(getJDisassemble32MenuItem());
		}
		return jHexTablePopupMenu;
	}

	private JMenuItem getJMenu7() {
		if (jGDTMenuItem == null) {
			jGDTMenuItem = new JMenuItem();
			jGDTMenuItem.setText("GDT table");
			jGDTMenuItem.setBounds(0, 21, 115, 21);
			jGDTMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGDTMenuItemActionPerformed(evt);
				}
			});
		}
		return jGDTMenuItem;
	}

	private JMenuItem getJMenu8() {
		if (jGDTDescriptorMenuItem == null) {
			jGDTDescriptorMenuItem = new JMenuItem();
			jGDTDescriptorMenuItem.setText("GDT descriptor");
			jGDTDescriptorMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGDTDescriptorMenuItemActionPerformed(evt);
				}
			});
		}
		return jGDTDescriptorMenuItem;
	}

	private JMenuItem getJMenuItem4() {
		if (jIDTMenuItem == null) {
			jIDTMenuItem = new JMenuItem();
			jIDTMenuItem.setText("IDT table");
			jIDTMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jIDTMenuItemActionPerformed(evt);
				}
			});
		}
		return jIDTMenuItem;
	}

	private JMenuItem getJMenuItem5() {
		if (jIDTDescriptorMenuItem == null) {
			jIDTDescriptorMenuItem = new JMenuItem();
			jIDTDescriptorMenuItem.setText("IDT descriptor");
			jIDTDescriptorMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jIDTDescriptorMenuItemActionPerformed(evt);
				}
			});
		}
		return jIDTDescriptorMenuItem;
	}

	private JMenuItem getJMenuItem6() {
		if (jPDEMenuItem == null) {
			jPDEMenuItem = new JMenuItem();
			jPDEMenuItem.setText(MyLanguage.getString("PDE"));
			jPDEMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPDEMenuItemActionPerformed(evt);
				}
			});
		}
		return jPDEMenuItem;
	}

	private JMenuItem getJMenuItem7() {
		if (jPTEMenuItem == null) {
			jPTEMenuItem = new JMenuItem();
			jPTEMenuItem.setText(MyLanguage.getString("PTE"));
			jPTEMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPTEMenuItemActionPerformed(evt);
				}
			});
		}
		return jPTEMenuItem;
	}

	private void jGDTMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "GDT").setVisible(true);
	}

	private void jGDTDescriptorMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "GDT Descriptor").setVisible(true);
	}

	private void jIDTMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "IDT").setVisible(true);
	}

	private void jIDTDescriptorMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "IDT Descriptor").setVisible(true);
	}

	private void jPDEMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "PDE").setVisible(true);
	}

	private void jPTEMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "PTE").setVisible(true);
	}

	private void jMemoryAddressComboBoxActionPerformed(ActionEvent evt) {
		if (this.isVisible()) {
			jGOMemoryButtonActionPerformed(evt);
		}
	}

	private JMenuItem getJDisassemble32MenuItem() {
		if (jDisassemble32MenuItem == null) {
			jDisassemble32MenuItem = new JMenuItem();
			jDisassemble32MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDisassemble32MenuItemActionPerformed(evt);
				}
			});
			jDisassemble32MenuItem.setText(MyLanguage.getString("Disassemble"));
		}
		return jDisassemble32MenuItem;
	}

	private void jDisassemble32MenuItemActionPerformed(ActionEvent evt) {
		this.jInstructionComboBox.setSelectedItem(currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1);
		jDisassembleButtonActionPerformed(null);
		jTabbedPane1.setSelectedIndex(0);
	}

	private JPanel getJELFBreakpointPanel() {
		if (jELFBreakpointPanel == null) {
			jELFBreakpointPanel = new JPanel();
			BorderLayout jELFBreakpointPanelLayout = new BorderLayout();
			jELFBreakpointPanel.setLayout(jELFBreakpointPanelLayout);
			jELFBreakpointPanel.add(getJPanel23(), BorderLayout.NORTH);
			jELFBreakpointPanel.add(getJScrollPane14(), BorderLayout.CENTER);
			jELFBreakpointPanel.add(getJPanel24(), BorderLayout.SOUTH);
		}
		return jELFBreakpointPanel;
	}

	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jPanel23 = new JPanel();
			FlowLayout jPanel23Layout = new FlowLayout();
			jPanel23.setLayout(jPanel23Layout);
			jPanel23.add(getJELFFileComboBox());
			jPanel23.add(getJOpenELFButton());
			jPanel23.add(getJShowELFByteCheckBox());
		}
		return jPanel23;
	}

	private JButton getJOpenELFButton() {
		if (jOpenELFButton == null) {
			jOpenELFButton = new JButton();
			jOpenELFButton.setText("Open ELF");
			jOpenELFButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jOpenELFButtonActionPerformed(evt);
				}
			});
		}
		return jOpenELFButton;
	}

	private JComboBox getJELFFileComboBox() {
		if (jELFFileComboBox == null) {
			ComboBoxModel jELFFileComboBoxModel = new DefaultComboBoxModel();
			jELFFileComboBox = new JComboBox();
			jELFFileComboBox.setModel(jELFFileComboBoxModel);
			jELFFileComboBox.setPreferredSize(new java.awt.Dimension(163, 26));
			jELFFileComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFFileComboBoxActionPerformed(evt);
				}
			});
		}
		return jELFFileComboBox;
	}

	private JScrollPane getJScrollPane14() {
		if (jScrollPane14 == null) {
			jScrollPane14 = new JScrollPane();
			jScrollPane14.setViewportView(getJELFTable());
		}
		return jScrollPane14;
	}

	private JTable getJELFTable() {
		if (jELFTable == null) {
			jELFTable = new JTable();
			jELFTable.setModel(new JSourceCodeTableModel());
			jELFTable.getColumnModel().getColumn(0).setCellRenderer(new JSourceCodeCellRenderer());
			jELFTable.getColumnModel().getColumn(3).setCellRenderer(new JSourceCodeCellRenderer());
			jELFTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jELFTable.getColumnModel().getColumn(0).setPreferredWidth(20);
			jELFTable.getColumnModel().getColumn(1).setPreferredWidth(30);
			jELFTable.getColumnModel().getColumn(2).setPreferredWidth(80);
			jELFTable.getColumnModel().getColumn(3).setPreferredWidth(300);
			jELFTable.getTableHeader().setReorderingAllowed(false);
			jELFTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jELFTableMouseClicked(evt);
				}
			});
		}
		return jELFTable;
	}

	private void jOpenELFButtonActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(Setting.getInstance().getLastElfHistoryOpenDir()));

		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			openELF(fc.getSelectedFile());
			parseELF(fc.getSelectedFile());
		}
	}

	private void openELF(File file) {
		String lines = ElfUtil.getDebugLine(file);
		String filenames[] = lines.split("\n")[0].split(",");
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		model.setDebugLine(lines);

		for (int x = 0; x < filenames.length; x++) {
			// find source file
			Collection<File> found = FileUtils.listFiles(file.getParentFile(), FileFilterUtils.nameFileFilter(filenames[x]), TrueFileFilter.INSTANCE);
			if (found.size() == 0) {
				this.jELFFileComboBox.addItem(file.getName() + " - " + filenames[x] + " (missing)");
			} else {
				File foundFile = (File) found.toArray()[0];

				// read source code
				try {
					List<String> list = FileUtils.readLines(foundFile);
					model.getSourceCodes().put(foundFile.getName(), list);
				} catch (IOException e) {
					e.printStackTrace();
				}

				this.jELFFileComboBox.addItem(file.getName() + " - " + foundFile.getAbsolutePath().substring(file.getParent().length()));
				// end read source code
			}
			// end find source file
		}
		jELFFileComboBoxActionPerformed(null);

		model.updateBreakpoint(getRealEIP());

		// save history
		Setting.getInstance().setLastElfHistoryOpenDir(file.getParentFile().getAbsolutePath());
		Setting.getInstance().save();
		// end save history
	}

	private void jELFFileComboBoxActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		model.setCurrentFile(new File(jELFFileComboBox.getSelectedItem().toString().split("-")[1]).getName());
	}

	private JPanel getJPanel24() {
		if (jPanel24 == null) {
			jPanel24 = new JPanel();
			jPanel24.add(getJRefreshButton());
			jPanel24.add(getJEnableELFBreakpointButton());
			jPanel24.add(getJDisableELFBreakpointButton());
			jPanel24.add(getJSaveELFBreakpointButton());
			jPanel24.add(getJLoadELFBreakpointButton());
		}
		return jPanel24;
	}

	private JButton getJRefreshButton() {
		if (jRefreshELFBreakpointButton == null) {
			jRefreshELFBreakpointButton = new JButton();
			jRefreshELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshELFBreakpointButtonActionPerformed(evt);
				}
			});
			jRefreshELFBreakpointButton.setText(MyLanguage.getString("Refresh"));
		}
		return jRefreshELFBreakpointButton;
	}

	private JButton getJEnableELFBreakpointButton() {
		if (jEnableELFBreakpointButton == null) {
			jEnableELFBreakpointButton = new JButton();
			jEnableELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jEnableELFBreakpointButtonActionPerformed(evt);
				}
			});
			jEnableELFBreakpointButton.setText(MyLanguage.getString("Enable"));
		}
		return jEnableELFBreakpointButton;
	}

	private JButton getJDisableELFBreakpointButton() {
		if (jDisableELFBreakpointButton == null) {
			jDisableELFBreakpointButton = new JButton();
			jDisableELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDisableELFBreakpointButtonActionPerformed(evt);
				}
			});
			jDisableELFBreakpointButton.setText(MyLanguage.getString("Disable"));
		}
		return jDisableELFBreakpointButton;
	}

	private JButton getJSaveELFBreakpointButton() {
		if (jSaveELFBreakpointButton == null) {
			jSaveELFBreakpointButton = new JButton();
			jSaveELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSaveELFBreakpointButtonActionPerformed(evt);
				}
			});
			jSaveELFBreakpointButton.setText(MyLanguage.getString("Save"));
		}
		return jSaveELFBreakpointButton;
	}

	private JButton getJLoadELFBreakpointButton() {
		if (jLoadELFBreakpointButton == null) {
			jLoadELFBreakpointButton = new JButton();
			jLoadELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jLoadELFBreakpointButtonActionPerformed(evt);
				}
			});
			jLoadELFBreakpointButton.setText(MyLanguage.getString("Load"));
		}
		return jLoadELFBreakpointButton;
	}

	private void jRefreshELFBreakpointButtonActionPerformed(ActionEvent evt) {
		if (Global.debug) {
			JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();

			model.updateBreakpoint(getRealEIP());
		}
	}

	private long getRealEIP() {
		try {
			long eip;
			if (CommonLib.getBit(CommonLib.convertFilesize(jRegisterPanel1.jCR0TextField.getText()), 0) == 1) {
				eip = CommonLib.convertFilesize(jRegisterPanel1.jEIPTextField.getText());
			} else {
				eip = CommonLib.convertFilesize(jRegisterPanel1.jCSTextField.getText()) * 16 + CommonLib.convertFilesize(jRegisterPanel1.jEIPTextField.getText());
			}
			return eip;
		} catch (Exception ex) {
			return 0;
		}
	}

	private void jEnableELFBreakpointButtonActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());

		for (int x = 0; x < jBreakpointTable.getRowCount(); x++) {
			long addr = CommonLib.convertFilesize(jBreakpointTable.getValueAt(x, 2).toString());
			if (addr == address) {
				String breakpointNo = jBreakpointTable.getValueAt(x, 0).toString().trim().split(" ")[0];
				sendCommand("bpe " + breakpointNo);

				model.updateBreakpoint(getRealEIP());
				this.updateBreakpoint();
				return;
			}
		}
	}

	private void jDisableELFBreakpointButtonActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());

		for (int x = 0; x < jBreakpointTable.getRowCount(); x++) {
			long addr = CommonLib.convertFilesize(jBreakpointTable.getValueAt(x, 2).toString());
			if (addr == address) {
				String breakpointNo = jBreakpointTable.getValueAt(x, 0).toString().trim().split(" ")[0];
				sendCommand("bpd " + breakpointNo);

				model.updateBreakpoint(getRealEIP());
				this.updateBreakpoint();
				return;
			}
		}
	}

	private void jSaveELFBreakpointButtonActionPerformed(ActionEvent evt) {
		this.jSaveBreakpointButtonActionPerformed(null);
	}

	private void jLoadELFBreakpointButtonActionPerformed(ActionEvent evt) {
		this.jLoadBreakpointButtonActionPerformed(null);
	}

	private void jELFTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jELFTable.rowAtPoint(p);
			int columnNumber = jELFTable.columnAtPoint(p);
			ListSelectionModel model = jELFTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jELFTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJELFTablePopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPanel getJPanel25() {
		if (jPanel25 == null) {
			jPanel25 = new JPanel();
			FlowLayout jPanel25Layout = new FlowLayout();
			jPanel25Layout.setHgap(0);
			jPanel25Layout.setVgap(0);
			jPanel25Layout.setAlignment(FlowLayout.LEFT);
			jPanel25.setLayout(jPanel25Layout);
			{
				jStatusLabel = new JLabel();
				jPanel25.add(jStatusLabel);
				jStatusLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
				jStatusLabel.setForeground(new java.awt.Color(255, 0, 0));
			}
			jPanel25.add(getJCPUModeLabel());
			jPanel25.add(getJBochsVersionLabel());
			jPanel25.add(getJLatestVersionLabel());
		}
		return jPanel25;
	}

	private JLabel getJCPUModeLabel() {
		if (jCPUModeLabel == null) {
			jCPUModeLabel = new JLabel();
		}
		return jCPUModeLabel;
	}

	private JCheckBox getJShowELFByteCheckBox() {
		if (jShowELFByteCheckBox == null) {
			jShowELFByteCheckBox = new JCheckBox();
			jShowELFByteCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jShowELFByteCheckBoxActionPerformed(evt);
				}
			});
			jShowELFByteCheckBox.setText(MyLanguage.getString("Bytes"));
		}
		return jShowELFByteCheckBox;
	}

	private void jShowELFByteCheckBoxActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		model.showBytes(jShowELFByteCheckBox.isSelected());
	}

	private JLabel getJBochsVersionLabel() {
		if (jBochsVersionLabel == null) {
			jBochsVersionLabel = new JLabel();
		}
		return jBochsVersionLabel;
	}

	private JLabel getJLatestVersionLabel() {
		if (jLatestVersionLabel == null) {
			jLatestVersionLabel = new JLabel();
			jLatestVersionLabel.setForeground(Color.green);
			jLatestVersionLabel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jLatestVersionLabelMouseClicked(evt);
				}
			});
		}
		return jLatestVersionLabel;
	}

	private void jLatestVersionLabelMouseClicked(MouseEvent evt) {
		if (!jLatestVersionLabel.getText().equals("")) {
			try {
				// java.awt.Desktop.getDesktop().browse(new
				// URI(jLatestVersionLabel.getText().split(MyLanguage.getString("Download_url")
				// + " : ")[1]));
				java.awt.Desktop.getDesktop().browse(new URI(latestVersionURL));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void thisWindowActivated(WindowEvent evt) {

	}

	private JPanel getJELFDumpScrollPane() {
		if (jELFDumpPanel == null) {
			jELFDumpPanel = new JPanel();
			BorderLayout jELFDumpPanelLayout = new BorderLayout();
			jELFDumpPanel.setLayout(jELFDumpPanelLayout);
			jELFDumpPanel.add(getJPanel26(), BorderLayout.NORTH);
			jELFDumpPanel.add(getJTabbedPane4(), BorderLayout.CENTER);
		}
		return jELFDumpPanel;
	}

	private JToolBar getJPanel26() {
		if (jPanel26 == null) {
			jPanel26 = new JToolBar();
			FlowLayout jPanel26Layout = new FlowLayout();
			jPanel26Layout.setAlignment(FlowLayout.LEFT);
			jPanel26.add(getJELFComboBox());
			jPanel26.add(getJButton16x());
		}
		return jPanel26;
	}

	private JComboBox getJELFComboBox() {
		if (jELFComboBox == null) {
			ComboBoxModel jELFComboBoxModel = new DefaultComboBoxModel(new String[] {});
			jELFComboBox = new JComboBox();
			jELFComboBox.setModel(jELFComboBoxModel);
			jELFComboBox.setMaximumSize(new java.awt.Dimension(400, 30));
			jELFComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFComboBoxActionPerformed(evt);
				}
			});
		}
		return jELFComboBox;
	}

	private JButton getJButton16x() {
		if (jOpenELFDumpButton == null) {
			jOpenELFDumpButton = new JButton();
			jOpenELFDumpButton.setText("Open ELF");
			jOpenELFDumpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jOpenELFDumpButtonActionPerformed(evt);
				}
			});
		}
		return jOpenELFDumpButton;
	}

	private JTabbedPane getJTabbedPane4() {
		if (jTabbedPane4 == null) {
			jTabbedPane4 = new JMaximizableTabbedPane();
			jTabbedPane4.addTab("Header", null, getJELFHeaderScrollPane(), null);
			jTabbedPane4.addTab("Section", null, getJScrollPane15(), null);
			jTabbedPane4.addTab("Program header", null, getJScrollPane16(), null);
			jTabbedPane4.addTab("objdump", null, getObjdump(), null);
			jTabbedPane4.addTab(".rel.plt", null, getJPanel28(), null);
			jTabbedPane4.addTab(".dynamic", null, getJPanel29(), null);
		}
		return jTabbedPane4;
	}

	private JScrollPane getJELFHeaderScrollPane() {
		if (jELFHeaderScrollPane == null) {
			jELFHeaderScrollPane = new JScrollPane();
			jELFHeaderScrollPane.setViewportView(getJELFHeaderTable());
		}
		return jELFHeaderScrollPane;
	}

	private JTable getJELFHeaderTable() {
		if (jELFHeaderTable == null) {
			TableModel jELFHeaderTableModel = new DefaultTableModel(null, new String[] { MyLanguage.getString("Field"), MyLanguage.getString("Value") });
			jELFHeaderTable = new JTable();
			jELFHeaderTable.setModel(jELFHeaderTableModel);
		}
		return jELFHeaderTable;
	}

	private void jOpenELFDumpButtonActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		// load history
		fc.setCurrentDirectory(new File(Setting.getInstance().getLastElfHistoryOpenDir2()));

		// end load history
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			jELFComboBox.addItem(file);

			parseELF(file);
			openELF(file);
			// save history
			Setting.getInstance().setLastElfHistoryOpenDir2(file.getParentFile().getAbsolutePath());
			Setting.getInstance().save();
			// end save history
		}
	}

	private void parseELF(File elfFile) {
		jELFDumpPanel.remove(jTabbedPane4);
		jTabbedPane4 = null;
		jELFDumpPanel.add(getJTabbedPane4(), BorderLayout.CENTER);

		HashMap map = ElfUtil.getELFDetail(elfFile);
		if (map != null) {
			// header
			DefaultTableModel model = (DefaultTableModel) jELFHeaderTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			Set entries = ((HashMap) map.get("header")).entrySet();
			Iterator it = entries.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();

				Vector<String> v = new Vector<String>();
				v.add(entry.getKey().toString());

				String bytesStr = "";

				if (entry.getValue().getClass() == Short.class) {
					jStatusLabel.setText("header " + Long.toHexString((Short) entry.getValue()));
					bytesStr += "0x" + Long.toHexString((Short) entry.getValue());
				} else if (entry.getValue().getClass() == Integer.class) {
					bytesStr += "0x" + Long.toHexString((Integer) entry.getValue());
				} else if (entry.getValue().getClass() == Long.class) {
					bytesStr += "0x" + Long.toHexString((Long) entry.getValue());
				} else {
					int b[] = (int[]) entry.getValue();
					for (int x = 0; x < b.length; x++) {
						bytesStr += "0x" + Long.toHexString(b[x]) + " ";
					}
				}

				v.add(bytesStr);
				model.addRow(v);
			}
			// end header

			// section
			model = (DefaultTableModel) jELFSectionTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			int sectionNo = 0;
			while (map.get("section" + sectionNo) != null) {
				entries = ((HashMap) map.get("section" + sectionNo)).entrySet();
				it = entries.iterator();
				Vector<String> v = new Vector<String>();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();

					String bytesStr = "";
					if (entry.getValue().getClass() == Short.class) {
						jStatusLabel.setText("section " + Long.toHexString((Short) entry.getValue()));
						bytesStr += "0x" + Long.toHexString((Short) entry.getValue());
					} else if (entry.getValue().getClass() == Integer.class) {
						bytesStr += "0x" + Long.toHexString((Integer) entry.getValue());
					} else if (entry.getValue().getClass() == String.class) {
						bytesStr = (String) entry.getValue();
					} else if (entry.getValue().getClass() == Long.class) {
						bytesStr += "0x" + Long.toHexString((Long) entry.getValue());
					} else {
						int b[] = (int[]) entry.getValue();
						for (int x = 0; x < b.length; x++) {
							bytesStr += "0x" + Long.toHexString(b[x]) + " ";
						}
					}

					v.add(bytesStr);
				}
				model.addRow(v);
				sectionNo++;
			}
			// end section

			// program header
			model = (DefaultTableModel) jProgramHeaderTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			int programHeaderNo = 0;
			while (map.get("programHeader" + programHeaderNo) != null) {
				entries = ((HashMap) map.get("programHeader" + programHeaderNo)).entrySet();
				it = entries.iterator();
				Vector<String> v = new Vector<String>();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();

					String bytesStr = "";
					if (entry.getValue().getClass() == Short.class) {
						jStatusLabel.setText("Program header " + Long.toHexString((Short) entry.getValue()));
						bytesStr += "0x" + Long.toHexString((Short) entry.getValue());
					} else if (entry.getValue().getClass() == Integer.class) {
						bytesStr += "0x" + Long.toHexString((Integer) entry.getValue());
					} else if (entry.getValue().getClass() == Long.class) {
						bytesStr += "0x" + Long.toHexString((Long) entry.getValue());
					} else if (entry.getValue().getClass() == String.class) {
						bytesStr += "0x" + entry.getValue();
					} else {
						int b[] = (int[]) entry.getValue();
						for (int x = 0; x < b.length; x++) {
							bytesStr += "0x" + Long.toHexString(b[x]) + " ";
						}
					}

					v.add(bytesStr);
				}
				model.addRow(v);
				programHeaderNo++;
			}
			// program header

			// symbol table
			int symbolTableNo = 0;
			while (map.get("symbolTable" + symbolTableNo) != null) {
				DefaultTableModel tempTableModel = new DefaultTableModel(null, new String[] { "No.", "st_name", "st_value", "st_size", "st_info", "st_other", "p_st_shndx" });
				JTable tempTable = new JTable();
				HashMap tempMap = (HashMap) map.get("symbolTable" + symbolTableNo);
				Vector<LinkedHashMap> v = (Vector<LinkedHashMap>) tempMap.get("vector");
				for (int x = 0; x < v.size(); x++) {
					Vector tempV = new Vector();
					jStatusLabel.setText("Symbol table " + x);
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("No.")));
					tempV.add(v.get(x).get("st_name"));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("st_value")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("st_size")));
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("st_info")));
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("st_other")));
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("p_st_shndx")));

					tempTableModel.addRow(tempV);
				}

				tempTable.setModel(tempTableModel);
				JScrollPane tempScrollPane = new JScrollPane();
				tempScrollPane.setViewportView(tempTable);
				jTabbedPane4.addTab(tempMap.get("name").toString(), null, tempScrollPane, null);

				symbolTableNo++;
			}
			// end symbol table

			// note
			int noteSectionNo = 0;
			while (map.get("note" + noteSectionNo) != null) {
				DefaultTableModel tempTableModel = new DefaultTableModel(null, new String[] { "No.", "namesz", "descsz", "type", "name", "desc" });
				JTable tempTable = new JTable();
				HashMap tempMap = (HashMap) map.get("note" + noteSectionNo);
				Vector<LinkedHashMap> v = (Vector<LinkedHashMap>) tempMap.get("vector");
				for (int x = 0; x < v.size(); x++) {
					Vector tempV = new Vector();
					jStatusLabel.setText("Note " + x);
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("No.")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("namesz")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("descsz")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("type")));
					tempV.add(v.get(x).get("name"));
					tempV.add(v.get(x).get("desc"));

					tempTableModel.addRow(tempV);
				}

				tempTable.setModel(tempTableModel);
				JScrollPane tempScrollPane = new JScrollPane();
				tempScrollPane.setViewportView(tempTable);
				jTabbedPane4.addTab(tempMap.get("name").toString(), null, tempScrollPane, null);

				noteSectionNo++;
			}
			// end note
		}

		try {
			jStatusLabel.setText("running objdump -DS");
			Process process = Runtime.getRuntime().exec("objdump -DS " + elfFile.getAbsolutePath());
			InputStream input = process.getInputStream();
			String str = "";
			byte b[] = new byte[102400];
			int len;
			while ((len = input.read(b)) > 0) {
				str += new String(b, 0, len);
			}
			jEditorPane1.setText(str);

			jStatusLabel.setText("readelf -r");
			process = Runtime.getRuntime().exec("readelf -r " + elfFile.getAbsolutePath());
			input = process.getInputStream();
			str = "";
			b = new byte[102400];
			while ((len = input.read(b)) > 0) {
				str += new String(b, 0, len);
			}
			jSearchRelPltEditorPane.setText(str);

			jStatusLabel.setText("readelf -d");
			process = Runtime.getRuntime().exec("readelf -d " + elfFile.getAbsolutePath());
			input = process.getInputStream();
			str = "";
			b = new byte[102400];
			while ((len = input.read(b)) > 0) {
				str += new String(b, 0, len);
			}
			input.close();
			jSearchDynamicEditorPane.setText(str);

			jStatusLabel.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// end symbol table
	}

	private void jELFComboBoxActionPerformed(ActionEvent evt) {
		parseELF((File) jELFComboBox.getSelectedItem());
	}

	private void thisWindowOpened(WindowEvent evt) {
		if (Global.debug) {
			System.out.println("updateBochsStatus");
		}
		updateBochsStatus(true);
		if (Global.debug) {
			System.out.println("updateBochsStatus end");
		}
	}

	private JScrollPane getJScrollPane15() {
		if (jScrollPane15 == null) {
			jScrollPane15 = new JScrollPane();
			jScrollPane15.setViewportView(getJSectionTable());
		}
		return jScrollPane15;
	}

	private JTable getJSectionTable() {
		if (jELFSectionTable == null) {
			TableModel jSectionTableModel = new DefaultTableModel(null, new String[] { "No.", "sh_name", "sh_type", "sh_flags", "sh_addr", "sh_offset", "sh_size", "sh_link",
					"sh_info", "sh_addralign", "sh_entsize" });
			jELFSectionTable = new JTable();
			jELFSectionTable.setModel(jSectionTableModel);
			jELFSectionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return jELFSectionTable;
	}

	private JScrollPane getJScrollPane16() {
		if (jScrollPane16 == null) {
			jScrollPane16 = new JScrollPane();
			jScrollPane16.setViewportView(getJProgramHeaderTable());
		}
		return jScrollPane16;
	}

	private JTable getJProgramHeaderTable() {
		if (jProgramHeaderTable == null) {
			TableModel jProgramHeaderTableModel = new DefaultTableModel(null, new String[] { "No.", "p_type", "p_offset", "p_vaddr", "p_filesz", "p_memsz", "p_flags", "p_align" });
			jProgramHeaderTable = new JTable();
			jProgramHeaderTable.setModel(jProgramHeaderTableModel);
			jProgramHeaderTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return jProgramHeaderTable;
	}

	private JButton getJButton19() {
		if (jButton19 == null) {
			jButton19 = new JButton();
			jButton19.setText("Delete");
			jButton19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/cross.png")));
			jButton19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton19ActionPerformed(evt);
				}
			});
		}
		return jButton19;
	}

	private void jButton19ActionPerformed(ActionEvent evt) {
		int rows[] = jAddressTranslateTable2.getSelectedRows();
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();
		model.removeRow(rows);
	}

	private JButton getJButton20() {
		if (jButton20 == null) {
			jButton20 = new JButton();
			jButton20.setText("Dump CR3");
			jButton20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDumpCR3ButtonActionPerformed(evt);
				}
			});
		}
		return jButton20;
	}

	private JButton getJButton21() {
		if (jDumpPageTableAtAddressButton == null) {
			jDumpPageTableAtAddressButton = new JButton();
			jDumpPageTableAtAddressButton.setText("Dump at here");
			jDumpPageTableAtAddressButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDumpPageTableAtAddressButtonActionPerformed(evt);
				}
			});
		}
		return jDumpPageTableAtAddressButton;
	}

	private JTextField getJDumpPageDirectoryAddressTextField() {
		if (jDumpPageDirectoryAddressTextField == null) {
			jDumpPageDirectoryAddressTextField = new JTextField();
			jDumpPageDirectoryAddressTextField.setMaximumSize(new java.awt.Dimension(150, 28));
			jDumpPageDirectoryAddressTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jDumpPageDirectoryAddressTextFieldKeyTyped(evt);
				}
			});
		}
		return jDumpPageDirectoryAddressTextField;
	}

	private void jDumpCR3ButtonActionPerformed(ActionEvent evt) {
		updatePageTable(CommonLib.convertFilesize(jRegisterPanel1.jCR3TextField.getText()));
	}

	private void jDumpPageTableAtAddressButtonActionPerformed(ActionEvent evt) {
		updatePageTable(CommonLib.convertFilesize(jDumpPageDirectoryAddressTextField.getText()));
	}

	private JButton getJButton21x() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jButton21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton21ActionPerformed(evt);
				}
			});
		}
		return jButton21;
	}

	private void jButton21ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, this.jPageDirectoryTable.getModel(), this.jPageTableTable.getModel(), jMemoryAddressComboBox.getSelectedItem()
					.toString());
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(jHistoryTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton17ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(jAddressTranslateTable2, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton18ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, this.jAddressTranslateTable2.getModel(), jMemoryAddressComboBox.getSelectedItem().toString());
		}
	}

	private void jDumpPageDirectoryAddressTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jDumpPageTableAtAddressButtonActionPerformed(null);
		}
	}

	private void jAddressTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jRefreshAddressTranslateButtonActionPerformed(null);
		}
	}

	private JButton getJClearBochsButton() {
		if (jClearBochsButton == null) {
			jClearBochsButton = new JButton();
			jClearBochsButton.setText(MyLanguage.getString("Clear"));
			jClearBochsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jClearBochsButtonActionPerformed(evt);
				}
			});
		}
		return jClearBochsButton;
	}

	private void jClearBochsButtonActionPerformed(ActionEvent evt) {
		this.jBochsEditorPane.setText("");
	}

	public static int[] getPhysicalMemory(long address, int totalByte) {
		return getMemory(address, totalByte, true);
	}

	public static int[] getLinearMemory(long address, int totalByte) {
		return getMemory(address, totalByte, false);
	}

	public static int[] getMemory(long address, int totalByte, boolean isPhysicalAddress) {
		try {
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			if (isPhysicalAddress) {
				sendCommand("xp /" + totalByte + "bx " + address);
			} else {
				sendCommand("x /" + totalByte + "bx " + address);
			}
			int bytes[] = new int[totalByte];

			if (totalByte > 0) {
				float totalByte2 = totalByte - 1;
				totalByte2 = totalByte2 / 8;
				int totalByte3 = (int) Math.floor(totalByte2);
				String realEndAddressStr;
				String realStartAddressStr;
				long realStartAddress = address;
				realStartAddressStr = String.format("%08x", realStartAddress);
				long realEndAddress = realStartAddress + totalByte3 * 8;
				realEndAddressStr = String.format("%08x", realEndAddress);
				String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
				if (result != null) {
					String[] lines = result.split("\n");
					int offset = 0;
					// System.out.println(result);
					for (int y = 0; y < lines.length; y++) {
						String[] b = lines[y].replaceFirst("^.*:", "").split("\t");
						// System.out.println(lines[y]);

						for (int x = 1; x < b.length && offset < totalByte; x++) {
							// System.out.println(offset + "==" + x);
							bytes[offset] = (int) CommonLib.convertFilesize(b[x]);
							offset++;
						}
					}
				}
			}
			return bytes;
		} catch (OutOfMemoryError ex) {
			System.gc();
			ex.printStackTrace();
			return null;
		}

	}

	private static String getMemoryStr(long address, int totalByte, boolean isPhysicalAddress) {
		int bytes[] = getMemory(address, totalByte, isPhysicalAddress);
		String str = "";
		for (int x = 0; x < bytes.length; x++) {
			str += (char) bytes[x];
		}
		return str;
	}

	private JButton getJGoLinearButton() {
		if (jGoLinearButton == null) {
			jGoLinearButton = new JButton();
			jGoLinearButton.setText("Lin");
			jGoLinearButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGoLinearButtonActionPerformed(evt);
				}
			});
			jGoLinearButton.setToolTipText(MyLanguage.getString("Linear_address"));
		}
		return jGoLinearButton;
	}

	private void jGoLinearButtonActionPerformed(ActionEvent evt) {
		updateMemory(false);

		addMemoryAddressComboBox(jMemoryAddressComboBox.getSelectedItem().toString());
		Setting.getInstance().memoryCombo.add(jMemoryAddressComboBox.getSelectedItem().toString());
		Setting.getInstance().save();
	}

	private DiskPanel getDiskPanel() {
		if (diskPanel == null) {
			diskPanel = new DiskPanel();
			try {
				String line = PeterBochsCommonLib.findLineInFile(new File(bochsrc), "ata0-master");
				if (line != null) {
					String strs[] = line.split(",");
					for (String str : strs) {
						if (str.toLowerCase().contains("path=")) {
							String filename = str.split("=")[1];
							filename = filename.replaceAll("\"", "");
							File file = new File(filename);
							if (file.exists()) {
								diskPanel.setFile(new File(filename));
							}
							break;
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return diskPanel;
	}

	private JMaximizableTabbedPane_BasePanel getJMaximizableTabbedPane_BasePanel1() {
		if (jMaximizableTabbedPane_BasePanel1 == null) {
			jMaximizableTabbedPane_BasePanel1 = new JMaximizableTabbedPane_BasePanel();
			jMaximizableTabbedPane_BasePanel1.add(getJSplitPane2(), "MAIN");
		}
		return jMaximizableTabbedPane_BasePanel1;
	}

	private JCheckBox getJHideIfAddressIsZeroCheckBox() {
		if (jHideIfAddressIsZeroCheckBox == null) {
			jHideIfAddressIsZeroCheckBox = new JCheckBox();
			jHideIfAddressIsZeroCheckBox.setText("Hide if address = 0");
			jHideIfAddressIsZeroCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jHideIfAddressIsZeroCheckBoxActionPerformed(evt);
				}
			});
		}
		return jHideIfAddressIsZeroCheckBox;
	}

	private void jHideIfAddressIsZeroCheckBoxActionPerformed(ActionEvent evt) {
		((PageDirectoryTableModel) jPageDirectoryTable.getModel()).setShowZeroAddress(!jHideIfAddressIsZeroCheckBox.isSelected());
		((PageTableTableModel) jPageTableTable.getModel()).setShowZeroAddress(!jHideIfAddressIsZeroCheckBox.isSelected());
	}

	private JPopupMenu getJInstructionPanelPopupMenu() {
		if (jInstructionPanelPopupMenu == null) {
			jInstructionPanelPopupMenu = new JPopupMenu();
			jInstructionPanelPopupMenu.add(getJSetPhysicalBreakpointMenuItem());
			jInstructionPanelPopupMenu.add(getJSetLinearBreakpointMenuItem());
			jInstructionPanelPopupMenu.add(getJSeparator3());
			jInstructionPanelPopupMenu.add(getJShowInSourceCodeMenuItem());
			jInstructionPanelPopupMenu.add(getJWhereIsHereMenuItem());
		}
		return jInstructionPanelPopupMenu;
	}

	/**
	 * Auto-generated method for setting the popup menu for a component
	 */
	private void setComponentPopupMenu(final java.awt.Component parent, final javax.swing.JPopupMenu menu) {
		parent.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}

			public void mouseReleased(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}
		});
	}

	private JMenuItem getJSetPhysicalBreakpointMenuItem() {
		if (jSetPhysicalBreakpointMenuItem == null) {
			jSetPhysicalBreakpointMenuItem = new JMenuItem();
			jSetPhysicalBreakpointMenuItem.setText("Set physical breakpoint here");
			jSetPhysicalBreakpointMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSetPhysicalBreakpointMenuItemActionPerformed(evt);
				}
			});
		}
		return jSetPhysicalBreakpointMenuItem;
	}

	private JMenuItem getJSetLinearBreakpointMenuItem() {
		if (jSetLinearBreakpointMenuItem == null) {
			jSetLinearBreakpointMenuItem = new JMenuItem();
			jSetLinearBreakpointMenuItem.setText("Set linear breakpoint here");
			jSetLinearBreakpointMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSetLinearBreakpointMenuItemActionPerformed(evt);
				}
			});
		}
		return jSetLinearBreakpointMenuItem;
	}

	public void jInstructionTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			JTable jTable = (JTable) evt.getSource();

			if (jTable == jInstructionTable) {
				Global.clickedWhichInstructionPanel = 0;
			} else {
				Global.clickedWhichInstructionPanel = 1;
			}

			// select
			Point p = evt.getPoint();
			int rowNumber = jTable.rowAtPoint(p);
			int columnNumber = jTable.columnAtPoint(p);
			ListSelectionModel model = jTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);

			jTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJInstructionPanelPopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private void jSetPhysicalBreakpointMenuItemActionPerformed(ActionEvent evt) {
		if (jRegisterToggleButton.isSelected()) {
			JInstructionTableModel model = (JInstructionTableModel) jInstructionTable.getModel();
			Application.sendCommand("pb " + model.getMemoryAddress(jInstructionTable.getSelectedRow()));
		} else if (this.jSourceLevelDebuggerButton.isSelected()) {
			JInstructionTableModel model = (JInstructionTableModel) sourceLevelDebugger.jAssemblyTable.getModel();
			Application.sendCommand("pb " + model.getMemoryAddress(sourceLevelDebugger.jAssemblyTable.getSelectedRow()));
		}
		this.updateBreakpoint();
		this.updateInstruction(null);
	}

	private void jSetLinearBreakpointMenuItemActionPerformed(ActionEvent evt) {
		if (jRegisterToggleButton.isSelected()) {
			Application.sendCommand("lb " + Application.jInstructionTable.getValueAt(Application.jInstructionTable.getSelectedRow(), 1));
		} else if (this.jSourceLevelDebuggerButton.isSelected()) {
			Application.sendCommand("lb " + this.sourceLevelDebugger.jAssemblyTable.getValueAt(this.sourceLevelDebugger.jAssemblyTable.getSelectedRow(), 1));
		}
		this.updateBreakpoint();
		this.updateInstruction(null);
	}

	private void jBreakpointTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jBreakpointTable.rowAtPoint(p);
			int columnNumber = jBreakpointTable.columnAtPoint(p);
			ListSelectionModel model = jBreakpointTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jBreakpointTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJBreakpointPopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPopupMenu getJBreakpointPopupMenu() {
		if (jBreakpointPopupMenu == null) {
			jBreakpointPopupMenu = new JPopupMenu();
			jBreakpointPopupMenu.add(getJMenuItem6x());
			jBreakpointPopupMenu.add(getJMenuItem7x());
		}
		return jBreakpointPopupMenu;
	}

	private JMenuItem getJMenuItem6x() {
		if (jMenuItem6 == null) {
			jMenuItem6 = new JMenuItem();
			jMenuItem6.setText("Dump here");
			jMenuItem6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem6ActionPerformed(evt);
				}
			});
		}
		return jMenuItem6;
	}

	private JMenuItem getJMenuItem7x() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText(MyLanguage.getString("Disassemble"));
			jMenuItem7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem7ActionPerformed(evt);
				}
			});
		}
		return jMenuItem7;
	}

	private void jMenuItem6ActionPerformed(ActionEvent evt) {
		this.jMemoryAddressComboBox.setSelectedItem(this.jBreakpointTable.getValueAt(this.jBreakpointTable.getSelectedRow(), 2));
		if (this.jBreakpointTable.getValueAt(this.jBreakpointTable.getSelectedRow(), 0).toString().contains("lb")) {
			jGoLinearButtonActionPerformed(null);
		} else {
			jGOMemoryButtonActionPerformed(null);
		}
		jTabbedPane3.setSelectedIndex(0);
	}

	private void jMenuItem7ActionPerformed(ActionEvent evt) {
		this.jInstructionComboBox.setSelectedItem(this.jBreakpointTable.getValueAt(this.jBreakpointTable.getSelectedRow(), 2));
		jDisassembleButtonActionPerformed(null);
		jTabbedPane1.setSelectedIndex(0);
	}

	private void jSearchMemoryTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jSearchMemoryTable.rowAtPoint(p);
			int columnNumber = jSearchMemoryTable.columnAtPoint(p);
			ListSelectionModel model = jSearchMemoryTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jSearchMemoryTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJSearchMemoryTablePopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPopupMenu getJSearchMemoryTablePopupMenu() {
		if (jSearchMemoryTablePopupMenu == null) {
			jSearchMemoryTablePopupMenu = new JPopupMenu();
			jSearchMemoryTablePopupMenu.add(getJMenuItem8());
			jSearchMemoryTablePopupMenu.add(getJMenuItem9());
		}
		return jSearchMemoryTablePopupMenu;
	}

	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Set physical breakpoint here");
			jMenuItem8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem8ActionPerformed(evt);
				}
			});
		}
		return jMenuItem8;
	}

	private JMenuItem getJMenuItem9() {
		if (jMenuItem9 == null) {
			jMenuItem9 = new JMenuItem();
			jMenuItem9.setText("Set linear breakpoint here");
			jMenuItem9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem9ActionPerformed(evt);
				}
			});
		}
		return jMenuItem9;
	}

	private void jMenuItem8ActionPerformed(ActionEvent evt) {
		System.out.println(this.jSearchMemoryTable.getValueAt(this.jSearchMemoryTable.getSelectedRow(), 0));
		Application.sendCommand("pb " + this.jSearchMemoryTable.getValueAt(this.jSearchMemoryTable.getSelectedRow(), 0));
		this.updateBreakpoint();
	}

	private void jMenuItem9ActionPerformed(ActionEvent evt) {
		Application.sendCommand("lb " + this.jSearchMemoryTable.getValueAt(this.jSearchMemoryTable.getSelectedRow(), 0));
		this.updateBreakpoint();
	}

	private JButton getJInstructionUpButton() {
		if (jInstructionUpButton == null) {
			jInstructionUpButton = new JButton();
			jInstructionUpButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_up1.png")));
			jInstructionUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jInstructionUpButtonActionPerformed(evt);
				}
			});
		}
		return jInstructionUpButton;
	}

	private JButton getJButton22() {
		if (jInstructionDownButton == null) {
			jInstructionDownButton = new JButton();
			jInstructionDownButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_down.png")));
			jInstructionDownButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jInstructionDownButtonActionPerformed(evt);
				}
			});
		}
		return jInstructionDownButton;
	}

	public JEditorPane getjBochsEditorPane() {
		return jBochsEditorPane;
	}

	public void jInstructionUpButtonActionPerformed(ActionEvent evt) {
		if (Application.jInstructionTable.getRowCount() > 0) {
			String firstAddress = "";
			int x = 0;
			do {
				firstAddress = Application.jInstructionTable.getValueAt(x, 1).toString().replaceAll("^-*", "").split(":")[0];
				x++;
			} while (!CommonLib.isNumber(firstAddress));
			firstAddress = Long.toHexString(CommonLib.string2decimal(firstAddress) - 1);

			this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
			updateInstruction(CommonLib.string2decimal("0x" + firstAddress));
			updateBreakpointTableColor();
		}
	}

	public void jInstructionDownButtonActionPerformed(ActionEvent evt) {
		try {
			if (Application.jInstructionTable.getRowCount() > 10) {
				String firstAddress = "";
				for (int x = 0, count = 0; count < 10 && x < Application.jInstructionTable.getRowCount(); x++) {
					firstAddress = Application.jInstructionTable.getValueAt(x, 1).toString().split(":")[0];
					if (CommonLib.isNumber(firstAddress)) {
						count++;
					}
				}

				this.jInstructionComboBox.setSelectedItem(firstAddress);
				updateInstruction(CommonLib.string2decimal(firstAddress));
				updateBreakpointTableColor();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private JButton getJInstructionUpTenButton() {
		if (jInstructionUpTenButton == null) {
			jInstructionUpTenButton = new JButton();
			jInstructionUpTenButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_up10.png")));
			jInstructionUpTenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jInstructionUpTenButtonActionPerformed(evt);
				}
			});
		}
		return jInstructionUpTenButton;
	}

	public void jInstructionUpTenButtonActionPerformed(ActionEvent evt) {
		String firstAddress = "";
		int x = 0;
		do {
			firstAddress = Application.jInstructionTable.getValueAt(x, 1).toString().replaceAll("^-*", "").split(":")[0];
			x++;
		} while (!CommonLib.isNumber(firstAddress));
		firstAddress = Long.toHexString(CommonLib.string2decimal(firstAddress) - 16);

		this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
		updateInstruction(CommonLib.string2decimal("0x" + firstAddress));
		updateBreakpointTableColor();
	}

	private JMenuItem getJKRMenuItem() {
		if (jKRMenuItem == null) {
			jKRMenuItem = new JMenuItem();
			jKRMenuItem.setText("Korean");
			jKRMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jKRMenuItemActionPerformed(evt);
				}
			});
		}
		return jKRMenuItem;
	}

	private void jKRMenuItemActionPerformed(ActionEvent evt) {
		changeLanguage("KR");
	}

	private JMenuItem getJJPMenuItem() {
		if (jJPMenuItem == null) {
			jJPMenuItem = new JMenuItem();
			jJPMenuItem.setText("Japanese");
			jJPMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jJPMenuItemActionPerformed(evt);
				}
			});
		}
		return jJPMenuItem;
	}

	private void jJPMenuItemActionPerformed(ActionEvent evt) {
		changeLanguage("JP");
	}

	private void jIDTTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			for (int x = 0; x < jTabbedPane2.getTabCount(); x++) {
				if (jTabbedPane2.getTitleAt(x).equals(("IDT " + String.format("0x%02x", jIDTTable.getSelectedRow())))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			jTabbedPane2.addTabWithCloseButton("IDT " + String.format("0x%02x", jIDTTable.getSelectedRow()), null,
					new IDTDescriptorPanel(this, CommonLib.string2decimal(this.jRegisterPanel1.jIDTRTextField.getText()), jIDTTable.getSelectedRow()), null);
			jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
		}
	}

	private JButton getJFastStepBochsButton() {
		if (jFastStepBochsButton == null) {
			jFastStepBochsButton = new JButton();
			jFastStepBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/step.png")));
			jFastStepBochsButton.setText(MyLanguage.getString("Fast_Step"));
			jFastStepBochsButton
					.setToolTipText("<html><body>A faster step<br><br>It will only update:<br>1) Memory panel<br>2) Instruction panel<br>3) Register panel</body></html>");
			jFastStepBochsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFastStepButtonActionPerformed(evt);
				}
			});
		}
		return jFastStepBochsButton;
	}

	private void jFastStepButtonActionPerformed(ActionEvent evt) {
		try {
			sendCommand("s");
			WebServiceUtil.log("peter-bochs", "fast step", null, null, null);
			Thread updateThread = new Thread("Fast step update thread") {
				public void run() {
					String result = commandReceiver.getCommandResultUntilEnd();

					enableAllButtons(false, false);

					if (Setting.getInstance().updateFastStepCommand_register) {
						if (Global.debug) {
							System.out.println("updateRegister");
						}
						updateRegister();
						if (Global.debug) {
							System.out.println("updateEFlag");
						}
						updateEFlag();
					}

					if (Setting.getInstance().updateFastStepCommand_memory) {
						if (Global.debug) {
							System.out.println("updateMemory");
						}
						updateMemory(true);
					}

					if (Setting.getInstance().updateFastStepCommand_instruction) {
						if (Global.debug) {
							System.out.println("updateInstruction");
						}
						updateInstruction(null);
					}

					if (Setting.getInstance().updateFastStepCommand_breakpoint) {
						if (Global.debug) {
							System.out.println("updateBreakpointTableColor");
						}
						updateBreakpoint();
						updateBreakpointTableColor();
					}

					if (Setting.getInstance().updateFastStepCommand_history) {
						if (Global.debug) {
							System.out.println("updateHistory");
						}
						updateHistoryTable(result);
					}

					jStatusLabel.setText("");

					enableAllButtons(true, false);
				}
			};
			updateThread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private JPopupMenu getJELFTablePopupMenu() {
		if (jELFTablePopupMenu == null) {
			jELFTablePopupMenu = new JPopupMenu();
			jELFTablePopupMenu.add(getJMenuItem1x());
			jELFTablePopupMenu.add(getJMenuItem2x());
		}
		return jELFTablePopupMenu;
	}

	private JMenuItem getJMenuItem1x() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Set linear breakpoint here");
			jMenuItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFLinearBreakpointMenuItemActionPerformed(evt);
				}
			});
		}
		return jMenuItem1;
	}

	private JMenuItem getJMenuItem2x() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Set physical breakpoint here");
			jMenuItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFPhysicalBreakpointMenuItemActionPerformed(evt);
				}
			});
		}
		return jMenuItem2;
	}

	private void jELFLinearBreakpointMenuItemActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		Long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());
		if (address != null) {
			sendCommand("lb 0x" + Long.toHexString(address));

			model.updateBreakpoint(getRealEIP());
			this.updateBreakpoint();
		}
	}

	private void jELFPhysicalBreakpointMenuItemActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		Long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());
		if (address != null) {
			sendCommand("pb 0x" + Long.toHexString(address));

			model.updateBreakpoint(getRealEIP());
			this.updateBreakpoint();
		}
	}

	private JButton getJSettingButton() {
		if (jSettingButton == null) {
			jSettingButton = new JButton();
			jSettingButton.setText(MyLanguage.getString("Setting"));
			jSettingButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/wrench.png")));
			jSettingButton.setToolTipText("System setting");
			jSettingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSettingButtonActionPerformed(evt);
				}
			});
		}
		return jSettingButton;
	}

	private void jSettingButtonActionPerformed(ActionEvent evt) {
		JSettingDialog jSettingDialog = new JSettingDialog(this);
		CommonLib.centerDialog(jSettingDialog);
		jSettingDialog.setVisible(true);
	}

	private JPanel getObjdump() {
		if (objdumpPanel == null) {
			objdumpPanel = new JPanel();
			BorderLayout ObjdumpLayout = new BorderLayout();
			objdumpPanel.setLayout(ObjdumpLayout);
			objdumpPanel.add(getJPanel27(), BorderLayout.NORTH);
			objdumpPanel.add(getJScrollPane17(), BorderLayout.CENTER);
		}
		return objdumpPanel;
	}

	private JToolBar getJPanel27() {
		if (jPanel27 == null) {
			jPanel27 = new JToolBar();
			FlowLayout jPanel27Layout = new FlowLayout();
			jPanel27Layout.setAlignment(FlowLayout.LEFT);
			jPanel27.add(getJTextField1x());
			jPanel27.add(getJSearchObjdumpButton());
		}
		return jPanel27;
	}

	private JTextField getJTextField1x() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setMaximumSize(new java.awt.Dimension(100, 25));
			jTextField1.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextField1KeyTyped(evt);
				}
			});
		}
		return jTextField1;
	}

	private void jTextField1KeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jSearchObjdumpButtonActionPerformed(null);
		}
	}

	private JButton getJSearchObjdumpButton() {
		if (jSearchObjdumpButton == null) {
			jSearchObjdumpButton = new JButton();
			jSearchObjdumpButton.setText("Search");
			jSearchObjdumpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchObjdumpButtonActionPerformed(evt);
				}
			});
		}
		return jSearchObjdumpButton;
	}

	final Highlighter hilit = new DefaultHighlighter();
	final Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.BLUE);

	private void jSearchObjdumpButtonActionPerformed(ActionEvent evt) {
		if (jTextField1.getText().length() > 0) {
			Highlighter h = jEditorPane1.getHighlighter();
			h.removeAllHighlights();
			String text = jEditorPane1.getText().toLowerCase();

			int nextPosition = -1;

			for (int j = 0; j < text.length() - jTextField1.getText().length() + 1; j += 1) {
				if (text.substring(j, j + jTextField1.getText().length()).equals(jTextField1.getText().toLowerCase())) {
					try {
						if (j >= jEditorPane1.getCaretPosition() && nextPosition == -1) {
							h.addHighlight(j, j + jTextField1.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.red));
							nextPosition = j + jTextField1.getText().length();
						} else {
							h.addHighlight(j, j + jTextField1.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
						}
					} catch (BadLocationException ble) {
					}
				}
			}
			if (nextPosition != -1) {
				jEditorPane1.setCaretPosition(nextPosition);
			} else {
				jEditorPane1.setCaretPosition(0);
			}
		}
	}

	private JEditorPane getJEditorPane1() {
		if (jEditorPane1 == null) {
			jEditorPane1 = new JEditorPane();
		}
		return jEditorPane1;
	}

	private JScrollPane getJScrollPane17() {
		if (jScrollPane17 == null) {
			jScrollPane17 = new JScrollPane();
			jScrollPane17.setPreferredSize(new java.awt.Dimension(997, 512));
			jScrollPane17.setViewportView(getJEditorPane1());
		}
		return jScrollPane17;
	}

	private JPanel getJPanel28() {
		if (jPanel28 == null) {
			jPanel28 = new JPanel();
			BorderLayout jPanel28Layout = new BorderLayout();
			jPanel28.setLayout(jPanel28Layout);
			jPanel28.add(getJScrollPane18(), BorderLayout.CENTER);
			jPanel28.add(getJToolBar4(), BorderLayout.NORTH);
		}
		return jPanel28;
	}

	private JScrollPane getJScrollPane18() {
		if (jScrollPane18 == null) {
			jScrollPane18 = new JScrollPane();
			jScrollPane18.setPreferredSize(new java.awt.Dimension(993, 533));
			jScrollPane18.setViewportView(getJEditorPane2());
		}
		return jScrollPane18;
	}

	private JEditorPane getJEditorPane2() {
		if (jSearchRelPltEditorPane == null) {
			jSearchRelPltEditorPane = new JEditorPane();
		}
		return jSearchRelPltEditorPane;
	}

	private JToolBar getJToolBar4() {
		if (jToolBar4 == null) {
			jToolBar4 = new JToolBar();
			jToolBar4.add(getJTextField2());
			jToolBar4.add(getJButton16xx());
		}
		return jToolBar4;
	}

	private JTextField getJTextField2() {
		if (jSearchRelPltTextField == null) {
			jSearchRelPltTextField = new JTextField();
			jSearchRelPltTextField.setMaximumSize(new java.awt.Dimension(100, 25));
			jSearchRelPltTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextField2KeyTyped(evt);
				}
			});
		}
		return jSearchRelPltTextField;
	}

	private JButton getJButton16xx() {
		if (jSearchRelPltButton == null) {
			jSearchRelPltButton = new JButton();
			jSearchRelPltButton.setText("Search");
			jSearchRelPltButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchRelPltButtonActionPerformed(evt);
				}
			});
		}
		return jSearchRelPltButton;
	}

	private void jSearchRelPltButtonActionPerformed(ActionEvent evt) {
		if (jSearchRelPltTextField.getText().length() > 0) {
			Highlighter h = jSearchRelPltEditorPane.getHighlighter();
			h.removeAllHighlights();
			String text = jSearchRelPltEditorPane.getText().toLowerCase();

			int nextPosition = -1;

			for (int j = 0; j < text.length() - jSearchRelPltTextField.getText().length() + 1; j += 1) {
				if (text.substring(j, j + jSearchRelPltTextField.getText().length()).equals(jSearchRelPltTextField.getText().toLowerCase())) {
					try {
						if (j >= jSearchRelPltEditorPane.getCaretPosition() && nextPosition == -1) {
							h.addHighlight(j, j + jSearchRelPltTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.red));
							nextPosition = j + jSearchRelPltTextField.getText().length();
						} else {
							h.addHighlight(j, j + jSearchRelPltTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
						}
					} catch (BadLocationException ble) {
					}
				}
			}
			if (nextPosition != -1) {
				jSearchRelPltEditorPane.setCaretPosition(nextPosition);
			} else {
				jSearchRelPltEditorPane.setCaretPosition(0);
			}
		}
	}

	private JPanel getJPanel29() {
		if (jPanel29 == null) {
			jPanel29 = new JPanel();
			BorderLayout jPanel29Layout = new BorderLayout();
			jPanel29.setLayout(jPanel29Layout);
			jPanel29.add(getJToolBar5(), BorderLayout.NORTH);
			jPanel29.add(getJScrollPane19(), BorderLayout.CENTER);
		}
		return jPanel29;
	}

	private JToolBar getJToolBar5() {
		if (jToolBar5 == null) {
			jToolBar5 = new JToolBar();
			jToolBar5.add(getJTextField3());
			jToolBar5.add(getJButton22x());
		}
		return jToolBar5;
	}

	private JTextField getJTextField3() {
		if (jSearchDynamicTextField == null) {
			jSearchDynamicTextField = new JTextField();
			jSearchDynamicTextField.setMaximumSize(new java.awt.Dimension(100, 25));
			jSearchDynamicTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextField3KeyTyped(evt);
				}
			});
		}
		return jSearchDynamicTextField;
	}

	private JButton getJButton22x() {
		if (jSearchDynamicButton == null) {
			jSearchDynamicButton = new JButton();
			jSearchDynamicButton.setText("Search");
			jSearchDynamicButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchDynamicButtonActionPerformed(evt);
				}
			});
		}
		return jSearchDynamicButton;
	}

	private void jSearchDynamicButtonActionPerformed(ActionEvent evt) {
		if (jSearchDynamicTextField.getText().length() > 0) {
			Highlighter h = jSearchDynamicEditorPane.getHighlighter();
			h.removeAllHighlights();
			String text = jSearchDynamicEditorPane.getText().toLowerCase();

			int nextPosition = -1;

			for (int j = 0; j < text.length() - jSearchDynamicTextField.getText().length() + 1; j += 1) {
				if (text.substring(j, j + jSearchDynamicTextField.getText().length()).equals(jSearchDynamicTextField.getText().toLowerCase())) {
					try {
						if (j >= jSearchDynamicEditorPane.getCaretPosition() && nextPosition == -1) {
							h.addHighlight(j, j + jSearchDynamicTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.red));
							nextPosition = j + jSearchDynamicTextField.getText().length();
						} else {
							h.addHighlight(j, j + jSearchDynamicTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
						}
					} catch (BadLocationException ble) {
					}
				}
			}
			if (nextPosition != -1) {
				jSearchDynamicEditorPane.setCaretPosition(nextPosition);
			} else {
				jSearchDynamicEditorPane.setCaretPosition(0);
			}
		}
	}

	private JScrollPane getJScrollPane19() {
		if (jScrollPane19 == null) {
			jScrollPane19 = new JScrollPane();
			jScrollPane19.setPreferredSize(new java.awt.Dimension(993, 533));
			jScrollPane19.setViewportView(getJEditorPane3());
		}
		return jScrollPane19;
	}

	private JEditorPane getJEditorPane3() {
		if (jSearchDynamicEditorPane == null) {
			jSearchDynamicEditorPane = new JEditorPane();
		}
		return jSearchDynamicEditorPane;
	}

	private void jTextField2KeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jSearchRelPltButtonActionPerformed(null);
		}
	}

	private void jTextField3KeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jSearchDynamicButtonActionPerformed(null);
		}
	}

	private JPanel getJOSDebugStandardPanel() {
		if (jOSDebugStandardPanel == null) {
			jOSDebugStandardPanel = new JPanel();
			CardLayout jOSDebugStandardPanelLayout = new CardLayout();
			jOSDebugStandardPanel.setLayout(jOSDebugStandardPanelLayout);
			jOSDebugStandardPanel.add(getJOSDebugInfoErrorLabel(), "OS debug error label");
			jOSDebugStandardPanel.add(getJOSDebugInformationPanel1(), "jOSDebugInformationPanel1");
		}
		return jOSDebugStandardPanel;
	}

	private JTabbedPane getJTabbedPane5() {
		if (jTabbedPane5 == null) {
			jTabbedPane5 = new JTabbedPane();
		}
		return jTabbedPane5;
	}

	private JLabel getJOSDebugInfoErrorLabel() {
		if (jOSDebugInfoErrorLabel == null) {
			jOSDebugInfoErrorLabel = new JLabel();
			if (Global.osDebug == -1) {
				jOSDebugInfoErrorLabel.setText("Parameter -osdebug is not specified.");
			} else {
				jOSDebugInfoErrorLabel.setText("OS debug information not found - wrong magic bytes.");
			}
			jOSDebugInfoErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jOSDebugInfoErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			jOSDebugInfoErrorLabel.setFont(new java.awt.Font("Arial", 0, 20));
			jOSDebugInfoErrorLabel.setForeground(Color.white);
			jOSDebugInfoErrorLabel.setBackground(new Color(0, 0, 0, 180));
			jOSDebugInfoErrorLabel.setOpaque(true);
		}
		return jOSDebugInfoErrorLabel;
	}

	private JOSDebugInformationPanel getJOSDebugInformationPanel1() {
		if (jOSDebugInformationPanel1 == null) {
			jOSDebugInformationPanel1 = new JOSDebugInformationPanel();
		}
		return jOSDebugInformationPanel1;
	}

	private InstrumentPanel getJInstrumentPanel() {
		if (jInstrumentPanel == null) {
			jInstrumentPanel = new InstrumentPanel();
		}
		return jInstrumentPanel;
	}

	private JToggleButton getJProfilerToggleButton() {
		if (jProfilerToggleButton == null) {
			jProfilerToggleButton = new JToggleButton();
			jProfilerToggleButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/chart_organisation.png")));
			jProfilerToggleButton.setText(MyLanguage.getString("Profile_and_Sampling"));
			getButtonGroup4().add(jProfilerToggleButton);
			jProfilerToggleButton.setToolTipText("Profile & Sampling");
			jProfilerToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jProfilerToggleButtonActionPerformed(evt);
				}
			});
		}
		return jProfilerToggleButton;
	}

	private void jProfilerToggleButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jProfilerToggleButton.isSelected()) {
			cl.show(jMainPanel, "jInstrumentPanel");
			currentPanel = "jInstrumentPanel";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
		}
	}

	private JToggleButton getJLogToggleButton() {
		if (jLogToggleButton == null) {
			jLogToggleButton = new JToggleButton();
			jLogToggleButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/script.png")));
			jLogToggleButton.setText("Log");
			getButtonGroup4().add(jLogToggleButton);
			jLogToggleButton.setToolTipText("Log");
			jLogToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jLogToggleButtonActionPerformed(evt);
				}
			});
		}
		return jLogToggleButton;
	}

	private void jLogToggleButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jLogToggleButton.isSelected()) {
			cl.show(jMainPanel, "logPanel1");
			currentPanel = "logPanel1";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
		}
	}

	private LogPanel getLogPanel1() {
		if (logPanel1 == null) {
			logPanel1 = new LogPanel();
		}
		return logPanel1;
	}

	private JToggleButton getJRegisterToggleButton() {
		if (jRegisterToggleButton == null) {
			jRegisterToggleButton = new JToggleButton();
			jRegisterToggleButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/chart_bar.png")));
			getButtonGroup4().add(jRegisterToggleButton);
			jRegisterToggleButton.setSelected(true);
			jRegisterToggleButton.setText(MyLanguage.getString("Register"));
			jRegisterToggleButton.setToolTipText("View all registers");
			jRegisterToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRegisterToggleButtonActionPerformed(evt);
				}
			});
		}
		return jRegisterToggleButton;
	}

	private void jRegisterToggleButtonActionPerformed(ActionEvent evt) {
		final CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jProfilerToggleButton.isSelected()) {
			cl.show(jMainPanel, "jInstrumentPanel");
			currentPanel = "jInstrumentPanel";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					if (jRunBochsButton.getText().equals(MyLanguage.getString("Pause_bochs"))) {
						cl.show(jMainPanel, "Running Label");
					}
				}
			});
		}
	}

	private JToggleButton getJOSLogToggleButton() {
		if (jOSLogToggleButton == null) {
			jOSLogToggleButton = new JToggleButton();
			jOSLogToggleButton.setText("os.log");
			jOSLogToggleButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/page_red.png")));
			jOSLogToggleButton.setToolTipText("os.log");
			getButtonGroup4().add(jOSLogToggleButton);
			jOSLogToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jOSLogToggleButtonActionPerformed(evt);
				}
			});
		}
		return jOSLogToggleButton;
	}

	private void jOSLogToggleButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jOSLogToggleButton.isSelected()) {
			cl.show(jMainPanel, "oSLogPanel1");
			currentPanel = "osLogPanel1";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
		}
	}

	private EnhancedTextArea getOsLogPanel1() {
		if (osLogPanel1 == null) {
			osLogPanel1 = new EnhancedTextArea();
			osLogPanel1.addTrailListener(new File("os.log"));
		}
		return osLogPanel1;
	}

	private JMenuItem getJHelpRequestMenuItem() {
		if (jHelpRequestMenuItem == null) {
			jHelpRequestMenuItem = new JMenuItem();
			jHelpRequestMenuItem.setText("Help request");
			jHelpRequestMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jHelpRequestMenuItemActionPerformed(evt);
				}
			});
		}
		return jHelpRequestMenuItem;
	}

	private void jHelpRequestMenuItemActionPerformed(ActionEvent evt) {
		HelpRequestDialog helpRequestDialog = new HelpRequestDialog(this, commandReceiver);
		CommonLib.centerDialog(helpRequestDialog);
		helpRequestDialog.setVisible(true);
	}

	private JPanel getJPanel30() {
		if (jPanel30 == null) {
			jPanel30 = new JPanel();
			BorderLayout jPanel30Layout = new BorderLayout();
			jPanel30.setLayout(jPanel30Layout);
			jPanel30.add(getJAddressTranslateTable(), BorderLayout.CENTER);
			jPanel30.add(getJTabbedPane5(), BorderLayout.WEST);
		}
		return jPanel30;
	}

	private JMenuItem getJStep10MenuItem() {
		if (jStep10MenuItem == null) {
			jStep10MenuItem = new JMenuItem();
			jStep10MenuItem.setText("Step 10 Instructions");
		}
		return jStep10MenuItem;
	}

	private JMenuItem getJStep100MenuItem() {
		if (jStep100MenuItem == null) {
			jStep100MenuItem = new JMenuItem();
			jStep100MenuItem.setText("Step 100 Instructions");
		}
		return jStep100MenuItem;
	}

	private JMenuItem getJStepNMenuItem() {
		if (jStepNMenuItem == null) {
			jStepNMenuItem = new JMenuItem();
			jStepNMenuItem.setText("Step N Instructions");
		}
		return jStepNMenuItem;
	}

	private JMenuItem getJStepUntilCallOrJumpMenuItem() {
		if (jStepUntilCallOrJumpMenuItem == null) {
			jStepUntilCallOrJumpMenuItem = new JMenuItem();
			jStepUntilCallOrJumpMenuItem.setText("Until call or jump");
		}
		return jStepUntilCallOrJumpMenuItem;
	}

	private JMenuItem getJStepUntilRetMenuItem() {
		if (jStepUntilRetMenuItem == null) {
			jStepUntilRetMenuItem = new JMenuItem();
			jStepUntilRetMenuItem.setText("Until ret");
		}
		return jStepUntilRetMenuItem;
	}

	private JMenuItem getJStepUntilIRetMenuItem() {
		if (jStepUntilIRetMenuItem == null) {
			jStepUntilIRetMenuItem = new JMenuItem();
			jStepUntilIRetMenuItem.setText("Until iret");
		}
		return jStepUntilIRetMenuItem;
	}

	private JMenuItem getJStepUntilMovMenuItem() {
		if (jStepUntilMovMenuItem == null) {
			jStepUntilMovMenuItem = new JMenuItem();
			jStepUntilMovMenuItem.setText("Until mov");
		}
		return jStepUntilMovMenuItem;
	}

	private JMenuItem getJJVMMenuItem() {
		if (jJVMMenuItem == null) {
			jJVMMenuItem = new JMenuItem();
			jJVMMenuItem.setText("JVM");
			jJVMMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jJVMMenuItemActionPerformed(evt);
				}
			});
		}
		return jJVMMenuItem;
	}

	private void jJVMMenuItemActionPerformed(ActionEvent evt) {
		new JVMInfoDialog(this).setVisible(true);
	}

	private JMenuItem getJStepUntilIPBigChangeMenuItem() {
		if (jStepUntilIPBigChangeMenuItem == null) {
			jStepUntilIPBigChangeMenuItem = new JMenuItem();
			jStepUntilIPBigChangeMenuItem.setText("Until IP big change");
		}
		return jStepUntilIPBigChangeMenuItem;
	}

	private JPanel getJRunningPanel() {
		if (jRunningPanel == null) {
			jRunningPanel = new JPanel();
			GroupLayout jRunningPanelLayout = new GroupLayout((JComponent) jRunningPanel);
			jRunningPanel.setLayout(jRunningPanelLayout);
			jRunningPanel.setPreferredSize(new java.awt.Dimension(1073, 758));
			jRunningPanelLayout
					.setHorizontalGroup(jRunningPanelLayout
							.createSequentialGroup()
							.addContainerGap()
							.addGroup(
									jRunningPanelLayout
											.createParallelGroup()
											.addGroup(
													GroupLayout.Alignment.LEADING,
													jRunningPanelLayout.createSequentialGroup()
															.addComponent(getJButton16xxx(), GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
															.addComponent(getJLabel1(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
															.addComponent(getJMaxRowComboBox(), GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
															.addComponent(getJClearRunningTextAreaButton(), GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(getJStepCountLabel(), 0, 749, Short.MAX_VALUE)
															.addGap(48))
											.addComponent(getJTextArea1(), GroupLayout.Alignment.LEADING, 0, 1116, Short.MAX_VALUE)
											.addGroup(
													GroupLayout.Alignment.LEADING,
													jRunningPanelLayout
															.createSequentialGroup()
															.addGap(65)
															.addComponent(getJCheckBox1(), GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
															.addGroup(
																	jRunningPanelLayout
																			.createParallelGroup()
																			.addGroup(
																					GroupLayout.Alignment.LEADING,
																					jRunningPanelLayout
																							.createSequentialGroup()
																							.addComponent(getJAutoUpdateEvery20LinesCheckBox(), 0, 546, Short.MAX_VALUE)
																							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																							.addComponent(getJSaveToRunDotTxtCheckBox(), GroupLayout.PREFERRED_SIZE, 158,
																									GroupLayout.PREFERRED_SIZE))
																			.addGroup(
																					GroupLayout.Alignment.LEADING,
																					jRunningPanelLayout
																							.createSequentialGroup()
																							.addPreferredGap(getJAutoUpdateEvery20LinesCheckBox(), getJRunningLabel2(),
																									LayoutStyle.ComponentPlacement.INDENT)
																							.addComponent(getJRunningLabel2(), GroupLayout.PREFERRED_SIZE, 679,
																									GroupLayout.PREFERRED_SIZE).addGap(0, 25, Short.MAX_VALUE))))));
			jRunningPanelLayout.setVerticalGroup(jRunningPanelLayout
					.createSequentialGroup()
					.addComponent(getJRunningLabel2(), GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(
							jRunningPanelLayout
									.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(getJButton16xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(getJMaxRowComboBox(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(getJClearRunningTextAreaButton(), GroupLayout.Alignment.BASELINE, 0, 23, Short.MAX_VALUE)
									.addComponent(getJStepCountLabel(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(
							jRunningPanelLayout
									.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(getJAutoUpdateEvery20LinesCheckBox(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(getJSaveToRunDotTxtCheckBox(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getJCheckBox1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(getJTextArea1(), 0, 610, Short.MAX_VALUE).addContainerGap(17, 17));
		}
		return jRunningPanel;
	}

	private JLabel getJRunningLabel2() {
		if (jRunningLabel2 == null) {
			jRunningLabel2 = new JLabel();
			URL url = getClass().getClassLoader().getResource("com/peterbochs/images/ajax-loader_red.gif");
			if (Setting.getInstance().getCurrentLanguage().equals("zh_TW")) {
				jRunningLabel2
						.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\""
								+ url
								+ "\" /><br><br><a style=\"color: #000000;  text-decoration:none\" href=\"http://www.kingofcoders.com\">操作系统开发社区 www.kingofcoders.com</a></center></html>");
			} else if (Setting.getInstance().getCurrentLanguage().equals("zh_CN")) {
				jRunningLabel2
						.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\""
								+ url
								+ "\" /><br><br><img src=\"http://www.kingofcoders.com/images/KOC_logo2.jpg\" /><br><a style=\"color: #000000;  text-decoration:none\" href=\"http://www.kingofcoders.com\">蝻���蝡� www.kingofcoders.com</a></center></html>");
			} else {
				jRunningLabel2.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\"" + url + "\" /></center></html>");
			}
			jRunningLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			jRunningLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
			jRunningLabel2.setFont(new java.awt.Font("Arial", 0, 20));
		}
		return jRunningLabel2;
	}

	private EnhancedTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new EnhancedTextArea();
			jTextArea1.setBorder(new LineBorder(new java.awt.Color(0xef, 0xef, 0xef), 1, false));
		}
		return jTextArea1;
	}

	private JButton getJButton16xxx() {
		if (jButton16 == null) {
			jButton16 = new JButton();
			jButton16.setText("Pause");
			jButton16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton16ActionPerformed(evt);
				}
			});
		}
		return jButton16;
	}

	private void jButton16ActionPerformed(ActionEvent evt) {
		if (untilThread != null) {
			untilThread.shouldStop = true;
		}
	}

	private JLabel getJStepCountLabel() {
		if (jStepCountLabel == null) {
			jStepCountLabel = new JLabel();
			jStepCountLabel.setForeground(new java.awt.Color(222, 0, 5));
			jStepCountLabel.setFont(new java.awt.Font("Abyssinica SIL", 0, 14));
		}
		return jStepCountLabel;
	}

	private JCheckBox getJCheckBox1() {
		if (jDisableAutoUpdateCheckBox == null) {
			jDisableAutoUpdateCheckBox = new JCheckBox();
			jDisableAutoUpdateCheckBox.setText("Disable auto update, so bochs runs faster");
		}
		return jDisableAutoUpdateCheckBox;
	}

	private JCheckBox getJAutoUpdateEvery20LinesCheckBox() {
		if (jAutoUpdateEvery20LinesCheckBox == null) {
			jAutoUpdateEvery20LinesCheckBox = new JCheckBox();
			jAutoUpdateEvery20LinesCheckBox.setSelected(true);
			jAutoUpdateEvery20LinesCheckBox.setText("Update the following instruction box every 20 lines, this make bochs runs faster");
		}
		return jAutoUpdateEvery20LinesCheckBox;
	}

	private JCheckBox getJSaveToRunDotTxtCheckBox() {
		if (jSaveToRunDotTxtCheckBox == null) {
			jSaveToRunDotTxtCheckBox = new JCheckBox();
			jSaveToRunDotTxtCheckBox.setText("Append to run.txt");
			jSaveToRunDotTxtCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSaveToRunDotTxtCheckBoxActionPerformed(evt);
				}
			});
		}
		return jSaveToRunDotTxtCheckBox;
	}

	private void jSaveToRunDotTxtCheckBoxActionPerformed(ActionEvent evt) {
		saveToRunDotTxt = jSaveToRunDotTxtCheckBox.isSelected();
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Maximum row");
		}
		return jLabel1;
	}

	private JComboBox getJMaxRowComboBox() {
		if (jMaxRowComboBox == null) {
			ComboBoxModel jMaxRowComboBoxModel = new DefaultComboBoxModel(new String[] { "infinite", "10", "100", "200", "500", "1000", "2000" });
			jMaxRowComboBox = new JComboBox();
			jMaxRowComboBox.setModel(jMaxRowComboBoxModel);
			jMaxRowComboBox.setSelectedItem("100");
		}
		return jMaxRowComboBox;
	}

	private void jInstructionComboBoxActionPerformed(ActionEvent evt) {
		jDisassembleButtonActionPerformed(evt);
	}

	private JButton getJNextMemoryPageButton() {
		if (jNextMemoryPageButton == null) {
			jNextMemoryPageButton = new JButton();
			jNextMemoryPageButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/resultset_next_grey.png")));
			jNextMemoryPageButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jNextMemoryPageButtonActionPerformed(evt);
				}
			});
		}
		return jNextMemoryPageButton;
	}

	private JButton getJPreviousMemoryButton() {
		if (jPreviousMemoryButton == null) {
			jPreviousMemoryButton = new JButton();
			jPreviousMemoryButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/resultset_previous_grey.png")));
			jPreviousMemoryButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPreviousMemoryButtonActionPerformed(evt);
				}
			});
		}
		return jPreviousMemoryButton;
	}

	private void jPreviousMemoryButtonActionPerformed(ActionEvent evt) {
		try {
			long address = CommonLib.convertFilesize(jMemoryAddressComboBox.getSelectedItem().toString());
			if (address >= 0xc8) {
				jMemoryAddressComboBox.setSelectedItem("0x" + Long.toHexString(address - 0xc8));
			} else {
				jMemoryAddressComboBox.setSelectedItem("0x0");
			}
			jGOMemoryButtonActionPerformed(null);
		} catch (Exception ex) {
			if (Global.debug) {
				ex.printStackTrace();
			}
		}
	}

	private void jNextMemoryPageButtonActionPerformed(ActionEvent evt) {
		try {
			long address = CommonLib.convertFilesize(jMemoryAddressComboBox.getSelectedItem().toString());
			jMemoryAddressComboBox.setSelectedItem("0x" + Long.toHexString(address + 0xc8));
			jGOMemoryButtonActionPerformed(null);
		} catch (Exception ex) {
			if (Global.debug) {
				ex.printStackTrace();
			}
		}
	}

	private JRadioButton getJFPURadioButton() {
		if (jFPURadioButton == null) {
			jFPURadioButton = new JRadioButton();
			jFPURadioButton.setText("fpu");
			jFPURadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFPURadioButtonActionPerformed(evt);
				}
			});
			getButtonGroup2().add(jFPURadioButton);
		}
		return jFPURadioButton;
	}

	private JRadioButton getJMMXRadioButton() {
		if (jMMXRadioButton == null) {
			jMMXRadioButton = new JRadioButton();
			jMMXRadioButton.setText("mmx");
			jMMXRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMMXRadioButtonActionPerformed(evt);
				}
			});
			getButtonGroup2().add(jMMXRadioButton);
		}
		return jMMXRadioButton;
	}

	private void jMMXRadioButtonActionPerformed(ActionEvent evt) {
		HistoryTableModel model = (HistoryTableModel) this.jHistoryTable.getModel();
		model.setView("mmx");
		for (int x = 0; x < model.getColumnCount(); x++) {
			jHistoryTable.getColumnModel().getColumn(x).setPreferredWidth(200);
		}
	}

	private void jFPURadioButtonActionPerformed(ActionEvent evt) {
		HistoryTableModel model = (HistoryTableModel) this.jHistoryTable.getModel();
		model.setView("fpu");
		for (int x = 1; x < model.getColumnCount(); x++) {
			jHistoryTable.getColumnModel().getColumn(x).setPreferredWidth(200);
		}
		jHistoryTable.getColumnModel().getColumn(9).setPreferredWidth(600);
		jHistoryTable.getColumnModel().getColumn(10).setPreferredWidth(500);
	}

	private void jTabbedPane1StateChanged(ChangeEvent evt) {
		JTabbedPane pane = (JTabbedPane) evt.getSource();
		int sel = pane.getSelectedIndex();
		if (sel == 2) {
			jBochsCommandTextField.requestFocus();
		}
	}

	private JSeparator getJSeparator3() {
		if (jSeparator3 == null) {
			jSeparator3 = new JSeparator();
		}
		return jSeparator3;
	}

	private JMenuItem getJShowInSourceCodeMenuItem() {
		if (jShowInSourceCodeMenuItem == null) {
			jShowInSourceCodeMenuItem = new JMenuItem();
			jShowInSourceCodeMenuItem.setText("Show in source code");
			jShowInSourceCodeMenuItem.setEnabled(false);
			jShowInSourceCodeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jShowInSourceCodeMenuItemActionPerformed(evt);
				}
			});
		}
		return jShowInSourceCodeMenuItem;
	}

	private void jShowInSourceCodeMenuItemActionPerformed(ActionEvent evt) {
		System.out.println("jShowInSourceCodeMenuItem.actionPerformed, event=" + evt);
	}

	private SourceLevelDebugger2 getSourceLevelDebugger() {
		if (sourceLevelDebugger == null) {
			sourceLevelDebugger = new SourceLevelDebugger2(this);
		}
		return sourceLevelDebugger;
	}

	private JToggleButton getJSourceLevelDebuggerButton() {
		if (jSourceLevelDebuggerButton == null) {
			jSourceLevelDebuggerButton = new JToggleButton();
			getButtonGroup4().add(jSourceLevelDebuggerButton);
			jSourceLevelDebuggerButton.setText("C/C++");
			jSourceLevelDebuggerButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/page_white_text.png")));
			jSourceLevelDebuggerButton.setEnabled(false);
			jSourceLevelDebuggerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSourceLevelDebuggerButtonActionPerformed(evt);
				}
			});
		}
		return jSourceLevelDebuggerButton;
	}

	public void jSourceLevelDebuggerButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jSourceLevelDebuggerButton.isSelected() || evt == null) {
			cl.show(jMainPanel, "sourceLevelDebugger");
			currentPanel = "sourceLevelDebugger";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
		}

		if (evt == null) {
			jSourceLevelDebuggerButton.setSelected(true);
		}
	}

	private JMenu getJSystemMenu() {
		if (jSystemMenu == null) {
			jSystemMenu = new JMenu();
			jSystemMenu.setText(MyLanguage.getString("System"));
			jSystemMenu.add(getJLoadSystemMapMenuItem());
		}
		return jSystemMenu;
	}

	private JMenuItem getJLoadSystemMapMenuItem() {
		if (jLoadSystemMapMenuItem == null) {
			jLoadSystemMapMenuItem = new JMenuItem();
			jLoadSystemMapMenuItem.setText(MyLanguage.getString("Load_System_Map"));
			jLoadSystemMapMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jLoadSystemMapMenuItemActionPerformed(evt);
				}
			});
		}
		return jLoadSystemMapMenuItem;
	}

	private void jLoadSystemMapMenuItemActionPerformed(ActionEvent evt) {
		this.sourceLevelDebugger.jLoadMapButtonActionPerformed(null);
	}

	private JMenuItem getJWhereIsHereMenuItem() {
		if (jWhereIsHereMenuItem == null) {
			jWhereIsHereMenuItem = new JMenuItem();
			jWhereIsHereMenuItem.setText("Where is here?");
			jWhereIsHereMenuItem.setEnabled(false);
			jWhereIsHereMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jWhereIsHereMenuItemActionPerformed(evt);
				}
			});
		}
		return jWhereIsHereMenuItem;
	}

	private void jWhereIsHereMenuItemActionPerformed(ActionEvent evt) {
		jSourceLevelDebuggerButtonActionPerformed(null);
		// sourceLevelDebugger.jMainTabbedPane.setSelectedIndex(1);
		if (Global.clickedWhichInstructionPanel == 0) {
			sourceLevelDebugger.showWhere(CommonLib.string2decimal((String) jInstructionTable.getValueAt(jInstructionTable.getSelectedRow(), 1)));
		} else {
			sourceLevelDebugger.showWhere(CommonLib.string2decimal((String) sourceLevelDebugger.jAssemblyTable.getValueAt(sourceLevelDebugger.jAssemblyTable.getSelectedRow(), 1)));
		}
	}

	private ButtonGroup getButtonGroup4() {
		if (buttonGroup4 == null) {
			buttonGroup4 = new ButtonGroup();
		}
		return buttonGroup4;
	}

	private JButton getJClearHistoryTableButton() {
		if (jClearHistoryTableButton == null) {
			jClearHistoryTableButton = new JButton();
			jClearHistoryTableButton.setText("Clear");
			jClearHistoryTableButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jClearHistoryTableButtonActionPerformed(evt);
				}
			});
		}
		return jClearHistoryTableButton;
	}

	private void jClearHistoryTableButtonActionPerformed(ActionEvent evt) {
		((HistoryTableModel) this.jHistoryTable.getModel()).clear();
	}

	private JButton getJClearRunningTextAreaButton() {
		if (jClearRunningTextAreaButton == null) {
			jClearRunningTextAreaButton = new JButton();
			jClearRunningTextAreaButton.setText("Clear");
			jClearRunningTextAreaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jClearRunningTextAreaButtonActionPerformed(evt);
				}
			});
		}
		return jClearRunningTextAreaButton;
	}

	private void jClearRunningTextAreaButtonActionPerformed(ActionEvent evt) {
		jTextArea1.setText("");
	}

	private JLabel getJHistoryTableRepeatedLabel() {
		if (jHistoryTableRepeatedLabel == null) {
			jHistoryTableRepeatedLabel = new JLabel();
		}
		return jHistoryTableRepeatedLabel;
	}

	private void jHistoryTableMouseClicked(MouseEvent evt) {
		try {
			String instruction = (String) jHistoryTable.getValueAt(jHistoryTable.getSelectedRow(), 2);
			instruction = instruction.replaceAll("^.*] [0-9]", "").split(":")[2].trim().replaceAll(" .*", "");
			int count = 0;
			for (int x = 0; x <= jHistoryTable.getSelectedRow(); x++) {
				try {
					String i = (String) jHistoryTable.getValueAt(x, 2);
					i = i.replaceAll("^.*]", "").split(":")[2].trim().replaceAll(" .*", "");
					if (instruction.equals(i)) {
						count++;
					}
				} catch (Exception ex) {
				}
			}
			jHistoryTableRepeatedLabel.setText(" " + instruction + " happened " + count + " times ");
		} catch (Exception ex) {
			jHistoryTableRepeatedLabel.setText("");
		}
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setOpaque(true);
			jLabel2.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jLabel2.setBackground(new java.awt.Color(0, 0, 0));
			jLabel2.setMinimumSize(new java.awt.Dimension(2, 15));
			jLabel2.setMaximumSize(new java.awt.Dimension(2, 15));
			jLabel2.setPreferredSize(new java.awt.Dimension(2, 15));
		}
		return jLabel2;
	}

	private JTextField getJFilterHistoryTableTextField() {
		if (jFilterHistoryTableTextField == null) {
			jFilterHistoryTableTextField = new JSearchTextField();
			jFilterHistoryTableTextField.setMaximumSize(new java.awt.Dimension(158, 26));
			jFilterHistoryTableTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					jFilterHistoryTableTextFieldKeyReleased(evt);
				}
			});
		}
		return jFilterHistoryTableTextField;
	}

	private void jFilterHistoryTableTextFieldKeyReleased(KeyEvent evt) {
		MyTableRowSorter<TableModel> sorter = (MyTableRowSorter<TableModel>) jHistoryTable.getRowSorter();
		sorter.showAfterwardCount = (Integer) jShowAfterwardSpinner.getValue();
		sorter.setRowFilter(RowFilter.regexFilter(jFilterHistoryTableTextField.getText()));
		// ((MyTableRowSorter<TableModel>)
		// jHistoryTable.getRowSorter()).setRowFilter(genRegexFilter(jFilterHistoryTableTextField.getText()));
	}

	private JMenuItem getJRunBochsAndSkipBreakpointMenuItem() {
		if (jRunBochsAndSkipBreakpointMenuItem == null) {
			jRunBochsAndSkipBreakpointMenuItem = new JMenuItem();
			jRunBochsAndSkipBreakpointMenuItem.setText("Run and skip breakpoint for N times");
		}
		return jRunBochsAndSkipBreakpointMenuItem;
	}

	private JSpinner getJShowAfterwardSpinner() {
		if (jShowAfterwardSpinner == null) {
			SpinnerNumberModel jShowAfterwardSpinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
			jShowAfterwardSpinner = new JSpinner();
			jShowAfterwardSpinner.setMaximumSize(new java.awt.Dimension(50, 26));
			jShowAfterwardSpinner.setModel(jShowAfterwardSpinnerModel);
			jShowAfterwardSpinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent evt) {
					jShowAfterwardSpinnerStateChanged(evt);
				}
			});
		}
		return jShowAfterwardSpinner;
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText(" Show afterward");
		}
		return jLabel7;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setBackground(new java.awt.Color(0, 0, 0));
			jLabel8.setMinimumSize(new java.awt.Dimension(2, 15));
			jLabel8.setPreferredSize(new java.awt.Dimension(2, 15));
			jLabel8.setMaximumSize(new java.awt.Dimension(2, 15));
			jLabel8.setOpaque(true);
			jLabel8.setBorder(new LineBorder(Color.LIGHT_GRAY));
		}
		return jLabel8;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText(" ");
		}
		return jLabel9;
	}

	private void jShowAfterwardSpinnerStateChanged(ChangeEvent evt) {
		jFilterHistoryTableTextFieldKeyReleased(null);
	}

	private JDropDownButton getJSBButton() {
		if (jSBButton == null) {
			jSBButton = new JDropDownButton();
			jSBButton.setText("SB");
			jSBButton.setPreferredSize(new java.awt.Dimension(40, 25));
			loadSBButton();
			jSBButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSBButtonActionPerformed(evt);
				}
			});
		}
		return jSBButton;
	}

	void loadSBButton() {
		jSBButton.removeAll();
		Object[] a = Setting.getInstance().sbAddress.toArray();
		for (int x = a.length - 1; x >= 0; x--) {
			JMenuItem menu = new JMenuItem();
			menu.setText(String.valueOf(a[x]));
			jSBButton.add(menu);
		}
	}

	private JDropDownButton getJSBAButton() {
		if (jSBAButton == null) {
			jSBAButton = new JDropDownButton();
			jSBAButton.setText("SBA");
			loadSBAButton();
			jSBAButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSBAButtonActionPerformed(evt);
				}
			});
		}
		return jSBAButton;
	}

	void loadSBAButton() {
		jSBAButton.removeAll();
		Object[] a = Setting.getInstance().sbaAddress.toArray();
		for (int x = a.length - 1; x >= 0; x--) {
			JMenuItem menu = new JMenuItem();
			menu.setText(String.valueOf(a[x]));
			jSBAButton.add(menu);
		}
	}

	private void jSBButtonActionPerformed(ActionEvent evt) {
		if (jSBButton.getEventSource() != null) {
			long l = Long.parseLong(((JMenuItem) jSBButton.getEventSource()).getText());
			sendCommand("sb " + l);
			Setting.getInstance().sbAddress.add(l);
		} else {
			String s = JOptionPane.showInputDialog(this, "Please input cycle interval for next stop?");
			if (s == null) {
				return;
			}
			try {
				long l = Long.parseLong(s);
				sendCommand("sb " + l);
				Setting.getInstance().sbAddress.add(l);
			} catch (Exception ex) {
				if (Global.debug) {
					ex.printStackTrace();
				}
			}
		}

		for (int x = 0; x < Setting.getInstance().sbAddress.size() - 10; x++) {
			Setting.getInstance().sbAddress.remove(Setting.getInstance().sbAddress.toArray()[x]);
		}
		Setting.getInstance().save();
		loadSBButton();
	}

	private void jSBAButtonActionPerformed(ActionEvent evt) {
		if (jSBAButton.getEventSource() != null) {
			long l = Long.parseLong(((JMenuItem) jSBAButton.getEventSource()).getText());
			sendCommand("sba " + l);
			Setting.getInstance().sbaAddress.add(l);
		} else {
			String s = JOptionPane.showInputDialog(this, "Please input cycle interval for next stop?");
			if (s == null) {
				return;
			}
			try {
				long l = Long.parseLong(s);
				sendCommand("sba " + l);
				Setting.getInstance().sbaAddress.add(l);
			} catch (Exception ex) {
				if (Global.debug) {
					ex.printStackTrace();
				}
			}
		}

		for (int x = 0; x < Setting.getInstance().sbaAddress.size() - 10; x++) {
			Setting.getInstance().sbaAddress.remove(Setting.getInstance().sbaAddress.toArray()[x]);
		}
		Setting.getInstance().save();
		loadSBAButton();
	}

	private JMenuItem getJShortcutHelpMenuItem() {
		if (jShortcutHelpMenuItem == null) {
			jShortcutHelpMenuItem = new JMenuItem();
			jShortcutHelpMenuItem.setText("Shortcut");
			jShortcutHelpMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jShortcutHelpMenuItemActionPerformed(evt);
				}
			});
		}
		return jShortcutHelpMenuItem;
	}

	private void jShortcutHelpMenuItemActionPerformed(ActionEvent evt) {
		String s = "F1 : Show memory\n" + "F2 : Show GDT\n" + "F3 : Show IDT\n" + "F4 : Show LDT\n" + "F5 : Start bochs\n" + "F6 : Stop bochs\n" + "F7 : Run/Pause bochs\n"
				+ "F8 : Step\n";
		JOptionPane.showMessageDialog(this, s);
	}

	private JPanel getJPanel31() {
		if (jPanel31 == null) {
			jPanel31 = new JPanel();
			BorderLayout jPanel31Layout = new BorderLayout();
			jPanel31.setLayout(jPanel31Layout);
			jPanel31.add(getBochsoutTextArea(), BorderLayout.CENTER);
		}
		return jPanel31;
	}

	private EnhancedTextArea getBochsoutTextArea() {
		if (bochsoutTextArea == null) {
			bochsoutTextArea = new EnhancedTextArea();
			// bochsoutTextArea.setMaxRow(20);
			// bochsoutTextArea.addTrailListener(new File("bochsout.txt"), 0,
			// false);

			new Thread(new BochsoutTimer()).start();
			getBochsoutTextArea().jToolBar.add(getJButton4(), -1);
		}
		return bochsoutTextArea;
	}

	class BochsoutTimer implements Runnable {
		long originalLengeh;

		int x = 0;

		@Override
		public void run() {
			while (true) {
				try {
					File file = new File("bochsout.txt");
					long newLength = file.length();
					if (originalLengeh != newLength) {
						bochsoutTextArea.setText(tail2(file, 80));
						bochsoutTextArea.jTextArea.setCaretPosition(bochsoutTextArea.jTextArea.getDocument().getLength());
						originalLengeh = newLength;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					Thread.currentThread();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String tail2(File file, int lines) {
		try {
			RandomAccessFile fileHandler = new RandomAccessFile(file, "r");
			long fileLength = file.length() - 1;
			StringBuilder sb = new StringBuilder();
			int line = 0;

			for (long filePointer = fileLength; filePointer != -1; filePointer--) {
				fileHandler.seek(filePointer);
				int readByte = fileHandler.readByte();

				if (readByte == 0xA) {
					line = line + 1;
					if (line == lines) {
						if (filePointer == fileLength) {
							continue;
						} else {
							break;
						}
					}
				}
				sb.append((char) readByte);
			}

			sb.deleteCharAt(sb.length() - 1);
			String lastLine = sb.reverse().toString();
			return lastLine;
		} catch (Exception e) {
			return null;
		}
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("Help");
			jButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton4ActionPerformed(evt);
				}
			});
		}
		return jButton4;
	}

	private void jButton4ActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "To enable bochsout.txt, add \"log: bochsout.txt\" to your bochsrc.bxrc");
	}

	private JMenuItem getJRunCustomCommandMenuItem() {
		if (jRunCustomCommandMenuItem == null) {
			jRunCustomCommandMenuItem = new JMenuItem();
			jRunCustomCommandMenuItem.setText("Run custom commands");
		}
		return jRunCustomCommandMenuItem;
	}

	private JDropDownButton getJStepOverDropDownButton() {
		if (jStepOverDropDownButton == null) {
			jStepOverDropDownButton = new JDropDownButton();
			jStepOverDropDownButton.setText(MyLanguage.getString("Step_over"));
			jStepOverDropDownButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/step_over.png")));
			jStepOverDropDownButton.setMaximumSize(new java.awt.Dimension(115, 26));
			jStepOverDropDownButton.add(getJStepOver10MenuItem());
			jStepOverDropDownButton.add(getJStepOver100MenuItem());
			jStepOverDropDownButton.add(getJStepOverNTimesMenuItem());
			jStepOverDropDownButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jStepOverDropDownButtonActionPerformed(evt);
				}
			});
		}
		return jStepOverDropDownButton;
	}

	private void jStepOverDropDownButtonActionPerformed(ActionEvent evt) {
		if (jStepOverDropDownButton.getEventSource() != null) {
			untilThread = new MyThread(jStepOverDropDownButton.getEventSource());
			if (jStepOverDropDownButton.getEventSource() == jStepOverNTimesMenuItem) {
				String s = JOptionPane.showInputDialog("Please input the instruction count?");
				if (s == null) {
					return;
				}
				untilThread.instructionCount = Integer.parseInt(s);
			}

			// if (currentPanel.equals("jMaximizableTabbedPane_BasePanel1")) {
			CardLayout cl = (CardLayout) (jMainPanel.getLayout());
			cl.show(jMainPanel, "Running Label 2");
			// }
			new Thread(untilThread, "Step until thread").start();
		} else {
			sendCommand("next");
			WebServiceUtil.log("peter-bochs", "step over", null, null, null);
			updateBochsStatus(true);
			// updateHistoryTable(re);
		}
	}

	private JMenuItem getJStepOver10MenuItem() {
		if (jStepOver10MenuItem == null) {
			jStepOver10MenuItem = new JMenuItem();
			jStepOver10MenuItem.setText(MyLanguage.getString("Step_over_10_times"));
		}
		return jStepOver10MenuItem;
	}

	private JMenuItem getJStepOver100MenuItem() {
		if (jStepOver100MenuItem == null) {
			jStepOver100MenuItem = new JMenuItem();
			jStepOver100MenuItem.setText(MyLanguage.getString("Step_over_100_times"));
		}
		return jStepOver100MenuItem;
	}

	private JMenuItem getJStepOverNTimesMenuItem() {
		if (jStepOverNTimesMenuItem == null) {
			jStepOverNTimesMenuItem = new JMenuItem();
			jStepOverNTimesMenuItem.setText(MyLanguage.getString("Step_over_N_times"));
		}
		return jStepOverNTimesMenuItem;
	}
}
